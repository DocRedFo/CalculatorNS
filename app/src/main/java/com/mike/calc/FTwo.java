package com.mike.calc;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;



import androidx.annotation.Nullable;

public class FTwo extends Fragment {

    Button plus, min, dev, mul, equal, del;
    public static EditText calc;
    public static boolean delete = false;

    @Override
    public void onStart() {
        super.onStart();

        equal = getActivity().findViewById(R.id.button5);
        del = getActivity().findViewById(R.id.button6);
        plus = getActivity().findViewById(R.id.button);
        min = getActivity().findViewById(R.id.button2);
        dev = getActivity().findViewById(R.id.button4);
        mul = getActivity().findViewById(R.id.button3);
        calc = getActivity().findViewById(R.id.calc);


        equal.setOnClickListener(new FTwo().listener);
        del.setOnClickListener(new FTwo().listener);
        plus.setOnClickListener(new FTwo().listener);
        min.setOnClickListener(new FTwo().listener);
        mul.setOnClickListener(new FTwo().listener);
        dev.setOnClickListener(new FTwo().listener);


    }

    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            String str = FTwo.calc.getText().toString();
            switch (id){
                case R.id.button:
                    str = str + "+";
                    delete = false;
                    break;
                case R.id.button2:
                    str = str + "-";
                    delete = false;
                    break;
                case R.id.button4:
                    str = str + "/";
                    delete = false;
                    break;
                case R.id.button3:
                    str = str + "*";
                    delete = false;
                    break;
                case R.id.button9:
                    str = str + "1";
                    delete = false;
                    break;
                case R.id.button6:
                    if (delete) str = "";
                    else if (!FTwo.calc.getText().toString().equals("") && !delete) str = str.substring(0, str.length() - 1);
                    delete = false;
                    break;
                case R.id.button5:
                    if (FTwo.calc.getText().toString().equals("")) str = "0";
                    double result = eval(str);
                    str = Double.toString(result);
                    delete = true;
                    break;
                case R.id.button7:
                    str = str + "3";
                    delete = false;
                    break;
                case R.id.button8:
                    str = str + "2";
                    delete = false;
                    break;
                case R.id.button11:
                    str = str + "5";
                    delete = false;
                    break;
                case R.id.button10:
                    str = str + "6";
                    delete = false;
                    break;
                case R.id.button12:
                    str = str + "4";
                    delete = false;
                    break;
                case R.id.button13:
                    str = str + "9";
                    delete = false;
                    break;
                case R.id.button14:
                    str = str + "8";
                    delete = false;
                    break;
                case R.id.button15:
                    str = str + "7";
                    delete = false;
                    break;
                case R.id.button16:
                    str = str + "0";
                    delete = false;
                    break;
                case R.id.button17:
                    str = str + ".";
                    delete = false;
                    break;
                case R.id.button18:
                    str = str + "(";
                    delete = false;
                    break;
                case R.id.button19:
                    str = str + ")";
                    delete = false;
                    break;
            }
            FTwo.calc.setText(str);
        }
    };


    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ftwo, container, false);

    }
}
