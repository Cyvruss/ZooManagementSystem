
package com.example.oop2a3zms.Model;

/**
 * Represents an animal in the Zoo Management System.
 * Each animal has a name and an age.
 *
 * @author Keren
 */
public class Animal implements ZooComponent {

    private String aName;
    private int aAge;

    /**
     * Creates an animal with a name and age.
     *
     * @param pName the animal's name
     * @param pAge the animal's age
     */
    public Animal(String pName, int pAge) {
        aName = pName;
        aAge = pAge;
    }

    public String getName() {
        return aName;
    }

    public int getAge() {
        return aAge;
    }

    public void setName(String pName) {
        aName = pName;
    }

    public void setAge(int pAge) {
        aAge = pAge;
    }

    /**
     * An individual animal counts as one.
     *
     * @return 1
     */
    @Override
    public int countAnimals() {
        return 1;
    }

    /**
     * Returns the animal's information.
     *
     * @return the animal's name and age
     */
    @Override
    public String toString() {
        return aName + " (" + aAge + " years old)";
    }
}
