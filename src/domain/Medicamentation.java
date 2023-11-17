package src.domain;

import java.util.ArrayList;

public class Medicamentation implements Identifiable<String>{
    private String Name;
    private ArrayList<Restrictions> restrictions;

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
