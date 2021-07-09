package com.example.yourdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    private EditText name, phone, password, repassword;
    private Button btnSignUp;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = (EditText)findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById((R.id.repassword));
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        DB = new DBHelper(this);

        btnSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String user = name.getText().toString();
                String SDT = phone.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("") || SDT.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(signup.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        boolean checkSDT = DB.checkphone(SDT);
                        if(checkSDT==false){
                            Boolean insert = DB.insertData(SDT, pass);
                            if(insert==true){
                                Toast.makeText( signup.this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(signup.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(signup.this, "User already exists!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(signup.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}