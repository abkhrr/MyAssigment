package com.example.assignment;

import android.app.Application;

import androidx.annotation.NonNull;
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

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    @Mock
    private Observer<Employee> observer;
    private Application application;


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

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
