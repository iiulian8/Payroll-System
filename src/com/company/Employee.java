package com.company;

public class Employee {
  int employee_id;
  String employee_title;
  String first_name, last_name;
  String date_of_birth;
  String national_insurance;
  String job_titles;
  // Returns the first and last name of the object.
  public void returnName() {
    System.out.println(" Name:" + this.first_name + " " + this.last_name);
  }
}
