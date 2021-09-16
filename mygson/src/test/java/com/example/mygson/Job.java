package com.example.mygson;

public class Job {
    private String name;
    private String salary;

    public Job(String name, String salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
