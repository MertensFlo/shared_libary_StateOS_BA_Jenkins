class StageBuild {
    private final Script script

    StageBuild(Script script) {
        this.script = script
    }

    void build(boolean flag_git, boolean flag_wget, boolean flag_xz_utils, boolean flag_arm, boolean flag_build_essential, boolean flag_apt_utils, boolean flag_ninja, boolean flag_submodule, String workingOrg, String workingRepo, String arm_path, String arm_tar_path, String arm_dir_path, String arm_condition, String cmake_version){
        def sharedSteps = new SharedSteps(script)
        sharedSteps.install_dependencies(flag_git, flag_wget, flag_xz_utils, flag_arm, flag_build_essential, flag_apt_utils, flag_ninja, cmake_version) //(boolean git, boolean wget, boolean xz-utils, boolean arm, boolean build-essential, boolean apt-utils)
        sharedSteps.checkout_git(workingOrg, workingRepo, flag_submodule) //(String workingOrg, String workingRepo, boolean flag_submodule)
        sharedSteps.install_pipeline_specific(arm_path, arm_tar_path, arm_dir_path, arm_condition, flag_arm) //(String arm_path, String arm_tar_path,String arm_dir_path String arm_condition, boolean flag_arm)
        sharedSteps.check_installs(flag_arm) //(boolean flag_arm)
        sharedSteps.make_build(workingRepo, flag_ninja, flag_cmake_build) //(String workingRepo, boolean flag_ninja, boolean flag_cmake_build)
    } 
}