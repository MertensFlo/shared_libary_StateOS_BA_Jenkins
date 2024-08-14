class Stages_{
    private final Script script
    StageBuild buildStage
    StageTest testStage

    Stages_(Script script) {
        this.script = script
        this.buildStage = new StageBuild(script)
        this.testStage = new StageTest(script)
    }

    void build(String stage_name, boolean flag_git, boolean flag_wget, boolean flag_xz_utils, boolean flag_arm, boolean flag_build_essential, boolean flag_apt_utils, boolean flag_ninja, boolean flag_submodule, String workingOrg, String workingRepo, String arm_path, String arm_tar_path, String arm_dir_path, String arm_condition, String cmake_version){
        script.stage(stage_name) {
            buildStage.build( flag_git, flag_wget, flag_xz_utils, flag_arm, flag_build_essential, flag_apt_utils, flag_ninja, flag_submodule, workingOrg, workingRepo, arm_path, arm_tar_path, arm_dir_path, arm_condition, cmake_version)  //(boolean flag_git, boolean flag_wget, boolean flag_xz_utils, boolean flag_arm, boolean flag_build_essential, boolean flag_apt_utils, boolean flag_ninja, boolean flag_submodule, String workingOrg, String workingRepo, String arm_path, String arm_tar_path, String arm_dir_path, String arm_condition, String cmake_version)
        }
    }

    void example_test(String stage_name, boolean flag_example_test, boolean flag_static_code, boolean flag_unit_test, boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String workingRepo){
        script.stage(stage_name) {
            testStage.test( flag_example_test, flag_static_code, flag_unit_test, flag_arm, arm_path, arm_tar_path, arm_dir_path, arm_condition, workingRepo) //(boolean flag_example_test, boolean flag_static_code, boolean flag_unit_test, boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String workingRepo)
        }
    }

    void static_code_test(String stage_name,boolean flag_example_test, boolean flag_static_code, boolean flag_unit_test, boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String workingRepo){
        script.stage(stage_name) {
            testStage.test(fflag_example_test, flag_static_code, flag_unit_test, flag_arm, arm_path, arm_tar_path, arm_dir_path, arm_condition, workingRepo) //(boolean flag_example_test, boolean flag_static_code, boolean flag_unit_test, boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String workingRepo)
        }
        
    }

    void unit_test(String stage_name,boolean flag_example_test, boolean flag_static_code, boolean flag_unit_test, boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String workingRepo){
        script.stage(stage_name) {
            testStage.test(flag_example_test, flag_static_code, flag_unit_test, flag_arm, arm_path, arm_tar_path, arm_dir_path, arm_condition, workingRepo) //(boolean flag_example_test, boolean flag_static_code, boolean flag_unit_test, boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String workingRepo)
        }
    }
}