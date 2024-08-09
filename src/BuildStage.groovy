#!/usr/bin/env groovy

class BuildStage{
    void defineParameters(){

    }
    void defineOptions(){

    }
    void body(){
        install_dependencies()
        checkout_git()
        sh'''
            apt-get -y -qq update && apt-get -y -qq install cmake ninja-build
        '''
        arm_none_eabi_gcc()
        check_installs()
        sh '''
            cd StateOS_BA_Jenkins
            cmake -S. -Bbuild -GNinja
            cmake --build build -v  
        '''  
    }
}