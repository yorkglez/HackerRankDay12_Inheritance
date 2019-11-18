package com.hackerrankday12inheritance.app;
import java.util.Scanner;

class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    // Constructor
    Person(String firstName, String lastName, int identification){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

    // Print person data
    public void printPerson(){
        System.out.println(
                "Name: " + lastName + ", " + firstName
                        + 	"\nID: " + idNumber);
    }

}

class Student extends Person
{
    private int[] testScores;
    private String firstName;
    private String lastName;
    private int id;
    /*
     *   Class Constructor
     *
     *   @param firstName - A string denoting the Person's first name.
     *   @param lastName - A string denoting the Person's last name.
     *   @param id - An integer denoting the Person's ID number.
     *   @param scores - An array of integers denoting the Person's test scores.
     */
    public  Student(String firstName, String lastName, int id, int[] testScores)
    {
        super(firstName, lastName, id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.testScores = testScores;
    }
    /*
     *   Method Name: calculate
     *   @return A character denoting the grade.
     */
    public char calculate()
    {
        //Variables declaration
        int sum = 0;
        int average = 0;
        char letter = 'T';

        //Sum scores of array
        for(int score: testScores)
        {
            sum = sum + score;
        }

        //Calculate average
        average = (sum / testScores.length);

        //Grading scale
        if(average >= 90)
        {
            letter = 'O';
        }
        else if(average >= 80)
        {
            letter =  'E';
        }
        else if(average >= 70)
        {
            letter =  'A';
        }
        else if(average >= 55)
        {
            letter =  'P';
        }
        else if(average >= 40)
        {
            letter = 'D';
        }
        else
        {
            letter = 'T';
        }
        return letter;
    }
}

class Solution {
    public static void main(String[] args) {
        //Variables declaration
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String lastName = scan.next();

        //Input id and number of scores
        int id = scan.nextInt();
        int numScores = scan.nextInt();

        //Array declaration
        int[] testScores = new int[numScores];

        //Input Scores
        for(int i = 0; i < numScores; i++){
            testScores[i] = scan.nextInt();
        }
        scan.close();

        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate() );
    }
}