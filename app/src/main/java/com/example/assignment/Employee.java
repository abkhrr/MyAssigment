package com.example.assignment;

import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("name")
    private String name;

    @SerializedName("age")
    private String age;

    @SerializedName("position")
    private String position;

    @SerializedName("contract")
    private String contract;

    public Employee(String name, String age, String position, String contract) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.contract = contract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
}
