package src.domain;

public class Disease implements Identifiable<String>{
    private String Name;
    private Restrictions restrictions;


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
