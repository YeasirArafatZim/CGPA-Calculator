package com.example.yeasi.cgpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Guide3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button next2, menu2;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide3);

        next2 =(Button) findViewById(R.id.next2);
        menu2 =(Button)findViewById(R.id.mainmenu2);
    }
    public void nxt1(View v){
        Intent intent = new Intent(Guide3.this,Guide4.class);
        startActivity(intent);


    }
    public void back(View v){
        Intent intent = new Intent(Guide3.this,Guide2.class);
        startActivity(intent);

    }
}