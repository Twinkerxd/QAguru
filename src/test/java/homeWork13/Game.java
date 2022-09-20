package homeWork13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Game {

    private Set<String> games = new HashSet<>();

    void addGame(String name) {
        games.add(name);
        System.out.println(name + " game was added to the HashSet");
    }

    void removeGame(String name) {
        games.remove(name);
        System.out.println(name + " game was removed from the HashSet");
    }

    void printAllGames() {
        Iterator<String> it = games.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
