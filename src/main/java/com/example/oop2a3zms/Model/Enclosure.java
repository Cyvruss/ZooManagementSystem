package com.example.oop2a3zms.Model;

import java.util.List;

public class Enclosure implements ZooComponent {
    private List<Enclosure> aComponents;

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
        int count = 0;
        for (Enclosure component : aComponents) {
            count += component.countAnimals();
        }
        return count;
    }

    public String toString() {
        return aEnclosureName + " (" + countAnimals() + ")";
    }
}
