package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class CommissionedEmployee extends Employee {
    double gross_salary;
    double commission_rate;
    ArrayList<CommissionedPayslip> commissioned_payslips = new ArrayList<>();

    CommissionedEmployee(
            int id,
            String title,
            String first_name,
            String last_name,
            String date_birth,
            String national_insurance,
            String job_titles,
            double gross_salary,
            double commission_rate) {
        this.employee_id = id;
        this.employee_title = title;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_birth;
        this.national_insurance = national_insurance;
        this.job_titles = job_titles;
        this.gross_salary = gross_salary;
        this.commission_rate = commission_rate;
    }

    // Returns a string with all the data of the specified employee.
    public String toString() {
        return String.format(
                "  Employee id : %d\n Employee title: %s\n First name: %s\n Last name: %s\n Date of birth: %s\n National insurance: %s \n Job titles: %s \n Gross salary: %.2f \n Commission rate: %.2f",
                employee_id,
                employee_title,
                first_name,
                last_name,
                date_of_birth,
                national_insurance,
                job_titles,
                gross_salary,
                commission_rate);
    }

    public static CommissionedEmployee createEmployee(int id_assign) {
        Scanner input_scanner = new Scanner(System.in);
        System.out.println("Title:");
        String title = Main.checkLine(input_scanner);
        System.out.println("First name:");
        String first_name = Main.checkLine(input_scanner);
        System.out.println("Last name");
        String last_name = Main.checkLine(input_scanner);
        System.out.println("Date of birth:");
        String date_birth = Main.checkLine(input_scanner);
        System.out.println("National insurance number");
        String national_insurance = Main.checkLine(input_scanner);
        System.out.println("Job titles:");
        String job_titles = Main.checkLine(input_scanner);
        System.out.println("Gross salary:");
        double gross_salary = Main.checkDouble(input_scanner);
        double commission_rate = Main.checkDouble(input_scanner);


        if (!isExisting(first_name, Main.salaried_employees, Main.hourly_employees, Main.commissioned_employees)) {

            return new CommissionedEmployee(
                    id_assign,
                    title,
                    first_name,
                    last_name,
                    date_birth,
                    national_insurance,
                    job_titles,
                    gross_salary,
                    commission_rate);
        }

        return null;
    }
}
