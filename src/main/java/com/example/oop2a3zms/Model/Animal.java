package com.example.oop2a3zms.Model;

/**
 * Represents an animal in the Zoo Management System.
 * Each animal has a name and an age.
 *
 * @author Keren
 */
public class Animal {

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

    /**
     * Gets the animal's name.
     *
     * @return the animal's name
     */
    public String getName() {
        return aName;
    }

    /**
     * Gets the animal's age.
     *
     * @return the animal's age
     */
    public int getAge() {
        return aAge;
    }

    /**
     * Changes the animal's name.
     *
     * @param pName the new name
     */
    public void setName(String pName) {
        aName = pName;
    }

    /**
     * Changes the animal's age.
     *
     * @param pAge the new age
     */
    public void setAge(int pAge) {
        aAge = pAge;
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
