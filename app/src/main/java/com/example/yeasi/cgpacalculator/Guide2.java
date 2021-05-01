package com.example.yeasi.cgpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Guide2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button next1, menu1;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide2);

        next1 =(Button) findViewById(R.id.next1);
        menu1 =(Button)findViewById(R.id.mainmenu1);
    }
    public void nxt1(View v){
        Intent intent = new Intent(Guide2.this,Guide3.class);
        startActivity(intent);

    }
    public void back(View v){
        Intent intent = new Intent(Guide2.this,Guide.class);
        startActivity(intent);

    }
}