package com.example.yourdoctor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yourdoctor.models.MedicalService;
import com.example.yourdoctor.repositories.MedicalServiceRepository;

import java.util.List;

public class DanhMuc1Adapter extends RecyclerView.Adapter<DanhMuc1Adapter.DanhMuc1ViewHolder> {
    private MedicalServiceRepository medicalRepository;

    public DanhMuc1Adapter() {
        medicalRepository = new MedicalServiceRepository();
    }

    private List<danhmuc1> mListDanhMuc1;


    public DanhMuc1Adapter(List<danhmuc1> mListDanhMuc1) {
        this.mListDanhMuc1 = mListDanhMuc1;
    }

    @NonNull
    @Override
    public DanhMuc1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_danhmuc1, parent, false);
        return new DanhMuc1ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull DanhMuc1ViewHolder holder, int position) {
        danhmuc1 danhMuc1 = mListDanhMuc1.get(position);
        List<MedicalService> list = medicalRepository.getAll();
        if(danhMuc1 == null){
            return;
        }
        holder.imgDanhMuc.setImageResource(danhMuc1.getImage());
        holder.tvName.setText(danhMuc1.getName());
        holder.tvDesc.setText(danhMuc1.getDesc());
        holder.tvSex.setText(danhMuc1.getSex());
        holder.tvAge.setText(danhMuc1.getAge());
        holder.tvCost.setText(danhMuc1.getCost());
        holder.tvOrder.setText(danhMuc1.getOrder());
    }

    @Override
    public int getItemCount() {
        if(mListDanhMuc1 != null){
            return mListDanhMuc1.size();
        }
        return 0;
    }

    public class DanhMuc1ViewHolder extends RecyclerView.ViewHolder {

        private  ImageView imgDanhMuc;
        private  TextView tvName, tvDesc, tvSex, tvCost, tvAge, tvOrder;



        public DanhMuc1ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDanhMuc = itemView.findViewById(R.id.imv_goikham);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvSex = itemView.findViewById(R.id.tv_sex);
            tvCost = itemView.findViewById(R.id.tv_cost);
            tvAge = itemView.findViewById(R.id.tv_age);
            tvOrder = itemView.findViewById(R.id.tv_order);
        }
    }
}
