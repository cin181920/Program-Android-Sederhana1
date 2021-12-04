package com.example.fixed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button masuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        masuk = findViewById(R.id.masuk);

        masuk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (username.getText().length() > 8) {
                    String toastMessage = "username maks 8 karakter !!";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                } else if(username.getText().toString().equals("cinta123")&& password.getText().toString().equals("123")) {
                    String toastMessage = "Berhasil login";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                    //pindah activity
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                }else {
                    String toastMessage = "Username atau Password  salah!  ";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}