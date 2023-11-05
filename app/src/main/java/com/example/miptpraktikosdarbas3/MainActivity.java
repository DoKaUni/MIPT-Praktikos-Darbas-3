package com.example.miptpraktikosdarbas3;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    double memoryResult;
    TextView calculatorText;
    Button buttonMC, buttonMR, buttonMS, buttonMPlus, buttonMMinus,
            buttonBack, buttonCE, buttonC, buttonPlusMinus, buttonSquareRoot,
            buttonDivision, buttonPercent, buttonMultiplication, buttonFraction, buttonAddition,
            buttonSubtraction, buttonDecimalPoint, buttonEquals, buttonN1, buttonN2,
            buttonN3, buttonN4, buttonN5, buttonN6, buttonN7, buttonN8, buttonN9, buttonN0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorText = findViewById(R.id.calculatorText);

        assignButtonId(buttonMC, R.id.MC);
        assignButtonId(buttonMR, R.id.MR);
        assignButtonId(buttonMS, R.id.MS);
        assignButtonId(buttonMPlus, R.id.MPlus);
        assignButtonId(buttonMMinus, R.id.MMinus);
        assignButtonId(buttonBack, R.id.back);
        assignButtonId(buttonCE, R.id.CE);
        assignButtonId(buttonC, R.id.C);
        assignButtonId(buttonPlusMinus, R.id.plusMinus);
        assignButtonId(buttonSquareRoot, R.id.squareRoot);
        assignButtonId(buttonDivision, R.id.division);
        assignButtonId(buttonPercent, R.id.percent);
        assignButtonId(buttonMultiplication, R.id.multiplication);
        assignButtonId(buttonFraction, R.id.fraction);
        assignButtonId(buttonAddition, R.id.addition);
        assignButtonId(buttonSubtraction, R.id.subtraction);
        assignButtonId(buttonDecimalPoint, R.id.decimalPoint);
        assignButtonId(buttonEquals, R.id.equals);
        assignButtonId(buttonN1, R.id.n1);
        assignButtonId(buttonN2, R.id.n2);
        assignButtonId(buttonN3, R.id.n3);
        assignButtonId(buttonN4, R.id.n4);
        assignButtonId(buttonN5, R.id.n5);
        assignButtonId(buttonN6, R.id.n6);
        assignButtonId(buttonN7, R.id.n7);
        assignButtonId(buttonN8, R.id.n8);
        assignButtonId(buttonN9, R.id.n9);
        assignButtonId(buttonN0, R.id.n0);

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

    void assignButtonId(Button button, int id){
        button = findViewById(id);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String calcDataString = calculatorText.getText().toString();
        calcDataString += buttonText;

        calculatorText.setText(calcDataString);
    }
}