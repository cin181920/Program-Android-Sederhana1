package com.example.fixed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailKomik extends AppCompatActivity {




    ImageView cover ;
    TextView judul;
    TextView detail;
    EditText angka;
    Button buttonadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_komik);


        judul = findViewById(R.id.judul);
        detail=findViewById(R.id.detail2);
        cover=findViewById(R.id.cover);
        angka=findViewById(R.id.angka);
        buttonadd=findViewById(R.id.button);
    }
}