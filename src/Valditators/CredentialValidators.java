package src.Valditators;
import src.domain.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CredentialValidators {
    public static void validate_password(String password)
    {
        if(password.length() < 8)
            throw new IllegalArgumentException("Password must be at least 8 characters long!");
        if(!containsUppercase(password))
        {
            throw  new IllegalArgumentException("Password must contain at least one uppercase letter");
        }
        if(!containsSpecialCharacter(password))
        {
            throw new IllegalArgumentException("Password must contain at least one special character (!@#$%^&*(),.?:{}|<>)");
        }
    }
    private static boolean containsUppercase(String password) {
        for (char character : password.toCharArray()) {
            if (Character.isUpperCase(character)) {
                return true;
            }
        }
        return false;
    }
    private static boolean containsSpecialCharacter(String password) {
        Pattern specialCharacterPattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
        Matcher matcher = specialCharacterPattern.matcher(password);
        return matcher.find();
}

}
