package org.paratipormarcelo.operations;

import com.opencsv.CSVWriter;
import net.datafaker.Faker;
import org.paratipormarcelo.model.Person;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class GenerateCSV {

    public static Faker dataFaker = new Faker();


    public GenerateCSV() {
    }


    public ArrayList<String> generateFristName() {
        ArrayList fristNames = new ArrayList<String>();

        for(int i = 0; i < 100; i++) {
            fristNames.add(dataFaker.name().firstName());
        }
        return fristNames;
    }


    public ArrayList<String> generateLastName() {
        ArrayList lastNames = new ArrayList<String>();

        for(int i = 0; i < 100; i++ ) {
            lastNames.add(dataFaker.name().lastName());
        }
        return lastNames;
    }


    public ArrayList<String> generateBirthDate() {
        Random randomFeildDate = new Random();
        ArrayList birthDates = new ArrayList<String>();

        for(int i = 0; i < 100; i++) {
            int day = randomFeildDate.nextInt(1, 32);
            int month = randomFeildDate.nextInt(1, 12);
            int year = randomFeildDate.nextInt(1950, 2000);
            birthDates.add(day+"/"+month+"/"+year);
        }
        return birthDates;
    }


    public ArrayList<String> generateState() {
        ArrayList states = new ArrayList<String>();

        for(int i = 0; i < 100; i++) {
            states.add(dataFaker.address().state());
        }
        return states;
    }


    public ArrayList<String> generateSalary() {
        ArrayList salaries = new ArrayList<String>();
        Random randomSalary = new Random();

        for(int i = 0; i < 100; i++) {
            Double salary = randomSalary.nextDouble(1000, 20000);
            salaries.add(String.format(Locale.US, "%,.2f", salary));
        }
        return salaries;
    }


    public ArrayList<String> generateSocialClass() {
        ArrayList classes = new ArrayList<String>();

        String[] classType = {"A", "B", "C"};

        for(int i = 0; i < 100; i++) {
            Random randomClass = new Random();
            classes.add(classType[randomClass.nextInt(3)]);
        }
        return classes;
    }


    public void create() {
        String CSV_PATH = "<choice your path>/persons.csv";

        try {
            FileWriter personDataSet = new FileWriter(new File(CSV_PATH));
            CSVWriter popularization = new CSVWriter(personDataSet);

            ArrayList fristName = this.generateFristName();
            ArrayList lastName = this.generateLastName();
            ArrayList birthDate = this.generateBirthDate();
            ArrayList state = this.generateState();
            ArrayList salary = this.generateSalary();
            ArrayList socialClass = this.generateSocialClass();

            String[] headers = {"frist-name", "last-name", "birth-date", "state", "salary", "social-class"};
            popularization.writeAll(Collections.singletonList(headers));

            for(int column = 0; column < 100; column++) {
                Person personObject = new Person(
                        (String) fristName.get(column),
                        (String) lastName.get(column),
                        (String) birthDate.get(column),
                        (String) state.get(column),
                        (String) salary.get(column),
                        (String) socialClass.get(column));
                popularization.writeAll(Collections.singletonList(personObject.instance()));
            }

            popularization.close();
            personDataSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
