package com.example.yeasi.cgpacalculator;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class display_history extends AppCompatActivity {

Button s,d;
DatabaseHelper myDb;
EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_history);

        s = (Button)findViewById(R.id.show);
        d= (Button)findViewById(R.id.delete);

        myDb = new DatabaseHelper(this);
        e = (EditText)findViewById(R.id.edel);
    }

    public void Show(View view) {
        Cursor res = myDb.getAlldata();
        if(res.getCount()==0) {
            showMessege("Error","Nothing Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("S/N : " + res.getString(0) + "\n");
            buffer.append("Name : " + res.getString(1) + "\n");
            buffer.append("ID : " + res.getString(2) + "\n");
            buffer.append("Semester : " + res.getString(3) + "\n");
            buffer.append("CGPA : " + res.getString(4) + "\n\n");
        }
        showMessege("History",buffer.toString());

    }

    public void showMessege(String title,String Messege){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Messege);
        builder.show();
    }

    public void Delete(View view) {
        Integer deletedRows = myDb.deleteData(e.getText().toString());
        if(deletedRows > 0)
            Toast.makeText(display_history.this,"Data Deleted", Toast.LENGTH_LONG).show();
        else Toast.makeText(display_history.this,"Data not Deleted",Toast.LENGTH_LONG).show();

    }
}
