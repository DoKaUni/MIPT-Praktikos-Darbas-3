package com.example.miptpraktikosdarbas3;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity{
    double memoryResult;
    TextView calculatorText;
    Button buttonMC, buttonMR, buttonMS, buttonMPlus, buttonMMinus,
            buttonBack, buttonCE, buttonC, buttonPlusMinus, buttonSquareRoot,
            buttonDivision, buttonPercentage, buttonMultiplication, buttonFraction, buttonAddition,
            buttonSubtraction, buttonDecimalPoint, buttonEquals, buttonN1, buttonN2,
            buttonN3, buttonN4, buttonN5, buttonN6, buttonN7, buttonN8, buttonN9, buttonN0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String expressionString = "2 + 3 * 1/4"; // Example expression

        try {
            Expression expression = new ExpressionBuilder(expressionString)
                    .build();

            double result = expression.evaluate();

            Log.d("Calculation Result", String.valueOf(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}