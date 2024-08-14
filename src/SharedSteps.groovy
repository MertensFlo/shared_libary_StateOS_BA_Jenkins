class SharedSteps {
    private final Script script

    SharedSteps(Script script) {
        this.script = script
    }
    def checkout_git(String workingOrg, String workingRepo, boolean submodule){
        script.sh """
            echo git --version
            echo git clone "https://github.com/"$workingOrg"/"$workingRepo".git"
            echo cd $workingRepo
            echo git remote"""
        if(submodule){
            script.sh "echo git submodule update --init --remote --recursive"
        }
    }

    def install_dependencies(boolean flag_git, boolean flag_wget, boolean flag_xz_utils, boolean flag_arm, boolean flag_build_essential, boolean flag_apt_utils, boolean flag_ninja, string cmake_verion){
        if(flag_git){
            script.sh "echo apt-get -y -qq install git"//, label: "install git"
        }
        if(flag_wget){
            script.sh "echo apt-get install -y wget"//, label: "install wget"
        }
        if(flag_xz_utils){
            script.sh "echo apt-get install -y xz-utils"//, label: "install xz-utils"
        }
        if(flag_arm){
            script.sh "echo apt-get install -y gcc-arm-none-eabi"//, label: "install arm"
        }
        if(flag_build_essential){
            script.sh "echo apt-get install -y build-essential"//, label: "install build-essential"
        }
        if(flag_apt_utils){
            script.sh "echo apt-get install apt-utils"//, label: "install apt-utils"
        }
        if(flag_ninja){
            script.sh "echo apt-get -y -qq update && echo apt-get -y -qq install $cmake_verison ninja-build"//, label: "install ninja"
        }
        script.sh """
            echo install python py.3.x
            echo python -m pip install --upgrade pip
            echo pip install jinja2 ruamel.yaml"""
        script.sh """
            """
    }

    def install_pipeline_specific(String arm_path, String arm_tar_path, String arm_dir_path, String arm_condition, String arm_working_dir, boolean flag_arm){
        if(flag_arm){
            script.sh """
                cd $arm_working_dir
                echo wget $arm_condition $arm_path
                echo tar -xf $arm_tar_path
                echo $arm_tar_path >> env.GITHUB_PATH
            """//, label: "arm install"
        }
    }

    def check_installs(boolean flag_arm){
        if(flag_arm){
            script.sh "echo arm-none-eabi-gcc -v"//, label: "check installs"
        }
    }

    def make_build(String workingRepo, boolean flag_ninja, boolean flag_cmake_build){
        if(flag_ninja){
            script.sh """
                echo cd $workingRepo
                echo cmake -S. -Bbuild -GNinja
            """//, label:"build ninja"
        }
        if(flag_cmake_build){
            script.sh """
                echo cd $workingRepo
                echo cmake --build build -v  
            """ //, label:"make build"
        }
        script.sh "echo ./scripts/buildAllConfigurations.sh configurations distortosTest" //TO-DO ----------------
    }

    def example_test(String workingRepo){
        if(false){
            script.sh """
                echo cd $workingRepo
                echo sh ./.example-test.sh
            """ //, label:"example test"
        }
        
        if(false){
            script.sh """
                for yamlFile in $(/usr/bin/find -L "${GITHUB_WORKSPACE}/source/board" -name '*.yaml')
                do
                    ${GITHUB_WORKSPACE}/scripts/generateBoard.py ${yamlFile}
                done

                git add -N .
                git diff --exit-code

                echo generate raw boards --------------------------

                for yamlFile in $(/usr/bin/find -L "${GITHUB_WORKSPACE}/source/chip" -name '*.yaml')
                do
                ${GITHUB_WORKSPACE}/scripts/generateBoard.py ${yamlFile} -o /tmp/$(basename ${yamlFile} .yaml)
                done
            """
        }
        
    }

    def static_code_test(String workingRepo){
        script.sh """
            echo cd $workingRepo
            echo sh ./.stdc++-test.sh 
        """ //, label:"static code test"
    }

    def unit_test(String workingRepo){
        if(false){
            script.sh """
                echo cd $workingRepo
                echo make all -f .unit-test.make 
            """ //, label:"make unit test"
        }
        if(false){
            script.sh """
                echo cmake -E make_directory ${{github.workspace}}/output
                echo cd cmake -G Ninja ${GITHUB_WORKSPACE}/unit-test
                CC=gcc-10
                CXX=g++-10
                echo cmake -G Ninja ${GITHUB_WORKSPACE}/unit-test
                echo cmake --build . --target all
                echo cmake --build . --target run
            """
        }
        
    }
}

