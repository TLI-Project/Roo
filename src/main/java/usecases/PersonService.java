package usecases;

import entities.Person;
import interfaces.PersonServiceIntercace;

public class PersonService implements PersonServiceIntercace {
    @Override
    public Person saveUpdatedPerson(Person person) {
        return null;
    }

    @Override
    public Person findPersonById(Integer id) {
        return null;
    }

//    @Override
//    public Person saveUpdatedPerson(Person person) {
//        return new Person(1, "test");
//    }
//
//    @Override
//    public Person findPersonById(Integer id) {
//        return new Person(1, "test");
//    }
}
