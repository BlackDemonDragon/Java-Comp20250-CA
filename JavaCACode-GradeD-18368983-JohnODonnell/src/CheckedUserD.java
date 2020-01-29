import CheckedUserExceptions.InvalidAgeException;
import CheckedUserExceptions.InvalidNameException;

public class CheckedUserD implements User {

    //The instance variables for the CheckedUserD class
    private String name;
    private String email = null; //Has a default value of null
    private int age = -1;// Has a default value of -1


    //Constructor for CheckedUserD taking only name as input
    public CheckedUserD(String name) throws InvalidNameException{

        //If the name is valid
        if (checkName(name)){

            //set the instance variable name to the inputted name
            this.name = name;

        }
        else {
            //Else throw an CheckedUserDExceptions.InvalidNameException so that the program can decide what to do about the invalid inputted name
            throw new InvalidNameException("Invalid name was inputted!\nNames one or two words and no name prefixes\nNames should have a capital at the start or each word\nOnly letters [a-z] are allowed");
        }

    }


    //Constructor for CheckedUserD taking name and age as input
    public CheckedUserD(String name, int age)throws InvalidNameException, InvalidAgeException {

        //If the age is valid
        if (checkAge(age)){

            //set the instance variable age to the inputted age
            this.age = age;

        }
        else {
            //Else throw an CheckedUserDExceptions.InvalidAgeException so that the program can decide what to do about the invalid inputted age
            throw new InvalidAgeException("Invalid age was inputted!\nUser's age must be between 18 and 30");
        }

        //If the name is valid
        if (checkName(name)){

            //set the instance variable name to the inputted name
            this.name = name;

        }
        else {
            //Else throw an CheckedUserDExceptions.InvalidNameException so that the program can decide what to do about the invalid inputted name
            throw new InvalidNameException("Invalid name was inputted!\nThe user's name is one or two words and with no name prefixes\nThe user's name should have a capital at the start or each word\nOnly letters [a-z] are allowed");
        }

    }


    //Constructor for CheckedUserD taking name, age and email as input
    public CheckedUserD(String name, int age, String email)throws InvalidNameException, InvalidAgeException {

        //If the age is valid
        if (checkAge(age)){

            //set the instance variable age to the inputted age
            this.age = age;

        }
        else {
            //Else throw an CheckedUserDExceptions.InvalidAgeException so that the program can decide what to do about the invalid inputted age
            throw new InvalidAgeException("Invalid age inputted!\nUser's age must be between 18 and 30");
        }

        //If the name is valid
        if (checkName(name)){

            //set the instance variable name to the inputted name
            this.name = name;

        }
        else {
            //Else throw an CheckedUserDExceptions.InvalidNameException so that the program can decide what to do about the invalid inputted name
            throw new InvalidNameException("Invalid name inputted!\nThe user's name is one or two words and with no name prefixes\nThe user's name should have a capital at the start or each word\nOnly letters [a-z] are allowed");
        }


        //set the instance variable email to the inputted email
        this.email = email;

    }


    //Method to check that the inputted name for the user is valid
    private boolean checkName(String name){

        //If the name matches a string that contains 0 or more word chars
        return (name.matches("[\\w\\s]*"));

    }

    //Method to check that the inputted age for the user is valid
    private boolean checkAge(int age){
        // Return if age is between 18 and 30
        return age >= 18 && age <= 30;
    }



    @Override
    public String getName() {
        // Accessor method to return the user name
        return name;
    }

    @Override
    //Mutator method to set he user's name
    public void setName(String name) throws InvalidNameException{

        //If the name is valid
        if (checkName(name)){

            //set the instance variable name to the inputted name
            this.name = name;


        }
        else {
            //Else throw an CheckedUserDExceptions.InvalidNameException so that the program can decide what to do about the invalid inputted name
            throw new InvalidNameException("Invalid name inputted!\nThe user's name is one or two words and with no name prefixes\nThe user's name should have a capital at the start or each word\nOnly letters [a-z] are allowed");
        }

    }


    @Override
    public String getEmail() {
        // Accessor method to return the user email
        return email;
    }

    @Override
    //Mutator method to set he user's email
    public void setEmail(String email) {

        //set the instance variable email to the inputted email
        this.email = email;
    }



    @Override
    public int getAge() {
        // Accessor method to return the user age
        return age;
    }


    @Override
    //Mutator method to set he user's age
    public void setAge(int age) throws InvalidAgeException{
        //If the age is valid
        if (checkAge(age)){

            //set the instance variable age to the inputted age
            this.age = age;

        }
        else {
            //Else throw an CheckedUserDExceptions.InvalidAgeException so that the program can decide what to do about the invalid inputted age
            throw new InvalidAgeException("Invalid age inputted!\nUser's age must be between 18 and 30");
        }
    }

    @Override
    //toString function for CheckedUserD
    public String toString() {
        //stringOut will always have name set
        String stringOut = "CheckedUserD: " + name;

        //If age is not set to the default value of -1 then age has been set so concatenate the age
        if (age != -1){
            stringOut = stringOut + " (" + age + ")";
        }

        //email has been concatenated
        stringOut = stringOut + ", " + email;

        //Return the string to be outputted
        return stringOut;

    }
}

