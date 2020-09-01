package com.company;

import java.util.ArrayList;

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

    public static boolean isExisting(String first_name, ArrayList<SalariedEmployee> salaried, ArrayList<HourlyEmployee> hourly, ArrayList<CommissionedEmployee> commissioned) {
        for (SalariedEmployee salariedEmployee : salaried) {
            if (salariedEmployee.first_name.equals(first_name)) {
                return true;
            }
        }

        for (HourlyEmployee hourlyEmployee : hourly) {
            if (hourlyEmployee.first_name.equals(first_name)) {
                return true;
            }
        }

        for (CommissionedEmployee commissionedEmployee : commissioned) {
            if (commissionedEmployee.first_name.equals(first_name)) {
                return true;
            }
        }
        return false;
    }

}




