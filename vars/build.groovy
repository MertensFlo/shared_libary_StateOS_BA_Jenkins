#!/usr/bin/env groovy


def call(){

    sh '''
        apt-get update && apt-get -y -qq install git
        apt-get update && apt-get install -y wget
        apt-get update && apt-get install -y xz-utils 
        apt-get update && apt-get install -y gcc-arm-none-eabi
        apt-get update && apt-get install -y build-essential

        git --version
        git clone https://github.com/MertensFlo/StateOS_BA_Jenkins.git
        cd StateOS_BA_Jenkins
        git remote
        git submodule update --init --remote --recursive
        apt-get -y -qq update && apt-get -y -qq install cmake ninja-build
        wget -q https://developer.arm.com/-/media/Files/downloads/gnu/11.3.rel1/binrel/arm-gnu-toolchain-11.3.rel1-x86_64-arm-none-eabi.tar.xz
        echo "1"
        tar -xf arm-gnu-toolchain-11.3.rel1-x86_64-arm-none-eabi.tar.xz
    '''
    script{
        env.JENKINS_PATH = "${env.WORKSPACE}/arm-gnu-toolchain-11.3.rel1-x86_64-arm-none-eabi/bin"
    }
    sh '''
        arm-none-eabi-gcc -v
        cd StateOS_BA_Jenkins
        cmake -S. -Bbuild -GNinja
        cmake --build build -v  
    '''               
}