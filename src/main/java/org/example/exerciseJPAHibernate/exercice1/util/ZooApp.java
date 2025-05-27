package org.example.exerciseJPAHibernate.exercice1.util;

import org.example.exerciseJPAHibernate.exercice1.dao.AnimalsDAO;
import org.example.exerciseJPAHibernate.exercice1.entity.Animals;
import org.example.exerciseJPAHibernate.exercice1.model.DietType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ZooApp {

    private static AnimalsDAO animalsDAO;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zoo_ex1");
        EntityManager em = emf.createEntityManager();
        animalsDAO = new AnimalsDAO(em);

        boolean running = true;

        while (running) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addAnimal();
                    break;
                case "2":
                    findAnimalById();
                    break;
                case "3":
                    findAnimalsByName();
                    break;
                case "4":
                    findAnimalsByDietType();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide, merci de réessayer.");
            }
        }

        em.close();
        emf.close();
        scanner.close();
        System.out.println("Au revoir !");
    }

    private static void showMenu() {
        System.out.println("\n--- Menu du Zoo ---");
        System.out.println("1. Ajouter un animal");
        System.out.println("2. Rechercher un animal par ID");
        System.out.println("3. Rechercher des animaux par nom");
        System.out.println("4. Rechercher des animaux par régime alimentaire");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void addAnimal() {
        System.out.print("Nom de l’animal : ");
        String name = scanner.nextLine();

        int age;
        try {
            System.out.print("Âge : ");
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("L’âge doit être un nombre entier.");
            return;
        }

        DietType dietType = null;
        while (dietType == null) {
            System.out.print("Régime alimentaire (HERBIVORE, CARNIVORE, OMNIVORE, ALGIVORE) : ");
            try {
                dietType = DietType.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Régime invalide, merci de choisir parmi HERBIVORE, CARNIVORE, OMNIVORE, ALGIVORE.");
            }
        }

        String arrivalDate = null;
        while (arrivalDate == null) {
            System.out.print("Date d’arrivée (AAAA-MM-JJ) : ");
            String inputDate = scanner.nextLine();
            try {
                LocalDate.parse(inputDate);
                arrivalDate = inputDate;
            } catch (DateTimeParseException e) {
                System.out.println("Format de date incorrect, merci d’utiliser AAAA-MM-JJ.");
            }
        }

        Animals animal = animalsDAO.createAnimal(name, age, dietType, arrivalDate);
        System.out.println("Animal ajouté : " + animal);
    }

    private static void findAnimalById() {
        try {
            System.out.print("ID de l’animal : ");
            Long id = Long.parseLong(scanner.nextLine());
            Animals animal = animalsDAO.findById(id);
            if (animal != null) {
                System.out.println(animal);
            } else {
                System.out.println("Aucun animal trouvé avec l’ID " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("L’ID doit être un nombre valide.");
        }
    }

    private static void findAnimalsByName() {
        System.out.print("Nom à rechercher : ");
        String name = scanner.nextLine();
        List<Animals> animals = animalsDAO.findByName(name);
        if (animals.isEmpty()) {
            System.out.println("Aucun animal trouvé avec le nom ' " + name + " '.");
        } else {
            animals.forEach(System.out::println);
        }
    }

    private static void findAnimalsByDietType() {
        DietType dietType = null;
        while (dietType == null) {
            System.out.print("Régime alimentaire à rechercher (HERBIVORE, CARNIVORE, OMNIVORE, ALGIVORE) : ");
            try {
                dietType = DietType.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Régime invalide, merci de choisir parmi HERBIVORE, CARNIVORE, OMNIVORE, ALGIVORE.");
            }
        }
        List<Animals> animals = animalsDAO.findByDiet(dietType);
        if (animals.isEmpty()) {
            System.out.println("Aucun animal trouvé avec le régime ' " + dietType + " '.");
        } else {
            animals.forEach(System.out::println);
        }
    }
}
