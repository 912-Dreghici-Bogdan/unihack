package src.domain;

import java.util.ArrayList;

public class Disease implements Identifiable<String>{
    private String Name;
    private ArrayList<Restrictions> restrictions;
    public Disease(String Name)
    {
        this.Name = Name;
        restrictions = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Restrictions> getRestrictions() {
        return restrictions;
    }

    public void addRestrictions(Restrictions restrictions) {
        this.restrictions.add(restrictions);
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
