package entities;

/**
 * The response given by the Senso API.
 */
public class LoanResponse {
    private final double amount;
    private final double interestSum;
    private final double capitalSum;
    private final double sum;
    private final int term;
    private final double interestRate;
    private final String[] installments;

    /**
     * Construct a new loan with the senso information.
     * @param amount total amount of the loan.
     * @param interestSum the sum of all the interest on the loan.
     * @param capitalSum The total capital on the laon.
     * @param sum the total sum of interest + capital.
     * @param term the length of the loan (months).
     * @param interestRate the interest rate of the loan.
     * @param installments list of the cars amortization data.
     */
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

    /**
     * Get the amount of the loan
     * @return double representation of loan amount.
     */
    public double getAmount(){
        return this.amount;
    }

    /**
     * Get the total interest on the car loan.
     * @return the interestSum.
     */
    public double getInterestSum(){
        return this.interestSum;
    }

    /**
     * Get the total capital on the car.
     * @return the capital sum of the loan.
     */
    public double getCapitalSum(){
        return this.capitalSum;
    }

    /**
     * Get the total money of the loan.
     * @return the total money.
     */
    public double getSum(){
        return this.sum;
    }

    /**
     * Get the term of the loan in months.
     * @return the length of the loan in months.
     */
    public int getTerm(){
        return this.term;
    }

    /**
     * Get the interest rate of the loan.
     * @return double representation of the interest rate.
     */
    public double getInterestRate(){
        return this.interestRate;
    }

    /**
     * Get the amortization data of the loan.
     * @return amortization table.
     */
    public String[] getInstallments(){
        return this.installments;
    }
}
