package com.rku.tutorial05;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        getSupportActionBar().setTitle("Registration Form");

        TextView fName,lName,email,password;
        TextView switchbranch;
        TextView radioGroup;
        TextView radioSex;
        TextView spinnerCity;
        TextView checkBox;

        fName=findViewById(R.id.fname);
        lName=findViewById(R.id.lname);
        email = findViewById(R.id.email);
        password=findViewById(R.id.password);
        switchbranch=findViewById(R.id.branch);
        radioGroup=findViewById(R.id.gender);
        spinnerCity=findViewById(R.id.city);
        checkBox=findViewById(R.id.status);

        Intent intent=getIntent();
        String first_name=intent.getStringExtra("FirstName");
        String last_name=intent.getStringExtra("LastName");
        String email_id=intent.getStringExtra("Email");
        String Password=intent.getStringExtra("Password");
        String branch=intent.getStringExtra("Branch");
        String gender=intent.getStringExtra("Gender");
        String city=intent.getStringExtra("City");
        String status=intent.getStringExtra("Status");

        fName.setText(first_name);
        lName.setText(last_name);
        email.setText(email_id);
        password.setText(Password);
        switchbranch.setText(branch);
        radioGroup.setText(gender);
        spinnerCity.setText(city);
        checkBox.setText(status);
    }
}