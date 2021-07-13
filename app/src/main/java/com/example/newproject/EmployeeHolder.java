package com.example.newproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeHolder extends RecyclerView.ViewHolder {
    private TextView mtvName;
    private TextView mtvAge;
    private TextView mtvAddress;
    private ImageView mtvEdit;
    private ClickListner clickListner;
    public EmployeeHolder( View itemView,ClickListner clickListner) {
        super(itemView);
        initData(itemView);
        this.clickListner=clickListner;
    }

    private void initData(View itemView) {
        mtvAddress=itemView.findViewById(R.id.tvAddress);
        mtvName=itemView.findViewById(R.id.tvName);
        mtvAge=itemView.findViewById(R.id.tvAge);
        mtvEdit=itemView.findViewById(R.id.ivEdit);
    }
    public  void setData(Employee employee){
        mtvName.setText(employee.getName());
        mtvAge.setText(employee.getAge()+" ");
        mtvAddress.setText(employee.getAddress());
        mtvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListner.onItemClicked(getAdapterPosition(),employee);
            }
        });

    }
}
