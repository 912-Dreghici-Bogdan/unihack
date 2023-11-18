package src.domain;

import java.util.ArrayList;

public class Disease implements Identifiable<String>{
    private String Name;
    private ArrayList<String> harmful_ingredients;
    public Disease(String Name)
    {
        this.Name = Name;
        harmful_ingredients = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<String> getHarmful_ingredients() {
        return harmful_ingredients;
    }

    public void addRestrictions(String restrictions) {
        this.harmful_ingredients.add(restrictions);
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
