package org.example.exerciseJPAHibernate.exercice3.utils;

import org.example.exerciseJPAHibernate.exercice3.entity.*;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProductManager {

    private final EntityManager em;
    private final Scanner scanner = new Scanner(System.in);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ProductManager(EntityManager em) {
        this.em = em;
    }

    public void menu() {
        boolean quit = false;
        while (!quit) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> createProduct();
                case "2" -> listProducts();
                case "3" -> updateProduct();
                case "4" -> deleteProduct();
                case "5" -> quit = true;
                default -> System.out.println("Choix invalide. Réessayez.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n=== Gestion des produits ===");
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Lister tous les produits");
        System.out.println("3. Modifier un produit");
        System.out.println("4. Supprimer un produit");
        System.out.println("5. Quitter");
        System.out.print("Choix : ");
    }

    private void createProduct() {
        System.out.println("Choisissez le type de produit :");
        System.out.println("1. ProductFood");
        System.out.println("2. ProductElectronic");
        System.out.println("3. ProductHousing");
        System.out.print("Type : ");
        String type = scanner.nextLine();

        System.out.print("Nom du produit : ");
        String name = scanner.nextLine();

        System.out.print("Prix : ");
        double price;
        try {
            price = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Prix invalide.");
            return;
        }

        Product product = switch (type) {
            case "1" -> {
                System.out.print("Date d'expiration (dd/MM/yyyy) : ");
                Date expiryDate = parseDate(scanner.nextLine());
                if (expiryDate == null) {
                    System.out.println("Date invalide.");
                    yield null;
                }
                yield ProductFood.builder()
                        .name(name)
                        .price(price)
                        .expiryDate(expiryDate)
                        .build();
            }
            case "2" -> {
                System.out.print("Durée batterie (heures) : ");
                int batterie;
                try {
                    batterie = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Durée invalide.");
                    yield null;
                }
                yield ProductElectronic.builder()
                        .name(name)
                        .price(price)
                        .batterieDuration(batterie)
                        .build();
            }
            case "3" -> {
                System.out.print("Hauteur : ");
                double height;
                try {
                    height = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Hauteur invalide.");
                    yield null;
                }

                System.out.print("Largeur : ");
                double width;
                try {
                    width = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Largeur invalide.");
                    yield null;
                }

                yield ProductHousing.builder()
                        .name(name)
                        .price(price)
                        .height(height)
                        .width(width)
                        .build();
            }
            default -> {
                System.out.println("Type de produit invalide.");
                yield null;
            }
        };

        if (product != null) {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
            System.out.println("Produit ajouté avec succès.");
        }
    }

    private void listProducts() {
        List<Product> products = em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        if (products.isEmpty()) {
            System.out.println("Aucun produit trouvé.");
        } else {
            for (Product p : products) {
                System.out.println(formatProduct(p));
            }
        }
    }

    private void updateProduct() {
        System.out.print("ID du produit à modifier : ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID invalide.");
            return;
        }

        Product product = em.find(Product.class, id);
        if (product == null) {
            System.out.println("Produit introuvable.");
            return;
        }

        System.out.println("Produit actuel : " + formatProduct(product));

        System.out.print("Nouveau nom (vide = inchangé) : ");
        String name = scanner.nextLine();
        if (!name.isBlank()) product.setName(name);

        System.out.print("Nouveau prix (vide = inchangé) : ");
        String priceStr = scanner.nextLine();
        if (!priceStr.isBlank()) {
            try {
                product.setPrice(Double.parseDouble(priceStr));
            } catch (NumberFormatException e) {
                System.out.println("Prix invalide.");
            }
        }

        if (product instanceof ProductFood food) {
            System.out.print("Nouvelle date d’expiration (dd/MM/yyyy) : ");
            String dateStr = scanner.nextLine();
            if (!dateStr.isBlank()) {
                Date newDate = parseDate(dateStr);
                if (newDate != null) food.setExpiryDate(newDate);
                else System.out.println("Date invalide.");
            }
        } else if (product instanceof ProductElectronic electronic) {
            System.out.print("Nouvelle durée batterie (heures) : ");
            String bat = scanner.nextLine();
            if (!bat.isBlank()) {
                try {
                    electronic.setBatterieDuration(Integer.parseInt(bat));
                } catch (NumberFormatException e) {
                    System.out.println("Durée invalide.");
                }
            }
        } else if (product instanceof ProductHousing housing) {
            System.out.print("Nouvelle hauteur : ");
            String h = scanner.nextLine();
            if (!h.isBlank()) {
                try {
                    housing.setHeight(Double.parseDouble(h));
                } catch (NumberFormatException e) {
                    System.out.println("Hauteur invalide.");
                }
            }

            System.out.print("Nouvelle largeur : ");
            String w = scanner.nextLine();
            if (!w.isBlank()) {
                try {
                    housing.setWidth(Double.parseDouble(w));
                } catch (NumberFormatException e) {
                    System.out.println("Largeur invalide.");
                }
            }
        }

        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
        System.out.println("Produit mis à jour.");
    }

    private void deleteProduct() {
        System.out.print("ID du produit à supprimer : ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID invalide.");
            return;
        }

        Product product = em.find(Product.class, id);
        if (product == null) {
            System.out.println("Produit introuvable.");
            return;
        }

        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
        System.out.println("Produit supprimé.");
    }

    private Date parseDate(String input) {
        try {
            return dateFormat.parse(input);
        } catch (ParseException e) {
            return null;
        }
    }

    private String formatProduct(Product p) {
        String base = "ID=" + p.getId() + ", Nom=" + p.getName() + ", Prix=" + p.getPrice();
        if (p instanceof ProductFood f) {
            return base + ", Expiration=" + dateFormat.format(f.getExpiryDate());
        } else if (p instanceof ProductElectronic e) {
            return base + ", Batterie=" + e.getBatterieDuration() + "h";
        } else if (p instanceof ProductHousing h) {
            return base + ", Hauteur=" + h.getHeight() + ", Largeur=" + h.getWidth();
        }
        return base;
    }
}
