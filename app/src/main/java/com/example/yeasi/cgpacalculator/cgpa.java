package com.example.yeasi.cgpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class cgpa extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatabaseHelper myDb;
    String Name,Semester,Id,Cgpa;
    EditText text;
    TextView tv;
    Spinner spinner;
    ListView lv;
    Button calculate;
    ArrayList<String> array;
    ArrayAdapter<String> adapt;
    double[] arr = new double[]{4, 3.75, 3.5, 3.25, 3, 2.75,2.5,2.25,2,0};

    double sum1=0,cgpa=0;
    double a,b;
    double sum2=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);
        text = (EditText) findViewById(R.id.e1);
        spinner = (Spinner) findViewById(R.id.grade);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.grade, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        calculate=(Button)findViewById(R.id.b2);

        lv = (ListView) findViewById(R.id.list1);
        array = new ArrayList<String>();
        adapt = new ArrayAdapter<String>(cgpa.this,android.R.layout.simple_list_item_1,array);
        lv.setAdapter(adapt);

        tv = (TextView)findViewById(R.id.cg);
        tv.setText("Current CGPA: "+cgpa);

        Name = getIntent().getStringExtra("NAME");
        Semester = getIntent().getStringExtra("SEMESTER");
        Id = getIntent().getStringExtra("ID");

        addData();
        myDb = new DatabaseHelper(this);

    }

    public void add(View view) {

        String s1=null;
        a = Double.parseDouble(text.getText().toString());
        sum1=sum1+(a*b);
        sum2=sum2+a;
        String result = text.getText().toString();
        if(b==4||b==3||b==2||b==0||b==3.5||b==2.5)
        {
            s1=String.valueOf(b)+"                             " +result;
        }
        else
        {
            s1=String.valueOf(b)+"                           " +result;
        }


        array.add(s1);
        adapt.notifyDataSetChanged();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        b=arr[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void addData(){
        calculate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        cgpa=sum1/sum2;
                        String r = String.format("%.4g%n",cgpa);
                        Cgpa=r;
                        tv.setText("Current CGPA: "+r);

                        boolean isInserted = myDb.insertData(Name,Id,Semester,Cgpa);
                        if(isInserted)
                            Toast.makeText(cgpa.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else Toast.makeText(cgpa.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
}