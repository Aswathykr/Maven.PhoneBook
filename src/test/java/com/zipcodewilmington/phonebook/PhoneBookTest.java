package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void addTest() {
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String givenName = "Devesh";
        String givenPhoneNumber = "302-883-4275";
        //When
        phoneBook.add(givenName, givenPhoneNumber);
        //Then
        List<String> retrievedPhoneNumberList = phoneBook.lookup(givenName);
        Assert.assertEquals(retrievedPhoneNumberList.get(0),givenPhoneNumber);

    }

    @Test
    public void addToSameNameTest() {
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String givenName = "Devesh";
        String givenPhoneNumber = "302-883-4275";
        String givenPhoneNumber2 = "302-883-4270";

        //When
        phoneBook.add(givenName, givenPhoneNumber);
        phoneBook.add(givenName, givenPhoneNumber2);
        //Then
        List<String> retrievedPhoneNumberList = phoneBook.lookup(givenName);
        Assert.assertEquals(retrievedPhoneNumberList.get(0),givenPhoneNumber);
        Assert.assertEquals(retrievedPhoneNumberList.get(1),givenPhoneNumber2);
    }

    @Test
    public void removeTest(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String givenName = "Devesh";
        String givenPhoneNumber = "302-883-4275";

        phoneBook.add(givenName, givenPhoneNumber);
        //Test add is successful
        List<String> addedPhoneNumberList = phoneBook.lookup(givenName);
        Assert.assertEquals(addedPhoneNumberList.get(0),givenPhoneNumber); //

        //When
        phoneBook.remove(givenName);

        //Then
        List<String> retrievedPhoneNumber = phoneBook.lookup(givenName);
        Assert.assertNull(retrievedPhoneNumber); //

    }

    @Test
    public void lookupTest() {
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String givenName = "Nirmal";
        String givenPhoneNumber = "302-883-4275";

        //When
        phoneBook.add(givenName, givenPhoneNumber);
        //Then
        List<String> retrievedPhoneNumberList = phoneBook.lookup(givenName);
        Assert.assertEquals(retrievedPhoneNumberList.get(0),givenPhoneNumber);

    }

    @Test
    public void lookupWithMoreThanSinglePhoneNumberTest() {
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String givenName = "Nirmal";
        String givenPhoneNumber = "302-883-4275";

        String givenPhoneNumber2 = "302-883-4270";
        phoneBook.add(givenName, givenPhoneNumber);

        //When
        phoneBook.add(givenName, givenPhoneNumber2);
        //Then
        List<String> retrievedPhoneNumberList = phoneBook.lookup(givenName);
        Assert.assertEquals(retrievedPhoneNumberList.get(0),givenPhoneNumber);
        Assert.assertEquals(retrievedPhoneNumberList.get(1),givenPhoneNumber2);

    }
    @Test
    public void reverseLookupTest() {

        //Given
        PhoneBook phoneBook = new PhoneBook();
        String givenName = "Nirmal";
        String givenPhoneNumber = "302-883-4275";

        //When
        phoneBook.add(givenName, givenPhoneNumber);

        //Then
        String retrievedName = phoneBook.reverseLookup(givenPhoneNumber);
        Assert.assertEquals(retrievedName, givenName);
    }

    @Test
    public void reverseLookupWhenMoreEntriesInMapTest() {

        //Given
        PhoneBook phoneBook = new PhoneBook();

        String givenName = "Nirmal";
        String givenPhoneNumber = "302-883-4275";
        phoneBook.add(givenName, givenPhoneNumber);

        String givenName2 = "Devesh";
        String givenPhoneNumber2 = "302-883-4270";
        phoneBook.add(givenName2, givenPhoneNumber2);


        //When
        String retrievedName = phoneBook.reverseLookup(givenPhoneNumber);
        //Then
        Assert.assertEquals(retrievedName, givenName);

    }

    @Test
    public void reverseLookupWithMoreThanSinglePhoneNumberTest() {

        //Given
        PhoneBook phoneBook = new PhoneBook();

        String givenName = "Nirmal";
        String givenPhoneNumber = "302-883-4275";
        phoneBook.add(givenName, givenPhoneNumber);

        String givenPhoneNumber2 = "302-883-4270";
        phoneBook.add(givenName, givenPhoneNumber2);


        //When
        String retrievedName = phoneBook.reverseLookup(givenPhoneNumber2);
        //Then
        Assert.assertEquals(retrievedName, givenName);

    }
    @Test
    public void displayTest() {
        ByteArrayOutputStream stringOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stringOut);
        PrintStream oldPrintStream = System.out;

        System.setOut(printStream);

        //Given
        PhoneBook phoneBook = new PhoneBook();
        String givenName = "Nirmal";
        String givenPhoneNumber = "302-883-4275";
        phoneBook.add(givenName, givenPhoneNumber);

        String givenName2 = "Devesh";
        String givenPhoneNumber2 = "302-883-4270";
        phoneBook.add(givenName2, givenPhoneNumber2);

        phoneBook.display();
        System.out.flush();
        System.setOut(oldPrintStream);

        String expected = givenName + " "+ givenPhoneNumber + " \n" + givenName2 + " "+ givenPhoneNumber2 + " \n";
        Assert.assertEquals(stringOut.toString(), expected);
    }
}
