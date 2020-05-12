package com.karanbajaj.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private enum OPERTOR{

        PLUS, SUBSTRACTION, MULTIPLY, DIVIDE, EQUAL
    }

    TextView txtCalculation, txtResult;

    // Insatance Varibles
    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERTOR currentOperator;
    private int calculationsResult;
    private String calculationString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculationsResult = 0;
        calculationString = "";

        txtCalculation = findViewById(R.id.txtCalculation);
        txtResult = findViewById(R.id.txtResult);
        findViewById(R.id.btnEqual).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn0).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnPlus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSubstraction).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnDivide).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnEqual:
                opertorIsTapped(OPERTOR.EQUAL);
                break;
            case R.id.btn7:
                numberIstapped(7);
                break;
            case R.id.btn8:
                numberIstapped(8);
                break;
            case R.id.btn9:
                numberIstapped(9);
                break;
            case R.id.btnPlus:
                opertorIsTapped(OPERTOR.PLUS);
                calculationString = calculationString + " + ";
                break;
            case R.id.btn4:
                numberIstapped(4);
                break;
            case R.id.btn5:
                numberIstapped(5);
                break;
            case R.id.btn6:
                numberIstapped(6);
                break;
            case R.id.btnSubstraction:
                opertorIsTapped(OPERTOR.SUBSTRACTION);
                calculationString = calculationString + " - ";
                break;
            case R.id.btn3:
                numberIstapped(3);
                break;
            case R.id.btn2:
                numberIstapped(2);
                break;
            case R.id.btn1:
                numberIstapped(1);
                break;
            case R.id.btnMultiply:
                opertorIsTapped(OPERTOR.MULTIPLY);
                calculationString = calculationString + " * ";
                break;
            case R.id.btn0:
                numberIstapped(0);
                break;
            case R.id.btnDivide:
                opertorIsTapped(OPERTOR.DIVIDE);
                calculationString = calculationString + " / ";
                break;
            case R.id.btnClear:
                break;


        }
        txtCalculation.setText(calculationString);

    }
    private void numberIstapped(int tappedNumber){

        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtResult.setText(currentNumber);
        calculationString = currentNumber;
        txtCalculation.setText(calculationString);
    }
    private void opertorIsTapped(OPERTOR tappedOpertor){

        if(currentOperator != null){
            if(currentNumber != "") {

                stringNumberAtRight = currentNumber;
                currentNumber = "";

                switch (currentOperator) {

                    case PLUS:

                        calculationsResult = Integer.parseInt(stringNumberAtLeft) + Integer.parseInt(stringNumberAtRight);
                        break;
                    case SUBSTRACTION:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) - Integer.parseInt(stringNumberAtRight);
                        break;
                    case DIVIDE:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) / Integer.parseInt(stringNumberAtRight);
                        break;
                    case MULTIPLY:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) * Integer.parseInt(stringNumberAtRight);
                        break;
                    case EQUAL:
                        break;

                }
                stringNumberAtLeft = String.valueOf(calculationsResult);
                txtResult.setText(stringNumberAtLeft);
                calculationString = stringNumberAtLeft;
            }
        }else{
            stringNumberAtLeft = currentNumber;
            currentNumber = "";

        }
        currentOperator = tappedOpertor;

    }
}


/* import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtCalculations;
    TextView txtResults;
    private enum OPERATOR{
        PLUS,SUBSTRACT,MULTIPLY,DIVIDE,EQUAL
    }

    private String currentNumber;
    private  String stringNumberAtLeft;
    private  String stringNumberAtRight;
    private  OPERATOR currentOperator;
    private  int calculationsResult;
    private  String calculationsString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentNumber="";
        calculationsResult=0;
        calculationsString="";
        txtCalculations=findViewById(R.id.txtCalculation);
        txtResults=findViewById(R.id.txtResult);
        findViewById(R.id.btnEqual).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn0).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnDivide).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnPlus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSubstraction).setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnEqual:
                operatorIsTapped(OPERATOR.EQUAL);
                break;
            case R.id.btn0:
                numberIsTapped(0);
                break;
            case R.id.btn1:
                numberIsTapped(1);
                break;
            case R.id.btn2:
                numberIsTapped(2);
                break;
            case R.id.btn3:
                numberIsTapped(3);
                break;
            case R.id.btn4:
                numberIsTapped(4);
                break;
            case R.id.btn5:
                numberIsTapped(5);
                break;
            case R.id.btn6:
                numberIsTapped(6);
                break;
            case R.id.btn7:
                numberIsTapped(7);
                break;
            case R.id.btn8:
                numberIsTapped(8);
                break;
            case R.id.btn9:
                numberIsTapped(9);
                break;
            case R.id.btnPlus:
                operatorIsTapped(OPERATOR.PLUS);
                calculationsString=calculationsString+"+";
                break;
            case R.id.btnSubstraction:
                operatorIsTapped(OPERATOR.SUBSTRACT);
                calculationsString=calculationsString+"-";
                break;
            case R.id.btnMultiply:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationsString=calculationsString+"*";
                break;
            case R.id.btnDivide:
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationsString=calculationsString+"/";
                break;
            case R.id.btnClear :
                clearButton();
                break;

        }
        txtCalculations.setText(calculationsString);

    }
    private void numberIsTapped(int tappedNumber){
        currentNumber=currentNumber+ String.valueOf(tappedNumber);
        txtResults.setText(currentNumber);
        calculationsString=currentNumber;
        txtCalculations.setText(calculationsString);

    }
    private  void operatorIsTapped(OPERATOR tappedOperator){
        if(currentOperator!=null) {
            if (currentNumber != "") {
                stringNumberAtRight = currentNumber;
                currentNumber = "";
                switch (currentOperator) {

                    case PLUS:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) + Integer.parseInt(stringNumberAtRight);
                        break;
                    case DIVIDE:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) / Integer.parseInt(stringNumberAtRight);
                        break;
                    case MULTIPLY:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) * Integer.parseInt(stringNumberAtRight);
                        break;
                    case SUBSTRACT:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) - Integer.parseInt(stringNumberAtRight);
                        break;
                    case EQUAL:
                        break;
                }
                stringNumberAtLeft = String.valueOf(calculationsResult);
                txtResults.setText(stringNumberAtLeft);
                calculationsString = stringNumberAtLeft;
            }
        }else{
            stringNumberAtLeft=currentNumber;
            currentNumber="";
        }
        currentOperator=tappedOperator;
    }
    private void clearButton(){

        stringNumberAtLeft="";
        stringNumberAtRight="";
        calculationsResult=0;
        currentNumber="";
        currentOperator=null;
        txtResults.setText("0");
        calculationsString="";
        txtCalculations.setText("0");
    }


} */
