package src.service;
import src.domain.*;
import src.repository.*;
public class service {
    private DiseaseRepo diseases;
    //private IngredientsRepo ingredients;
    private UserRepo users;
    private ProductRepo products;
    private MedicamentationRepo medicamentationRepo;
    public boolean checkProduct(int user_id, Product product)
    {
        for(User user : users.getAllItems())
        {
            if(user.getId() == user_id)
            {
                for(Ingredients ingredient : product.getIngredients())
                {
                    if(!checkDiseases(user,ingredient))
                        return false;
                    if(!checkMedicamentation(user,ingredient))
                        return false;
                }
                break;
            }
        }
        return true;
    }
     public boolean checkMedicamentation(User user, Ingredients ingredient)
     {
         for(Medicamentation med : user.getMedicamentation().getAllItems())
             for(Restrictions restriction : med.getRestrictions())
                 for(String harmful_ingredients : restriction.getHarmful_ingredients())
                 {
                     if(ingredient.getId() == harmful_ingredients)
                         return false;
                 }
         return true;
     }
    public boolean checkDiseases(User user, Ingredients ingredient)
    {
        for(Disease disease : user.getDisease().getAllItems())
            for(Restrictions restriction : disease.getRestrictions())
            {
                for(String harmful_ingridients : restriction.getHarmful_ingredients())
                    if (harmful_ingridients == ingredient.getId())
                        return false;
            }
        return true;
    }

}
