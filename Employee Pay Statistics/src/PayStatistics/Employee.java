package PayStatistics;

public class Employee {

    private String name;
    private float hours;
    private float rate;

    public Employee() {
        name = "";
        hours = 0;
        rate = 0;
    }

    public Employee(String name, float hours, float rate) {
        this.name = name;
        this.hours = hours;
        this.rate = rate;
    }

    public Employee(Employee anotherEmployee) {
        this.name = anotherEmployee.name;
        this.hours = anotherEmployee.hours;
        this.rate = anotherEmployee.rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHours() {
        return hours;
    }

    public void setHours(float hours) {
        this.hours = hours;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", hours=" + hours + ", rate=" + rate + '}';
    }
}
