package student;

/**
 * The class represents a pay stub for an employee.
 * It provides details such as the employee's name, net pay, taxes,
 * year-to-date (YTD) earnings, and YTD taxes paid.
 */
public class PayStub implements IPayStub {

    /**
     * The employee's name.
     */
    private String name;

    /**
     * The net pay amount.
     */
    private double netPay;

    /**
     * The amount of taxes paid.
     */
    private double taxes;

    /**
     * The year-to-date earnings.
     */
    private double ytdEarnings;

    /**
     * The year-to-date taxes paid.
     */
    private double ytdTaxesPaid;

    /**
     * Constructs a new PayStub with the specified details.
     *
     * @param name         the employee's name
     * @param netPay       the net pay amount
     * @param taxes        the amount of taxes paid
     * @param ytdEarnings  the year-to-date earnings
     * @param ytdTaxesPaid the year-to-date taxes paid
     */
    public PayStub(String name, double netPay, double taxes, double ytdEarnings, double ytdTaxesPaid) {
        this.name = name;
        this.netPay = netPay;
        this.taxes = taxes;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    /**
     * Returns the employee's name.
     *
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the net pay amount.
     *
     * @return the net pay amount
     */
    @Override
    public double getPay() {
        return this.netPay;
    }

    /**
     * Returns the amount of taxes paid.
     *
     * @return the taxes paid
     */
    @Override
    public double getTaxesPaid() {
        return this.taxes;
    }

    /**
     * Returns the year-to-date earnings.
     *
     * @return the YTD earnings
     */
    public double getYtdEarnings() {
        return ytdEarnings;
    }

    /**
     * Returns the year-to-date taxes paid.
     *
     * @return the YTD taxes paid
     */
    public double getYtdTaxesPaid() {
        return ytdTaxesPaid;
    }

    /**
     * Returns a CSV representation of the pay stub.
     * The CSV string contains the employee's name, net pay, taxes, YTD earnings,
     * and YTD taxes paid, formatted to two decimal places.
     *
     * @return a CSV formatted string representing the pay stub
     */
    @Override
    public String toCSV() {
        return String.format("%s,%.2f,%.2f,%.2f,%.2f",
                name, netPay, taxes, ytdEarnings, ytdTaxesPaid);
    }
}
