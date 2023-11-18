package src.domain;

import java.util.ArrayList;

public class Medicamentation implements Identifiable<String>{
    private String Name;
    private ArrayList<String> harmful_ingredients;

    public ArrayList<String> getHarmfulIngredients() {
        return harmful_ingredients;
    }
    public void addHarmfulIngredient(String Harmful_ingredient) {
        this.harmful_ingredients.add(Harmful_ingredient);
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
