package com.example.memorymed.model;

/**
 * Created by Cameron on 2/5/2015.
 * This class is the model for a Medfriend. A Medfriend will be the recipient of an SMS or Push message stating the main user has not taken their medication on time.
 */
public class Medfriend {

    String name;
    String number;

    public Medfriend(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
