package com.rku.tutorial05;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ResourceCursorAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText fName,lName,email,password;
    Switch switchbranch;
    RadioGroup radioGroup;
    RadioButton radioSex;
    Spinner spinnerCity;
    CheckBox checkBox;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().setTitle("Registration Form");

        fName=(EditText) findViewById(R.id.editFname);
        //first_name=fName.getText().toString();
        lName=(EditText)findViewById(R.id.editLastname);
        //last_name=lName.getText().toString();
        email =(EditText)findViewById(R.id.editEmail);
        //email_id=email.getText().toString();
        password=(EditText)findViewById(R.id.editPassword);
        //Password=password.getText().toString();
        switchbranch=(Switch) findViewById(R.id.branchSwitch);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        spinnerCity=(Spinner) findViewById(R.id.spinnerCity);
        checkBox=(CheckBox) findViewById(R.id.checkBox);
        button=(Button)findViewById(R.id.btnRegister);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String first_name=fName.getText().toString();
               String last_name=lName.getText().toString();
               String email_id=email.getText().toString();
               String Password=password.getText().toString();

                String branchStatus;
                String radio;
                int selectedId;
                String City;
                String check;

                if(first_name.isEmpty()){
                    fName.setError("Enter First Name");
                    return;
                }

                if(last_name.isEmpty()){
                    lName.setError("Enter Last Name");
                    return;
                }

                if(email_id.isEmpty()){
                    email.setError("Enter Email Id");
                    return;
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email_id).matches()){
                    email.setError("Enter valid email id");
                    return;
                }

                if(Password.isEmpty()){
                    password.setError("Enter Password");
                    return;
                }

                if(switchbranch.isChecked()){
                    branchStatus="CE";
                }
                else{
                    branchStatus="IT";
                }

                City=spinnerCity.getSelectedItem().toString();
                if(City.equals("Select City")){
                    Toast.makeText(RegistrationActivity.this,"Please Select City",Toast.LENGTH_LONG).show();
                    return;
                }

                if(checkBox.isChecked()){
                    check="Active";
                }
                else{
                    check="Inactive";
                }

                selectedId = radioGroup.getCheckedRadioButtonId();
                radioSex=findViewById(selectedId);
                radio=radioSex.getText().toString();

                Intent intent = new Intent(RegistrationActivity.this, ShowActivity.class);

                intent.putExtra("FirstName", first_name);
                intent.putExtra("Email", email_id);
                intent.putExtra("LastName", last_name);
                intent.putExtra("Password", Password);
                intent.putExtra("Branch", branchStatus);
                intent.putExtra("Gender", radio);
                intent.putExtra("City", City);
                intent.putExtra("Status", check);
                startActivity(intent);
            }
        });
    }
}