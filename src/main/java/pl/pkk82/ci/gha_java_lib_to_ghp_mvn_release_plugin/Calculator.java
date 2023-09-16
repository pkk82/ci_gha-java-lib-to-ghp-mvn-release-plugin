package pl.pkk82.ci.gha_java_lib_to_ghp_mvn_release_plugin;

import java.util.function.IntFunction;
public class Calculator {

    private int value = 0;

    public int apply(IntFunction<Integer> f) {
        value = f.apply(value);
        return value;
    }

    public int currentValue(int value) {
        this.value = value;
        return this.value;
    }

    public int currentValue() {
        return value;
    }

    public void reset() {
        value = 0;
    }
}

