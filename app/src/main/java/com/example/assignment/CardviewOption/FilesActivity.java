package com.example.assignment.CardviewOption;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.assignment.Adapter.EmployeeAdapter;
import com.example.assignment.Employee;
import com.example.assignment.R;
import com.example.assignment.ViewModel.FilesViewModel;
import com.example.assignment.databinding.ActivityFilesBinding;

import java.util.ArrayList;
import java.util.List;

public class FilesActivity extends AppCompatActivity {

    private FilesViewModel mainViewModel;
    private EmployeeAdapter employeeDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFilesBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_files);

        // bind RecyclerView
        RecyclerView recyclerView = activityMainBinding.viewEmployees;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        mainViewModel = ViewModelProviders.of(this).get(FilesViewModel.class);
        employeeDataAdapter = new EmployeeAdapter();
        recyclerView.setAdapter(employeeDataAdapter);

        getAllEmployee();

    }

    private void getAllEmployee() {
        mainViewModel.getAllEmployee().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(@Nullable List<Employee> employees) {
                employeeDataAdapter.setEmployeeList((ArrayList<Employee>) employees);

            }
        });
    }
}
