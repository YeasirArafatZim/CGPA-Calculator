package com.example.yeasi.cgpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.cgpa);
        b2=(Button)findViewById(R.id.history);
        b3=(Button)findViewById(R.id.guide);

    }
    public void goToCgpa(View v){
        Intent intent = new Intent(MainActivity.this,userName.class);
        startActivity(intent);

    }

    public void History(View view) {
        Intent intent = new Intent(MainActivity.this,display_history.class);
        startActivity(intent);

    }

    public void guide(View view) {
        Intent intent = new Intent(MainActivity.this,Guide.class);
        startActivity(intent);
    }
}
