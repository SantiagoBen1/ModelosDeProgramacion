package codeee;

import java.util.Scanner;

// ---------------- INTERFACES ----------------
interface Starter { void eat(); }
interface MainDish { void eat(); }
interface Drink { void drink(); }
interface Dessert { void eat(); }

interface MenuFactory {
    Starter createStarter();
    MainDish createMainDish();
    Drink createDrink();
    Dessert createDessert();
}

// ---------------- GOURMET ----------------
class GourmetStarter implements Starter {
    @Override
    public void eat() { System.out.println("Comiendo un Carpaccio de res :)"); }
}
class GourmetMainDish implements MainDish {
    @Override
    public void eat() { System.out.println("Disfrutando un Filete Mignon con salsa de trufas :)"); }
}
class GourmetDrink implements Drink {
    @Override
    public void drink() { System.out.println("Bebiendo un vino tinto de reserva :)"); }
}
class GourmetDessert implements Dessert {
    @Override
    public void eat() { System.out.println("Saboreando un postre de chocolate 70% :)"); }
}
class GourmetFactory implements MenuFactory {
    @Override public Starter createStarter() { return new GourmetStarter(); }
    @Override public MainDish createMainDish() { return new GourmetMainDish(); }
    @Override public Drink createDrink() { return new GourmetDrink(); }
    @Override public Dessert createDessert() { return new GourmetDessert(); }
}

// ---------------- HEALTHY ----------------
class HealthyStarter implements Starter {
    @Override
    public void eat() { System.out.println("Comiendo una ensalada de quinoa con aguacate :)"); }
}
class HealthyMainDish implements MainDish {
    @Override
    public void eat() { System.out.println("Disfrutando un bowl nutritivo con pollo a la parrilla :)"); }
}
class HealthyDrink implements Drink {
    @Override
    public void drink() { System.out.println("Bebiendo un jugo verde saludable con espinacas :)"); }
}
class HealthyDessert implements Dessert {
    @Override
    public void eat() { System.out.println("Saboreando un postre de yogurt griego con miel y nueces :)"); }
}
class HealthyFactory implements MenuFactory {
    @Override public Starter createStarter() { return new HealthyStarter(); }
    @Override public MainDish createMainDish() { return new HealthyMainDish(); }
    @Override public Drink createDrink() { return new HealthyDrink(); }
    @Override public Dessert createDessert() { return new HealthyDessert(); }
}

// ---------------- VEGETARIAN ----------------
class VegetarianStarter implements Starter {
    @Override
    public void eat() { System.out.println("Comiendo una crema de calabaza con crutones :)"); }
}
class VegetarianMainDish implements MainDish {
    @Override
    public void eat() { System.out.println("Disfrutando una Lasaña de berenjena con queso ricotta :)"); }
}
class VegetarianDrink implements Drink {
    @Override
    public void drink() { System.out.println("Bebiendo un jugo natural de frutos rojos :)"); }
}
class VegetarianDessert implements Dessert {
    @Override
    public void eat() { System.out.println("Saboreando un cheesecake de frutas :)"); }
}
class VegetarianFactory implements MenuFactory {
    @Override public Starter createStarter() { return new VegetarianStarter(); }
    @Override public MainDish createMainDish() { return new VegetarianMainDish(); }
    @Override public Drink createDrink() { return new VegetarianDrink(); }
    @Override public Dessert createDessert() { return new VegetarianDessert(); }
}

// ---------------- CLIENT ----------------
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuFactory factory = null;

        System.out.println("=== Bienvenido al sistema de menús ===");
        System.out.println("Seleccione el tipo de menú:");
        System.out.println("1. Gourmet");
        System.out.println("2. Saludable");
        System.out.println("3. Vegetariano");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();

        factory = switch(opcion) {
            case 1 -> new GourmetFactory();
            case 2 -> new HealthyFactory();
            case 3 -> new VegetarianFactory();
            default -> {
                System.out.println("Opción inválida. Saliendo...");
                System.exit(0);
                yield null;
            }
        };

        if (factory != null) {
            Starter starter = factory.createStarter();
            MainDish mainDish = factory.createMainDish();
            Drink drink = factory.createDrink();
            Dessert dessert = factory.createDessert();

            int choice;
            do {
                System.out.println("\n--- Menú interactivo ---");
                System.out.println("1. Comer entrada");
                System.out.println("2. Comer plato principal");
                System.out.println("3. Beber bebida");
                System.out.println("4. Comer postre");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> starter.eat();
                    case 2 -> mainDish.eat();
                    case 3 -> drink.drink();
                    case 4 -> dessert.eat();
                    case 0 -> System.out.println("Saliendo del restaurante...");
                    default -> System.out.println("Opción inválida.");
                }
            } while (choice != 0);
        }

        sc.close();
    }
}
