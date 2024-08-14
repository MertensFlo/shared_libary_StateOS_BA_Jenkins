class Stages_{
    private final Script script

    Stages_(Script script) {
        this.script = script
    }

    void build(String stage_name, Boolean flag_git, Boolean flag_wget, Boolean flag_xz_utils, Boolean flag_arm, Boolean flag_build_essential, Boolean flag_apt_utils, Boolean flag_ninja, Boolean flag_submodule, String workingOrg, String workingRepo, String arm_path, String arm_tar_path, String arm_dir_path, String arm_condition, String arm_working_dir, String cmake_version){
        script.stage(stage_name) {
            def buildStage = new StageBuild(script)
            buildStage.build( flag_git, flag_wget, flag_xz_utils, flag_arm, flag_build_essential, flag_apt_utils, flag_ninja, flag_submodule, workingOrg, workingRepo, arm_path, arm_tar_path, arm_dir_path, arm_condition, arm_working_dir, cmake_version)  //(Boolean flag_git, Boolean flag_wget, Boolean flag_xz_utils, Boolean flag_arm, Boolean flag_build_essential, Boolean flag_apt_utils, Boolean flag_ninja, Boolean flag_submodule, String workingOrg, String workingRepo, String arm_path, String arm_tar_path, String arm_dir_path, String arm_condition, String arm_working_dir,  String cmake_version)
        }
    }

    void example_test(String stage_name, Boolean flag_example_test, Boolean flag_static_code, Boolean flag_unit_test, Boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String arm_working_dir, String workingRepo){
        script.stage(stage_name) {
            def testStage = new StageTest(script)
            testStage.test( flag_example_test, flag_static_code, flag_unit_test, flag_arm, arm_path, arm_tar_path, arm_dir_path, arm_condition, arm_working_dir, workingRepo) //(Boolean flag_example_test, Boolean flag_static_code, Boolean flag_unit_test, Boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String arm_working_dir, String workingRepo)
        }
    }

    void static_code_test(String stage_name,Boolean flag_example_test, Boolean flag_static_code, Boolean flag_unit_test, Boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String arm_working_dir, String workingRepo){
        script.stage(stage_name) {
            def testStage = new StageTest(script)
            testStage.test(fflag_example_test, flag_static_code, flag_unit_test, flag_arm, arm_path, arm_tar_path, arm_dir_path, arm_condition, arm_working_dir, workingRepo) //(Boolean flag_example_test, Boolean flag_static_code, Boolean flag_unit_test, Boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String arm_working_dir, String workingRepo)
        }
        
    }

    void unit_test(String stage_name,Boolean flag_example_test, Boolean flag_static_code, Boolean flag_unit_test, Boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String arm_working_dir, String workingRepo){
        script.stage(stage_name) {
            def testStage = new StageTest(script)
            testStage.test(flag_example_test, flag_static_code, flag_unit_test, flag_arm, arm_path, arm_tar_path, arm_dir_path, arm_condition, arm_working_dir, workingRepo) //(Boolean flag_example_test, Boolean flag_static_code, Boolean flag_unit_test, Boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String arm_working_dir, String workingRepo)
        }
    }
}