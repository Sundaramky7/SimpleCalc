package com.example.calculator;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ios_calculator_ui);
//      EdgeToEdge.enable(getWindow());

        //textview
        TextView textView = findViewById(R.id.tvMainDisplay);
        TextView textView2 = findViewById(R.id.tvMainDisplay2);
        textView.setText(""); //set textview to empty string
        textView2.setText(""); //set textview2 to empty string

        // All the buttons
        Button one = findViewById(R.id.btn1);
        Button two = findViewById(R.id.btn2);
        Button three = findViewById(R.id.btn3);
        Button four = findViewById(R.id.btn4);
        Button five = findViewById(R.id.btn5);
        Button six = findViewById(R.id.btn6);
        Button seven = findViewById(R.id.btn7);
        Button eight = findViewById(R.id.btn8);
        Button nine = findViewById(R.id.btn9);
        Button zero = findViewById(R.id.btn0);
        Button c = findViewById(R.id.btnClear);
        Button backspace = findViewById(R.id.btnDelete);
        Button add = findViewById(R.id.btnAdd);
        Button sub = findViewById(R.id.btnSubtract);
        Button mul = findViewById(R.id.btnMultiply);
        Button div = findViewById(R.id.btnDivide);
        Button equalTo = findViewById(R.id.btnEquals);
        Button deci = findViewById(R.id.btnDecimal);

        // Array of all the buttons
        Button[] btn ={one,two,three,four,five,six,seven,eight,nine,zero,c,backspace,add,sub,mul,div,deci,equalTo};

        //Loop for any btn click:
        for (int i = 0; i < btn.length; i++) {
            int finalI1 = i;

            //for btn click:
            btn[i].setOnClickListener(v -> {
                v.animate()
                        .scaleX(0.9f)
                        .scaleY(0.9f)
                        .setDuration(200)
                        .withEndAction(() -> v.animate()
                                .scaleX(1f)
                                .scaleY(1f)
                                .setDuration(200))
                        .start();

                //when btn minus click for negative number.
                if (finalI1==13 && textView.getText().toString().isEmpty()) {
                    textView.setText("-");
                }

                //when btn click for clear to equalTo:
                else if (finalI1 > 9 && !textView.getText().toString().isEmpty()) {

                    //clear
                    if (finalI1 == 10) {
                        textView.setText("");
                        textView2.setText("");
                    }

                    //backspace
                    else if (finalI1 == 11) {
                        //textview update:
                        textView.setText(textView.getText().toString().substring(0, textView.getText().toString().length() - 1));
                        String[] tokens = splitExpression(textView.getText().toString().replace('−', '-').trim().replace(" ","").replace('×','*').replace('÷','/'));
//                        Log.d("Expression", "Tokens: " + Arrays.toString(tokens));

                        //textview2 update:
                        if(tokens.length<=2){
                            if(tokens.length==2)
                                textView2.setText("= "+ textView.getText().toString().substring(0,textView.getText().toString().length()-1));

                            else if (textView.getText().toString().trim().isEmpty())
                                textView2.setText("");

                            else
                                textView2.setText("= "+textView.getText().toString());

                        }
                        else if (textView.getText().toString().charAt(textView.getText().length()-1) == '+' || textView.getText().toString().replace('−', '-').charAt(textView.getText().length()-1) == '-' || textView.getText().toString().charAt(textView.getText().length()-1) == '×' || textView.getText().toString().charAt(textView.getText().length()-1) == '÷'){
                            textView2.setText("= "+String.format("%.5f",evaluateCalc(textView.getText().toString().replace('−', '-').substring(0,textView.getText().toString().length()-1).replace('×','*').replace('÷','/'))).replaceAll("\\.?0+$", ""));
                        }
                        else if(!"+-×÷".contains(textView.getText().toString().replace('−', '-').substring(textView.getText().toString().replace('−', '-').length() - 1))){
                            textView2.setText("= "+String.format("%.5f",evaluateCalc(textView.getText().toString().replace('−', '-').replace('×','*').replace('÷','/'))).replaceAll("\\.?0+$", ""));
                        }
                    }

                    //for btn add , sub ,mult ,div , decimal , equal:
                    else if(!"+-×÷.".contains(textView.getText().toString()
                            .substring(textView.getText().toString().length() - 1))) {

                        // for btn add , sub ,mult ,div:
                        if (finalI1 <= 15 ) {
                            String currentChar = btn[finalI1].getText().toString();
                            Log.d("CharAdded", currentChar);
                            Log.d("Text", textView.getText().toString());
                            textView.append(currentChar);
                        }

                        //for btn decimal:
                        else if (finalI1 == 16) {
                            boolean check = true;
                            String[] tokens = splitExpression(textView.getText().toString().replace('−', '-').trim().replace(" ","").replace('×','*').replace('÷','/'));
                            Log.d("Tokens", Arrays.toString(tokens));
                            if(!tokens[tokens.length-1].contains(".")){
                                check = false;
                            }
                            if(!check) {
                                textView.append(".");
                            }

                        }

                        //for btn equal:
                        else {
                            if(textView.getText().toString().contains("+") || textView.getText().toString().replace(" ","").replace('−', '-').replace('–', '-').replace('—', '-').contains("-") || textView.getText().toString().contains("×") || textView.getText().toString().contains("÷")&&
                                    !"+-×÷.".contains(textView.getText().toString().substring(textView.getText().toString().length() - 1))){
                                String text = textView.getText().toString()
                                        .replace(" ","")
                                        .replace('−', '-') // Unicode minus sign
                                        .replace('–', '-') // En dash
                                        .replace('—', '-');

                                textView.setText("");
                                Log.d("text",text);
                                textView.append(String.format("%.15f",evaluateCalc(text.replace('×','*').replace('÷','/'))).replaceAll("\\.?0+$", ""));
                                textView2.setText("");
                            }

                        }
                    }
                }

                //for btn 0-9 :
                else if (finalI1 < 10){
                    String[] tokens = splitExpression(textView.getText().toString().replace('−', '-').trim().replace(" ","").replace('×','*').replace('÷','/'));
                    Log.d("Tokens", Arrays.toString(tokens));

                    //when textview is empty and btn 0 is clicked:
                    if (finalI1==9 && textView.getText().toString().isEmpty()){
                        textView.append("0");
                        textView2.setText("= 0");
                    }
                    //when textview is not empty and btn 0-9 is clicked:
                    else{
                        textView.append(btn[finalI1].getText());
                        if (textView.getText().toString().contains("+") || textView.getText().toString().replace('−', '-').replace('–', '-').replace('—', '-').contains("-") || textView.getText().toString().contains("×") || textView.getText().toString().contains("÷")){
                            textView2.setText("= "+String.format("%.5f",evaluateCalc(textView.getText().toString().replace('×','*').replace('÷','/'))).replaceAll("\\.?0+$", ""));
                        }else{
                            textView2.setText("= "+textView.getText().toString());
                        }
                    }
                    Log.d("text",textView2.getText().toString());
                }
            });
        }
    }

