import java.util.Scanner;   //Importamos la clase Scanner para leer entradas del usuario

// ---------------- INTERFACES ----------------
// Estas interfaces definen los "productos" del menú que cada fábrica puede crear

interface Starter { //Entrada 
    void eat(); // Método para "comer" la entrada
}

interface MainDish { // Plato principal
    void eat(); // Método para "comer" el plato principal
}

interface Drink { // Bebida
    void drink(); // Método para "beber" la bebida
}

interface Dessert { // Postre
    void eat(); // Método para "comer" el postre
}

// Interfaz que define la Fábrica Abstracta
interface MenuFactory {
    Starter createStarter();    // Método para crear una entrada
    MainDish createMainDish();  // Método para crear un plato principal
    Drink createDrink();        // Método para crear una bebida
    Dessert createDessert();    // Método para crear un postre
}

// ---------------- GOURMET ----------------
// Implementaciones concretas de los productos para el menú Gourmet

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

//Fábrica concreta que produce un menú completo tipo Gourmet
class GourmetFactory implements MenuFactory {
    @Override public Starter createStarter() { return new GourmetStarter(); }
    @Override public MainDish createMainDish() { return new GourmetMainDish(); }
    @Override public Drink createDrink() { return new GourmetDrink(); }
    @Override public Dessert createDessert() { return new GourmetDessert(); }
}

// ---------------- HEALTHY ----------------
// Implementaciones concretas de los productos para el menú Saludable
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

//Fábrica concreta que produce un menú completo tipo Saludable
class HealthyFactory implements MenuFactory {
    @Override public Starter createStarter() { return new HealthyStarter(); }
    @Override public MainDish createMainDish() { return new HealthyMainDish(); }
    @Override public Drink createDrink() { return new HealthyDrink(); }
    @Override public Dessert createDessert() { return new HealthyDessert(); }
}

// ---------------- VEGETARIAN ----------------
// Implementaciones concretas de los productos para el menú Vegetariano

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

//Fábrica concreta que produce un menú completo tipo Vegetariano
class VegetarianFactory implements MenuFactory {
    @Override public Starter createStarter() { return new VegetarianStarter(); }
    @Override public MainDish createMainDish() { return new VegetarianMainDish(); }
    @Override public Drink createDrink() { return new VegetarianDrink(); }
    @Override public Dessert createDessert() { return new VegetarianDessert(); }
}

// ---------------- CLIENT ----------------
// Clase principal que interactúa con el usuario y utiliza las fábricas para crear menús

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    // Scanner para leer la entrada del usuario
        MenuFactory factory = null; // Fábrica que se seleccionará según la elección del usuario

        // Menú para seleccionar el tipo de menú
        System.out.println("=== Bienvenido al sistema de menús ===");
        System.out.println("Seleccione el tipo de menú:");
        System.out.println("1. Gourmet");
        System.out.println("2. Saludable");
        System.out.println("3. Vegetariano");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();  // Leer la opción del usuario

        // Seleccionar la fábrica adecuada según la opción del usuario
        factory = switch(opcion) {
            case 1 -> new GourmetFactory();
            case 2 -> new HealthyFactory();
            case 3 -> new VegetarianFactory();
            default -> {
                // Manejo de opción inválida
                System.out.println("Opción inválida. Saliendo...");
                System.exit(0);
                yield null; // Esto nunca se alcanza, pero es necesario para la sintaxis
            }
        };

        // Usar la fábrica para crear los productos del menú
        if (factory != null) {
            // Se crean los productos del menú a través de la fábrica seleccionada
            Starter starter = factory.createStarter();
            MainDish mainDish = factory.createMainDish();
            Drink drink = factory.createDrink();
            Dessert dessert = factory.createDessert();

            int choice; // Variable para la opción del menú interactivo
            do {
                // Sub-menú interactivo para que el usuario elija qué consumir
                System.out.println("\n--- Menú interactivo ---");
                System.out.println("1. Comer entrada");
                System.out.println("2. Comer plato principal");
                System.out.println("3. Beber bebida");
                System.out.println("4. Comer postre");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");
                choice = sc.nextInt();  // Leer la opción del usuario

                // Ejecutar la acción correspondiente según la elección del usuario
                switch (choice) {
                    case 1 -> starter.eat();
                    case 2 -> mainDish.eat();
                    case 3 -> drink.drink();
                    case 4 -> dessert.eat();
                    case 0 -> System.out.println("Saliendo del restaurante...");
                    default -> System.out.println("Opción inválida.");
                }
            } while (choice != 0);  // Repetir hasta que el usuario decida salir
        }

        sc.close(); // Cerrar el scanner
    }
}