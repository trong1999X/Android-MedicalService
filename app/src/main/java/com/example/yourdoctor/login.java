package com.example.yourdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yourdoctor.models.MedicalService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import cz.msebera.android.httpclient.Header;

public class login extends AppCompatActivity {
    Button btnSignIn, btnSignUp;
    TextView testdata;
    EditText phone, password;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        testdata = (TextView) findViewById(R.id.txtwelcome);
        DB = new DBHelper(this);



        AsyncHttpClient client = new AsyncHttpClient();
        String apiUrl = "http://192.168.1.4:5001/api/medical-services";
        //String apiUrlById = "http://192.168.1.4:5001/api/medical-services";

        client.get(apiUrl, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    MedicalService medicalService = new MedicalService();
                    medicalService.setTitle(response.getString("title"));
                    medicalService.setDescription(response.getString("description"));
                    medicalService.setId(response.getLong("id"));

                    btnSignIn.setText(response.getString("title"));
                } catch (Exception e) {

                }
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
//                Lấy danh sách dịch vụ theo mảng
                List<MedicalService> medicalServiceList = new ArrayList<>();
                try {
                    for (int i = 0; i < response.length(); i++) {
                        MedicalService medicalService = new MedicalService();

                        JSONObject serviceObject = (JSONObject) response.get(i);
                        medicalService.setTitle(serviceObject.getString("title"));
                        medicalService.setDescription(serviceObject.getString("description"));
                        medicalService.setId(serviceObject.getLong("id"));
                        medicalServiceList.add(medicalService);

                    }
                    System.out.println(medicalServiceList);
                    testdata.setText(response.getString(3));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SDT = phone.getText().toString();
                String pass = password.getText().toString();

                if (phone.equals("") || pass.equals(""))
                    Toast.makeText(login.this, "Please Enter All The Fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkphonepass = DB.checkphonepassword(SDT, pass);
                    if (checkphonepass == true) {
                        Toast.makeText(login.this, "Login Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View signup) {
                Intent intent = new Intent(getApplicationContext(), signup.class);
                startActivity(intent);

            }
        });
    }
}

//    public void openMainActivity(){
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }
//    public void opensignup(){
//        Intent intent = new Intent(this, signup.class);
//        startActivity(intent);
//    }
//
//
//    public void openMainActivity(){
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }
//    public void opensignup(){
//        Intent intent = new Intent(this, signup.class);
//        startActivity(intent);
//    }


//    public void openMainActivity(){
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }

