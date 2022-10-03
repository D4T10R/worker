package entities;

import java.util.Date;

public class HourContract {
    
    private Date date;
    private Double valuePerHour;
    private Integer hours;

    // CONSTRUTORES
    public HourContract() {
    }

    public HourContract(Date date, Double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    // ENCAPSULAMENTO
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }
    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
    public Integer getHours() {
        return hours;
    }
    // ENCAPSULAMENTO

    // METODOS
    public Double totalValue() {
        return valuePerHour * hours;
    }

}
