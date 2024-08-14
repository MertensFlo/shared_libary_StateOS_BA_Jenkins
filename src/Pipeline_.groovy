class Pipeline_{
    private final Script script

    Pipeline_(Script script) {
        this.script = script
    }

    void pipeline_build(Boolean flag_build, Boolean flag_example_test, Boolean flag_static_test, Boolean flag_unit_test, boolean flag_git, boolean flag_wget, boolean flag_xz_utils, boolean flag_arm, boolean flag_build_essential, boolean flag_apt_utils, boolean flag_ninja, boolean flag_submodule, String workingOrg, String workingRepo, String arm_path, String arm_tar_path, String arm_dir_path, String arm_condition, String cmake_version){
        def stages = new Stages_(script)
        if(build){
            stages.build("build", flag_git, flag_wget, flag_xz_utils, flag_arm, flag_build_essential, flag_apt_utils, flag_ninja, flag_submodule, workingOrg, workingRepo, arm_path, arm_tar_path, arm_dir_path, arm_condition, cmake_version)  //(boolean flag_git, boolean flag_wget, boolean flag_xz_utils, boolean flag_arm, boolean flag_build_essential, boolean flag_apt_utils, boolean flag_ninja, boolean flag_submodule, String workingOrg, String workingRepo, String arm_path, String arm_tar_path, String arm_dir_path, String arm_condition, String cmake_version))
        }
        if(example_test){
            stages.example_test("example_test", true, false, false, flag_arm, arm_path, arm_tar_path, arm_dir_path, arm_condition, workingRepo) //(boolean flag_example_test, boolean flag_static_code, boolean flag_unit_test, boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String workingRepo)
        }
        if(static_test){
            stages.static_code_test("static_test", false, true, false, flag_arm, arm_path, arm_tar_path, arm_dir_path, arm_condition, workingRepo) //(boolean flag_example_test, boolean flag_static_code, boolean flag_unit_test, boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String workingRepo)
        }
        if(unit_test){
            stages.unit_test("unit_test", false, false, true, flag_arm, arm_path, arm_tar_path, arm_dir_path, arm_condition, workingRepo) //(boolean flag_example_test, boolean flag_static_code, boolean flag_unit_test, boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String workingRepo)
        }
    }
}