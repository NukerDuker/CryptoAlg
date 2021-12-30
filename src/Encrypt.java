public class Encrypt {

    protected final Character[] dictionary = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', ',','.','!','?','&','.', ' '};
    private final int key;
    protected final StringBuilder builderStr;
    protected String toEncrypt;

    public Encrypt(int key, String str) {
        this.key = key;
        this.toEncrypt = str;
        builderStr = new StringBuilder();
        builderStr.append("\n");
    }


    public String encrypt() {
        for (int i = 0; i < toEncrypt.length(); i++) {

            char cryptLetter = toEncrypt.toLowerCase().charAt(i);

            if (contains(cryptLetter)) {

                cryptLetter = changeLetter(cryptLetter);
                if (cryptLetter == '#') {
                    builderStr.append('*');
                } else {
                    builderStr.append(cryptLetter);
                }

            }

        }
        return builderStr.toString();
    }

    private char changeLetter(char a) {

        int index = 0;

        for (int j = 0; j < dictionary.length; j++) {

            if (a == ' ') {
                return ' ';
            } else if (a == dictionary[j]) {
                index = j - key;
                if (index < 0) {
                    index += dictionary.length;
                }
                return dictionary[index];
            }

        }
        return '#';
    }

    public boolean contains(char letter) {

        for (Character character : dictionary) {

            if (character == letter) {
                return true;

            }
        }
        return false;
    }

    @Override
    public String toString() {
        return builderStr.toString();
    }
}
