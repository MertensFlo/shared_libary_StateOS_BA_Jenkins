def build(boolean git, boolean wget, boolean xz_utils, boolean arm, boolean build_essential, boolean apt_utils, String workingOrg, String workingRepo, String arm_version){
    def sharedSteps = new SharedSteps()
    sharedSteps.install_dependencies(git, wget, xz_utils, arm, build_essential, apt_utils) //(boolean git, boolean wget, boolean xz-utils, boolean arm, boolean build-essential, boolean apt-utils)
    sharedSteps.checkout_git(workingOrg, workingRepo) //(String workingOrg, String workingRepo)
    sharedSteps.install_pipeline_specific(arm_version, arm) //(String arm version, boolean arm)
    sharedSteps.check_installs(arm)
    sharedSteps.make_build(ninja)
} 