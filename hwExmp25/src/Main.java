import exeption.WrongLoginException;
import exeption.WrongPasswordException;

import java.util.SplittableRandom;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello SkyPRO!");
        String login = "java_skypro_go";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";
        System.out.println(verifyLoginAndPassword(login,password,confirmPassword));

    }

    public static boolean verifyLoginAndPassword(String login, String password,String confirmPassword) {
        boolean lengthPassword;
        boolean lengthConfirmPassword;
        boolean verifyLoginByCharacters;
        boolean verifyPasswordByCharacters;
        boolean verifyLengthLogin;
        boolean checkPasswordMatches;

        try {
            verifyLoginByCharacters = verifyLoginAndPasswordByCharacters(login);
            verifyPasswordByCharacters = verifyLoginAndPasswordByCharacters(password);
            lengthPassword =  verifyLengthPasswordAndConfirmPassword(password);
            lengthConfirmPassword = verifyLengthPasswordAndConfirmPassword(confirmPassword);
            verifyLengthLogin = verifyLengthLogin(login);
            checkPasswordMatches = checkPasswordMatches(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;

        }
        return verifyLoginByCharacters && verifyPasswordByCharacters
                && lengthPassword && lengthConfirmPassword
                &&verifyLengthLogin && checkPasswordMatches;
    }

    public static boolean verifyLoginAndPasswordByCharacters(String loginOrPassword) {   //проверка логина и пароля на  латинские буквы, цифры и знак подчеркивания
        if (loginOrPassword == null) {
            throw new NullPointerException("Введите логин/пароль");
        }
        if (loginOrPassword.matches("\\w*")) {
            return true;
        }
        throw new NullPointerException(String.format("Введен некорректный символ - '%s'\n", loginOrPassword));

    }

    public static boolean verifyLengthPasswordAndConfirmPassword(String passwordAndConfirmPassword) throws WrongPasswordException {  //Проверка на длинну пароля
        if (passwordAndConfirmPassword.length() >= 20) {
            throw new WrongPasswordException("Превышенна длинна значения пароля");
        }
        return true;

    }

    public static boolean verifyLengthLogin(String login) throws WrongLoginException {  //Проверка на длинну логина
        if (login.length() > 20) {
            throw new WrongLoginException("Превышенна длинна значения логина");
        }
        return true;
    }

    public static boolean checkPasswordMatches(String password, String confirmPassword) {  //Проверка совпадения паролей
        if (password.equals(confirmPassword)){
            return true;
        }
        throw new RuntimeException("Пароли не совпадают");
    }
}