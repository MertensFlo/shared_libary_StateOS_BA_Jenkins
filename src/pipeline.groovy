class Pipeline_ {
    private final Script script

    Pipeline_(Script script) {
        this.script = script
    }

    void pipeline_build(Boolean build, Boolean example_test, Boolean static_test, Boolean unit_test){
        def stages = new Stages_(script)
        if(build){
            stages.build("build")
        }
        if(example_test){
            stages.example_test("example_test")
        }
        if(static_test){
            stages.static_test("static_test")
        }
        if(unit_test){
            stages.unit_test("unit_test")
        }
    }
}