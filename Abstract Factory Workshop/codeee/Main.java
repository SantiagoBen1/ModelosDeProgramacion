package codeee;

import java.util.Scanner;

// ---------------- INTERFACES ----------------
interface Starter {
    void eat();
}

interface MainDish {
    void eat();
}

interface Drink {
    void drink();
}

interface Dessert {
    void eat();
}

interface MenuFactory {
    Starter createStarter();
    MainDish createMainDish();
    Drink createDrink();
    Dessert createDessert();
}

// ---------------- GOURMET ----------------
class GourmetStarter implements Starter {
    @Override
    public void eat() {
        System.out.println("Comiendo una entrada gourmet...");
    }
}

class GourmetMainDish implements MainDish {
    @Override
    public void eat() {
        System.out.println("Disfrutando un plato principal gourmet...");
    }
}

class GourmetDrink implements Drink {
    @Override
    public void drink() {
        System.out.println("Bebiendo un vino gourmet...");
    }
}

class GourmetDessert implements Dessert {
    @Override
    public void eat() {
        System.out.println("Saboreando un postre gourmet...");
    }
}

class GourmetFactory implements MenuFactory {
    @Override
    public Starter createStarter() { return new GourmetStarter(); }
    @Override
    public MainDish createMainDish() { return new GourmetMainDish(); }
    @Override
    public Drink createDrink() { return new GourmetDrink(); }
    @Override
    public Dessert createDessert() { return new GourmetDessert(); }
}

// ---------------- HEALTHY ----------------
class HealthyStarter implements Starter {
    @Override
    public void eat() {
        System.out.println("Comiendo una ensalada saludable...");
    }
}

class HealthyMainDish implements MainDish {
    @Override
    public void eat() {
        System.out.println("Disfrutando un bowl nutritivo...");
    }
}

class HealthyDrink implements Drink {
    @Override
    public void drink() {
        System.out.println("Bebiendo un jugo verde saludable...");
    }
}

class HealthyDessert implements Dessert {
    @Override
    public void eat() {
        System.out.println("Saboreando un postre bajo en calorías...");
    }
}

class HealthyFactory implements MenuFactory {
    @Override
    public Starter createStarter() { return new HealthyStarter(); }
    @Override
    public MainDish createMainDish() { return new HealthyMainDish(); }
    @Override
    public Drink createDrink() { return new HealthyDrink(); }
    @Override
    public Dessert createDessert() { return new HealthyDessert(); }
}

// ---------------- VEGETARIAN ----------------
class VegetarianStarter implements Starter {
    @Override
    public void eat() {
        System.out.println("Comiendo una entrada vegetariana...");
    }
}

class VegetarianMainDish implements MainDish {
    @Override
    public void eat() {
        System.out.println("Disfrutando un plato principal vegetariano...");
    }
}

class VegetarianDrink implements Drink {
    @Override
    public void drink() {
        System.out.println("Bebiendo una limonada vegetariana...");
    }
}

class VegetarianDessert implements Dessert {
    @Override
    public void eat() {
        System.out.println("Saboreando un postre vegetariano...");
    }
}

class VegetarianFactory implements MenuFactory {
    @Override
    public Starter createStarter() { return new VegetarianStarter(); }
    @Override
    public MainDish createMainDish() { return new VegetarianMainDish(); }
    @Override
    public Drink createDrink() { return new VegetarianDrink(); }
    @Override
    public Dessert createDessert() { return new VegetarianDessert(); }
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

        // Crear menú
        if (factory != null) {
            Starter starter = factory.createStarter();
            MainDish mainDish = factory.createMainDish();
            Drink drink = factory.createDrink();
            Dessert dessert = factory.createDessert();

            // Simulación de comer
            System.out.println("\n--- Su menú está listo ---");
            starter.eat();
            mainDish.eat();
            drink.drink();
            dessert.eat();
        }

        sc.close();
    }
}
