package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class HourlyEmployee extends Employee {
    double hourly_rate;
    ArrayList<HourlyPayslip> hourly_payslips = new ArrayList<>();

    HourlyEmployee(
            int id,
            String title,
            String first_name,
            String last_name,
            String date_birth,
            String national_insurance,
            String job_titles,
            double hourly_rate) {
        this.employee_id = id;
        this.employee_title = title;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_birth;
        this.national_insurance = national_insurance;
        this.job_titles = job_titles;
        this.hourly_rate = hourly_rate;
    }

    public double getRate() {
        return hourly_rate;
    }

    public int getId() {
        return employee_id;
    }

    // Returns a string with all the data of the specified employee.
    public String toString() {
        return String.format(
                "  Employee id: %d\n Employee title: %s\n First name: %s\n Last name: %s\n Date of birth: %s\n National insurance: %s \n Job titles: %s \n Hourly rate: %.2f",
                employee_id,
                employee_title,
                first_name,
                last_name,
                date_of_birth,
                national_insurance,
                job_titles,
                hourly_rate);
    }

    public static HourlyEmployee createEmployee(int id_assign) {
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
        System.out.println("Hourly rate:");
        double hourly_rate = Main.checkDouble(input_scanner);


        if (!isExisting(first_name, Main.salaried_employees, Main.hourly_employees, Main.commissioned_employees)) {
            return new HourlyEmployee(
                    id_assign,
                    title,
                    first_name,
                    last_name,
                    date_birth,
                    national_insurance,
                    job_titles,
                    hourly_rate);
        }

        return null;

    }
}