// Manage or call other function for calculation:
    public static double evaluateCalc(String expressionStr) {
        Log.d("Expression", "Evaluating: " + expressionStr.replace("-","m"));
        Log.d("Char Dump", Arrays.toString(expressionStr.toCharArray()));
        expressionStr = expressionStr
                .replace('−', '-') // Unicode minus sign
                .replace('–', '-') // En dash
                .replace('—', '-');
        String[] tokens = splitExpression(expressionStr);

        Log.d("Expression", "Tokens: " + Arrays.toString(tokens));
        return evaluate(tokens);
    }

    // Step 1: Split the expression into tokens:
    public static String[] splitExpression(String expr) {
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if ((ch >= '0' && ch <= '9') || ch == '.') {
                current.append(ch);
            }
            else if (expr.charAt(i) == 'm') {
                Log.d("Negative", "Found");
                current.append("-"); // keep it with the number
            }
            else if (isOperator(ch)) {
                // If current is not empty, save the number
                // Save the current number if any
                if (current.length() > 0) {
                    result.append(current).append(",");
                    current.setLength(0);
                }
                // Append the operator
                result.append(ch).append(",");
            }
        }

        if (!current.toString().isEmpty()) {
            result.append(current);
        }

        return result.toString().split(",");
    }

    public static boolean isOperator(char ch) {
        return ch == '-' || ch == '+' || ch == '*' || ch == '/';
    }

    // Step 2: Evaluate the expression:
    public static double evaluate(String[] tokens) {
        double result =0;
        double left;
        double right = 0;
        // First pass: handle+,-, *, /
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[0].equals("-") && tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                if (i==1){
                    left = Double.parseDouble(tokens[i - 1]);
                }
                else{
                    left=result;
                }
                if (tokens.length != (i + 1)){
                    right = Double.parseDouble(tokens[i + 1]);
                }
                switch (tokens[i]) {
                    case "+":
                        result = left + right;
                        break;
                    case "-":
                        result = left - right;
                        break;
                    case "*":
                        result = left * right;
                        break;
                    case "/":
                        result = left / right;
                        break;
                }
            }
        }
        return result;
    }
}