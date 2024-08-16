package Java_Advanced_May_2024._06_Defining_Classes._02_Exercise._06_Pokemon_Trainer;

import java.util.LinkedList;

public class Trainer {
    private String name;
    private int badges = 0;
    private LinkedList<Pokemon> collectionOfPokemons;

    public String getName() {
        return name;
    }

    public void setBadges() {
        this.badges++;
    }

    public LinkedList<Pokemon> getCollectionOfPokemons() {
        return collectionOfPokemons;
    }

    public Trainer(String name) {
        this.name = name;
        this.collectionOfPokemons = new LinkedList<>();
     }

     public void addPokemon (Pokemon pokemon) {
        collectionOfPokemons.add(pokemon);
     }

    public int getBadges() {
        return badges;
    }

    public int  getNumOfPokemons() {
        return collectionOfPokemons.size();
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", getName(), getBadges(), getNumOfPokemons());
    }
}
