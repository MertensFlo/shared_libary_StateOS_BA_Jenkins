class SharedSteps {
    private final Script script

    SharedSteps(Script script) {
        this.script = script
    }
    def checkout_git(String workingOrg, String workingRepo){
        script.sh """
            echo git --version
            echo git clone "https://github.com/"$workingOrg"/"$workingRepo".git"
            echo cd $workingRepo
            echo git remote
            echo git submodule update --init --remote --recursive
        """
    }

    def install_dependencies(boolean git, boolean wget, boolean xz_utils, boolean arm, boolean build_essential, boolean apt_utils, boolean ninja){
        if(git){
            script.sh "echo apt-get -y -qq install git"//, label: "install git"
        }
        if(wget){
            script.sh "echo apt-get install -y wget"//, label: "install wget"
        }
        if(xz_utils){
            script.sh "echo apt-get install -y xz-utils"//, label: "install xz-utils"
        }
        if(arm){
            script.sh "echo apt-get install -y gcc-arm-none-eabi"//, label: "install arm"
        }
        if(build_essential){
            script.sh "echo apt-get install -y build-essential"//, label: "install build-essential"
        }
        if(apt_utils){
            script.sh "echo apt-get install apt-utils"//, label: "install apt-utils"
        }
        if(ninja){
            script.sh "echo apt-get -y -qq update && apt-get -y -qq install cmake ninja-build"//, label: "install ninja"
        }
    }

    def install_pipeline_specific(String arm_version, boolean arm){
        if(arm && false){
            script.sh """
                wget -q https://developer.arm.com/-/media/Files/downloads/gnu/$arm_version/binrel/arm-gnu-toolchain-$arm_version-x86_64-arm-none-eabi.tar.xz
                echo "1"
                tar -xf arm-gnu-toolchain-$arm_version-x86_64-arm-none-eabi.tar.xz
                echo ${env.WORKSPACE}/arm-gnu-toolchain-$arm_version-x86_64-arm-none-eabi/bin >> env.GITHUB_PATH
            """//, label: "arm install"
        }
    }

    def check_installs(boolean arm){
        if(arm && false){
            script.sh "arm-none-eabi-gcc -v"//, label: "check installs"
        }
    }

    def make_build(String workingRepo, boolean ninja){
        if(ninja && false){
            script.sh """
                cd $workingRepo
                cmake -S. -Bbuild -GNinja
            """//, label:"build ninja"
        }
        script.sh """
            echo cd $workingRepo
            echo cmake --build build -v  
        """ //, label:"make build"
    }

    def example_test(String workingRepo){
        script.sh """
            echo cd $workingRepo
            echo sh ./.example-test.sh
        """ //, label:"example test"
    }

    def static_code_test(String workingRepo){
        script.sh """
            echo cd $workingRepo
            echo sh ./.stdc++-test.sh 
        """ //, label:"static code test"
    }

    def unit_test(String workingRepo){
        script.sh """
            echo cd $workingRepo
            echo make all -f .unit-test.make 
        """ //, label:"make unit test"
    }
}

