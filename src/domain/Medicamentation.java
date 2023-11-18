package src.domain;

import java.util.ArrayList;

public class Medicamentation implements Identifiable<ConditionType>{
    private ConditionType conditionType ;
    private String Name;
    private ArrayList<String> harmful_ingredients;
    public Medicamentation(String name, ArrayList<String> Harmful_ingredients)
    {
        conditionType = ConditionType.Medication;
        Name = name;
        harmful_ingredients = Harmful_ingredients;
    }

    public ArrayList<String> getHarmfulIngredients() {
        return harmful_ingredients;
    }
    public void addHarmfulIngredient(String Harmful_ingredient) {
        this.harmful_ingredients.add(Harmful_ingredient);
    }


    @Override
    public ConditionType getId() {
        return conditionType;
    }

    @Override
    public void setId(ConditionType newId) {
        conditionType = newId;
    }
}
