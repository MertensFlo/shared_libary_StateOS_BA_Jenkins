class StageTest {
    private final Script script

    StageTest(Script script) {
        this.script = script
    }

    void test(boolean flag_example_test, boolean flag_static_code, boolean flag_unit_test, boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String workingRepo){
        def sharedSteps = new SharedSteps(script)
        sharedSteps.install_pipeline_specific(arm_path, arm_tar_path, arm_dir_path, arm_condition, flag_arm) //(String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, boolean flag_arm)
        sharedSteps.check_installs(flag_arm) //(boolean flag_arm)
        if(flag_example_test){
            sharedSteps.example_test(workingRepo) //(String workingRepo)
        }else if(flag_static_code){
            sharedSteps.static_code_test(workingRepo) //(String workingRepo)
        }else if(flag_unit_test){ 
            sharedSteps.unit_test(workingRepo) //(String workingRepo)
        }
    }
}