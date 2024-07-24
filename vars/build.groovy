#!/usr/bin/env groovy

def call(){
    script{
        shared_steps.install_dependencies()
        shared_steps.checkout()
    }
    sh'''
        apt-get -y -qq update && apt-get -y -qq install cmake ninja-build
    '''
    script{
        shared_steps.arm-none-eabi-gcc()
        shared_steps.check_installs()
    }
    sh '''
        cd StateOS_BA_Jenkins
        cmake -S. -Bbuild -GNinja
        cmake --build build -v  
    '''               
}