package entities;

public class LoanResponse {
    private final double amount;
    private final double interestSum;
    private final double capitalSum;
    private final double sum;
    private final int term;
    private final double interestRate;
    private final String[] installments;

    public LoanResponse(double amount, double interestSum, double capitalSum, double sum,
                        int term, double interestRate, String[] installments){
        this.amount = amount;
        this.interestSum = interestSum;
        this.capitalSum = capitalSum;
        this.sum = sum;
        this.term = term;
        this.interestRate = interestRate;
        this.installments = installments;
    }

    public double getAmount(){
        return this.amount;
    }

    public double getInterestSum(){
        return this.interestSum;
    }

    public double getCapitalSum(){
        return this.capitalSum;
    }

    public double getSum(){
        return this.sum;
    }

    public int getTerm(){
        return this.term;
    }

    public double getInterestRate(){
        return this.interestRate;
    }

    public String[] getInstallments(){
        return this.installments;
    }
}
