package student;

/**
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {

    private Builder() {
    }


    /**
     * Builds an employee object from a CSV string.
     * <p>
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     *
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {
        // Split the CSV string into parts using a comma as the delimiter
        String[] parts = csv.split(",");

        // Ensure the CSV contains exactly 7 elements; otherwise, throw an error
        if (parts.length != 7) {
            throw new IllegalArgumentException("Invalid employee CSV format: expected 7 columns");
        }

        try {
            // Trim and extract each field from the CSV
            String employeeType = parts[0].trim();  // Employee type
            String name = parts[1].trim();          // Employee name
            String id = parts[2].trim();            // Employee ID
            double payRate = Double.parseDouble(parts[3].trim());        // Pay rate
            double pretaxDeductions = Double.parseDouble(parts[4].trim()); // Pre-tax deductions
            double ytdEarnings = Double.parseDouble(parts[5].trim());    // Year-to-date earnings
            double ytdTaxesPaid = Double.parseDouble(parts[6].trim());   // Year-to-date taxes paid

            // Determine the employee type and create the appropriate object
            switch (employeeType.toUpperCase()) {
                case "HOURLY":
                    return new HourlyEmployee(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
                case "SALARY":
                    return new SalaryEmployee(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
                default:
                    throw new IllegalArgumentException("Unknown employee type: " + employeeType);
            }
        } catch (NumberFormatException e) {
            // Handle invalid number format in pay rate, deductions, earnings, or taxes
            throw new IllegalArgumentException("Invalid number format in employee CSV", e);
        }
    }

    /**
     * Converts a TimeCard from a CSV String.
     *
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        // Split the CSV string into parts using a comma
        String[] parts = csv.split(",");

        // Ensure the CSV contains exactly 2 elements; otherwise, throw an error
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid time card format: expected 2 columns");
        }

        try {
            // Extract employee ID
            String employeeID = parts[0].trim();

            // Parse hours worked from the string
            double hoursWorked = Double.parseDouble(parts[1].trim());

            // Return a new TimeCard object
            return new TimeCard(employeeID, hoursWorked);
        } catch (NumberFormatException e) {
            // Handle invalid number format in hours worked
            throw new IllegalArgumentException("Invalid hours format in time card", e);
        }
    }
}
