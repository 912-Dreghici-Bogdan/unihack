package src.domain;

import java.util.ArrayList;

public class Product implements Identifiable<String>{
    private String Name;
    private ArrayList<Ingredients> ingredients;
    public ArrayList<Ingredients> getIngredients() {
        return ingredients;
    }
    public void addIngredients(Ingredients ingredients) {
        this.ingredients.add(ingredients);
    }
    @Override
    public String getId() {
        return Name;
    }

    @Override
    public void setId(String newId) {
        Name = newId;
    }
}
