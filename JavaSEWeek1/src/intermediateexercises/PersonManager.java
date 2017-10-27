package intermediateexercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class PersonManager {
    private List<Person> personList = new ArrayList<Person>();
    private List<Person> inputPersonList = new ArrayList<Person>();
    private FileWriter writer ;
    private FileReader reader;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String filePath = "C:/Users/Admin/Documents/people.txt";
    private String currentLine = "";
    private Person tempPerson;
    private String[] tempArray;

    public PersonManager(){
        try {
            writer = new FileWriter(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            reader = new FileReader(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedWriter = new BufferedWriter(writer);
        bufferedReader = new BufferedReader(reader);
    }

    public void addToList(Person p){
        personList.add(p);
    }
    public void printListContents(List<Person> list){
        for (Person p : list) {
            System.out.println(p.toString());
        }
    }

    public String personSearch(String name){
        boolean wasFound = false;
        for (Person p : personList) {
            if (p.name.equals(name)){
                wasFound = true;
            }
        }
        if (wasFound){
            return name + " has been found in the given list.";
        }
        else {
            return name + " was not found in the list.";
        }
    }

    public void savePersonList(){
        for (Person p : personList){
            try {
                bufferedWriter.write(p.toString(), 0, p.toString().length());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPerson(){
        while (currentLine != null){
            try {
                currentLine = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (currentLine != null){
                tempArray = currentLine.split("-");
                tempPerson = new Person(tempArray[0], Integer.parseInt(tempArray[1]), tempArray[2]);
                inputPersonList.add(tempPerson);
            }
        }
        printListContents(inputPersonList);
    }
}

