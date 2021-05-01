package com.example.yeasi.cgpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Guide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button nxt, menu;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        nxt =(Button) findViewById(R.id.next);
        menu =(Button)findViewById(R.id.mainmenu);
    }
    public void nxt1(View v){
        Intent intent = new Intent(Guide.this,Guide2.class);
        startActivity(intent);

    }
    public void menu(View v){
        Intent intent = new Intent(Guide.this,MainActivity.class);
        startActivity(intent);

    }

}
