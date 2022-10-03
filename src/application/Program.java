

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities_enum.WorkerLevel;

public class Program {

    public static void main(String[] args) throws ParseException {

        // VARIAVEIS INCIALIZADAS
        Scanner sc = new Scanner(System.in);
        Department department = new Department();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
        // INFORMAÇÕES DO WORK
        System.out.print("Enter department's name: ");
        department.setName(sc.next());
        System.out.print("Enter worker data: ");
        System.out.print("\nName: ");
        String nameWorker = sc.next();
        System.out.print("Level: ");
        String level = sc.next();
        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();

        // INICIALIZANDO WORK
        Worker worker = new Worker(nameWorker, WorkerLevel.valueOf(level), baseSalary, department);


        System.out.println("How many contracts to this worker? ");
        int n = sc.nextInt();

        // INFORMAÇÕES DO CONTRATO
        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.print("\nDate (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("\nValue per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.print("\nDuration (Hours): ");
            int hours = sc.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);

        }

        // CALCULO FINAL DO SALARIO
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String incomeDate = sc.next();
        int month = Integer.parseInt(incomeDate.substring(0, 2));
        int year = Integer.parseInt(incomeDate.substring(4));
        System.out.printf("\nName: %s", worker.getName());
        System.out.printf("\nDepartment: %s", worker.getDepartment().getName());
        System.out.printf("\nIncome for %d/%d: %.2f", month, year, worker.income(month, year));
    
    
    }

}