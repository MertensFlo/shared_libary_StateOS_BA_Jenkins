
def checkout_git(){

    sh '''
        git --version
        git clone https://github.com/MertensFlo/StateOS_BA_Jenkins.git
        cd StateOS_BA_Jenkins
        git remote
        git submodule update --init --remote --recursive
    ''' label: "git checkout"
}

def install_dependencies(){
    sh '''
        apt-get update && apt-get -y -qq install git
        apt-get install -y wget
        apt-get install -y xz-utils 
        apt-get install -y gcc-arm-none-eabi
        apt-get install -y build-essential
        apt-get install apt-utils
    ''' label: "install dependencies"
}

def arm_install(){
    sh '''
        wget -q https://developer.arm.com/-/media/Files/downloads/gnu/11.3.rel1/binrel/arm-gnu-toolchain-11.3.rel1-x86_64-arm-none-eabi.tar.xz
        echo "1"
        tar -xf arm-gnu-toolchain-11.3.rel1-x86_64-arm-none-eabi.tar.xz
    ''' label: "arm install"
    script{
        env.JENKINS_PATH = "${env.WORKSPACE}/arm-gnu-toolchain-11.3.rel1-x86_64-arm-none-eabi/bin"
    }  label: "set variable"
}

def check_installs(){
    sh '''
        arm-none-eabi-gcc -v
    ''' label: "check installs"
}