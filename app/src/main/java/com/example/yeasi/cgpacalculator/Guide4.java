package com.example.yeasi.cgpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Guide4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button next1, menu1;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide4);

        next1 =(Button) findViewById(R.id.next2);
        menu1 =(Button)findViewById(R.id.mainmenu2);
    }
    public void nxt1(View v){
        Intent intent = new Intent(Guide4.this,Guide5.class);
        startActivity(intent);


    }
    public void back(View v){
        Intent intent = new Intent(Guide4.this,Guide3.class);
        startActivity(intent);

    }
}