package PayStatistics;

/**
 * Employee.java A class representing an employee with the desired 3 fields:
 * name, hours and rate.
 * <pre>
 *      Project: Employee Pay Statistics (Project 1)
 *      Platform: jdk 8.0_66, Netbeans 8.1, Windows 10
 *      Course: CS 142C
 *      Hours: 10 hours
 *      Date: 1/27/2016
 *      Revision:
 * </pre>
 *
 * @author Mitchell Nye
 * @author Alexander Jordan
 * @version %1
 */
public class Employee {

    // Instance variables:
    private String name;
    private float hours;
    private float rate;

    /**
     * Default constructor:
     */
    public Employee() {
        name = "";
        hours = 0;
        rate = 0;
    }

    /**
     * Overloaded constructor:
     *
     * @param name
     * @param hours
     * @param rate
     */
    public Employee(String name, float hours, float rate) {
        this.name = name;
        this.hours = hours;
        this.rate = rate;
    }

    /**
     * Clone constructor:
     *
     * @param anotherEmployee
     */
    public Employee(Employee anotherEmployee) {
        this.name = anotherEmployee.name;
        this.hours = anotherEmployee.hours;
        this.rate = anotherEmployee.rate;
    }

    /**
     * getName returns the name of the employee.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setName sets the name of the employee.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getHours returns the hours of the employee.
     *
     * @return
     */
    public float getHours() {
        return hours;
    }

    /**
     * setHours sets the hours of the employee.
     *
     * @param hours
     */
    public void setHours(float hours) {
        this.hours = hours;
    }

    /**
     * getRate returns the rate of the employee.
     *
     * @return rate
     */
    public float getRate() {
        return rate;
    }

    /**
     * setRate sets the rate of the employee.
     *
     * @param rate
     */
    public void setRate(float rate) {
        this.rate = rate;
    }

    /**
     * toString returns the employee's data.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", hours=" + hours + ", rate=" + rate + '}';
    }

    /**
     * equals determines if one employee is the same as another based
     * on name and their hourly rates.
     *
     * @param employee
     * @return
     */
    public boolean equals(Employee employee) {
        return this.getName().equalsIgnoreCase(getName())
                && closeEnough(this.rate, employee.rate);
    }

    /**
     * closeEnough rounds floats and compares them to each other.
     *
     * @param x
     * @param y
     * @return
     */
    private boolean closeEnough(float x, float y) {
        final double EPSILON = 1e-9;
        return Math.abs(x - y) < EPSILON;
    }
}
