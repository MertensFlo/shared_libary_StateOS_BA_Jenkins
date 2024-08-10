

def checkout_git(String workingOrg, String workingRepo){
    sh script: """
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

def install_dependencies(){
    sh script: """
        apt-get update && apt-get -y -qq install git
        apt-get install -y wget
        apt-get install -y xz-utils 
        apt-get install -y gcc-arm-none-eabi
        apt-get install -y build-essential
        apt-get install apt-utils
    """, label: "install dependencies"
}

def install_ninja(){
    sh script:"""
        apt-get -y -qq update && apt-get -y -qq install cmake ninja-build
    """ , label:"install"
}

def arm_install(){
    sh script: """
        wget -q https://developer.arm.com/-/media/Files/downloads/gnu/11.3.rel1/binrel/arm-gnu-toolchain-11.3.rel1-x86_64-arm-none-eabi.tar.xz
        echo "1"
        tar -xf arm-gnu-toolchain-11.3.rel1-x86_64-arm-none-eabi.tar.xz
    """, label: "arm install"
    script{
        env.JENKINS_PATH = "${env.WORKSPACE}/arm-gnu-toolchain-11.3.rel1-x86_64-arm-none-eabi/bin"
    }
}

def check_installs(){
    sh script: """
        arm-none-eabi-gcc -v
    """, label: "check installs"
}