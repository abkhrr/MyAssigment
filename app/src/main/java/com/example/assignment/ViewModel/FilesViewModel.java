package com.example.assignment.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.assignment.Employee;
import com.example.assignment.Repo.EmployeeRepository;

import java.util.List;

public class FilesViewModel extends AndroidViewModel {

    private EmployeeRepository employeeRepository;

    public FilesViewModel(@NonNull Application application) {
        super(application);
        employeeRepository = new EmployeeRepository();
    }

    public LiveData<List<Employee>> getAllEmployee() {
        return employeeRepository.getMutableLiveData();
    }
}
