package src.domain;

import java.util.ArrayList;

public class Ingredients implements Identifiable<String>{
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
