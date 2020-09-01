package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static public ArrayList<SalariedEmployee> salaried_employees = new ArrayList<>();
    static public ArrayList<HourlyEmployee> hourly_employees = new ArrayList<>();
    static public ArrayList<CommissionedEmployee> commissioned_employees = new ArrayList<>();
    // This section populates the employee array lists with a new object each for testing
    // purposes.

    public static void main(String[] args) {
        Scanner input_scanner = new Scanner(System.in);

        salaried_employees.add(
                new SalariedEmployee(
                        1,
                        "Mr",
                        "John",
                        "Smith",
                        "20/02/1955",
                        "SS00221C",
                        "Director",
                        "Management",
                        "Full-time",
                        10000));
        hourly_employees.add(
                new HourlyEmployee(2, "Mr", "Reby", "Douglass", "20/02/2000", "SS00321B", "Cleaner", 8.50));
        commissioned_employees.add(
                new CommissionedEmployee(
                        3, "Mss", "Abbey", "Thorn", "20/02/1955", "SS00221C", "Management", 5000, 1000));

        int stop = 1;
        int id_assign = 4;
        // The software loop, runs until the stop variable is changed to 0.

        while (stop != 0) {
            MenuInterface.mainMenu();
            int input = checkInt(input_scanner);

            if (input > 0 && input <= 6) {
                // If input is 1 then the user is directed to the create employee submenu.
                if (input == 1) {
                    int is_running = 1;
                    // The is_running variable ensures the user selects the correct submenu, else it
                    // re-loops and asks for input again.
                    while (is_running == 1) {
                        MenuInterface.employeeInterface();
                        input = checkInt(input_scanner);
                        // Goes next line, needed to make the title String accept the scanner input as there
                        // seems to be an issue with how the Scanner lib is built.
                        // Please visit the website below for more information:
                        // https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo

                        if (input == 1) {
                            // Creates a salaried employee and stores it into an object array.
                            salaried_employees.add(SalariedEmployee.createEmployee(id_assign));

                            if (Objects.isNull(salaried_employees.get(salaried_employees.size() - 1))) {
                                MenuInterface.isExisting();
                                salaried_employees.remove(salaried_employees.size() - 1);
                            }

                            id_assign++;
                        } else if (input == 2) {
                            // Creates an hourly employee and stores it into an object array.
                            hourly_employees.add(HourlyEmployee.createEmployee(id_assign));
                            if (Objects.isNull(hourly_employees.get(hourly_employees.size() - 1))) {
                                MenuInterface.isExisting();
                                hourly_employees.remove(hourly_employees.size() - 1);
                            }
                            // Checks if the first name is already in the system, if it is, it will delete the
                            // object.

                            id_assign++;
                        } else if (input == 3) {
                            // Creates a commissioned employee and stores it into an object array.
                            commissioned_employees.add(CommissionedEmployee.createEmployee(id_assign));

                            if (Objects.isNull(commissioned_employees.get(commissioned_employees.size() - 1))) {
                                MenuInterface.isExisting();
                                commissioned_employees.remove(commissioned_employees.size() - 1);
                            }
                            // Checks if the first name is already in the system, if it is, it will delete the
                            // object.

                            id_assign++;
                        } else if (input == 4) {
                            is_running = 0;
                        } else {
                            MenuInterface.validSelection();
                        }
                    }

                } else if (input == 2) {
                    // Views all the employees from one of the categories.
                    int is_running = 1;
                    // Views employees from the salaried array.
                    while (is_running == 1) {
                        MenuInterface.employeeInterface();
                        input = checkInt(input_scanner);
                        if (input == 1 && !salaried_employees.isEmpty()) {
                            for (int i = 0; i < salaried_employees.size(); i++) {
                                System.out.println(i + 1 + ". " + salaried_employees.get(i).toString());
                            }
                            // Views employees from the hourly array.
                        } else if (input == 2 && !hourly_employees.isEmpty()) {
                            for (int i = 0; i < hourly_employees.size(); i++) {
                                System.out.println(i + 1 + ". " + hourly_employees.get(i).toString());
                            }
                            // Views employees from the commissioned array.
                        } else if (input == 3 && !commissioned_employees.isEmpty()) {
                            for (int i = 0; i < commissioned_employees.size(); i++) {
                                System.out.println(i + 1 + ". " + commissioned_employees.get(i).toString());
                            }
                        } else if (input >= 1 && input <= 3) {
                            MenuInterface.isEmptyList();
                        } else if (input == 4) {
                            is_running = 0;
                        } else {
                            MenuInterface.validSelection();
                        }
                    }
                    // Removes a selected employee from the list.
                } else if (input == 3) {
                    // Directs the user to the corresponding array that he wishes to remove the user from.
                    int is_running = 1;
                    while (is_running == 1) {
                        MenuInterface.employeeInterface();
                        System.out.println("Please select category of employee you want to remove:");
                        input = checkInt(input_scanner);
                        int selected_employee;
                        int array_validator = 0;
                        // Salaried employee array selection.
                        if (input == 1 && !salaried_employees.isEmpty()) {
                            for (SalariedEmployee salaried_employee : salaried_employees) {
                                System.out.println(salaried_employee.toString());
                            }
                            selected_employee = checkInt(input_scanner);
                            // Checks that no faulty input is passed to the array, if there is any, it will
                            // re-loop
                            // asking the user to re-input the selection.
                            while (array_validator != 1) {
                                try {
                                    // Checks that the input corresponds to one of the elements in the array
                                    // if it is not, the user will be asked to input the selection again.
                                    salaried_employees.remove(selected_employee - 1);
                                    array_validator = 1;
                                } catch (Exception e) {
                                    selected_employee = checkInt(input_scanner) - 1;
                                }
                            }
                            // Hourly employee array selection.
                        } else if (input == 1) {
                            MenuInterface.isEmptyList();
                        } else if (input == 2 && !hourly_employees.isEmpty()) {
                            for (HourlyEmployee hourly_employee : hourly_employees) {
                                System.out.println(hourly_employee.toString());
                            }
                            selected_employee = checkInt(input_scanner);
                            // Checks that no faulty input is passed to the array, if there is any, it will
                            // re-loop
                            // asking the user to re-input the selection.
                            array_validator = 0;
                            while (array_validator != 1) {
                                // Checks that the input corresponds to one of the elements in the array
                                try {
                                    hourly_employees.remove(selected_employee - 1);
                                    array_validator = 1;
                                } catch (Exception e) {
                                    selected_employee = checkInt(input_scanner) - 1;
                                }
                            }
                            // Commissioned employee array selection.
                        } else if (input == 2) {
                            MenuInterface.isEmptyList();
                        } else if (input == 3 && !commissioned_employees.isEmpty()) {
                            for (CommissionedEmployee commissioned_employee : commissioned_employees) {
                                System.out.println(commissioned_employee.toString());
                            }
                            selected_employee = checkInt(input_scanner);
                            // Checks that no faulty input is passed to the array, if there is any, it will
                            // re-loop
                            // asking the user to re-input the selection.
                            while (array_validator != 1)
                                // Checks that the input corresponds to one of the elements in the array
                                try {
                                    commissioned_employees.remove(selected_employee - 1);
                                    array_validator = 1;
                                } catch (Exception e) {
                                    selected_employee = checkInt(input_scanner) - 1;
                                }
                        } else if (input == 3) {
                            MenuInterface.isEmptyList();
                        } else if (input == 4) {
                            is_running = 0;
                        } else {
                            MenuInterface.validSelection();
                        }
                    }

                    // Generates a payslip for one of the employees on the list.
                } else if (input == 4) {

                    int is_running = 1;
                    while (is_running == 1) {
                        MenuInterface.employeeInterface();
                        input = checkInt(input_scanner);
                        if (input == 1 && !salaried_employees.isEmpty()) {
                            for (SalariedEmployee salaried_employee : salaried_employees) {
                                System.out.println(salaried_employee.toString());
                            } // Asks the user which employee to select from the list.
                            int selected_employee = checkInt(input_scanner) - 1;
                            int array_validator = 0;
                            while (array_validator != 1) {
                                try {
                                    salaried_employees.get(selected_employee);
                                    array_validator = 1;
                                } catch (Exception e) {
                                    selected_employee = checkInt(input_scanner) - 1;
                                }
                            }
                            // The following 2 variables are used to retrieve the respective values of the
                            // selected
                            // employee from the list.
                            int employee_id = salaried_employees.get(selected_employee).getId();
                            int monthly_salary = salaried_employees.get(selected_employee).getSalary();
                            System.out.println("Please input the month: ");
                            int salary_month = input_scanner.nextInt();
                            System.out.println(
                                    "The id of the employee is: "
                                            + employee_id
                                            + "\nThe monthly salary of the employee is: "
                                            + monthly_salary);
                            // A new payslip is created for the selected  salaried employee.
                            // Note it is stored inside the an arrayList of the type SalariedPayslip inside the
                            // Employee file.
                            salaried_employees
                                    .get(selected_employee)
                                    .salaried_payslips
                                    .add(new SalariedPayslip(salary_month, employee_id, monthly_salary));
                        } else if (input == 1) {
                            MenuInterface.isEmptyList();
                        } else if (input == 2 && !hourly_employees.isEmpty()) {
                            for (HourlyEmployee hourly_employee : hourly_employees) {
                                System.out.println(hourly_employee.toString());
                            }
                            int selected_employee = checkInt(input_scanner) - 1;
                            int array_validator = 0;
                            // Checks if the user made a valid selection.
                            while (array_validator == 0) {
                                try {
                                    hourly_employees.get(selected_employee);
                                    array_validator = 1;
                                } catch (Exception e) {
                                    selected_employee = checkInt(input_scanner) - 1;
                                }
                            }

                            System.out.println("Please input the month: ");
                            int month = input_scanner.nextInt();
                            System.out.println("Please input the number of hours for this week: ");
                            double hours = input_scanner.nextDouble();
                            int employee_id = hourly_employees.get(selected_employee).employee_id;
                            double hourly_rate = hourly_employees.get(selected_employee).hourly_rate;
                            double salary = hourly_employees.get(selected_employee).hourly_rate * hours;

                            hourly_employees
                                    .get(selected_employee)
                                    .hourly_payslips
                                    .add(new HourlyPayslip(employee_id, month, hourly_rate, salary));

                        } else if (input == 2) {
                            MenuInterface.isEmptyList();
                        } else if (input == 3 && !commissioned_employees.isEmpty()) {
                            for (CommissionedEmployee commissioned_employee : commissioned_employees) {
                                System.out.println(commissioned_employee.toString());
                            }

                            int selected_employee = checkInt(input_scanner) - 1;
                            int array_validator = 0;
                            while (array_validator == 0) {
                                try {
                                    commissioned_employees.get(selected_employee);
                                    array_validator = 1;
                                } catch (Exception e) {
                                    selected_employee = checkInt(input_scanner) - 1;
                                }
                            }
                            System.out.println("Please input the month: ");
                            int month = input_scanner.nextInt();
                            System.out.println("Please input the sales amount: ");
                            double sales_amount = input_scanner.nextInt();
                            int employee_id = commissioned_employees.get(selected_employee).employee_id;
                            double gross_salary = commissioned_employees.get(selected_employee).gross_salary;
                            double commission_rate =
                                    commissioned_employees.get(selected_employee).commission_rate
                                            % 100
                                            * sales_amount;

                            commissioned_employees
                                    .get(selected_employee)
                                    .commissioned_payslips
                                    .add(
                                            new CommissionedPayslip(
                                                    employee_id, month, gross_salary, sales_amount, commission_rate));
                        } else if (input == 3) {
                            MenuInterface.isEmptyList();
                        }

                        if (input == 4) {
                            is_running = 0;
                        } else {
                            MenuInterface.validSelection();
                        }
                    }

                    // Views all the payslips for any selected employee.
                } else if (input == 5) {
                    int is_running = 1;
                    while (is_running == 1) {
                        MenuInterface.employeeInterface();
                        input = input_scanner.nextInt();
                        // Salaried employee.
                        if (input == 1 && !salaried_employees.isEmpty()) {
                            for (SalariedEmployee salaried_employee : salaried_employees) {
                                salaried_employee.returnName();
                            }
                            int selected_employee = checkInt(input_scanner) - 1;
                            int array_validator = 0;
                            while (array_validator == 0) {
                                try {
                                    salaried_employees.get(selected_employee);
                                    array_validator = 1;
                                } catch (Exception e) {
                                    selected_employee = checkInt(input_scanner);
                                }
                                salaried_employees.get(selected_employee).returnName();
                                for (int i = 0;
                                     i < salaried_employees.get(selected_employee).salaried_payslips.size();
                                     i++)
                                    System.out.println(
                                            salaried_employees
                                                    .get(selected_employee)
                                                    .salaried_payslips
                                                    .get(i)
                                                    .toString());
                            }
                            // Hourly employee.
                        } else if (input == 2 && !hourly_employees.isEmpty()) {
                            for (HourlyEmployee hourly_employee : hourly_employees) {
                                hourly_employee.returnName();
                            }
                            int selected_employee = checkInt(input_scanner) - 1;
                            int array_validator = 0;
                            while (array_validator == 0) {
                                try {
                                    hourly_employees.get(selected_employee);
                                    array_validator = 1;
                                } catch (Exception e) {
                                    MenuInterface.validSelection();
                                    selected_employee = checkInt(input_scanner);
                                }
                                for (int i = 0;
                                     i < hourly_employees.get(selected_employee).hourly_payslips.size();
                                     i++)
                                    System.out.println(
                                            hourly_employees.get(selected_employee).hourly_payslips.get(i).toString());
                            }
                            // Commissioned employee.
                        } else if (input == 3 && !commissioned_employees.isEmpty()) {
                            for (int i = 0; i < salaried_employees.size(); i++) {
                                commissioned_employees.get(i).returnName();
                            }
                            int selected_employee = checkInt(input_scanner) - 1;
                            int array_validator = 0;
                            while (array_validator == 0) {
                                try {
                                    commissioned_employees.get(selected_employee);
                                    array_validator = 1;
                                } catch (Exception e) {
                                    selected_employee = checkInt(input_scanner) - 1;
                                    commissioned_employees.get(selected_employee).returnName();
                                }
                                for (int i = 0;
                                     i < commissioned_employees.get(selected_employee).commissioned_payslips.size();
                                     i++) {
                                    System.out.println(
                                            commissioned_employees
                                                    .get(selected_employee)
                                                    .commissioned_payslips
                                                    .get(i)
                                                    .toString());
                                }
                            }
                        } else if (input == 4) {
                            is_running = 0;
                        } else {
                            MenuInterface.validSelection();
                        }
                    }
                }
                // If user input is 6, the program stops.
                else if (input == 6) {
                    stop = 0;
                    System.out.println("Thank you for your custom!");
                }
            } else {
                MenuInterface.validSelection();
            }
        }
    }

    public static String checkLine(Scanner input_scanner) {
        int input_validator = 1;
        String input = "";
        do {
            if (input_scanner.hasNextLine()) {
                input = input_scanner.nextLine();
                input_validator = 0;

            } else {
                MenuInterface.validSelection();
                input_scanner.next();
            }
        } while (input_validator == 1);

        return input;
    }

    public static int checkInt(Scanner input_scanner) {
        int input = 0;
        int input_validator = 1;
        do {
            if (input_scanner.hasNextInt()) {
                input = input_scanner.nextInt();
                input_validator = 0;
            } else {
                MenuInterface.validSelection();
                input_scanner.next();
            }
        } while (input_validator == 1);
        return input;
    }

    public static double checkDouble(Scanner input_scanner) {
        double input = 0;
        int input_validator = 1;
        do {
            if (input_scanner.hasNextDouble()) {
                input = input_scanner.nextDouble();
                input_validator = 0;
            } else {
                MenuInterface.validSelection();
                input_scanner.next();
            }
        } while (input_validator == 1);
        return input;
    }


}
