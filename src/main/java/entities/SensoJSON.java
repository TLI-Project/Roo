package entities;

/**
 * Compatible with SensoReadyInfo
 */
public abstract class SensoJSON {

    /**
     * @return a JSON representation of the data needed for the Senso API body for the Loan API call.
     */
    public abstract String sensoReadyData();
}
