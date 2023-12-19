package com.example.miptpraktikosdarbas3;

import org.junit.Test;

import static org.junit.Assert.*;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testAddition() {
        String calcDataString = "2 + 2";
        Expression expression = new ExpressionBuilder(calcDataString).build();
        double result = expression.evaluate();
        double expected = 4.0;
        assertEquals(expected, result, 0.0001); // Delta value to handle rounding issues
    }

    @Test
    public void testSubtraction(){
        String calcDataString = "2 - 2";
        Expression expression = new ExpressionBuilder(calcDataString).build();
        double result = expression.evaluate();
        double expected = 0.0;
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testMultiplication(){
        String calcDataString = "2 * 3";
        Expression expression = new ExpressionBuilder(calcDataString).build();
        double result = expression.evaluate();
        double expected = 6.0;
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testDivision(){
        String calcDataString = "6 / 3";
        Expression expression = new ExpressionBuilder(calcDataString).build();
        double result = expression.evaluate();
        double expected = 2.0;
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testSquareRoot(){
        double result = Math.sqrt(9);
        double expected = 3.0;
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testPercentage(){
        double result = 69.0 / 100.0;
        double expected = 0.69;
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testFraction(){
        double result = 1.0 / 5.0;
        double expected = 0.2;
        assertEquals(expected, result, 0.0001);
    }
}