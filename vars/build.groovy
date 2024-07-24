#!/usr/bin/env groovy
import vars.shared_steps

def call(){
    install_dependencies()
    checkout()
    sh'''
        apt-get -y -qq update && apt-get -y -qq install cmake ninja-build
    '''
    arm-none-eabi-gcc()
    check_installs()
    sh '''
        cd StateOS_BA_Jenkins
        cmake -S. -Bbuild -GNinja
        cmake --build build -v  
    '''               
}