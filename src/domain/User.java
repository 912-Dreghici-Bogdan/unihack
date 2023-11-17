package src.domain;

public class User implements Identifiable<Integer> {
    private Integer id;
    private String email_adress;
    private String username;
    private UserType type;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String name;
    private String lastName;
    private Disease disease;
    private Restrictions restrictions;
    private Medicamentation medicamentation;

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    public Medicamentation getMedicamentation() {
        return medicamentation;
    }

    public void setMedicamentation(Medicamentation medicamentation) {
        this.medicamentation = medicamentation;
    }

    public String getEmail_adress() {
        return email_adress;
    }

    private String password;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer newId) {
        id = newId;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setEmail_adress(String email_adress)
    {
        this.email_adress = email_adress;
    }
    public void update_credentials(String name, String email_adress)
    {
        this.name = name;
        this.email_adress = email_adress;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return password;
    }
}
