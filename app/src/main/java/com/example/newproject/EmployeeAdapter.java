package com.example.newproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeAdapter  extends RecyclerView.Adapter<EmployeeHolder> {
    private ArrayList<Employee> employeeList;
    private ClickListner clickListner;
    public  EmployeeAdapter(ArrayList<Employee> employeeList,ClickListner clickListner){
        this.employeeList=employeeList;
        this.clickListner=clickListner;

    }
    @NonNull

    @Override
    public EmployeeHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new EmployeeHolder(view,clickListner);
    }

    @Override
    public void onBindViewHolder( EmployeeHolder holder, int position) {
        Employee employee=employeeList.get(position);
        holder.setData(employee);

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}
