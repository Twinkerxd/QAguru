package homeWork13;

import org.junit.jupiter.api.Test;

public class Main {

    @Test
    void forAndHashMap() {
        Human human = new Human();
        human.addStudent(0,"Vasya");
        human.addStudent(1,"Petya");
        human.addStudent(2,"Victor");
        human.addStudent(3,"Oleg");
        human.addStudent(4,"Gleb");

        human.removeStudentById(2);

        human.printStudentById(3);
        human.printAllOfStudents();
    }

    @Test
    void foriAndArray() {
        Device devices = new Device();
        devices.addDeviceByIndex(0, "mouse");
        devices.addDeviceByIndex(1, "keyboard");
        devices.addDeviceByIndex(2, "monitor");

        devices.printAllDevices();
    }

    @Test
    void doWhileArrayList() {
        Pet pet = new Pet();
        pet.addPet("cat");
        pet.addPet("dog");
        pet.addPet("snake");

        pet.getPetNameById(2);
        pet.removePet("snake");

        pet.printAllPets();
    }

    @Test
    void whileHashSet() {
        Game game = new Game();
        game.addGame("Dune 2");
        game.addGame("Dota 2");
        game.addGame("Half Life 2");

        game.removeGame("Half Life 2");

        game.printAllGames();
    }
}
