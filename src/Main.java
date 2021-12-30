import java.util.Arrays;
import java.util.Locale;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        String res = "I love u";
        Encrypt test = new Encrypt(5, res);
        System.out.println(res);
        Encrypt.Decrypt test2 = test.new Decrypt(5, test.toString());
        System.out.println(test2);
    }
}
