package marital_status;

import org.fluttercode.datafactory.impl.DataFactory;


public class PersonService {

    private DataFactory dataFactory = new DataFactory();

    public Person getPerson(String name, int age, int maritalStatusCode) {
        return new Person(name, age, MaritalStatus.findByDbCode(maritalStatusCode));
    }

    public Person getRandomPerson(){
        return new Person(
                dataFactory.getName(),
                dataFactory.getNumberBetween(12, 90),
                MaritalStatus.findByDbCode(dataFactory.getNumberBetween(1,5)));
    }


}
