#!/usr/bin/env groovy

def build(){
    def sharedSteps = new SharedSteps()
    sharedSteps.install_dependencies()
    sharedSteps.checkout_git()
    sh'''
        apt-get -y -qq update && apt-get -y -qq install cmake ninja-build
    '''
    sharedSteps.arm_none_eabi_gcc()
    sharedSteps.check_installs()
    sh '''
        cd StateOS_BA_Jenkins
        cmake -S. -Bbuild -GNinja
        cmake --build build -v  
    ''' 
} 