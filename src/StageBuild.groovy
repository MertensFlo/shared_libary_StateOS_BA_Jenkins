def build(){
    def sharedSteps = new SharedSteps()
    sharedSteps.install_dependencies()
    sharedSteps.checkout_git("MertensFlo","StateOS_BA_Jenkins")
    sharedSteps.install_ninja()
    sharedSteps.arm_install("11.3.rel1")
    sharedSteps.check_installs()
    sh script:'''
        cd StateOS_BA_Jenkins
        cmake -S. -Bbuild -GNinja
        cmake --build build -v  
    ''' , label:"make test"
} 