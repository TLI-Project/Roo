package interfaces;

import entities.Person;

public interface PersonServiceIntercace {
    public Person saveUpdatedPerson(Person person);
    public Person findPersonById(Integer id);
}
