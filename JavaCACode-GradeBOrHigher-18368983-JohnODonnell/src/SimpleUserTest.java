import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleUserTest {

    //Variables used during testing
    private SimpleUser Suser; // The default SimpleUser object used for testing
    private User user; // The default User object used for testing

    // The default values passed into the SimpleUser constructor to create the default SimpleUser for testing
    private String defaultName = "John O'Donnell", defaultEmail = "john.odonnell@ucdconnect.ie";
    private int defaultAge = 19;


    @BeforeEach
    void setUp() {
        // Before each test set Suser back to the default
        Suser = new SimpleUser(defaultName, defaultAge, defaultEmail);

        // The set user to a User of Suser
        user = Suser;
    }

    @DisplayName("Test SimpleUser instanceof User")
    @Test
    void testSimpleUserInstanceOfUser() {
        //Checking that SimpleUser object is instance of User
        assertTrue(Suser instanceof User, "SimpleUser does not implement User");
    }

    @DisplayName("Test getName")
    @Test
    void testGetName() {
        //assertAll so that both assertions are run and reported together
        assertAll("Testing getName in SimpleUser",
                // Assertion to test that the getName method works on a SimpleUser object
                () -> assertEquals(Suser.getName(), defaultName, "\nThe name returned from getName on SimpleUser object was not equal to the default name: " + defaultName + "\n"),
                // Assertion to test that the getName method works on a SimpleUser object using the User type
                () -> assertEquals(user.getName(), defaultName,  "\nThe name returned from getName on SimpleUser object using User interface was not equal to the default name: " + defaultName + "\n")
        );
    }


    @DisplayName("Test setName")
    @Test
    void testSetName() {
        // Setting a String variable new temp that is being set over name in the SimpleUser object
        String newTemp = "David";
        // Using setName on SimpleUser object
        Suser.setName(newTemp);

        //assertAll so that both assertions are run and reported together
        assertAll("Testing setName on SimpleUser",
                // Assertion to test that the getName method returns the new set name on a SimpleUser object
                () -> assertEquals(Suser.getName(), newTemp, "\nThe name returned from getName on SimpleUser object was not equal to the new name: " + newTemp + "\n When setName was used on SimpleUser object\n"),
                // Assertion to test that the getName method returns the new set name on a SimpleUser object using the User type
                () -> assertEquals(user.getName(), newTemp,  "\nThe name returned from getName on SimpleUser object using User interface was not equal to the new name: " + newTemp + "\n When setName was used on SimpleUser object\n")
        );


        // Setting a String variable new temp 2 that is being set over name in the SimpleUser object using the User type
        String newTemp2 = "Bob Smith";
        // Using setName on SimpleUser object using the User type
        Suser.setName(newTemp2);

        //assertAll so that both assertions are run and reported together
        assertAll("Testing setName on SimpleUser using the User type",
                // Assertion to test that the getName method returns the new set name on a SimpleUser object
                () -> assertEquals(Suser.getName(), newTemp2, "\nThe name returned from getName on SimpleUser object was not equal to the new name: " + newTemp2 + "\n When setName was used on SimpleUser object\n"),
                // Assertion to test that the getName method returns the new set name on a SimpleUser object using the User type
                () -> assertEquals(user.getName(), newTemp2,  "\nThe name returned from getName on SimpleUser object using User interface was not equal to the new name: " + newTemp2 + "\n When setName was used on SimpleUser object\n")
        );
    }

    @DisplayName("Test getEmail")
    @Test
    void testGetEmail() {
        //assertAll so that both assertions are run and reported together
        assertAll("Testing getEmail in SimpleUser",
                // Assertion to test that the getEmail method works on a SimpleUser object
                () -> assertEquals(Suser.getEmail(), defaultEmail, "\nThe name returned from getEmail on SimpleUser object was not equal to the default email: " + defaultEmail + "\n"),
                // Assertion to test that the getEmail method works on a SimpleUser object using the User type
                () -> assertEquals(user.getEmail(), defaultEmail,  "\nThe name returned from getEmail on SimpleUser object using User interface was not equal to the default email: " + defaultEmail + "\n")
        );
    }

    @DisplayName("Test setEmail")
    @Test
    void testSetEmail() {
        // Setting a String variable new temp that is being set over email in the SimpleUser object
        String newTemp = "david@ucdconnect.ie";
        // Using setEmail on SimpleUser object
        Suser.setEmail(newTemp);

        //assertAll so that both assertions are run and reported together
        assertAll("Testing setEmail on SimpleUser",
                // Assertion to test that the getEmail method returns the new set email on a SimpleUser object
                () -> assertEquals(Suser.getEmail(), newTemp, "\nThe email returned from getEmail on SimpleUser object was not equal to the new email: " + newTemp + "\n When setEmail was used on SimpleUser object\n"),
                // Assertion to test that the getEmail method returns the new set email on a SimpleUser object using the User type
                () -> assertEquals(user.getEmail(), newTemp,  "\nThe email returned from getEmail on SimpleUser object using User interface was not equal to the new email: " + newTemp + "\n When setEmail was used on SimpleUser object\n")
        );


        // Setting a String variable new temp 2 that is being set over email in the SimpleUser object using the User type
        String newTemp2 = "bob.smith@ucdconnect.ie";
        // Using setEmail on SimpleUser object using the User type
        Suser.setEmail(newTemp2);

        //assertAll so that both assertions are run and reported together
        assertAll("Testing setEmail on SimpleUser using the User type",
                // Assertion to test that the getEmail method returns the new set email on a SimpleUser object
                () -> assertEquals(Suser.getEmail(), newTemp2, "\nThe email returned from getEmail on SimpleUser object was not equal to the new email: " + newTemp2 + "\n When setEmail was used on SimpleUser object\n"),
                // Assertion to test that the getEmail method returns the new set email on a SimpleUser object using the User type
                () -> assertEquals(user.getEmail(), newTemp2,  "\nThe email returned from getEmail on SimpleUser object using User interface was not equal to the new email: " + newTemp2 + "\n When setEmail was used on SimpleUser object\n")
        );
    }

    @DisplayName("Test getAge")
    @Test
    void testGetAge() {
        //assertAll so that both assertions are run and reported together
        assertAll("Testing getEAge in SimpleUser",
                // Assertion to test that the getAge method works on a SimpleUser object
                () -> assertEquals(Suser.getAge(), defaultAge, "\nThe age returned from getAge on SimpleUser object was not equal to the default age: " + defaultAge + "\n"),
                // Assertion to test that the getAge method works on a SimpleUser object using the User type
                () -> assertEquals(user.getAge(), defaultAge,  "\nThe age returned from getAge on SimpleUser object using User interface was not equal to the default age: " + defaultAge + "\n")
        );
    }

    @DisplayName("Test setAge")
    @Test
    void testSetAge() {
        // Setting a String variable new temp that is being set over age in the SimpleUser object
        int newTemp = 20;
        // Using setAge on SimpleUser object
        Suser.setAge(newTemp);

        //assertAll so that both assertions are run and reported together
        assertAll("Testing setAge on SimpleUser",
                // Assertion to test that the getAge method returns the new set age on a SimpleUser object
                () -> assertEquals(Suser.getAge(), newTemp, "\nThe age returned from getAge on SimpleUser object was not equal to the new age: " + newTemp + "\n When setAge was used on SimpleUser object\n"),
                // Assertion to test that the getAge method returns the new set age on a SimpleUser object using the User type
                () -> assertEquals(user.getAge(), newTemp,  "\nThe age returned from getAge on SimpleUser object using User interface was not equal to the new age: " + newTemp + "\n When setAge was used on SimpleUser object\n")
        );


        // Setting a String variable new temp 2 that is being set over name in the SimpleUser object using the User type
        int newTemp2 = 21;
        // Using setName on SimpleUser object using the User type
        Suser.setAge(newTemp2);

        //assertAll so that both assertions are run and reported together
        assertAll("Testing setAge on SimpleUser using the User type",
                // Assertion to test that the getAge method returns the new set age on a SimpleUser object
                () -> assertEquals(Suser.getAge(), newTemp2, "\nThe age returned from getAge on SimpleUser object was not equal to the new age: " + newTemp2 + "\n When setAge was used on SimpleUser object\n"),
                // Assertion to test that the getAge method returns the new set age on a SimpleUser object using the User type
                () -> assertEquals(user.getAge(), newTemp2,  "\nThe age returned from getAge on SimpleUser object using User interface was not equal to the new age: " + newTemp2 + "\n When setAge was used on SimpleUser object\n")
        );
    }

}