package student;

public class PayStub implements IPayStub {
    private String name;
    private double netPay;
    private double taxes;
    private double ytdEarnings;
    private double ytdTaxesPaid;

    public PayStub(String name, double netPay, double taxes, double ytdEarnings, double ytdTaxesPaid) {
        this.name = name;
        this.netPay = netPay;
        this.taxes = taxes;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPay() {
        return this.netPay;
    }

    @Override
    public double getTaxesPaid() {
        return this.taxes;
    }

    public double getYtdEarnings() {
        return ytdEarnings;
    }

    public double getYtdTaxesPaid() {
        return ytdTaxesPaid;
    }

    @Override
    public String toCSV() {
        return String.format("%s,%.2f,%.2f,%.2f,%.2f",
                name, netPay, taxes, ytdEarnings, ytdTaxesPaid);
    }
}
