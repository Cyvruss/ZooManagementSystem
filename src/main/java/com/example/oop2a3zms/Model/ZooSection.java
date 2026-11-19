package com.example.oop2a3zms.Model;

import java.util.*;

public class ZooSection implements ZooComponent {
    private List<ZooComponent> aComponents;
    private final String aSectionName;

    @Override
    public String getName() {
        return aSectionName;
    }

    @Override
    public int countAnimals() {
        int count = 0;
        for (ZooComponent component : aComponents) {
            count += component.countAnimals();
        }
        return count;
    }

    public ZooSection(String pName) {
        this.aSectionName = pName;
        this.aComponents = new ArrayList<>();
    }

    public void addComponent(ZooComponent pComponent) {
        this.aComponents.add(pComponent);
    }

    public List<ZooComponent> getComponents() {
        return aComponents;
    }

    public void removeComponent(ZooComponent pComponent) {
        aComponents.remove(pComponent);
    }
}
