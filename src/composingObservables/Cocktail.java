package composingObservables;

import java.util.ArrayList;
import java.util.List;

// This class can be used for the illustration of the zip() operator

public class Cocktail {

    private List<Drink> ingredients =  new ArrayList<>();

    public void addIngredient(Drink drink){
         ingredients.add(drink);
    }

    public List<Drink> getIngredients(){
        return ingredients;
    }
}
