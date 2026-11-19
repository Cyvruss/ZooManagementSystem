package com.example.oop2a3zms.Model;

public class Enclosure implements ZooComponent {

    private String aEnclosureName;

    public Enclosure(String pEnclosureName) {
        aEnclosureName = pEnclosureName;
    }

    public void setEnclosureName(String pEnclosureName) {
        aEnclosureName = pEnclosureName;
    }

    @Override
    public String getName() {
        return aEnclosureName;
    }

    @Override
    public int countAnimals() {
        return 0;
    }

    public String toString() {
        return
    }
}
