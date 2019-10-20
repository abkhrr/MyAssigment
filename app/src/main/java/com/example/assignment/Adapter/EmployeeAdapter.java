package com.example.assignment.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.Employee;
import com.example.assignment.R;
import com.example.assignment.databinding.ListItemEmployeeBinding;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private ArrayList<Employee> employees;

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ListItemEmployeeBinding employeeListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.list_item_employee, viewGroup, false);

        employeeListItemBinding.executePendingBindings();

        return new  EmployeeViewHolder(employeeListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder employeeViewHolder, int i) {
        Employee currentEmployee = employees.get(i);
        employeeViewHolder.employeeListItemBinding.setEmployee(currentEmployee);

    }

    @Override
    public int getItemCount() {
        if (employees != null) {
            return employees.size();
        } else {
            return 0;
        }
    }

    public void setEmployeeList(ArrayList<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        ListItemEmployeeBinding employeeListItemBinding;

        public EmployeeViewHolder(@NonNull ListItemEmployeeBinding employeetListItemBinding) {
            super(employeetListItemBinding.getRoot());

            this.employeeListItemBinding = employeetListItemBinding;
        }
    }
}
