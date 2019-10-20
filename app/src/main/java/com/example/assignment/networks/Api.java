package com.example.assignment.networks;

import com.example.assignment.EmployeeDBResponse;
import retrofit2.Call;
import retrofit2.http.GET;


public interface Api {

    @GET("employee2.php")
    Call<EmployeeDBResponse> getEmployees();
}

