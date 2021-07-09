 package com.example.yourdoctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yourdoctor.models.MedicalService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
//Thêm Import API Từ Trang Login :
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

public class MainActivity extends AppCompatActivity {
    TextView danhmuctxt;
    TextView dichvu;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        danhmuctxt = (TextView) findViewById(R.id.btnChiTiet);
        dichvu = (TextView) findViewById(R.id.txtTendichvu);
        DB = new DBHelper(this);
        //BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


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

//                    btnSignIn.setText(response.getString("title"));
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
                    dichvu.setText(response.getString(4));
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



        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(navView, navController);



//        danhmuctxt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View danhmuc) {
//                Intent intent = new Intent(getApplicationContext(), danhmuc.class);
//                startActivity(intent);
//            }
//        });
    }

}