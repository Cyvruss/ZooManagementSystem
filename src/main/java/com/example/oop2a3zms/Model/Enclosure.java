package com.example.oop2a3zms.Model;

import java.util.ArrayList;
import java.util.List;

public class Enclosure implements ZooComponent {

    private List<ZooComponent> aComponents;

    private String aEnclosureName;

    public Enclosure(String pEnclosureName) {
        aEnclosureName = pEnclosureName;
        aComponents = new ArrayList<>();
    }

    public void setEnclosureName(String pEnclosureName) {
        aEnclosureName = pEnclosureName;
    }

    @Override
    public String getName() {
        return aEnclosureName;
    }

    public void addComponent(ZooComponent pComponent) {
        aComponents.add(pComponent);
    }

    public void removeComponent(ZooComponent pComponent) {
        aComponents.remove(pComponent);
    }

    public List<ZooComponent> getComponents() {
        return aComponents;
    }

    @Override
    public int countAnimals() {
        int count = 0;

        for (ZooComponent component : aComponents) {
            count += component.countAnimals();
        }

        return count;
    }

    @Override
    public String toString() {
        return aEnclosureName + " (" + countAnimals() + ")";
    }
}