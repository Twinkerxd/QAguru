package homework13;

import java.util.ArrayList;

public class Pet {

    ArrayList<String> pets = new ArrayList<>();

    void addPet(String name) {
        pets.add(name);
        System.out.println(name + " added to the Pet ArrayList");
    }

    void removePet(String name) {
        System.out.println(name + " removed from the Pet ArrayList");
        pets.remove(name);
    }

    String getPetNameById(int id) {
        return pets.get(id);
    }

    void printAllPets() {
        for (String pet : pets) {
            System.out.println(pet);
        }
    }
}
