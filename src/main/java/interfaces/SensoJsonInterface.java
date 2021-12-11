package interfaces;

/**
 * Compatible with SensoReadyInfo
 */
public interface SensoJsonInterface {

    /**
     * @return a JSON representation of the data needed for the Senso API body for the Loan API call.
     */
    public String sensoReadyData();
}
