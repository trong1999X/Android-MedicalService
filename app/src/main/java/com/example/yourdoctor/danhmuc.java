package com.example.yourdoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class danhmuc extends AppCompatActivity {

    private RecyclerView rcvDanhMuc;
    private DanhMuc1Adapter danhMuc1Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhmuc);
        rcvDanhMuc = findViewById(R.id.rcv_danhmuc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvDanhMuc.setLayoutManager(linearLayoutManager);

        danhMuc1Adapter = new DanhMuc1Adapter(getListDanhMuc());
        rcvDanhMuc.setAdapter(danhMuc1Adapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvDanhMuc.addItemDecoration(itemDecoration);
    }

    private List<danhmuc1> getListDanhMuc() {
        List<danhmuc1> list = new ArrayList<>();
        list.add(new danhmuc1(R.drawable.about9, "Gói Khám Sức Khoẻ Nâng Cao", "Gói khám sức khỏe cơ bản : cung cấp những hạng mục khám và Xét Nghiệm Cơ Bản ...", "Mọi Lứa Tuổi", "2.500.000","Đặt Lịch Ngay", "Nam & nữ"));
        list.add(new danhmuc1(R.drawable.about9, "Gói Khám Sức Khoẻ Nâng Cao", "Gói khám sức khỏe cơ bản : cung cấp những hạng mục khám và Xét Nghiệm Cơ Bản ...", "Mọi Lứa Tuổi", "2.500.000","Đặt Lịch Ngay", "Nam & nữ"));
        list.add(new danhmuc1(R.drawable.about9, "Gói Khám Sức Khoẻ Nâng Cao", "Gói khám sức khỏe cơ bản : cung cấp những hạng mục khám và Xét Nghiệm Cơ Bản ...", "Mọi Lứa Tuổi", "2.500.000","Đặt Lịch Ngay", "Nam & nữ"));
        list.add(new danhmuc1(R.drawable.about9, "Gói Khám Sức Khoẻ Nâng Cao", "Gói khám sức khỏe cơ bản : cung cấp những hạng mục khám và Xét Nghiệm Cơ Bản ...", "Mọi Lứa Tuổi", "2.500.000","Đặt Lịch Ngay", "Nam & nữ"));
        list.add(new danhmuc1(R.drawable.about9, "Gói Khám Sức Khoẻ Nâng Cao", "Gói khám sức khỏe cơ bản : cung cấp những hạng mục khám và Xét Nghiệm Cơ Bản ...", "Mọi Lứa Tuổi", "2.500.000","Đặt Lịch Ngay", "Nam & nữ"));
        return list;
    }
}