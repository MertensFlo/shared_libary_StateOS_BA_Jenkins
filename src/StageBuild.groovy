

def build(){
    def sharedSteps = new SharedSteps()
    sharedSteps.install_dependencies()
    sharedSteps.checkout_git()
    sharedSteps.install_ninja()
    sharedSteps.arm_install()
    sharedSteps.check_installs()
    sh script:'''
        cd StateOS_BA_Jenkins
        cmake -S. -Bbuild -GNinja
        cmake --build build -v  
    ''' , label:"make test"
} 