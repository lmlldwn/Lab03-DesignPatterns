import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final HashMap<String, Pizza> pizzaCache = new HashMap<>();


    public static void main(String[] args) {
        Pizza order;
        createPizzaMenu();

        Scanner scan = new Scanner(System.in);
        LOGGER.log(Level.INFO, "Order: ");
        String key = scan.nextLine();

        order = buyPizza(key);

        LOGGER.info("===================Original Objects=====================");
        LOGGER.info("Original Object: " + pizzaCache.get(key));

        showReceipt(order);
    }

    public static void createPizzaMenu() {
        Pizza flavor = new PepperoniFlavor();
        addPizzaToMenu("P1", flavor, "Circle", "Solo", "Thin" );
        addPizzaToMenu("P2", flavor, "Circle", "Family", "Thin" );
        addPizzaToMenu("P3", flavor, "Circle", "Party", "Thin" );

        flavor = new HawaiianFlavor();
        addPizzaToMenu("H1", flavor, "Circle", "Solo", "Thin" );
        addPizzaToMenu("H2", flavor, "Circle", "Family", "Thin" );
        addPizzaToMenu("H3", flavor, "Circle", "Party", "Thin" );
    }

    public static void addPizzaToMenu(String key, Pizza flavor, String shape, String size, String crust) {
        Pizza pizza = null;
        if ( flavor instanceof PepperoniFlavor ) {
            pizza = new PepperoniFlavor();
            pizza.setShape(shape);
            pizza.setSize(size);
            pizza.setCrust(crust);
        }

        if ( flavor instanceof HawaiianFlavor ) {
            pizza = new HawaiianFlavor();
            pizza.setShape(shape);
            pizza.setSize(size);
            pizza.setCrust(crust);
        }

        pizzaCache.put(key, pizza);
    }

    public static Pizza buyPizza(String key) {
        Pizza getPizza;
        try {
            getPizza = pizzaCache.get(key);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Invalid key: ", e);
            return null;
        }

        Pizza cookPizza = null;

        if ( getPizza instanceof HawaiianFlavor ) {
            cookPizza = (HawaiianFlavor) pizzaCache.get(key).clone();
        } else if ( getPizza instanceof PepperoniFlavor ) {
            cookPizza = (PepperoniFlavor) pizzaCache.get(key).clone();
        }
        return cookPizza;
    }

    public static void showReceipt (Pizza pizza) {
        int totalPrice = 0;
        if ( pizza instanceof HawaiianFlavor ) {
            HawaiianFlavor price = new HawaiianFlavor();
            totalPrice = price.calculatePrice(pizza);
        } else if ( pizza instanceof PepperoniFlavor ) {
            PepperoniFlavor price = new PepperoniFlavor();
            totalPrice = price.calculatePrice(pizza);
        }
        LOGGER.log(Level.INFO,"Your order is as follows: " + pizza);
        LOGGER.log(Level.INFO,"Pizza Flavor : " + pizza.getFlavor() );
        LOGGER.log(Level.INFO,"Pizza Size : " + pizza.getSize() );
        LOGGER.log(Level.INFO,"Pizza Shape : " + pizza.getShape() );
        LOGGER.log(Level.INFO,"Pizza Crust : " + pizza.getCrust() );
        LOGGER.log(Level.INFO,"Total Price is : " + totalPrice );
    }

}
