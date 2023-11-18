
import src.domain.Disease;
import src.domain.User;
import src.repository.DiseaseRepo;

public class main {
    public static void main(String[] args) {
        User user1 = new User("Matei", "MiRau", "mancatias@HAzu.com", "Miraut", 1);
        String restriction = "Gluten";
        Disease glutens = new Disease("gluten free");
        glutens.addRestrictions(restriction);
        DiseaseRepo diseases = new DiseaseRepo();
        diseases.addItem(glutens);
        user1.setDisease(diseases);
        user1.printuser();
    }

}
