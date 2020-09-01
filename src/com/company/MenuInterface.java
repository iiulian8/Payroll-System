package com.company;

public class MenuInterface {

    // Prints the "*Payroll system*" header"
    public static void generalInterface() {

        System.out.print("********************************");
        System.out.print("\n" + "*");
        System.out.print("        ");
        System.out.print("Payroll System");
        System.out.print("        ");
        System.out.print("*" + "\n");
        System.out.print("********************************");
    }

    // The main menu interface, it displays all the submenus.
    public static void mainMenu() {
        generalInterface();
        System.out.print(
                "\n1. Register Employee \n"
                        + "2. View Employee \n"
                        + "3. Remove Employee \n"
                        + "4. Generate New Payslip \n"
                        + "5. View Payslip \n"
                        + "6. Exit \n"
                        + "Please enter an option:");
    }

    // Interface used for selecting which type of employee to be registered.
    public static void employeeInterface() {
        generalInterface();
        System.out.println(
                "\n1. Salaried Employee \n"
                        + "2. Hourly Employee \n"
                        + "3. Commissioned Employee \n"
                        + "4. Exit \n"
                        + "Please enter an option:");
    }

    // Interface used for viewing employees.
    public static void viewEmployee() {
        generalInterface();
        System.out.println(
                "\n1. View Salaried Employee \n"
                        + "2. View Hourly Employee \n"
                        + "3. View Commissioned Employee \n"
                        + "4. Exit \n"
                        + "Please enter an option:");
    }

    // Interface used for removing employees.
    public static void removeMenu() {
        generalInterface();
        System.out.println(
                "\n1. Remove Salaried Employee \n"
                        + "2. Remove Hourly Employee \n"
                        + "3. Remove Commissioned Employee \n"
                        + "Exit"
                        + "\n Please enter an option:");
    }

    public static void validSelection() {
        System.out.println("Please input a valid selection: ");
    }

    public static void isEmptyList() {
        System.out.println("There is no employee of this type registered");
    }

    public static void existingEmployee() {
        System.out.println("An employee with this name already exists.");
    }

    public static void noPayslip() {System.out.println("No payslip has been found in this category");}
}


