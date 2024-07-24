def call(){
    sh '''
        apt-get update && apt-get -y -qq install git
        apt-get apt-get install -y wget
        apt-get apt-get install -y xz-utils 
        apt-get apt-get install -y gcc-arm-none-eabi
        apt-get apt-get install -y build-essential
        apt-get install apt-utils
    '''
}