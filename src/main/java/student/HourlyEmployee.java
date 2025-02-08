package student;

public class HourlyEmployee implements IEmployee {
    private String name;
    private String id;
    private final String employeeType = "Hourly";
    private double payRate;
    private double ytdEarnings;
    private double ytdTaxesPaid;
    private double pretaxDeductions;

    public HourlyEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions){
        if (payRate < 0 || ytdEarnings < 0 || ytdTaxesPaid < 0 || pretaxDeductions < 0){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public double getPayRate() {
        return this.payRate;
    }

    @Override
    public String getEmployeeType() {
        return this.employeeType;
    }

    @Override
    public double getYTDEarnings() {
        return this.ytdEarnings;
    }

    @Override
    public double getYTDTaxesPaid() {
        return this.ytdTaxesPaid;
    }

    @Override
    public double getPretaxDeductions() {
        return this.pretaxDeductions;
    }

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        return null;
    }

    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%.2f,%.2f,%.2f",
                employeeType, name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);
    }
}
