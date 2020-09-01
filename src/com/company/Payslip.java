package com.company;

public class Payslip {
  int month;
  int employee_id;
}

class SalariedPayslip extends Payslip {
  int employee_id;
  double monthly_salary;
  int month;

  SalariedPayslip(int month, int id, double salary) {
    this.month = month;
    this.employee_id = id;
    this.monthly_salary = salary / 12;
  }
  // Returns data about the payslip.
  public String toString() {
    return String.format(
        " Employee id: %d\n Month: %d\n Monthly salary: %2f\n", employee_id, month, monthly_salary);
  }
}

class HourlyPayslip extends Payslip {
  double hourly_rate;
  double salary;

  HourlyPayslip(int id, int month, double hourly_rate, double salary) {
    this.month = month;
    this.employee_id = id;
    this.hourly_rate = hourly_rate;
    this.salary = salary * hourly_rate;
  }

  public String toString() {
    return String.format(
        "Employee id: %d\n Month: %d\n Hourly rate: %2f\n Salary: %2f",
        employee_id, month, hourly_rate, salary);
  }
}

class CommissionedPayslip extends Payslip {

  double sales_amount;
  double commission_rate;
  double gross_salary;

  CommissionedPayslip(
      int id, int month, double gross_salary, double sales_amount, double commission_rate) {
    this.employee_id = id;
    this.month = month;
    this.sales_amount = sales_amount;
    this.gross_salary = gross_salary;
    this.commission_rate = commission_rate;
  }
  // Returns data about the payslip.


  public String toString() {
    return String.format(
        "  Employee id: %d\n Month: %d\n Gross salary: %2f\n Sales amount: %1f \n Commission rate: %1f",
        employee_id, month, gross_salary, sales_amount, commission_rate);
  }
}
