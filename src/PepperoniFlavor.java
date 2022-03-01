import java.util.ArrayList;
import java.util.List;

public class PepperoniFlavor extends Pizza implements Pricing{

    private List<String> toppings = new ArrayList<>();

    public PepperoniFlavor() {
        setFlavor("Pepperoni Flavor");

        toppings.add("pepperoni");
        toppings.add("tomato sauce");
        setToppings(toppings);
    }

    //can be deleted
    @Override
    void viewToppings() {
        for (String topping : getToppings()){
            System.out.println(topping); //change to logger
        }
    }

    @Override
    public int calculatePrice(Pizza pizza) {

        int price = 0;

        if (pizza.getSize() == "Solo") {
            price += 75;
        }

        if (pizza.getSize() == "Family") {
            price += 125;
        }

        if (pizza.getSize() == "Party") {
            price += 175;
        }

        switch (pizza.getShape()){
            case "Triangle":
                price += 15;
                break;
            case "Square":
                price += 25;
                break;
            default: //circle
                price += 0;
        }
        return price;
    }
}
