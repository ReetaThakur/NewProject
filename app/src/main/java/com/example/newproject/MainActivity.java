package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements ClickListner{
    private ArrayList<Employee>employees=new ArrayList<>();
    private RecyclerView recyclerView;
    private CardView cardView;
    private EditText mEtName;
    private EditText mEtAge;
    private EditText mEtAddress;
    private Button mBtnDone;
    private int poss;
    EmployeeAdapter employeeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        buildEmployeeList();
        setRecyclerView();
    }

    private void setRecyclerView() {
        employeeAdapter=new EmployeeAdapter(employees,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(employeeAdapter);
    }

    private void buildEmployeeList() {
        for(int i=0;i<50;i++){
            employees.add(new Employee("Sai Krishana",26,"Banglore India"));
            employees.add(new Employee("Lloyd Decosta",31,"Karnatika India"));
            employees.add(new Employee("Siddharth",22,"Maharashtra"));
        }
    }

    private void initView() {

        recyclerView=findViewById(R.id.recyclerView);
        cardView=findViewById(R.id.editCardView);
        mEtName=findViewById(R.id.etName);
        mEtAge=findViewById(R.id.etAge);
        mEtAddress=findViewById(R.id.etAddress);
        mBtnDone=findViewById(R.id.btnDone);


    }

    @Override
    public void onItemClicked(int position, Employee employee) {
        cardView.setVisibility(View.VISIBLE);
        poss=position;
        mEtName.setText(employee.getName());
        mEtAge.setText(employee.getAge()+"");
        mEtAddress.setText(employee.getAddress());

        mBtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardView.setVisibility(View.GONE);
                Employee new_employee=new Employee(mEtName.getText().toString(),
                        Integer.parseInt(mEtAge.getText().toString()),mEtAddress.getText().toString());
                employees.set(position,new_employee);
                employeeAdapter.notifyDataSetChanged();
            }
        });

    }
}