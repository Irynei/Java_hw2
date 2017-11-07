package marital_status;


import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        final PersonService personService = new PersonService();
        final PersonReader personReader = new PersonReader();

        personReader.read(personService.getPerson("Chuck Norris", 77, 2));
        personReader.read(personService.getPerson("Chuck Norris", 77, 2));

        while(true){
            personReader.read(personService.getRandomPerson());
            Thread.sleep(1000);
        }

    }
}
