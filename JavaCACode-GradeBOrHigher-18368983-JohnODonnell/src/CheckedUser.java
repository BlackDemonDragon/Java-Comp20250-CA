import CheckedUserExceptions.InvalidAgeException;
import CheckedUserExceptions.InvalidEmailException;
import CheckedUserExceptions.InvalidNameException;

public class CheckedUser implements User {

    //The array of strings storing the name prefixes
    private static final String[] namePrefix = {"Mr", "Mrs", "Ms", "Miss", "Dr", "Prof"};

    //The instance variables for the CheckedUser class
    private String name;
    private String email = null; //Has a default value of null
    private int age = -1;// Has a default value of -1


    //Constructor for CheckedUser taking only name as input
    public CheckedUser(String name) throws InvalidNameException{

        //If the name is valid
        if (checkName(name)){

            //set the instance variable name to the inputted name
            this.name = name;

        }
        else {
            //Else throw an CheckedUserExceptions.InvalidNameException so that the program can decide what to do about the invalid inputted name
            throw new InvalidNameException("Invalid name was inputted!\nNames one or two words and no name prefixes\nNames should have a capital at the start or each word\nOnly letters [a-z] are allowed");
        }

    }


    //Constructor for CheckedUser taking name and age as input
    public CheckedUser(String name, int age)throws InvalidNameException, InvalidAgeException {

        //If the name is valid
        if (checkName(name)){

            //set the instance variable name to the inputted name
            this.name = name;

        }
        else {
            //Else throw an CheckedUserExceptions.InvalidNameException so that the program can decide what to do about the invalid inputted name
            throw new InvalidNameException("Invalid name was inputted!\nThe user's name is one or two words and with no name prefixes\nThe user's name should have a capital at the start or each word\nOnly letters [a-z] are allowed");
        }

        //If the age is valid
        if (checkAge(age)){

            //set the instance variable age to the inputted age
            this.age = age;

        }
        else {
            //Else throw an CheckedUserExceptions.InvalidAgeException so that the program can decide what to do about the invalid inputted age
            throw new InvalidAgeException("Invalid age was inputted!\nUser's age must be between 18 and 30");
        }

    }


    //Constructor for CheckedUser taking name, age and email as input
    public CheckedUser(String name, int age, String email)throws InvalidNameException, InvalidAgeException, InvalidEmailException {

        //If the name is valid
        if (checkName(name)){

            //set the instance variable name to the inputted name
            this.name = name;

        }
        else {
            //Else throw an CheckedUserExceptions.InvalidNameException so that the program can decide what to do about the invalid inputted name
            throw new InvalidNameException("Invalid name inputted!\nThe user's name is one or two words and with no name prefixes\nThe user's name should have a capital at the start or each word\nOnly letters [a-z] are allowed");
        }

        //If the age is valid
        if (checkAge(age)){

            //set the instance variable age to the inputted age
            this.age = age;

        }
        else {
            //Else throw an CheckedUserExceptions.InvalidAgeException so that the program can decide what to do about the invalid inputted age
            throw new InvalidAgeException("Invalid age inputted!\nUser's age must be between 18 and 30");
        }

        ///Calling emailToLowerCase in order to change lower case the email
        email = emailToLowerCase(email);

        //If the email is valid
        if (checkEmail(email)){

            //set the instance variable email to the inputted email
            this.email = email;

        }
        else {
            //Else throw an CheckedUserExceptions.InvalidEmailException so that the program can decide what to do about the invalid inputted email
            throw new InvalidEmailException("Invalid email inputted!\nThe user's email should be all lower case\nthe email should be in the form: <name>(.<surname>)@<somewhere>.<something>");
        }

    }

    //Method to change email to lower case
    private String emailToLowerCase(String email){
        return email.trim().toLowerCase();
    }




    //Method to check that the inputted name for the user is valid
    private boolean checkName(String name){

        //If the name matches the regular expression that says that the string starts with a Capital letter
        //followed by 0 or more lower case letters. Then there can be 0 or 1 space followed by Capital letter (for Surname)
        //then there is 0 or more lower case letters then the end of the string
        if (name.matches("^[A-Z][a-z]*( [A-Z])?[a-z]*$")){

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


    //Method to check that the inputted email for the user is valid
    private boolean checkEmail(String email){
        //If the email is in the correct format and the email matches the name of the user then return true
        return (checkEmailFormat(email) && checkEmailName(email));
    }


    //Method to check that the inputted email has the valid email format
    private boolean checkEmailFormat(String email){
        //Regular expression to check email is in form: <name>(.<surname>)@<somewhere>.<something> in all lower case
        //The email has one or more letters then has 0 or 1 '.' followed by a letter then 0 or more letters
        //Next is an @ then one or more letters then a '.' and finally one or more letters
        return email.matches("^[a-z]+(\\.[a-z])?[a-z]*@[a-z]+\\.[a-z]+$");
    }


    //Method to check that the inputted email matches the name of the user
    private boolean checkEmailName(String email){
        // modifiedName is equal to name where if there is a space for the surname the space is replaced with a .
        // then the name string is made all lowercase and assigned to modifiedName
        String modifiedName = name.replaceAll(" ", ".").toLowerCase();

        //nameEmail stores the substring of email that contains everything before the @ symbol as this part corresponds to the name of the user
        String nameEmail = email.substring(0 , email.indexOf("@"));

        //If the substring nameEmail == to the modified name then return true
        return nameEmail.equals(modifiedName);
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

            //email is made null to avoid conflict in the name and email
            email = null;
        }
        else {
            //Else throw an CheckedUserExceptions.InvalidNameException so that the program can decide what to do about the invalid inputted name
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
    public void setEmail(String email) throws InvalidEmailException{

        //Calling emailToLowerCase in order to change lower case the email
        email = emailToLowerCase(email);

        //If the email is valid
        if (checkEmail(email)){

            //set the instance variable email to the inputted email
            this.email = email;

        }
        else {
            //Else throw an CheckedUserExceptions.InvalidEmailException so that the program can decide what to do about the invalid inputted email
            throw new InvalidEmailException("Invalid email inputted!\nThe user's email should be all lower case\nthe email should be in the form: <name>(.<surname>)@<somewhere>.<something>\n");
        }
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
            //Else throw an CheckedUserExceptions.InvalidAgeException so that the program can decide what to do about the invalid inputted age
            throw new InvalidAgeException("Invalid age inputted!\nUser's age must be between 18 and 30");
        }
    }

    @Override
    //toString function for CheckedUser
    public String toString() {
        //stringOut will always have name set
        String stringOut = "CheckedUser: " + name;

        //If age is not set to the default value of -1 then age has been set so concatenate the age
        if (age != -1){
            stringOut = stringOut + " (" + age + ")";
        }

        //If email is not null then email has been set so concatenate the email.
        if (email != null){
            stringOut = stringOut + ", " + email;
        }

        //Return the string to be outputted
        return stringOut;

    }
}

