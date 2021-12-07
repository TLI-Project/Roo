package entities;

public class InputData extends Entity {
    public final int id;
    public final double loanAmount;
    public final int creditScore;
    public final double pytBudget;
    public final double downpayment;

    public InputData(int id, double loanAmount, int creditScore, double pytBudget, double downpayment){
        this.id = id;
        this.loanAmount = loanAmount;
        this.creditScore = creditScore;
        this.pytBudget = pytBudget;
        this.downpayment = downpayment;
    }


    @Override
    public String getEntityStr() {
        return null;
    }
}
