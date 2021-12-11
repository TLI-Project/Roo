package entities;

/**
 * Compatible with the CreditScore API call
 */
public abstract class CreditScoreJSON {

    /**
     * @return a JSON representation of the data needed for a credit score check.
     */
    public abstract String creditReadyData();
}
