import java.util.HashMap;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final HashMap<String, Pizza> pizzaCache = new HashMap<>();

    public static void main(String[] args) {
        Pizza order = new PepperoniFlavor();
        order.setShape("Circle");
        order.setSize("Family");
        order.setCrust("Hand-tossed");

        pizzaCache.put(order.getFlavor(), order);

        order = new HawaiianFlavor();
        order.setShape("Square");
        order.setSize("Party");
        order.setCrust("Thin");

        pizzaCache.put(order.getFlavor(), order);

        order = new PepperoniFlavor();
        order.setShape("Triangle");
        order.setSize("Solo");
        order.setCrust("Thin");
        pizzaCache.put("P1", order);

        HawaiianFlavor hawaiianClone = (HawaiianFlavor) pizzaCache.get("Hawaiian Flavor").clone();



        LOGGER.info("===================Original Objects=====================");
        LOGGER.info("Original: " + pizzaCache.get("Hawaiian Flavor"));
        LOGGER.info("Original Size: " + pizzaCache.get("Hawaiian Flavor").getSize());


        LOGGER.info("===================Clone=====================");
        LOGGER.info("Cloned: " + hawaiianClone);
        LOGGER.info("Cloned Size: " + hawaiianClone.getSize());


        LOGGER.info("===================Pricing=====================");
        HawaiianFlavor pricingHawaiian = new HawaiianFlavor();
        LOGGER.info("Original Price (Hawaiian): " + pricingHawaiian.calculatePrice(pizzaCache.get("Hawaiian Flavor")));
        LOGGER.info("Clone Price (Hawaiian): " + pricingHawaiian.calculatePrice(hawaiianClone));

        PepperoniFlavor pricingPepperoni = new PepperoniFlavor();
        LOGGER.info("Original Price (Pepperoni): " + pricingPepperoni.calculatePrice(pizzaCache.get("Pepperoni Flavor")));
        LOGGER.info("P1 price: " + pricingPepperoni.calculatePrice(pizzaCache.get("P1")));

    }
}
