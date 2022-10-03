package entities;

import java.time.Month;
import java.util.ArrayList;

import entities_enum.WorkerLevel;
import java.util.List;
import java.util.Calendar;
import java.util.ArrayList;


public class Worker {
    
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    // CONSTRUTORES
    public Worker() {
    }
    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }
    // CONSTRUTORES

    // ENCAPSULAMENTO
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }
    public WorkerLevel getWorkerLevel() {
        return level;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    public Department getDepartment() {
        return department;
    }
    // ENCAPSULAMETO

    // METODOS
    public void addContract(HourContract contract) {
        this.contracts.add(contract);
    }
    public void removeContract(HourContract contract) {
        this.contracts.remove(contract);
    }

    public Double income(Integer year, Integer month) {
        Double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts) {
            cal.setTime(c.getDate());
            int c_month = cal.get(Calendar.MONTH);
            int c_year = cal.get(Calendar.YEAR);
            if (year == c_year && month == c_month) {
                sum += c.totalValue();
            }
        }
        return sum;
    }
    // METODOS
    


}
