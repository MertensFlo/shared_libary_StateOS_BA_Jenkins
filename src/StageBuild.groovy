#!/usr/bin/env groovy

def build(){
    def sharedSteps = new SharedSteps()
    sharedSteps.install_dependencies()
    sharedSteps.checkout_git()
    sh script:'''
        apt-get -y -qq update && apt-get -y -qq install cmake ninja-build
    ''' , label:"further installs"
    sharedSteps.arm_install()
    sharedSteps.check_installs()
    sh script:'''
        cd StateOS_BA_Jenkins
        cmake -S. -Bbuild -GNinja
        cmake --build build -v  
    ''' , label:"make test"
} 