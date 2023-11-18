package src.service;
import src.Valditators.CredentialValidators;
import src.Valditators.StringValidators;
import src.domain.*;
import src.repository.*;

import java.util.ArrayList;

public class service {
    private DiseaseRepo diseases;
    //private IngredientsRepo ingredients;
    private UserRepo users;
    private MedicamentationRepo medicamentationRepo;
    public boolean checkProduct(int user_id, ArrayList<String> product_ingredients)
    {
        for(User user : users.getAllItems())
        {
            if(user.getId() == user_id)
            {
                for(String ingredient : product_ingredients)
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
     public boolean checkMedicamentation(User user, String ingredient)
     {
         for(Medicamentation med : user.getMedicamentation().getAllItems())
             for(String harmful_ingredients : med.getHarmfulIngredients())
                 {
                     StringValidators.StringMatching(ingredient,harmful_ingredients);
                     if(ingredient.equalsIgnoreCase(harmful_ingredients))
                         return false;
                 }
         return true;
     }
    public boolean checkDiseases(User user, String ingredient)
    {
        for(Disease disease : user.getDisease().getAllItems())
            for(String harmful_ingredients : disease.getHarmful_ingredients())
            {
                StringValidators.StringMatching(ingredient,harmful_ingredients);
                if (harmful_ingredients.equalsIgnoreCase(ingredient))
                    return false;
            }
        return true;
    }
    private static String encrypt(String plainText, int shift)
    {
        StringBuilder encryptedText = new StringBuilder();
        for(char character : plainText.toCharArray())
        {

            if(Character.isLetter(character))
            {
                char encryptedChar = (char) ('A' + (character - 'A' + shift) % 26);
                encryptedText.append(encryptedChar);
            }
            else {
                encryptedText.append(character);
            }
        }
        return encryptedText.toString();
    }
    private static String decrypt(String encryptedText, int shift)
    {
        return encrypt(encryptedText,-shift);
    }

}
