class SharedSteps {
    private final Script script

    SharedSteps(Script script) {
        this.script = script
    }
}

def checkout_git(String workingOrg, String workingRepo){
    script.sh """
        git --version
        echo workingOrg: $workingOrg
        echo workingRepo: $workingRepo
        echo "https://github.com/"$workingOrg"/"$workingRepo".git"
        git clone "https://github.com/"$workingOrg"/"$workingRepo".git"
        cd $workingRepo
        git remote
        git submodule update --init --remote --recursive
    """
}

def install_dependencies(boolean git, boolean wget, boolean xz_utils, boolean arm, boolean build_essential, boolean apt_utils, boolean ninja){
    if(git){
        script.sh "apt-get update && apt-get -y -qq install git", label: "install git"
    }
    if(wget){
        script.sh "apt-get install -y wget", label: "install wget"
    }
    if(xz_utils){
        script.sh "apt-get install -y xz-utils", label: "install xz-utils"
    }
    if(arm){
        script.sh "apt-get install -y gcc-arm-none-eabi", label: "install arm"
    }
    if(build_essential){
        script.sh "apt-get install -y build-essential", label: "install build-essential"
    }
    if(apt_utils){
        script.sh "apt-get install apt-utils", label: "install apt-utils"
    }
    if(ninja){
        script.sh "apt-get -y -qq update && apt-get -y -qq install cmake ninja-build", label: "install ninja"
    }
}

def install_pipeline_specific(String arm_version, boolean arm){
    if(arm){
        script.sh """
            wget -q https://developer.arm.com/-/media/Files/downloads/gnu/$arm_version/binrel/arm-gnu-toolchain-$arm_version-x86_64-arm-none-eabi.tar.xz
            echo "1"
            tar -xf arm-gnu-toolchain-$arm_version-x86_64-arm-none-eabi.tar.xz
            echo ${env.WORKSPACE}/arm-gnu-toolchain-$arm_version-x86_64-arm-none-eabi/bin >> env.GITHUB_PATH
        """, label: "arm install"
    }
}

def check_installs(boolean arm){
    if(arm){
        script.sh "arm-none-eabi-gcc -v", label: "check installs"
    }
}

def make_build(String workingRepo, boolean ninja){
    if(ninja){
        script.sh """
            cd $workingRepo
            cmake -S. -Bbuild -GNinja
        """, label:"build ninja"
    }
    script.sh """
        cd $workingRepo
        cmake --build build -v  
    """ , label:"make build"
}

def example_test(String workingRepo){
    script.sh """
        cd $workingRepo
        sh ./.example-test.sh
    """ , label:"example test"
}

def static_code_test(String workingRepo){
    script.sh """
        cd $workingRepo
        sh ./.stdc++-test.sh 
    """ , label:"static code test"
}

def unit_test(String workingRepo){
    script.sh """
        cd $workingRepo
        make all -f .unit-test.make 
    """ , label:"make unit test"
}