package com.example.assignment;

import android.app.Application;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.example.assignment.ViewModel.FilesViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ExampleRecyclerViewTest {
    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    @Mock
    private Observer<Employee> observer;
    private Application application;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_returnCorrectObject(){
        List<Employee> employees = generateEmployees();
        FilesViewModel viewModel = new FilesViewModel(application);
        viewModel.getAllEmployee().getValue();
    }

    private List<Employee> generateEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Employee employee = new Employee("name","age","position","contract");
            employee.setName("name" + i);
            employees.add(employee);
        }
        return employees;
    }
}
