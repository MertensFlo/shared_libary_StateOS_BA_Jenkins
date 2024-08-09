
def example_test(){/*
    def sharedSteps = new SharedSteps()
    //sharedSteps.install_ninja()
    //sharedSteps.arm_install()
    sharedSteps.check_installs()
    sh script:'''
        cd StateOS_BA_Jenkins
        sh ./.example-test.sh
    ''' , label:"example test"
    //cmake -S. -Bbuild -GNinja
     //   cmake --build build -v */
} 

def static_test(){/*
    def sharedSteps = new SharedSteps()
    //sharedSteps.install_ninja()
    //sharedSteps.arm_install()
    sharedSteps.check_installs()
    sh script:'''
        cd StateOS_BA_Jenkins
        sh ./.stdc++-test.sh 
    ''' , label:"static code test"
    //cmake -S. -Bbuild -GNinja
     //   cmake --build build -v */
} 

def unit_test(){/*
    def sharedSteps = new SharedSteps()
    //sharedSteps.install_ninja()
    //sharedSteps.arm_install()
    sharedSteps.check_installs()
    sh script:'''
        cd StateOS_BA_Jenkins
        make all -f .unit-test.make 
    ''' , label:"make unit test"
    //cmake -S. -Bbuild -GNinja
     //   cmake --build build -v */
} 