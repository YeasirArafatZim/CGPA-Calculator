package com.example.yeasi.cgpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class userName extends AppCompatActivity {

    Button n;
    EditText Name,Semester,ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_name);
        n = (Button) findViewById(R.id.next);
        Name = (EditText) findViewById(R.id.name);
        Semester = (EditText) findViewById(R.id.semester);
        ID = (EditText) findViewById(R.id.studentID);

    }

    public void Next(View view) {
        Intent intent = new Intent(userName.this,cgpa.class);
        intent.putExtra("NAME",Name.getText().toString());
        intent.putExtra("SEMESTER",Semester.getText().toString());
        intent.putExtra("ID",ID.getText().toString());
        startActivity(intent);

    }
}
