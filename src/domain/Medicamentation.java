package src.domain;

public class Medicamentation implements Identifiable<String>{
    private String Name;

    @Override
    public String getId() {
        return Name;
    }

    @Override
    public void setId(String newId) {
        Name = newId;
    }
}
