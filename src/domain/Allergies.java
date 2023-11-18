package src.domain;

import java.util.ArrayList;

public class Allergies implements Identifiable<ConditionType>{


    private String name;
    private ConditionType conditionType ;
    private ArrayList<String> harmful_Ingredients;
    public Allergies(String name)
    {
        this.name = name;
        harmful_Ingredients = new ArrayList<>();
        conditionType = ConditionType.Allergies;
    }
    public ArrayList<String> getHarmful_Ingredients() {
        return harmful_Ingredients;
    }

    public void setHarmful_Ingredients(ArrayList<String> harmful_Ingredients) {
        this.harmful_Ingredients = harmful_Ingredients;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public ConditionType getId() {
        return conditionType;
    }

    @Override
    public void setId(ConditionType newId) {
        this.conditionType = newId;
    }
}
