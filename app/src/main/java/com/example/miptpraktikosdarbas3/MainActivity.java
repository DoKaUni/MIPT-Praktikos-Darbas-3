package com.example.miptpraktikosdarbas3;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    double memoryResult = 0;
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
    }

    void assignButtonId(Button button, int id){
        button = findViewById(id);
        button.setOnClickListener(this);
    }

    String removeChar(String string, int index){
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.deleteCharAt(index);

        return stringBuilder.toString();
    }

    String addChar(String string, char character, int index){
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.insert(index, character);

        return stringBuilder.toString();
    }

    boolean unfinishedOperationExists(String string){
        if(string.length() < 2)
            return false;

        char operationChar = string.charAt(string.length() - 2);
        return operationChar == '/' || operationChar == '*' || operationChar == '+' || operationChar == '-';
    }

    boolean isLastCharDigit(String string){
        if(string.isEmpty())
            return false;

        return Character.isDigit(string.charAt(string.length() - 1));
    }

    String copyDigitSection(String string){
        int lastWhitespaceIndex = string.lastIndexOf(' ');

        if(lastWhitespaceIndex == -1)
            return string;
        else
            return string.substring(lastWhitespaceIndex + 1);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String calcDataString = calculatorText.getText().toString();

        if(buttonText.equals("MC"))
            memoryResult = 0;
        else if(buttonText.equals("MR"))
            calcDataString = String.valueOf(memoryResult);
        else if(buttonText.equals("MS") || buttonText.equals("M+") || buttonText.equals("M-")){
            if(!isLastCharDigit(calcDataString))
                return;

            String digitSection = copyDigitSection(calcDataString);
            switch(buttonText) {
                case "MS":
                    memoryResult = Double.parseDouble(digitSection);

                    break;
                case "M+":
                    memoryResult += Double.parseDouble(digitSection);

                    break;
                case "M-":
                    memoryResult -= Double.parseDouble(digitSection);

                    break;
            }
        }else if(button.equals(findViewById((R.id.back)))) {
            if (calcDataString.isEmpty())
                return;

            calcDataString = calcDataString.trim();
            calcDataString = calcDataString.substring(0, calcDataString.length() - 1);
        } else if(buttonText.equals("CE")){
            if(calcDataString.isEmpty())
                return;

            int lastSpaceIndex = calcDataString.lastIndexOf(' ');
            calcDataString = calcDataString.substring(0, lastSpaceIndex + 1);
        } else if(buttonText.equals("C"))
            calcDataString = "";
        else if(button.equals(findViewById(R.id.plusMinus))) {
            if(calcDataString.isEmpty())
                return;

            int lastSpaceIndex = calcDataString.lastIndexOf(' ');
            if(calcDataString.charAt(lastSpaceIndex + 1) == '-')
                calcDataString = removeChar(calcDataString, lastSpaceIndex + 1);
            else
                calcDataString = addChar(calcDataString, '-', lastSpaceIndex + 1);
        }else if(buttonText.equals("√") || buttonText.equals("%") || buttonText.equals("1/x")) {
            if(calcDataString.isEmpty())
                return;
            if(!isLastCharDigit(calcDataString))
                return;

            String digitSection;
            int lastWhitespaceIndex = calcDataString.lastIndexOf(' ');

            if(lastWhitespaceIndex != -1){
                digitSection = calcDataString.substring(lastWhitespaceIndex + 1);
                calcDataString = calcDataString.substring(0, lastWhitespaceIndex + 1);
            } else {
                digitSection = calcDataString;
                calcDataString = "";
            }

            double result = Double.parseDouble(digitSection);
            switch(buttonText) {
                case "√":
                    result = Math.sqrt(result);

                    break;
                case "%":
                    result = result / 100;

                    break;
                case "1/x":
                    result = 1 / result;

                    break;
            }

            calcDataString += result;
        }else if(buttonText.equals("/") || buttonText.equals("*") || buttonText.equals("+") || buttonText.equals("-")) {
            if(calcDataString.isEmpty())
                return;
            if(unfinishedOperationExists(calcDataString))
                return;

            calcDataString += " " + buttonText + " ";
        }else if(buttonText.equals(".")) {
            if(!isLastCharDigit(calcDataString))
                calcDataString += 0;

            String digitSection = copyDigitSection(calcDataString);

            if (digitSection.contains("."))
                return;

            calcDataString += buttonText;
        }else if(buttonText.equals("=")) {
            if(unfinishedOperationExists(calcDataString))
                return;

            Expression expression = new ExpressionBuilder(calcDataString).build();
            calcDataString = Double.toString(expression.evaluate());
        }else
            calcDataString += buttonText;

        calculatorText.setText(calcDataString);
    }
}