package src.domain;

import src.repository.DiseaseRepo;
import src.repository.MedicamentationRepo;

public class User implements Identifiable<Integer> {
    private Integer id;
    private String email_address;
    private String username;
    private UserType type;
    private String name;
    private String lastName;
    private DiseaseRepo disease;
    //private Restrictions restrictions;
    private MedicamentationRepo medicamentation;
    public User(String name, String lastName, String email_address,String username,int id)
    {
        this.name = name;
        this.lastName = lastName;
        this.email_address = email_address;
        this.username = username;
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DiseaseRepo getDisease() {
        return disease;
    }

    public void setDisease(DiseaseRepo disease) {
        this.disease = disease;
    }


    public MedicamentationRepo getMedicamentation() {
        return medicamentation;
    }

    public void setMedicamentation(MedicamentationRepo medicamentation) {
        this.medicamentation = medicamentation;
    }

    public String getEmail_adress() {
        return email_address;
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
    public void setEmail_address(String email_address)
    {
        this.email_address = email_address;
    }
    public void update_credentials(String name, String email_adress)
    {
        this.name = name;
        this.email_address = email_adress;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return password;
    }
    public void printuser()
    {
        System.out.println("Name:" + name + lastName);
        System.out.println("email:" + email_address);
        System.out.println("username:" + username);
        System.out.println("identification number:" + id);
        for(Disease disease : this.disease.getAllItems())
        {
            System.out.println("diseas: " + disease.getId() + " with restrictions:");
            for(Restrictions restriction : disease.getRestrictions())
            {
                System.out.println("    -" + restriction.getName());
                System.out.println("Containing harmful ingredients : ");
                for(String ingredient : restriction.getHarmful_ingredients())
                {
                    System.out.println("Ingredient : " + ingredient);
                }
            }

        }
    }
}
