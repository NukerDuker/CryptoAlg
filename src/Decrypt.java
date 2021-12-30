public class Decrypt extends Encrypt {

    private final int key;
    private String toDecrypt;

    Decrypt(int key, String str) {
        super(key, str);
        this.key = key;
        builderStr.append("\n");
    }

    public String decrypt() {
        for (int i = 0; i < toEncrypt.length(); i++) {
            char cryptLetter = decryptLetter(toEncrypt.toLowerCase().charAt(i));
            if (cryptLetter != '/') {
                builderStr.append(cryptLetter);
            } else {
                builderStr.append('*');
            }
        }
        return builderStr.toString();
    }

    private char decryptLetter(char a) {
        int index = 0;
        for (int j = 0; j < dictionary.length; j++) {
            if (a == ' ') {
                return ' ';
            } else if (a == dictionary[j]) {
                index = j + key;
                if (index > dictionary.length - 1) {
                    index -= dictionary.length;
                }
                return dictionary[index];
            }
        }
        return '/';
    }

    @Override
    public String toString() {
        return builderStr.toString();
    }
}