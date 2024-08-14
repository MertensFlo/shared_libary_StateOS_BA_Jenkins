class Pipeline_{
    private final Script script

    Pipeline_(Script script) {
        this.script = script
    }

    void pipeline_build(Boolean flag_build, Boolean flag_example_test, Boolean flag_static_test, Boolean flag_unit_test, Boolean flag_git, Boolean flag_wget, Boolean flag_xz_utils, Boolean flag_arm, Boolean flag_build_essential, Boolean flag_apt_utils, Boolean flag_ninja, Boolean flag_submodule, Boolean flag_cmake_build, String workingOrg, String workingRepo, String arm_path, String arm_tar_path, String arm_dir_path, String arm_condition, String cmake_version){
        def stages = new Stages_(script)
        if(flag_build){
            stages.build("build", flag_git, flag_wget, flag_xz_utils, flag_arm, flag_build_essential, flag_apt_utils, flag_ninja, flag_submodule, flag_cmake_build, workingOrg, workingRepo, arm_path, arm_tar_path, arm_dir_path, arm_condition, cmake_version)  //(Boolean flag_git, Boolean flag_wget, Boolean flag_xz_utils, Boolean flag_arm, Boolean flag_build_essential, Boolean flag_apt_utils, Boolean flag_ninja, Boolean flag_submodule, String workingOrg, String workingRepo, String arm_path, String arm_tar_path, String arm_dir_path, String arm_condition, String cmake_version))
        }
        if(flag_example_test){
            stages.example_test("example_test", true, false, false, flag_arm, arm_path, arm_tar_path, arm_dir_path, arm_condition, workingRepo) //(Boolean flag_example_test, Boolean flag_static_code, Boolean flag_unit_test, Boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String workingRepo)
        }
        if(flag_static_test){
            stages.static_code_test("static_test", false, true, false, flag_arm, arm_path, arm_tar_path, arm_dir_path, arm_condition, workingRepo) //(Boolean flag_example_test, Boolean flag_static_code, Boolean flag_unit_test, Boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String workingRepo)
        }
        if(flag_unit_test){
            stages.unit_test("unit_test", false, false, true, flag_arm, arm_path, arm_tar_path, arm_dir_path, arm_condition, workingRepo) //(Boolean flag_example_test, Boolean flag_static_code, Boolean flag_unit_test, Boolean flag_arm, String arm_path, String arm_tar_path,String arm_dir_path, String arm_condition, String workingRepo)
        }
    }
}