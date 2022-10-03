package application;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities_enum.WorkerLevel;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Department department = new Department();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        department.setName(sc.next());
        System.out.print("Enter worker data: ");
        System.out.print("Name: ");
        String nameWorker = sc.next();
        System.out.print("Level: ");
        String level = sc.next();
        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();

        Worker worker = new Worker(nameWorker, WorkerLevel.valueOf(level), baseSalary, department);

        System.out.println("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.println("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.println("Duration (Hours): ");
            int hours = sc.nextInt();

            worker.addContract(new HourContract(contractDate, valuePerHour, hours));
        }

        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        String incomeDate = sc.next();
        int month = Integer.parseInt(incomeDate.substring(0, 2));
        int year = Integer.parseInt(incomeDate.substring(4));
        System.out.printf("Name: %s", worker.getName());
        System.out.printf("Department: %s", worker.getDepartment().getName());
        System.out.printf("Income for %d/%d: %.2f", month, year, worker.income(month, year));
    }

}