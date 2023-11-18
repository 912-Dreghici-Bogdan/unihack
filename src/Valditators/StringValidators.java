package src.Valditators;

public class StringValidators {
    public static boolean StringMatching(String ingredient, String harmful_ingredient) {
        if (Math.abs(ingredient.length() - harmful_ingredient.length()) > 2) {
            return false;
        }
        int differences = 0;
        for (int i = 0; i < Math.min(ingredient.length(), harmful_ingredient.length()); i++) {
            if (ingredient.charAt(i) != harmful_ingredient.charAt(i)) {
                differences++;
            }
            if (differences > 2)
                return false;

        }
        return true;
    }
}
