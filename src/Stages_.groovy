class Stages_{
    private final Script script

    Stages_(Script script) {
        this.script = script
    }

    void build(String name){
        script.stage(name) {
            def buildStage = new StageBuild(script)
            buildStage.build(true, true, true, true, true,true, true, "MertensFlo", "StateOS_BA_Jenkins", "11.3.rel1")  //(boolean git, boolean wget, boolean xz-utils, boolean arm, boolean build-essential, boolean apt-utils,String workingOrg, String workingRepo, String arm_version)
        }
    }

    void example_test(String name){
        script.stage(name) {
            if(false){
                def testStage = new StageTest(script)
                testStage.test(false, false, false, true, "11.3.rel1", "StateOS_BA_Jenkins") //(boolean example_test, boolean static_code, boolean unit_test, boolean arm, String arm_version, String workingRepo)
            }
        }
    }

    void static_code_test(String name){
        script.stage(name) {
            if(false){
                def testStage = new StageTest(script)
                testStage.test(false, false, true, true, "11.3.rel1", "StateOS_BA_Jenkins") //(boolean example_test, boolean static_code, boolean unit_test, boolean arm, String arm_version, String workingRepo)
            }
        }
        
    }

    void unit_test(String name){
        script.stage(name) {
            if(true) {
                def testStage = new StageTest(script)
                testStage.test(false, false, true, true, "11.3.rel1", "StateOS_BA_Jenkins") //(boolean example_test, boolean static_code, boolean unit_test, boolean arm, String arm_version, String workingRepo)
            }
        }
    }
}