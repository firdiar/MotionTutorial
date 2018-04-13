package com.group.ini.motion1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName , password;
    Button login_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_Btn = findViewById(R.id.login_Btn);

        login_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = userName.getText().toString();
                String p = password.getText().toString();

                if(u.equals("firdi") && p.equals("c4ntik")){
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    @Override
    protected void onPause() {
        super.onPause();
    }
}
