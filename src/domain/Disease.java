package src.domain;

public class Disease implements Identifiable<String>{
    private String Name;
    private Restrictions restrictions;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
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
