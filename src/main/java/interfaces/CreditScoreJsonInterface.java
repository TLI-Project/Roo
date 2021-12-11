package interfaces;

/**
 * Compatible with the CreditScore API call
 */
public interface CreditScoreJsonInterface {

    /**
     * @return a JSON representation of the data needed for a credit score check.
     */
    public String creditReadyData();
}
