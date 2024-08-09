def call(){
    sh '''
        apt-get update && apt-get -y -qq install git
        apt-get install -y wget
        apt-get install -y xz-utils 
        apt-get install -y gcc-arm-none-eabi
        apt-get install -y build-essential
        apt-get install apt-utils
    '''
}