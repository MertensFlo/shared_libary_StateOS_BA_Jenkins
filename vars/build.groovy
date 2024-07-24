#!/usr/bin/env groovy

def call(){
    script{
        install_dependencies()
        checkout()
    }
    sh'''
        apt-get -y -qq update && apt-get -y -qq install cmake ninja-build
    '''
    script{
        arm-none-eabi-gcc()
        check_installs()
    }
    sh '''
        cd StateOS_BA_Jenkins
        cmake -S. -Bbuild -GNinja
        cmake --build build -v  
    '''               
}