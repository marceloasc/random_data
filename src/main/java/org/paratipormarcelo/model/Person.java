package org.paratipormarcelo.model;

public class Person {

    public String firstName;
    public String lastName;
    public String birthDate;
    public String stateLocation;
    public String salary;
    public String socialClass;


    public Person(String firstName, String lastName, String birthDate, String stateLocation, String salary, String socialClass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.stateLocation = stateLocation;
        this.salary = salary;
        this.socialClass = socialClass;
    }


    public String[] instance() {
        String[] instance = {firstName, lastName, birthDate, stateLocation, salary, socialClass};
        return instance;
    }
}
