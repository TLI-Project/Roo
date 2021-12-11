package interfaces;

import entities.GraphingData;

public interface GraphingServiceInterface {
    public GraphingData saveUpdatedPerson(GraphingData person);
    public GraphingData findPersonById(Integer id);
}
