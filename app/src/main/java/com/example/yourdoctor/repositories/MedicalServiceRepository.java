package com.example.yourdoctor.repositories;

import android.util.Log;

import com.example.yourdoctor.helpers.ApiHelper;
import com.example.yourdoctor.models.MedicalService;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class MedicalServiceRepository {
    private ApiHelper apiHelper;
    private Object ApiHelper;

    public MedicalServiceRepository() {
        apiHelper = new ApiHelper();
    }
    String apiUrl = "http://192.168.1.4:5001/api/medical-services";

    public ApiHelper getApiHelper() {
        return apiHelper;
    }

    public List<MedicalService> getAll() {
        List<MedicalService> list = new ArrayList<>();
        // TODO Call api
        // apiHelper.getClient().get(apiHelper.getApiUrl() + "/medical-services");
        Log.v("GET", apiUrl );
        return list;
    }

    public MedicalService getById(int id) {
        return null;
    }

    public void add() {

    }

    public void update() {

    }

    public void delete() {

    }
}
