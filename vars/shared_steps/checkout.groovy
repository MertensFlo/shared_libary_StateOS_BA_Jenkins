def call(){
    sh '''
        git --version
        git clone https://github.com/MertensFlo/StateOS_BA_Jenkins.git
        cd StateOS_BA_Jenkins
        git remote
        git submodule update --init --remote --recursive
    '''
}