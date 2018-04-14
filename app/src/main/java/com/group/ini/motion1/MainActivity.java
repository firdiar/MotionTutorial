package com.group.ini.motion1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    public enum Operators{
        plus , negative , kali , bagi
    }

    Operators op;
    EditText num1 , num2;
    TextView operator , hasil;
    Button hitung_btn;
    Button[] operator_btn = new Button[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        op = Operators.plus;
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        operator = findViewById(R.id.currentoperator);
        hasil = findViewById(R.id.hasilhitung);

        hitung_btn = findViewById(R.id.hitung_btn);


        hitung_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String number1 = num1.getText().toString();
               String number2 = num2.getText().toString();
               if(number1.equals("") || number2.equals(""))
                   return;


               int a = Integer.parseInt( number1 );
               int b = Integer.parseInt( number2 );
               Log.w("hasil " , num1.getText().toString() );
               hasil.setText( Float.toString(Calculate(a , b))) ;

               if (view != null) {
                   InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                   imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
               }

           }
        });


    }



    public void ChangeOperator(View v){

        Button b = findViewById(v.getId());
        String s = b.getText().toString();
        operator.setText(s);
        UpdateOP(s);

    }

    float Calculate(int a , int b){
        switch (op){
            case plus:
                return  a+b;
            case negative:
                return  a-b;
            case kali:
                return  a*b;
            case bagi:
                return  a/(b*1.0f);
        }
        return 0;
    }

    void UpdateOP(String s){

        if(s.equals("+")){
            op = Operators.plus;
        }else if(s.equals("-")){
            op = Operators.negative;
        }else if(s.equals("*")){
            op = Operators.kali;
        }else if(s.equals("/")){
            op = Operators.bagi;
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
    }
}
