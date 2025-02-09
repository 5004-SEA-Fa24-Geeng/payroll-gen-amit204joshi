package student;

/**
 * The {@code TimeCard} class implements the {@code ITimeCard} interface and
 * represents a record of an employee's working hours.
 *
 * <p>This class stores an employee's identification and the number of hours worked.
 * It ensures that the hours worked are non-negative.</p>
 */
public class TimeCard implements ITimeCard {

    /**
     * The identification number of the employee.
     */
    private String employeeID;

    /**
     * The number of hours the employee has worked.
     */
    private double hoursWorked;

    /**
     * Constructs a new TimeCard with the specified employee ID and hours worked.
     *
     * @param employeeID  the identification number of the employee
     * @param hoursWorked the number of hours the employee worked
     * @throws IllegalArgumentException if hoursWorked is negative
     */
    public TimeCard(String employeeID, double hoursWorked) {
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked cannot be negative");
        }
        this.employeeID = employeeID;
        this.hoursWorked = hoursWorked;
    }

    /**
     * Returns the identification number of the employee.
     *
     * @return the employee ID
     */
    @Override
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * Returns the number of hours worked by the employee.
     *
     * @return the hours worked
     */
    @Override
    public double getHoursWorked() {
        return hoursWorked;
    }
}
