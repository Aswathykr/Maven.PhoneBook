package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private Map<String, List<String>> phoneMap;

    public PhoneBook(){
        phoneMap = new HashMap<String, List<String>>();
    }

    public void add(String name, String phoneNumber) {
        if(phoneMap.containsKey(name)){
            List<String> phoneList =phoneMap.get(name);
            phoneList.add(phoneNumber);

        }else {
            ArrayList phoneList = new ArrayList<String>();
            phoneList.add(phoneNumber);
            phoneMap.put(name, phoneList);
        }
    }

    public String[] lookup(String name) {

        List<String> list = phoneMap.get(name);

        return (list == null) ? null : list.toArray(new String[list.size()]);
    }

    public void remove(String name) {
        phoneMap.remove(name);
    }

    public String reverseLookup(String phoneNumber) {
        String name = "";
        for (String key : phoneMap.keySet()) {
            List<String> valueList = phoneMap.get(key);
            if(valueList.contains(phoneNumber)){
                name = key;
                break;
            }
        }
        return name;
    }

    public void display() {
        for (String key : phoneMap.keySet()) {
            System.out.print(key + " " );
            for(String value : phoneMap.get(key)) {
                System.out.print(value + " " );
            }
            System.out.print( "\n" );
        }
    }

    public void remove(String givenName, String givenPhoneNumber) {
        List<String> valueList = phoneMap.get(givenName);
        valueList.remove(givenPhoneNumber);
        if(valueList.size() == 0)
            phoneMap.remove(givenName);
    }
}
