import java.util.Arrays;
import java.util.Locale;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        String encrypt = "Designed to teach you the most up-to-date IT (information technology)-related words and expressions. This exercise is on computer programming terminology.\n";
        Encrypt test = new Encrypt(5, encrypt);
        System.out.println(test.encrypt());
        Decrypt test2 = new Decrypt(5, test.toString());
        System.out.println(test2.decrypt());
    }
}
