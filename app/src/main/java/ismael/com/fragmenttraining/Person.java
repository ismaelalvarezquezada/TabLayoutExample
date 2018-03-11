package ismael.com.fragmenttraining;

/**
 * Created by ismael on 11-03-18.
 */

public class Person {

    String name;
    String age;
    String gender;

    public Person (){}

    public Person(String name,String age,String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }


}
