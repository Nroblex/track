package position.Model;

import org.codehaus.enunciate.json.JsonRootType;

/**
 * Created by ueh093 on 5/5/15.
 */
@JsonRootType
public class Person {

    public Person(){}

    private String firstName;
    private String lastName;
    //private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

   // public int getAge() {
    //    return age;
    //}

    //public void setAge(int age) {
    //    this.age = age;
   // }

    @Override
    public String toString() {
        //return new StringBuffer(" Firstname: " ).append(getFirstName()).append("Lastname: " ).append(getLastName()).append(" age: ").append(String.valueOf(this.getAge())).toString();
        return new StringBuffer(" Firstname: " ).append(getFirstName()).append(" Lastname: ").append(getLastName()).toString();

    }
}
