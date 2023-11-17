package src.domain;

import java.util.ArrayList;

public class Restrictions {
    // for example gluten free, vegan , etc
    private ArrayList<String> harmful_ingredients;
    private String Name;
    public Restrictions(String Name)
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

    public Restrictions()
    {
        harmful_ingredients = new ArrayList<>();
    }
    public void addRestrictons(String restrictons) {
        this.harmful_ingredients.add(restrictons);
    }
    public ArrayList<String> getHarmful_ingredients()
    {
        return harmful_ingredients;
    }
}
