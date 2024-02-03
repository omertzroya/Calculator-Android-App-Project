package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView resultTextView;
    double firstNum;
    String operation;
    Button sqrtButton , modButton, DelButton,zeroButton,oneButton,twoButton,threeButton,fourButton,fiveButton,sixButton,sevenButton,eightButton,nineButton,addButton,subButton,mulButton,divButton,clearButton,equalButton,pointButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.textViewResult);

        zeroButton = findViewById(R.id.buttonZero);
        oneButton = findViewById(R.id.buttonOne);
        twoButton = findViewById(R.id.buttonTwo);
        threeButton = findViewById(R.id.buttonThree);
        fourButton = findViewById(R.id.buttonFour);
        fiveButton = findViewById(R.id.buttonFive);
        sixButton = findViewById(R.id.buttonSix);
        sevenButton = findViewById(R.id.buttonSeven);
        eightButton = findViewById(R.id.buttonEight);
        nineButton = findViewById(R.id.buttonNine);

        addButton = findViewById(R.id.buttonPlus);
        subButton = findViewById(R.id.buttonMinus);
        mulButton = findViewById(R.id.buttonMultiply);
        divButton = findViewById(R.id.buttonDivide);
        clearButton = findViewById(R.id.buttonAC);
        equalButton = findViewById(R.id.buttonEqual);
        pointButton = findViewById(R.id.buttonPoint);
        DelButton = findViewById(R.id.buttonDel);
        modButton = findViewById(R.id.buttonMod);
        sqrtButton = findViewById(R.id.buttonSqrt);

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(zeroButton);
        nums.add(oneButton);
        nums.add(twoButton);
        nums.add(threeButton);
        nums.add(fourButton);
        nums.add(fiveButton);
        nums.add(sixButton);
        nums.add(sevenButton);
        nums.add(eightButton);
        nums.add(nineButton);

        for(Button b : nums){
            b.setOnClickListener(view -> {
                if(!resultTextView.getText().toString().equals("0")){
                    resultTextView.setText(resultTextView.getText().toString() + b.getText().toString());
                } else{
                    resultTextView.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> operators = new ArrayList<>();
        operators.add(addButton);
        operators.add(subButton);
        operators.add(mulButton);
        operators.add(divButton);
        operators.add(modButton);
        operators.add(sqrtButton);

        for (Button b : operators) {
            b.setOnClickListener(v -> {
                firstNum = Double.parseDouble(resultTextView.getText().toString());
                operation = b.getText().toString();
                resultTextView.setText("");
            });
        }

        equalButton.setOnClickListener(view ->{
            double secondNum = Double.parseDouble(resultTextView.getText().toString());
            double result;

            switch (operation){
                case "/":
                    result = firstNum/secondNum;
                    break;
                case "x":
                    result = firstNum*secondNum;
                    break;
                case "+":
                    result = firstNum+secondNum;
                    break;
                case "-":
                    result = firstNum-secondNum;
                    break;
                case "mod":
                    result = firstNum%secondNum;
                    break;
                case "x^n":
                    result = Math.pow(firstNum,secondNum);
                    break;
                default:
                    result = firstNum+secondNum;
            }
            resultTextView.setText(String.valueOf(result));
            firstNum = result;
        });

        DelButton.setOnClickListener(view ->{
            String num = resultTextView.getText().toString();
            if (num.length() > 1) {

                resultTextView.setText(num.substring(0, num.length()-1));
            } else if(num.length() == 1 && !num.equals("0")){
                resultTextView.setText("0");

            }
        });

        pointButton.setOnClickListener(view ->{
            if(!resultTextView.getText().toString().contains(".")){
                resultTextView.setText(resultTextView.getText().toString()+".");
            }
        });

        clearButton.setOnClickListener(v -> {
            resultTextView.setText("");
        });





    }
}