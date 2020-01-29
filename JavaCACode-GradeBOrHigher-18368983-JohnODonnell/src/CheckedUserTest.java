import CheckedUserExceptions.InvalidAgeException;
import CheckedUserExceptions.InvalidEmailException;
import CheckedUserExceptions.InvalidNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class CheckedUserTest {

    //Default ideal value for CheckedUser class
    private String defaultName = "John Doe", defaultEmail = "john.doe@ucdconnect.ie";
    private int defaultAge = 20;
    
    //User and CheckedUser Variables
    private CheckedUser Cuser, tempCuser;
    private User user;

    //Method to get the stack trace of an exception as a string
    private String exceptionToString (Exception e){
        //Create a StringWriter and PrinterWriter for the stack trace to be printed to
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        //Print the stack trace to the StringWriter using PrintWriter
        e.printStackTrace(printWriter);

        //Return the stack trace as a string
        return stringWriter.toString();
    }

    @BeforeEach
    void setUp() {
        //Try statement to catch if the constructor throws an exception in creating the CheckedUser before the test(Should not throw exception as passed valid data)
        try {
            // Before each test set Cuser back to the default
            Cuser = new CheckedUser(defaultName, defaultAge, defaultEmail);
        } catch (Exception e){
            fail("Constructor failed to create the CheckedUser in setUp so test failed and was aborted\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }

        // The set user to a User of Cuser
        user = Cuser;
    }

    @Test
    @DisplayName("Test CheckedUser is an instance of User Interface (b)")
    void testCheckedUserInstanceOfUser() {

        //Checking that CheckedUser object is instance of User
        assertTrue(Cuser instanceof User, "CheckedUser does not implement User");

    }

    @DisplayName("Test getName Accessor Method in CheckedUser  (b)")
    @Test
    void testGetName() {
        //assertAll so that all assertions are run and reported together
        assertAll("Testing getName in CheckedUser",
                // Assertion to test that the getName method works on a CheckedUser object
                () -> assertEquals(Cuser.getName(), defaultName, "\nThe name returned from getName on CheckedUser object was not equal to the default name: " + defaultName + "\n"),
                // Assertion to test that the getName method works on a CheckedUser object using the User type
                () -> assertEquals(user.getName(), defaultName,  "\nThe name returned from getName on CheckedUser object using User interface was not equal to the default name: " + defaultName + "\n")
        );
    }


    @DisplayName("Test setName Mutator Method in CheckedUser  (b)")
    @Test
    void testSetName() {
        // Setting a String variable new temp that is being set over name in the CheckedUser object
        String newTemp = "David";

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser for the test (Should not throw exception as passed valid data)
        try {
            //Create tempCuser to be modified for the test (needs to have email blank inorder to test setName and set email)
            tempCuser = new CheckedUser("John Doe");
        } catch (InvalidNameException e) {
            fail("Constructor failed to create the CheckedUser so test failed and was aborted\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }


        //Setting user to tempCuser
        user = tempCuser;

        //Try statement to catch possible exceptions thrown by setName (Should not throw exception as passed valid data)
        try {
            // Using setName on CheckedUser object
            tempCuser.setName(newTemp);
        } catch (InvalidNameException e){
            fail("Test failed because setName throw an InvalidNameException because the inputted name:" + newTemp + " was an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }  catch (Exception e){
            fail("Test Failed because setName throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }


        //assertAll so that all assertions are run and reported together
        assertAll("Testing setName on CheckedUser",
                // Assertion to test that the getName method returns the new set name on a CheckedUser object
                () -> assertEquals(tempCuser.getName(), newTemp, "\nThe name returned from getName on CheckedUser object was not equal to the new name: " + newTemp + "\n When setName was used on CheckedUser object\n"),
                // Assertion to test that the getName method returns the new set name on a CheckedUser object using the User type
                () -> assertEquals(user.getName(), newTemp,  "\nThe name returned from getName on CheckedUser object using User interface was not equal to the new name: " + newTemp + "\n When setName was used on CheckedUser object\n")
        );


        // Setting a String variable new temp 2 that is being set over name in the CheckedUser object using the User type
        String newTemp2 = "Bob Smith";

        //Try statement to catch possible exceptions thrown by setName (Should not throw exception as passed valid data)
        try{
            // Using setName on CheckedUser object using the User type
            tempCuser.setName(newTemp2);
        } catch (InvalidNameException e){
            fail("Test failed because setName throw an InvalidNameException because the inputted name:" + newTemp2 + " was an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }  catch (Exception e){
            fail("Test Failed because setName throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }


        //assertAll so that all assertions are run and reported together
        assertAll("Testing setName on CheckedUser using the User type",
                // Assertion to test that the getName method returns the new set name on a CheckedUser object
                () -> assertEquals(tempCuser.getName(), newTemp2, "\nThe name returned from getName on CheckedUser object was not equal to the new name: " + newTemp2 + "\n When setName was used on CheckedUser object\n"),
                // Assertion to test that the getName method returns the new set name on a CheckedUser object using the User type
                () -> assertEquals(user.getName(), newTemp2,  "\nThe name returned from getName on CheckedUser object using User interface was not equal to the new name: " + newTemp2 + "\n When setName was used on CheckedUser object\n")
        );
    }

    @DisplayName("Test getEmail Accessor Method in CheckedUser (b)")
    @Test
    void testGetEmail() {
        //assertAll so that all assertions are run and reported together
        assertAll("Testing getEmail in CheckedUser",
                // Assertion to test that the getEmail method works on a CheckedUser object
                () -> assertEquals(Cuser.getEmail(), defaultEmail, "\nThe name returned from getEmail on CheckedUser object was not equal to the default email: " + defaultEmail + "\n"),
                // Assertion to test that the getEmail method works on a CheckedUser object using the User type
                () -> assertEquals(user.getEmail(), defaultEmail,  "\nThe name returned from getEmail on CheckedUser object using User interface was not equal to the default email: " + defaultEmail + "\n")
        );
    }

    @DisplayName("Test setEmail Mutator Method in CheckedUser (b)")
    @Test
    void testSetEmail() {
        // Setting a String variable new temp that is being set over email in the CheckedUser object
        String newTemp = "john.doe@ucdconnect.ie";

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser for the test (Should not throw exception as passed valid data)
        try {
            //Create tempCuser to be modified for the tests
            tempCuser = new CheckedUser("John Doe");
        } catch (InvalidNameException e) {
            fail("Constructor failed to create the CheckedUser so test failed and was aborted\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }


        //Setting user to tempCuser
        user = tempCuser;

        //Try statement to catch possible exceptions thrown by setEmail (Should not throw exception as passed valid data)
        try {
            // Using setEmail on CheckedUser object
            tempCuser.setEmail(newTemp);
        } catch (InvalidEmailException e){
            fail("Test Failed because setEmail throw an InvalidEmailException because the email was invalid\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because setEmail throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }



        //assertAll so that all assertions are run and reported together
        assertAll("Testing setEmail on CheckedUser",
                // Assertion to test that the getEmail method returns the new set email on a CheckedUser object
                () -> assertEquals(tempCuser.getEmail(), newTemp, "\nThe email returned from getEmail on CheckedUser object was not equal to the new email: " + newTemp + "\n When setEmail was used on CheckedUser object\n"),
                // Assertion to test that the getEmail method returns the new set email on a CheckedUser object using the User type
                () -> assertEquals(user.getEmail(), newTemp,  "\nThe email returned from getEmail on CheckedUser object using User interface was not equal to the new email: " + newTemp + "\n When setEmail was used on CheckedUser object\n")
        );


        // Setting a String variable new temp 2 that is being set over email in the CheckedUser object using the User type
        String newTemp2 = "john@ucdconnect.ie";

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser for the test (Should not throw exception as passed valid data)
        try {
            //Create tempCuser to be modified for the tests
            tempCuser = new CheckedUser("John");
        } catch (InvalidNameException e) {
            fail("Constructor failed to create the CheckedUser so test failed and was aborted\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }


        //Try statement to catch possible exceptions thrown by setEmail (Should not throw exception as passed valid data)
        try {
            // Using setEmail on CheckedUser object using the User type
            tempCuser.setEmail(newTemp2);
        } catch (InvalidEmailException e){
            fail("Test Failed because setEmail throw an InvalidEmailException because the email was invalid\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because setEmail throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }

        //Setting user to tempCuser
        user = tempCuser;

        //assertAll so that all assertions are run and reported together
        assertAll("Testing setEmail on CheckedUser using the User type",
                // Assertion to test that the getEmail method returns the new set email on a CheckedUser object
                () -> assertEquals(tempCuser.getEmail(), newTemp2, "\nThe email returned from getEmail on CheckedUser object was not equal to the new email: " + newTemp2 + "\n When setEmail was used on CheckedUser object\n"),
                // Assertion to test that the getEmail method returns the new set email on a CheckedUser object using the User type
                () -> assertEquals(user.getEmail(), newTemp2,  "\nThe email returned from getEmail on CheckedUser object using User interface was not equal to the new email: " + newTemp2 + "\n When setEmail was used on CheckedUser object\n")
        );
    }

    @DisplayName("Test getAge Accessor Method in CheckedUser (b)")
    @Test
    void testGetAge() {
        //assertAll so that all assertions are run and reported together
        assertAll("Testing getAge in CheckedUser",
                // Assertion to test that the getAge method works on a CheckedUser object
                () -> assertEquals(Cuser.getAge(), defaultAge, "\nThe age returned from getAge on CheckedUser object was not equal to the default age: " + defaultAge + "\n"),
                // Assertion to test that the getAge method works on a CheckedUser object using the User type
                () -> assertEquals(user.getAge(), defaultAge,  "\nThe age returned from getAge on CheckedUser object using User interface was not equal to the default age: " + defaultAge + "\n")
        );
    }

    @DisplayName("Test setAge Mutator Method in CheckedUser (b)")
    @Test
    void testSetAge() {
        // Setting a String variable new temp that is being set over age in the CheckedUser object
        int newTemp = 22;

        //Try statement to catch possible exceptions thrown by setAge (Should not throw exception as passed valid data)
        try {
            // Using setAge on CheckedUser object
            Cuser.setAge(newTemp);
        } catch (InvalidAgeException e){
            fail("Test Failed because setAge throw an InvalidAgeException because the age was invalid\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because setAge throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }

        //assertAll so that all assertions are run and reported together
        assertAll("Testing setAge on CheckedUser",
                // Assertion to test that the getAge method returns the new set age on a CheckedUser object
                () -> assertEquals(Cuser.getAge(), newTemp, "\nThe age returned from getAge on CheckedUser object was not equal to the new age: " + newTemp + "\n When setAge was used on CheckedUser object\n"),
                // Assertion to test that the getAge method returns the new set age on a CheckedUser object using the User type
                () -> assertEquals(user.getAge(), newTemp,  "\nThe age returned from getAge on CheckedUser object using User interface was not equal to the new age: " + newTemp + "\n When setAge was used on CheckedUser object\n")
        );


        // Setting a String variable new temp 2 that is being set over name in the CheckedUser object using the User type
        int newTemp2 = 21;

        //Try statement to catch possible exceptions thrown by setAge (Should not throw exception as passed valid data)
        try {
            // Using setName on CheckedUser object using the User type
            Cuser.setAge(newTemp2);
        } catch (InvalidAgeException e){
            fail("Test Failed because setAge throw an InvalidAgeException because the age was invalid\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because setAge throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }


        //assertAll so that all assertions are run and reported together
        assertAll("Testing setAge on CheckedUser using the User type",
                // Assertion to test that the getAge method returns the new set age on a CheckedUser object
                () -> assertEquals(Cuser.getAge(), newTemp2, "\nThe age returned from getAge on CheckedUser object was not equal to the new age: " + newTemp2 + "\n When setAge was used on CheckedUser object\n"),
                // Assertion to test that the getAge method returns the new set age on a CheckedUser object using the User type
                () -> assertEquals(user.getAge(), newTemp2,  "\nThe age returned from getAge on CheckedUser object using User interface was not equal to the new age: " + newTemp2 + "\n When setAge was used on CheckedUser object\n")
        );
    }

    @Test
    @DisplayName("Test Overloaded Constructor with just User's Name (b)")
    void testConstructorName(){
        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the just name constructor
            CheckedUser constructorTest = new CheckedUser(defaultName);

            // Assertion to test that the getName method returns the name set in the constructor
            assertEquals(constructorTest.getName(), defaultName, "\nThe name returned from getName on constructorTest was not equal to the name: " + defaultName + " set in the constructor\n");


        } catch (InvalidNameException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

    @Test
    @DisplayName("Test Overloaded Constructor with User's Name and Age (b)")
    void testConstructorNameAge(){
        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the name and age constructor
            CheckedUser constructorTest = new CheckedUser(defaultName, defaultAge);

            //assertAll so that all assertions are run and reported together
            assertAll("Testing Overloaded Constructor with User's Name and Age",
                    // Assertion to test that the getName method returns the name set in the constructor
                    () -> assertEquals(constructorTest.getName(), defaultName, "\nThe name returned from getName on constructorTest was not equal to the name: " + defaultName + " set in the constructor\n"),
                    // Assertion to test that the getAge method returns the age set in the constructor
                    () -> assertEquals(constructorTest.getAge(), defaultAge, "\nThe age returned from getAge on constructorTest was not equal to the age: " + defaultAge + " set in the constructor\n")
            );

        } catch (InvalidNameException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }catch (InvalidAgeException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid age\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

    @Test
    @DisplayName("Test Overloaded Constructor with User's Name, Age and Email (b)")
    void testConstructorNameAgeEmail(){
        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the name, age and email constructor
            CheckedUser constructorTest = new CheckedUser(defaultName, defaultAge, defaultEmail);

            //assertAll so that all assertions are run and reported together
            assertAll("Testing Overloaded Constructor with User's Name, Age and Email",
                    // Assertion to test that the getName method returns the name set in the constructor
                    () -> assertEquals(constructorTest.getName(), defaultName, "\nThe name returned from getName on constructorTest was not equal to the name: " + defaultName + " set in the constructor\n"),
                    // Assertion to test that the getAge method returns the age set in the constructor
                    () -> assertEquals(constructorTest.getAge(), defaultAge, "\nThe age returned from getAge on constructorTest was not equal to the age: " + defaultAge + " set in the constructor\n"),
                    // Assertion to test that the getEmail method returns the email set in the constructor
                    () -> assertEquals(constructorTest.getEmail(), defaultEmail, "\nThe email returned from getEmail on constructorTest was not equal to the email: " + defaultEmail + " set in the constructor\n")
            );

        } catch (InvalidNameException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }catch (InvalidAgeException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid age\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }catch (InvalidEmailException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid email\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

    @Test
    @DisplayName("Test Name Validation for One Word Name in Constructors (c)")
    void testNameOneWordConstructors(){
        // Setting a String variable oneWordName that is being set in the CheckedUser
        String oneWordName = "David";

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the just name constructor with a one word name
            CheckedUser constructorTest = new CheckedUser(oneWordName);

            // Assertion to test that the getName method returns the one word name set in the constructor
            assertEquals(constructorTest.getName(), oneWordName, "\nThe name returned from getName on constructorTest was not equal to the one word name: " + oneWordName + " set in the name constructor\n");

        } catch (InvalidNameException e) {
            fail("Test Failed because checkName Method found the one word name to be invalid in name constructor\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }


        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the name and age constructor with a one word name
            CheckedUser constructorTest = new CheckedUser(oneWordName, defaultAge);

            // Assertion to test that the getName method returns the one word name set in the constructor
            assertEquals(constructorTest.getName(), oneWordName, "\nThe name returned from getName on constructorTest was not equal to the one word name: " + oneWordName + " set in the name and age constructor\n");

        } catch (InvalidNameException e) {
            fail("Test Failed because checkName Method found the one word name to be invalid in name and age constructor\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (InvalidAgeException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid age\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the name age and email constructor with a one word name
            CheckedUser constructorTest = new CheckedUser(oneWordName, defaultAge, "david@ucd.ie");

            // Assertion to test that the getName method returns the one word name set in the constructor
            assertEquals(constructorTest.getName(), oneWordName, "\nThe name returned from getName on constructorTest was not equal to the one word name: " + oneWordName + " set in the name age email constructor\n");

        } catch (InvalidNameException e) {
            fail("Test Failed because checkName Method found the one word name to be invalid in name, age and email constructor\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (InvalidAgeException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid age\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (InvalidEmailException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid email\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }


    @Test
    @DisplayName("Test Name Validation for One Word Name in setName (c)")
    void testNameOneWordSetName(){
        // Setting a String variable oneWordName that is being set over name in the CheckedUser object
        String oneWordName = "David";

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the just name constructor
            CheckedUser constructorTest = new CheckedUser(defaultName);

            try {
                //Using setName to set the one word name
                constructorTest.setName(oneWordName);

                // Assertion to test that the getName method returns the one word name set using setName
                assertEquals(constructorTest.getName(), oneWordName, "\nThe name returned from getName on constructorTest was not equal to the one word name: " + oneWordName + " set using setName\n");

            }catch (InvalidNameException e){
                fail("Test Failed because checkName Method found the one word name to be invalid in setName Method\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
            }catch (Exception e){
                fail("Test Failed because setName throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
            }

        } catch (InvalidNameException e) {
            fail("Test Failed because constructor throw an InvalidNameException because of an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }

    }

    @Test
    @DisplayName("Test Name Validation for Two Word Name in Constructors (c)")
    void testNameTwoWordConstructors(){
        // Setting a String variable twoWordName that is being set in the CheckedUser
        String twoWordName = "David Smith";

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the just name constructor with a two word name
            CheckedUser constructorTest = new CheckedUser(twoWordName);

            // Assertion to test that the getName method returns the two word name set in the constructor
            assertEquals(constructorTest.getName(), twoWordName, "\nThe name returned from getName on constructorTest was not equal to the two word name: " + twoWordName + " set in the name constructor\n");

        } catch (InvalidNameException e) {
            fail("Test Failed because checkName Method found the two word name to be invalid in name constructor\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }


        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the name and age constructor with a two word name
            CheckedUser constructorTest = new CheckedUser(twoWordName, defaultAge);

            // Assertion to test that the getName method returns the one word name set in the constructor
            assertEquals(constructorTest.getName(), twoWordName, "\nThe name returned from getName on constructorTest was not equal to the two word name: " + twoWordName + " set in the name and age constructor\n");

        } catch (InvalidNameException e) {
            fail("Test Failed because checkName Method found the two word name to be invalid in name and age constructor\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (InvalidAgeException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid age\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the name age and email constructor with a two word name
            CheckedUser constructorTest = new CheckedUser(twoWordName, defaultAge, "david.smith@ucd.ie");

            // Assertion to test that the getName method returns the two word name set in the constructor
            assertEquals(constructorTest.getName(), twoWordName, "\nThe name returned from getName on constructorTest was not equal to the two word name: " + twoWordName + " set in the name age email constructor\n");

        } catch (InvalidNameException e) {
            fail("Test Failed because checkName Method found the two word name to be invalid in name, age and email constructor\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (InvalidAgeException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid age\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (InvalidEmailException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid email\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }

    }

    @Test
    @DisplayName("Test Name Validation for Two Word Name in setName (c)")
    void testNameTwoWordSetName(){
        // Setting a String variable twoWordName that is being set over name in the CheckedUser object
        String twoWordName = "David Smith";

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the just name constructor
            CheckedUser constructorTest = new CheckedUser(defaultName);

            try {
                //Using setName to set the two word name
                constructorTest.setName(twoWordName);

                // Assertion to test that the getName method returns the two word name set using setName
                assertEquals(constructorTest.getName(), twoWordName, "\nThe name returned from getName on constructorTest was not equal to the two word name: " + twoWordName + " set using setName\n");

            }catch (InvalidNameException e){
                fail("Test Failed because checkName Method found the two word name to be invalid in setName Method\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
            }catch (Exception e){
                fail("Test Failed because setName throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
            }

        } catch (InvalidNameException e) {
            fail("Test Failed because constructor throw an InvalidNameException because of an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }

    }

    @Test
    @DisplayName("Test Name Validation for Two Plus Word Name in Constructors (c)")
    void testNameTwoPlusWordConstructors(){
        // Setting a String variable twoPlusWordName that is being set in the CheckedUser
        String twoPlusWordName = "David Smith Bob";


        //assertAll so that all assertions are run and reported together
        assertAll("Testing Name Validation for Two Plus Word Name in Constructors",
                //Assertion that says that the just name constructor should throw an InvalidNameException when inputted with a name with two plus words
                () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(twoPlusWordName), "The name constructor didn't throw InvalidNameException when a name with two plus words was inputted" ),

                //Assertion that says that the name and age constructor should throw an InvalidNameException when inputted with a name with two plus words
                () ->assertThrows(InvalidNameException.class, () -> new CheckedUser(twoPlusWordName, defaultAge), "The name and age constructor didn't throw InvalidNameException when a name with two plus words was inputted" ),

                //Assertion that says that the just name, age and email constructor should throw an InvalidNameException when inputted with a name with two plus words
                () ->assertThrows(InvalidNameException.class, () -> new CheckedUser(twoPlusWordName, defaultAge, "david.smith.bob"), "The name, age and email constructor didn't throw InvalidNameException when a name with two plus words was inputted" )
        );

    }

    @Test
    @DisplayName("Test Name Validation for Two Plus Words Name in setName (c)")
    void testNameTwoPlusWordSetName(){
        // Setting a String variable twoPlusWordName that is being set over name in the CheckedUser object
        String twoPlusWordName = "David Smith Bob";

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the just name constructor
            CheckedUser constructorTest = new CheckedUser(defaultName);

            //Assertion that if a setName is pass a name with more than two words it will throw an InvalidNameException
            assertThrows(InvalidNameException.class,() -> constructorTest.setName(twoPlusWordName), "The setName didn't throw InvalidNameException when a name with two plus words was inputted");

        } catch (InvalidNameException e) {
            fail("Test Failed because constructor throw an InvalidNameException because of an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

    @Test
    @DisplayName("Test Name Can Not Have Prefixes (c)")
    void testNamePrefix(){
        //Strings of all test names
        String nameDrPrefix = "Dr Joe", nameDr = "Dr", nameMrPrefix = "Mr Bob", nameMr = "Mr", nameMrsPrefix = "Mrs Jane", nameMrs = "Mrs", nameMsPrefix = "Ms Smith", nameMs = "Ms", nameMissPrefix = "Miss Lane", nameMiss = "Miss", nameProfPrefix = "Prof Simon", nameProf = "Prof";

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //CheckedUsers for testing all prefixes
            CheckedUser defaultCuserDrPrefixTest = new CheckedUser(defaultName), defaultCuserDrTest = new CheckedUser(defaultName), defaultCuserMrPrefixTest = new CheckedUser(defaultName), defaultCuserMrTest = new CheckedUser(defaultName), defaultCuserMrsPrefixTest = new CheckedUser(defaultName), defaultCuserMrsTest = new CheckedUser(defaultName), defaultCuserMsPrefixTest = new CheckedUser(defaultName), defaultCuserMsTest = new CheckedUser(defaultName), defaultCuserMissPrefixTest = new CheckedUser(defaultName), defaultCuserMissTest = new CheckedUser(defaultName), defaultCuserProfPrefixTest = new CheckedUser(defaultName), defaultCuserProfTest = new CheckedUser(defaultName);

            //assertAll so that all assertions are run and reported together
            assertAll("Testing Name Can Not Have Prefixes or Name Can Not Be a Prefix",
                    () -> assertAll("Testing Dr Prefix",
                            //Assertion that if name constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameDrPrefix), "The name constructor didn't throw InvalidNameException when inputted with a name with the Dr prefix\nTest name: " + nameDrPrefix),
                            //Assertion that if name and age constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameDrPrefix, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with the Dr prefix\nTest name: " + nameDrPrefix),
                            //Assertion that if name, age and email constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameDrPrefix, defaultAge, "dr.joe@ucd.ie"), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with the Dr prefix\nTest name: " + nameDrPrefix),
                            //Assertion that if name constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameDr), "The name constructor didn't throw InvalidNameException when inputted with a name with the Dr prefix as name\nTest name: " + nameDr),
                            //Assertion that if name and age constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameDr, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with the Dr prefix as name\nTest name: " + nameDr),
                            //Assertion that if name, age and email constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameDr, defaultAge, "dr@ucd.ie"), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with the Dr prefix as name\nTest name: " + nameDr),
                            //Assertion that if setNAme is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> defaultCuserDrPrefixTest.setName(nameDrPrefix), "The setName didn't throw InvalidNameException when inputted with a name with the Dr prefix\nTest name: " + nameDrPrefix),
                            //Assertion that if setName is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> defaultCuserDrTest.setName(nameDr), "The setName didn't throw InvalidNameException when inputted with a name with the Dr prefix as name\nTest name: " + nameDr)
                    ),
                    () -> assertAll("Testing Mr Prefix",
                            //Assertion that if name constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMrPrefix), "The name constructor didn't throw InvalidNameException when inputted with a name with the Mr prefix\nTest name: " + nameMrPrefix),
                            //Assertion that if name and age constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMrPrefix, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with the Mr prefix\nTest name: " + nameMrPrefix),
                            //Assertion that if name, age and email constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMrPrefix, defaultAge, "mr.bob@ucd.ie"), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with the Mr prefix\nTest name: " + nameMrPrefix),
                            //Assertion that if name constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMr), "The name constructor didn't throw InvalidNameException when inputted with a name with the Mr prefix as name\nTest name: " + nameMr),
                            //Assertion that if name and age constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMr, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with the Mr prefix as name\nTest name: " + nameMr),
                            //Assertion that if name, age and email constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMr, defaultAge, "mr@ucd.ie"), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with the Mr prefix as name\nTest name: " + nameMr),
                            //Assertion that if setNAme is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> defaultCuserMrPrefixTest.setName(nameMrPrefix), "The setName didn't throw InvalidNameException when inputted with a name with the Mr prefix\nTest name: " + nameMrPrefix),
                            //Assertion that if setName is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> defaultCuserMrTest.setName(nameMr), "The setName didn't throw InvalidNameException when inputted with a name with the Mr prefix as name\nTest name: " + nameMr)
                    ),
                    () -> assertAll("Testing Mrs Prefix",
                            //Assertion that if name constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMrsPrefix), "The name constructor didn't throw InvalidNameException when inputted with a name with the Mrs prefix\nTest name: " + nameMrsPrefix),
                            //Assertion that if name and age constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMrsPrefix, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with the Mrs prefix\nTest name: " + nameMrsPrefix),
                            //Assertion that if name, age and email constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMrsPrefix, defaultAge, "mrs.jane@ucd.ie"), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with the Mrs prefix\nTest name: " + nameMrsPrefix),
                            //Assertion that if name constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMrs), "The name constructor didn't throw InvalidNameException when inputted with a name with the Mrs prefix as name\nTest name: " + nameMrs),
                            //Assertion that if name and age constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMrs, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with the Mrs prefix as name\nTest name: " + nameMrs),
                            //Assertion that if name, age and email constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMrs, defaultAge, "mrs@ucd.ie"), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with the Mrs prefix as name\nTest name: " + nameMrs),
                            //Assertion that if setNAme is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> defaultCuserMrsPrefixTest.setName(nameMrsPrefix), "The setName didn't throw InvalidNameException when inputted with a name with the Mrs prefix\nTest name: " + nameMrsPrefix),
                            //Assertion that if setName is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> defaultCuserMrsTest.setName(nameMrs), "The setName didn't throw InvalidNameException when inputted with a name with the Mrs prefix as name\nTest name: " + nameMrs)
                    ),
                    () -> assertAll("Testing Ms Prefix",
                            //Assertion that if name constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMsPrefix), "The name constructor didn't throw InvalidNameException when inputted with a name with the Ms prefix\nTest name: " + nameMsPrefix),
                            //Assertion that if name and age constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMsPrefix, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with the Ms prefix\nTest name: " + nameMsPrefix),
                            //Assertion that if name, age and email constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMsPrefix, defaultAge, "ms.smith@ucd.ie"), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with the Ms prefix\nTest name: " + nameMsPrefix),
                            //Assertion that if name constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMs), "The name constructor didn't throw InvalidNameException when inputted with a name with the Ms prefix as name\nTest name: " + nameMs),
                            //Assertion that if name and age constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMs, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with the Ms prefix as name\nTest name: " + nameMs),
                            //Assertion that if name, age and email constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMs, defaultAge, "ms@ucd.ie"), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with the Ms prefix as name\nTest name: " + nameMs),
                            //Assertion that if setNAme is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> defaultCuserMsPrefixTest.setName(nameMsPrefix), "The setName didn't throw InvalidNameException when inputted with a name with the Ms prefix\nTest name: " + nameMsPrefix),
                            //Assertion that if setName is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> defaultCuserMsTest.setName(nameMs), "The setName didn't throw InvalidNameException when inputted with a name with the Ms prefix as name\nTest name: " + nameMs)
                    ),
                    () -> assertAll("Testing Miss Prefix",
                            //Assertion that if name constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMissPrefix), "The name constructor didn't throw InvalidNameException when inputted with a name with the Miss prefix\nTest name: " + nameMissPrefix),
                            //Assertion that if name and age constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMissPrefix, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with the Miss prefix\nTest name: " + nameMissPrefix),
                            //Assertion that if name, age and email constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMissPrefix, defaultAge, "miss.lane@ucd.ie"), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with the Miss prefix\nTest name: " + nameMissPrefix),
                            //Assertion that if name constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMiss), "The name constructor didn't throw InvalidNameException when inputted with a name with the Miss prefix as name\nTest name: " + nameMiss),
                            //Assertion that if name and age constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMiss, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with the Miss prefix as name\nTest name: " + nameMiss),
                            //Assertion that if name, age and email constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameMiss, defaultAge, "miss@ucd.ie"), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with the Miss prefix as name\nTest name: " + nameMiss),
                            //Assertion that if setNAme is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> defaultCuserMissPrefixTest.setName(nameMissPrefix), "The setName didn't throw InvalidNameException when inputted with a name with the Miss prefix\nTest name: " + nameMissPrefix),
                            //Assertion that if setName is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> defaultCuserMissTest.setName(nameMiss), "The setName didn't throw InvalidNameException when inputted with a name with the Miss prefix as name\nTest name: " + nameMiss)
                    ),
                    () -> assertAll("Testing Prof Prefix",
                            //Assertion that if name constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameProfPrefix), "The name constructor didn't throw InvalidNameException when inputted with a name with the Prof prefix\nTest name: " + nameProfPrefix),
                            //Assertion that if name and age constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameProfPrefix, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with the Prof prefix\nTest name: " + nameProfPrefix),
                            //Assertion that if name, age and email constructor is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameProfPrefix, defaultAge, "prof.simon@ucd.ie"), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with the Prof prefix\nTest name: " + nameProfPrefix),
                            //Assertion that if name constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameProf), "The name constructor didn't throw InvalidNameException when inputted with a name with the Prof prefix as name\nTest name: " + nameProf),
                            //Assertion that if name and age constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameProf, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with the Prof prefix as name\nTest name: " + nameProf),
                            //Assertion that if name, age and email constructor is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameProf, defaultAge, "prof@ucd.ie"), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with the Prof prefix as name\nTest name: " + nameProf),
                            //Assertion that if setNAme is inputted a name with a prefix it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> defaultCuserProfPrefixTest.setName(nameProfPrefix), "The setName didn't throw InvalidNameException when inputted with a name with the Prof prefix\nTest name: " + nameProfPrefix),
                            //Assertion that if setName is inputted a prefix as name  it should throw InvalidNameException
                            () -> assertThrows(InvalidNameException.class, () -> defaultCuserProfTest.setName(nameProf), "The setName didn't throw InvalidNameException when inputted with a name with the Prof prefix as name\nTest name: " + nameProf)
                    )
            );
        } catch (InvalidNameException e) {
            fail("Test Failed because constructor throw an InvalidNameException because of an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

    @Test
    @DisplayName("Test Name can not Contain Digits  (c)")
    void testNameNoDigits(){
        //name and CheckedUser for testing digits in name
        String nameNumber = "J0hn";
        CheckedUser CuserDigit;

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            CuserDigit = new CheckedUser(defaultName);

            //assertAll so that all assertions are run and reported together
            assertAll("Testing Name can not Contain Digits",
                    //Assertion that if name constructor is inputted a name with a digit it should throw InvalidNameException
                    () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameNumber), "The name constructor didn't throw InvalidNameException when inputted with a name with a digit\nTest name: " + nameNumber),
                    //Assertion that if name constructor is inputted a name with a digit it should throw InvalidNameException
                    () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameNumber, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with a digit\nTest name: " + nameNumber),
                    //Assertion that if name constructor is inputted a name with a digit it should throw InvalidNameException
                    () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameNumber, defaultAge, "j0hn@ucd.ie"), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with a digit\nTest name: " + nameNumber),
                    //Assertion that if setName is inputted a name with a digit it should throw InvalidNameException
                    () -> assertThrows(InvalidNameException.class, () -> CuserDigit.setName(nameNumber), "The setName didn't throw InvalidNameException when inputted with a name with a digit\nTest name: " + nameNumber)
            );

        } catch (InvalidNameException e) {
            fail("Test Failed because constructor throw an InvalidNameException because of an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

    @Test
    @DisplayName("Test Name can not Contain Symbols (c)")
    void testNameNoSymbols(){
        //name and CheckedUser for testing symbols in name
        String nameSymbol = "John!";
        CheckedUser CuserSymbol;

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            CuserSymbol = new CheckedUser(defaultName);

            //assertAll so that all assertions are run and reported together
            assertAll("Testing Name can not Contain Symbols",
                    //Assertion that if name constructor is inputted a name with a symbol it should throw InvalidNameException
                    () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameSymbol), "The name constructor didn't throw InvalidNameException when inputted with a name with a symbol\nTest name: " + nameSymbol),
                    //Assertion that if name constructor is inputted a name with a symbol it should throw InvalidNameException
                    () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameSymbol, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with a symbol\nTest name: " + nameSymbol),
                    //Assertion that if name constructor is inputted a name with a symbol it should throw InvalidNameException
                    () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameSymbol, defaultAge, "john!@ucd.ie"), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with a symbol\nTest name: " + nameSymbol),
                    //Assertion that if setName is inputted a name with a symbol it should throw InvalidNameException
                    () -> assertThrows(InvalidNameException.class, () -> CuserSymbol.setName(nameSymbol), "The setName didn't throw InvalidNameException when inputted with a name with a symbol\nTest name: " + nameSymbol)
            );

        } catch (InvalidNameException e) {
            fail("Test Failed because constructor throw an InvalidNameException because of an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

    @Test
    @DisplayName("Test Name(s) start with a Capital Letter (c)")
    void testStartNameCap(){
        //name a for testing no Capital Letters in name
        String nameTest = "john doe";

            //assertAll so that all assertions are run and reported together
            assertAll("Testing Name(s) start with a Capital Letter ",
                    //Assertion that if name constructor is inputted a name with no capitals it should throw InvalidNameException
                    () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameTest), "The name constructor didn't throw InvalidNameException when inputted with a name with no capitals\nTest name: " + nameTest),
                    //Assertion that if name and age constructor is inputted a name with no capitals it should throw InvalidNameException
                    () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameTest, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with no capitals\nTest name: " + nameTest),
                    //Assertion that if name, age and email constructor is inputted a name with no capitals it should throw InvalidNameException
                    () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameTest, defaultAge, defaultEmail), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with no capitals\nTest name: " + nameTest),
                    //Assertion that if setName is inputted a name with no capitals it should throw InvalidNameException
                    () -> assertThrows(InvalidNameException.class, () -> Cuser.setName(nameTest), "The setName didn't throw InvalidNameException when inputted with a name with no capitals\nTest name: " + nameTest)
            );
    }

    @Test
    @DisplayName("Test Name can not have Extra White Space Characters (c)")
    void testNameWhiteSpace(){
        //name  for testing extra whit space in name
        String nameTest = "John  Doe";

        //assertAll so that all assertions are run and reported together
        assertAll("Testing Name can not have Extra White Space Characters",
                //Assertion that if name constructor is inputted a name with extra white space it should throw InvalidNameException
                () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameTest), "The name constructor didn't throw InvalidNameException when inputted with a name with extra white space\nTest name: " + nameTest),
                //Assertion that if name and age constructor is inputted a name with extra white space should throw InvalidNameException
                () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameTest, defaultAge), "The name and age constructor didn't throw InvalidNameException when inputted with a name with extra white space\nTest name: " + nameTest),
                //Assertion that if name, age and email constructor is inputted a name with extra white space it should throw InvalidNameException
                () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(nameTest, defaultAge, defaultEmail), "The name, age and email constructor didn't throw InvalidNameException when inputted with a name with extra white space\nTest name: " + nameTest),
                //Assertion that if setNAme is inputted a name with extra white space it should throw InvalidNameException
                () -> assertThrows(InvalidNameException.class, () -> Cuser.setName(nameTest), "The setName didn't throw InvalidNameException when inputted with a name with extra white space\nTest name: " + nameTest)
        );
    }

    @Test
    @DisplayName("Test if Email is set and setName is called, Email is set to null (c)")
    void testSetNameEmailNull(){
        // Setting a String variable nameTest that is being set over name in the CheckedUser object
        String nameTest = "David";

        //Set name to name test on a CheckedUSer with a set Email
        Cuser.setName(nameTest);

        //Assertion to check the email was set to null after setName was called
        assertNull(Cuser.getEmail(), "The email was not set to null after setName");
    }

    @Test
    @DisplayName("Test Age can not be Less Than 18 (c)")
    void testAgeLessThan18(){
        //Age for testing age can be less than 18
        int ageTest = 17;

        //assertAll so that all assertions are run and reported together
        assertAll("Testing Age can not be Less Than 18",
                //Assertion that if name and age constructor is inputted an age less than 18 it should throw InvalidAgeException
                () -> assertThrows(InvalidAgeException.class, () -> new CheckedUser(defaultName, ageTest), "The name and age constructor didn't throw InvalidAgeException when inputted with an age less than 18 \nTest age: " + ageTest),
                //Assertion that if name, age and email constructor is inputted an age less than 18  it should throw InvalidAgeException
                () -> assertThrows(InvalidAgeException.class, () -> new CheckedUser(defaultName, ageTest, defaultEmail), "The name, age and email constructor didn't throw InvalidAgeException when inputted with an age less than 18 \nTest age: " + ageTest),
                //Assertion that if setAge is inputted an age less than 18  it should throw InvalidAgeException
                () -> assertThrows(InvalidAgeException.class, () -> Cuser.setAge(ageTest), "The setName didn't throw InvalidAgeException when inputted with an age less than 18 \nTest age: " + ageTest)
        );
    }

    @Test
    @DisplayName("Test Age can not be Greater Than 30 (c)")
    void testAgeGreaterThan30(){
        //Age for testing age can be greater than 30
        int ageTest = 31;

        //assertAll so that all assertions are run and reported together
        assertAll("Testing Age can not be Greater Than 30",
                //Assertion that if name and age constructor is inputted an age greater than 30 it should throw InvalidAgeException
                () -> assertThrows(InvalidAgeException.class, () -> new CheckedUser(defaultName, ageTest), "The name and age constructor didn't throw InvalidAgeException when inputted with an age greater than 30 \nTest age: " + ageTest),
                //Assertion that if name, age and email constructor is inputted an age greater than 30  it should throw InvalidAgeException
                () -> assertThrows(InvalidAgeException.class, () -> new CheckedUser(defaultName, ageTest, defaultEmail), "The name, age and email constructor didn't throw InvalidAgeException when inputted with an age greater than 30 \nTest age: " + ageTest),
                //Assertion that if setAge is inputted an age greater than 30  it should throw InvalidAgeException
                () -> assertThrows(InvalidAgeException.class, () -> Cuser.setAge(ageTest), "The setName didn't throw InvalidAgeException when inputted with an age greater than 30 \nTest age: " + ageTest)
        );
    }

    @Test
    @DisplayName("Test Email when Name is One Word (c)")
    void testEmailOneWordName(){
        //Name and Email for testing email when name is one word
        String nameTest = "David", emailTest = "david@ucd.ie";

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the name age and email constructor with a one word name
            CheckedUser constructorTest = new CheckedUser(nameTest, defaultAge, emailTest);

            // Assertion to test that the getEmail method returns the one word email set in the constructor
            assertEquals(constructorTest.getEmail(), emailTest, "\nThe email returned from getEmail on constructorTest was not equal to the one word email: " + emailTest + " set in the name, age and email constructor\n");

        } catch (InvalidNameException e) {
            fail("Test Failed because checkName Method found the one word name to be invalid in name, age and email constructor\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (InvalidAgeException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid age\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (InvalidEmailException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid email\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the just name constructor
            CheckedUser constructorTest = new CheckedUser(nameTest);

            try {
                //Using setEmail to set the one word email
                constructorTest.setEmail(emailTest);

                // Assertion to test that the getEmail method returns the one word email set using setEmail
                assertEquals(constructorTest.getEmail(), emailTest, "\nThe email returned from getEmail on constructorTest was not equal to the one word email: " + emailTest + " set using setEmail\n");

            }catch (InvalidEmailException e){
                fail("Test Failed because checkEmail Method found the one word email to be invalid in setEmail Method\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
            }catch (Exception e){
                fail("Test Failed because setEmail throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
            }
        } catch (InvalidNameException e) {
            fail("Test Failed because constructor throw an InvalidNameException because of an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

    @Test
    @DisplayName("Test Email when Name is Two Words (c)")
    void testEmailTwoWordName(){
        //Name and Email for testing email when name is two words
        String nameTest = "David Smith", emailTest = "david.smith@ucd.ie";

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the name age and email constructor with a two word name
            CheckedUser constructorTest = new CheckedUser(nameTest, defaultAge, emailTest);

            // Assertion to test that the getEmail method returns the two word email set in the constructor
            assertEquals(constructorTest.getEmail(), emailTest, "\nThe email returned from getEmail on constructorTest was not equal to the two word email: " + emailTest + " set in the name, age and email constructor\n");

        } catch (InvalidNameException e) {
            fail("Test Failed because checkName Method found the one word name to be invalid in name, age and email constructor\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (InvalidAgeException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid age\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (InvalidEmailException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid email\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the just name constructor
            CheckedUser constructorTest = new CheckedUser(nameTest);

            try {
                //Using setEmail to set the two word email
                constructorTest.setEmail(emailTest);

                // Assertion to test that the getEmail method returns the two word email set using setEmail
                assertEquals(constructorTest.getEmail(), emailTest, "\nThe email returned from getEmail on constructorTest was not equal to the two word email: " + emailTest + " set using setEmail\n");

            }catch (InvalidEmailException e){
                fail("Test Failed because checkEmail Method found the two word email to be invalid in setEmail Method\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
            }catch (Exception e){
                fail("Test Failed because setEmail throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
            }

        } catch (InvalidNameException e) {
            fail("Test Failed because constructor throw an InvalidNameException because of an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

    @Test
    @DisplayName("Test Email can not Contain Digits  (c)")
    void testEmailNoDigits(){
        //CheckedUser, Name and Email for testing email can't contain digits
        String nameNumber = "John", emailNumber = "j0hn@ucd.ie";
        CheckedUser CuserDigit;

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            CuserDigit = new CheckedUser(nameNumber);

            //assertAll so that all assertions are run and reported together
            assertAll("Testing Email can not Contain Digits",
                    //Assertion that if name constructor is inputted an email with a digit it should throw InvalidEmailException
                    () -> assertThrows(InvalidEmailException.class, () -> new CheckedUser(nameNumber, defaultAge, emailNumber), "The name, age and email constructor didn't throw InvalidEmailException when inputted with a email with a digit\nTest email: " + emailNumber),
                    //Assertion that if setEmail is inputted an email with a digit it should throw InvalidEmailException
                    () -> assertThrows(InvalidEmailException.class, () -> CuserDigit.setEmail(emailNumber), "The setEmail didn't throw InvalidEmailException when inputted with a email with a digit\nTest email: " + emailNumber)
            );
        } catch (InvalidNameException e) {
            fail("Test Failed because constructor throw an InvalidNameException because of an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

    @Test
    @DisplayName("Test Email can not Contain Symbols (c)")
    void testEmailNoSymbols(){
        //CheckedUser, Name and Email for testing email cant contain symbols
        String nameSymbol = "John", emailSymbol = "john!.@ucd.ie";
        CheckedUser CuserSymbol;

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            CuserSymbol = new CheckedUser(nameSymbol);

            //assertAll so that all assertions are run and reported together
            assertAll("Testing Email can not Contain Symbols ",
                    //Assertion that if name constructor is inputted a email with a symbol it should throw InvalidEmailException
                    () -> assertThrows(InvalidEmailException.class, () -> new CheckedUser(nameSymbol, defaultAge, emailSymbol), "The name, age and email constructor didn't throw InvalidEmailException when inputted with an email with a symbol\nTest email: " + emailSymbol),
                    //Assertion that if setEmail is inputted a name with a symbol it should throw InvalidEmailException
                    () -> assertThrows(InvalidEmailException.class, () -> CuserSymbol.setEmail(emailSymbol), "The setEmail didn't throw InvalidEmailException when inputted with an email with a symbol\nTest email: " + emailSymbol)
            );
        } catch (InvalidNameException e) {
            fail("Test Failed because constructor throw an InvalidNameException because of an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

    @Test
    @DisplayName("Test Email Stored in Lower Case (c)")
    void testEmailCapital(){
        //Test email
        String emailTest= "John.Doe@ucd.ie";


        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the name age and email constructor with a capitalised email
            CheckedUser constructorTest = new CheckedUser(defaultName, defaultAge, emailTest);

            // Assertion to test that the getEmail method returns the  email in lower case
            assertEquals(constructorTest.getEmail(), emailTest.toLowerCase(), "\nThe email returned from getEmail on constructorTest was not equal to the email in lower case: " + emailTest + " set in the name, age and email constructor\n");

        } catch (InvalidNameException e) {
            fail("Test Failed because checkName Method found the one word name to be invalid in name, age and email constructor\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (InvalidAgeException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid age\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (InvalidEmailException e) {
            fail("Constructor failed to create the CheckedUser so test failed due to an invalid email\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }

        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Create constructorTest using the just name constructor
            CheckedUser constructorTest = new CheckedUser(defaultName);

            try {
                //Using setEmail to set the capitalised email
                constructorTest.setEmail(emailTest);

                // Assertion to test that the getEmail method returns the email as lower case set using setEmail
                assertEquals(constructorTest.getEmail(), emailTest.toLowerCase(), "\nThe email returned from getEmail on constructorTest was not equal to the email as lower case: " + emailTest + " set using setEmail\n");

            }catch (InvalidEmailException e){
                fail("Test Failed because checkEmail Method found the two word email to be invalid in setEmail Method\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
            }catch (Exception e){
                fail("Test Failed because setEmail throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
            }

        } catch (InvalidNameException e) {
            fail("Test Failed because constructor throw an InvalidNameException because of an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

    @Test
    @DisplayName("Test Email Matches the Name (c)")
    void testEmailMatchName(){
        //Email for testing email matches name
        String testEmail = "john@ucd.ie";


        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            tempCuser = new CheckedUser(defaultName);

            //assertAll so that all assertions are run and reported together
            assertAll("Testing Email Matches the Name ",
                    //Assertion that if name, age and email constructor is inputted a email that does not match name it should throw InvalidEmailException
                    () -> assertThrows(InvalidEmailException.class, () -> new CheckedUser(defaultName, defaultAge, testEmail), "The name, age and email constructor didn't throw InvalidEmailException when inputted with an email that does not match name\nTest email: " + testEmail),
                    //Assertion that if setEmail is inputted a name that does not match name it should throw InvalidEmailException
                    () -> assertThrows(InvalidEmailException.class, () -> tempCuser.setEmail(testEmail), "The setEmail didn't throw InvalidEmailException when inputted with an email that does not match name\nTest email: " + testEmail)
            );
        } catch (InvalidNameException e) {
            fail("Test Failed because constructor throw an InvalidNameException because of an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

    @Test
    @DisplayName("Test the order of Exceptions (c)")
    void testOrderExceptions(){
        //Variables of invalid data
        String invalidName = "!john", invalidEmail = "*david@.com";
        int invalidAge = 12;

        //assertAll so that all assertions are run and reported together
        assertAll("Testing the order of Exceptions",
                //Assertion that name should be checked first so InvalidNameException should be thrown
                () -> assertThrows(InvalidNameException.class, () -> new CheckedUser(invalidName, invalidAge, invalidEmail), "Name was not checked first so InvalidNameException was not thrown\n"),
                //Assertion that age should be checked before email so InvalidAgeException should be thrown
                () -> assertThrows(InvalidAgeException.class, () -> new CheckedUser(defaultName, invalidAge, invalidEmail), "Age was not checked before email so InvalidAgeException was not thrown\n")
        );
    }

    @Test
    @DisplayName("Test toString with Name (d)")
    void testToStringName(){
        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            tempCuser = new CheckedUser(defaultName);

            //Assertion to check that toString for name outputs the correct string
            assertEquals("CheckedUser: John Doe", tempCuser.toString(), "Failed because the string outputted by toString did not match the expected string: \"CheckedUser: John Doe\"");

        } catch (InvalidNameException e) {
            fail("Test Failed because constructor throw an InvalidNameException because of an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

    @Test
    @DisplayName("Test toString with Name and Age (d)")
    void testToStringNameAge(){
        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            tempCuser = new CheckedUser(defaultName, defaultAge);

            //Assertion to check that toString for name and age outputs the correct string
            assertEquals("CheckedUser: John Doe (20)", tempCuser.toString(), "Failed because the string outputted by toString did not match the expected string: \"CheckedUser: John Doe (20)\"");

        } catch (InvalidNameException e) {
            fail("Test Failed because constructor throw an InvalidNameException because of an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (InvalidAgeException e) {
            fail("Test Failed because constructor throw an InvalidAgeException because of an invalid age\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

    @Test
    @DisplayName("Test toString with Name Age and Email (d)")
    void testToStringNameAgeEmail(){

        //Assertion to check that toString for name age and email outputs the correct string
        assertEquals("CheckedUser: John Doe (20), john.doe@ucdconnect.ie", Cuser.toString(), "Failed because the string outputted by toString did not match the expected string: \"CheckedUser: John Doe (20), john.doe@ucdconnect.ie\"");
    }

    @Test
    @DisplayName("Test toString with Name and Email (d)")
    void testToStringNameEmail(){
        //Try statement to catch if the constructor throws an exception in creating the CheckedUser(Should not throw exception as passed valid data)
        try {
            //Setting up tempCuser to have name and email set
            tempCuser = new CheckedUser(defaultName);
            tempCuser.setEmail(defaultEmail);

            //Assertion to check that toString for name and age outputs the correct string
            assertEquals("CheckedUser: John Doe, john.doe@ucdconnect.ie", tempCuser.toString(), "Failed because the string outputted by toString did not match the expected string: \"CheckedUser: John Doe, john.doe@ucdconnect.ie\"");

        } catch (InvalidNameException e) {
            fail("Test Failed because constructor throw an InvalidNameException because of an invalid name\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (InvalidEmailException e) {
            fail("Test Failed because constructor throw an InvalidEmailException because of an invalid email\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        } catch (Exception e){
            fail("Test Failed because constructor throw an unexpected exception\n\nException Stack Trace:\n" + exceptionToString(e) + "\n\nFail Trace:\n");
        }
    }

}