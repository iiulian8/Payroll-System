package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class SalariedEmployee extends Employee {
  public ArrayList<SalariedPayslip> salaried_payslips = new ArrayList<>();
  int annual_salary;
  String work_mode;
  String job_department;

  public SalariedEmployee(
      int id,
      String title,
      String first_name,
      String last_name,
      String date_birth,
      String national_insurance,
      String job_titles,
      String job_department,
      String work_mode,
      int salary) {
    this.employee_id = id;
    this.employee_title = title;
    this.first_name = first_name;
    this.last_name = last_name;
    this.date_of_birth = date_birth;
    this.national_insurance = national_insurance;
    this.job_titles = job_titles;
    this.job_department = job_department;
    this.work_mode = work_mode;
    this.annual_salary = salary;
  }

  public int getSalary() {
    return annual_salary;
  }

  public int getId() {
    return employee_id;
  }

  // Returns a string with all the data of the specified employee.
  public String toString() {
    return String.format(
        "  Employee id: %d\n Title: %s\n First name: %s\n Last name: %s\n Date of birth: %s\n National Insurance: %s\n Job titles: %s\n Job department: %s\n Work mode: %s\n Annual salary: %d",
        employee_id,
        employee_title,
        first_name,
        last_name,
        date_of_birth,
        national_insurance,
        job_titles,
        job_department,
        work_mode,
        annual_salary);
  }

  public static SalariedEmployee createEmployee(int id_assign) {
    Scanner input_scanner = new Scanner(System.in);
    System.out.println("Title:");
    String employee_title = Main.checkLine(input_scanner);
    System.out.println("First name:");
    String first_name = Main.checkLine(input_scanner);
    System.out.println("Last name");
    String last_name = Main.checkLine(input_scanner);
    System.out.println("Date of birth:");
    String date_of_birth = Main.checkLine(input_scanner);
    System.out.println("National insurance number");
    String national_insurance = Main.checkLine(input_scanner);
    System.out.println("Job titles:");
    String job_titles = Main.checkLine(input_scanner);
    System.out.println("Job department:");
    String job_department = Main.checkLine(input_scanner);
    System.out.println("Full-time or part-time?:");
    String work_mode = Main.checkLine(input_scanner);
    System.out.println("Salary:");
    int salary = Main.checkInt(input_scanner);

    return new SalariedEmployee(
        id_assign,
        employee_title,
        first_name,
        last_name,
        date_of_birth,
        national_insurance,
        job_titles,
        job_department,
        work_mode,
        salary);
  }
}
