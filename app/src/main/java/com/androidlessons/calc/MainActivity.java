package com.androidlessons.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private Button btnC, power, multiplication, division, subtraction, add, equals;
    private Button one, two, three, four, five, six, seven, eight, nine, zero, btnPoint;
    private String input, answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.screen);
        btnC = findViewById(R.id.C);
        power = findViewById(R.id.power);
        multiplication = findViewById(R.id.multiplication);
        division = findViewById(R.id.division);
        subtraction = findViewById(R.id.btn_sub);
        add = findViewById(R.id.add);
        equals = findViewById(R.id.equals);
        btnPoint = findViewById(R.id.btn_point);

        one = findViewById(R.id.btn1);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn3);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        eight = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        zero = findViewById(R.id.btn_zero);
    }

    public void buttonClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data) {
            case "C":

                if (input.length() > 0) {
                    String newText = input.substring(0, input.length() - 1);
                    input = newText;
                }
                break;
            case "=":
                solve();
                answer = input;
                break;
            case "+":
                solve();
                input += "+";
                break;
            case "-":
                solve();
                input += "-";
                break;

            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("*") || data.equals("/") || data.equals("%")) {
                    solve();
                }
                input += data;
        }

        screen.setText(input);
    }

    private void solve() {
        if (input.split("\\*").length == 2) {
            String number[] = input.split("\\*");
            input = "";
            try {
                double multi = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = multi + "";
            } catch (Exception e) {
                //toggle error
            }
        } else if (input.split("/").length == 2) {
            String number[] = input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div + "";
            } catch (Exception e) {
                //toggle error
            }
        } else if (input.split("\\*").length == 2) {
            String number[] = input.split("\\*");
            try {
                double multi = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = multi + "";
            } catch (Exception e) {
                //toggle error
            }
        } else if (input.split("\\^").length == 2) {
            String number[] = input.split("\\^");
            try {
                double pow = Math.pow(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
                input = pow + "";
            } catch (Exception e) {
                //toggle error
            }
        } else if (input.split("\\+").length == 2) {
            String number[] = input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum + "";
            } catch (Exception e) {
                //toggle error
            }
        } else if (input.split("\\-").length == 2) {
            String number[] = input.split("\\-");
            try {
                double sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                input = sub + "";
            } catch (Exception e) {
                //toggle error
            }


        }
        String n[] = input.split("\\.");
        if (n.length > 1) {
            if (n[1].equals("0")) {
                input = n[0];
            }


            screen.setText(input);
        }
    }

}