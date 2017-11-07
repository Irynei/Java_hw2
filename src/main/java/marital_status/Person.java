package marital_status;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String fullName;
    private int age;
    private MaritalStatus maritalStatus;

    @Override
    public String toString(){
        return String.format("%s age: %d, %s", getFullName(), getAge(), getMaritalStatus());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (getAge() != person.getAge()) return false;
        if (!getFullName().equals(person.getFullName())) return false;
        return getMaritalStatus() == person.getMaritalStatus();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getFullName().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + getMaritalStatus().hashCode();
        return result;
    }
}
