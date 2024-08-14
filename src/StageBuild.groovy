class StageBuild{
    private final Script script

    StageBuild(Script script) {
        this.script = script
    }

    void build(Boolean flag_git, Boolean flag_wget, Boolean flag_xz_utils, Boolean flag_arm, Boolean flag_build_essential, Boolean flag_apt_utils, Boolean flag_ninja, Boolean flag_submodule, String workingOrg, String workingRepo, String arm_path, String arm_tar_path, String arm_dir_path, String arm_condition, String arm_working_dir, String cmake_version){
        def sharedSteps = new SharedSteps(this)
        sharedSteps.install_dependencies(flag_git, flag_wget, flag_xz_utils, flag_arm, flag_build_essential, flag_apt_utils, flag_ninja, workingRepo, cmake_version) //(Boolean git, Boolean wget, Boolean xz-utils, Boolean arm, Boolean build-essential, Boolean apt-utils)
        sharedSteps.checkout_git(workingOrg, workingRepo, flag_submodule) //(String workingOrg, String workingRepo, Boolean flag_submodule)
        sharedSteps.install_pipeline_specific(arm_path, arm_tar_path, arm_dir_path, arm_condition, arm_working_dir, flag_arm) //(String arm_path, String arm_tar_path,String arm_dir_path String arm_condition, String arm_working_dir, Boolean flag_arm)
        sharedSteps.check_installs(flag_arm) //(Boolean flag_arm)
        sharedSteps.make_build(workingRepo, flag_ninja, flag_cmake_build) //(String workingRepo, Boolean flag_ninja, Boolean flag_cmake_build)
    } 
}