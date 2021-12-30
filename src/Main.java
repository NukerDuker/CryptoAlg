import java.util.Arrays;
import java.util.Locale;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        String encrypt = "hello, world!";
        Encrypt test = new Encrypt(22, encrypt);
        System.out.println(test.encrypt());
        Decrypt test2 = new Decrypt(22, test.toString());
        System.out.println(test2.decrypt());
    }
}
