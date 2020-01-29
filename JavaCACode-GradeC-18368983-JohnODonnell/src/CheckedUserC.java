import CheckedUserExceptions.InvalidAgeException;
import CheckedUserExceptions.InvalidNameException;

public class CheckedUserC implements User {

    //The array of strings storing the name prefixes
    private static final String[] namePrefix = {"Mr", "Mrs", "Ms", "Miss", "Dr", "Prof"};

    //The instance variables for the CheckedUserC class
    private String name;
    private String email = null; //Has a default value of null
    private int age = -1;// Has a default value of -1


    //Constructor for CheckedUserC taking only name as input
    public CheckedUserC(String name) throws InvalidNameException {

        //If the name is valid
        if (checkName(name)){

            //set the instance variable name to the inputted name
            this.name = name;

        }
        else {
            //Else throw an CheckedUserCExceptions.InvalidNameException so that the program can decide what to do about the invalid inputted name
            throw new InvalidNameException("Invalid name was inputted!\nNames one or two words and no name prefixes\nNames should have a capital at the start or each word\nOnly letters [a-z] are allowed");
        }

    }


    //Constructor for CheckedUserC taking name and age as input
    public CheckedUserC(String name, int age)throws InvalidNameException, InvalidAgeException {

        //If the name is valid
        if (checkName(name)){

            //set the instance variable name to the inputted name
            this.name = name;

        }
        else {
            //Else throw an CheckedUserCExceptions.InvalidNameException so that the program can decide what to do about the invalid inputted name
            throw new InvalidNameException("Invalid name was inputted!\nThe user's name is one or two words and with no name prefixes\nThe user's name should have a capital at the start or each word\nOnly letters [a-z] are allowed");
        }

        //If the age is valid
        if (checkAge(age)){

            //set the instance variable age to the inputted age
            this.age = age;

        }
        else {
            //Else throw an CheckedUserCExceptions.InvalidAgeException so that the program can decide what to do about the invalid inputted age
            throw new InvalidAgeException("Invalid age was inputted!\nUser's age must be between 18 and 30");
        }

    }


    //Constructor for CheckedUserC taking name, age and email as input
    public CheckedUserC(String name, int age, String email)throws InvalidNameException, InvalidAgeException {

        //If the name is valid
        if (checkName(name)){

            //set the instance variable name to the inputted name
            this.name = name;

        }
        else {
            //Else throw an CheckedUserCExceptions.InvalidNameException so that the program can decide what to do about the invalid inputted name
            throw new InvalidNameException("Invalid name inputted!\nThe user's name is one or two words and with no name prefixes\nThe user's name should have a capital at the start or each word\nOnly letters [a-z] are allowed");
        }

        //If the age is valid
        if (checkAge(age)){

            //set the instance variable age to the inputted age
            this.age = age;

        }
        else {
            //Else throw an CheckedUserCExceptions.InvalidAgeException so that the program can decide what to do about the invalid inputted age
            throw new InvalidAgeException("Invalid age inputted!\nUser's age must be between 18 and 30");
        }


        //set the instance variable email to the inputted email
        this.email = email;
    }


    //Method to check that the inputted name for the user is valid
    private boolean checkName(String name){

        //If the name matches the regular expression that says that the string
        //has 0 or more letters. Then there can be 0 or more white space chars
        //This may repeat for multiple words
        if (name.matches("([a-zA-z]*\\s*)+")){

            //For loop to check that name does have a prefix or is equal to a prefix
            //space after is because a name may contain the prefix as part of there name eg. Drake contains Dr.
            for (String prefix : namePrefix) {

                if (name.contains(prefix + " ") || (name.equals(prefix))) {
                    //Name is invalid cause has a prefix
                    return false;
                }

            }

            //Name is valid return true;
            return true;
        }
        else {
            //Name is not valid
            return false;
        }

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
    public void setName(String name) throws InvalidNameException {

        //If the name is valid
        if (checkName(name)){

            //set the instance variable name to the inputted name
            this.name = name;

        }
        else {
            //Else throw an CheckedUserCExceptions.InvalidNameException so that the program can decide what to do about the invalid inputted name
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
            //Else throw an CheckedUserCExceptions.InvalidAgeException so that the program can decide what to do about the invalid inputted age
            throw new InvalidAgeException("Invalid age inputted!\nUser's age must be between 18 and 30");
        }
    }

    @Override
    //toString function for CheckedUserC
    public String toString() {
        //stringOut will always have name set
        String stringOut = "CheckedUserC: " + name;

        //If age is not set to the default value of -1 then age has been set so concatenate the age
        if (age != -1){
            stringOut = stringOut + " (" + age + ")";

            //If email is not null then email has been set so concatenate the email.
            if (email != null){
                stringOut = stringOut + ", " + email;
            }
        }

        //Return the string to be outputted
        return stringOut;

    }
}

