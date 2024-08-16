package Java_Advanced_May_2024._06_Defining_Classes._02_Exercise._06_Pokemon_Trainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Trainer> listOfTrainers = new LinkedList<>();

        String command = scan.nextLine();
        while (!command.equals("Tournament")) {
            String[] info = command.split("\\s+");
            String trainerName = info[0];
            String pokemonName = info[1];
            String pokemonElement = info[2];
            int pokemonHealth = Integer.parseInt(info[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (listOfTrainers.stream().noneMatch(obj -> obj.getName().equals(trainerName))) {
                Trainer trainer = new Trainer(trainerName);
                trainer.addPokemon(pokemon);
                listOfTrainers.add(trainer);
            } else {
                listOfTrainers.forEach(trn -> {
                    if (trn.getName().equals(trainerName)) {
                        trn.addPokemon(pokemon);
                    }
                });
            }
            command = scan.nextLine();
        }

        String instruction = scan.nextLine();
        while (!instruction.equals("End")) {
            String finalInstruction = instruction;
            listOfTrainers.forEach(trainer -> {
                boolean hasElement = trainer.getCollectionOfPokemons().stream()
                        .anyMatch(pokemon -> pokemon.getElement().equals(finalInstruction));

                if (hasElement) {
                    trainer.setBadges();
                } else {
                    List<Pokemon> pokemonsToRemove = new ArrayList<>();
                    trainer.getCollectionOfPokemons().forEach(pokemon -> {
                        pokemon.reduceHealth(10);
                        if (pokemon.getHealth() <= 0) {
                            pokemonsToRemove.add(pokemon);
                        }
                    });
                    trainer.getCollectionOfPokemons().removeAll(pokemonsToRemove);
                }
            });
            instruction = scan.nextLine();
        }

        // sorting by number of badgers in discending order.
        listOfTrainers.stream()
                .sorted(Comparator.comparingInt(Trainer::getBadges).reversed())
                .forEach(System.out::println);
    }
}
