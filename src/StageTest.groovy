
def test(boolean example_test, boolean static_code, boolean unit_test, boolean arm, String arm_version, String workingRepo){
    def sharedSteps = new SharedSteps()
    //sharedSteps.install_ninja()
    sharedSteps.install_pipeline_specific(arm_version, arm)
    sharedSteps.check_installs(arm)
    if(example_test){
        sharedSteps.example_test(workingRepo)
    }else if(static_code){
        sharedSteps.static_test(workingRepo)
    }else if(unit){
        sharedSteps.unit_test(workingRepo)
    }
} 
