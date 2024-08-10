
def example_test(){
    def sharedSteps = new SharedSteps()
    //sharedSteps.install_ninja()
    //sharedSteps.arm_install()
    sharedSteps.check_installs()
    sh script:'''
        cd StateOS_BA_Jenkins
        sh ./.example-test.sh
    ''' , label:"example test"
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
} 