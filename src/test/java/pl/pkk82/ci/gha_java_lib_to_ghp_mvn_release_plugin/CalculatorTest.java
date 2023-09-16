package pl.pkk82.ci.gha_java_lib_to_ghp_mvn_release_plugin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class CalculatorTests {

    private int result;
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    @Test
    void shouldAddTwoPositiveNumbers() {
        whenAdd(1, 2);
        then(result).isEqualTo(3);
    }

    @Test
    void shouldAddTwoNegativeNumbers() {
        whenAdd(-1, -2);
        then(result).isEqualTo(-3);
    }

    @Test
    void shouldMultiplyTwoPositiveNumbers() {
        whenMultiply(1, 2);
        then(result).isEqualTo(2);
    }

    @Test
    void shouldMultiplyTwoNegativeNumbers() {
        whenMultiply(-1, -2);
        then(result).isEqualTo(2);
    }

    @Test
    void shouldSetValue() {
        whenSet10();
        then(result).isEqualTo(10);
    }

    @Test
    void shouldReset() {
        calculator.currentValue(10);
        whenReset();
        then(result).isEqualTo(0);
    }


    private void whenAdd(int a, int b) {
        calculator.currentValue(a);
        result = calculator.apply(x -> x + b);
    }

    private void whenMultiply(int a, int b) {
        calculator.currentValue(a);
        calculator.apply(x -> x * b);
        result = calculator.currentValue();
    }

    private void whenReset() {
        calculator.reset();
        result = calculator.currentValue();
    }

    private void whenSet10() {
        result = calculator.currentValue(10);
    }
}

