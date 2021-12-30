public class Encrypt {

    private final Character[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private final Integer[] integers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final int key;
    private final StringBuilder builderStr;

    public Encrypt(int key, String str) {
        this.key = key;
        builderStr = new StringBuilder();
        builderStr.append("\n");
        encrypt(str);
    }

    public String encrypt (String str){
        for (int i = 0; i < str.length(); i++){
            char cryptLetter = changeLetter(str.toLowerCase().charAt(i));
            if (cryptLetter != '/'){
                builderStr.append(cryptLetter);
            } else {
                builderStr.append('*');
            }
        }
        return builderStr.toString();
    }

    private char changeLetter(char a){
        int index = 0;
        for (int j = 0; j < letters.length; j++){
            if ( a == ' ') {
                return ' ';
            } else if (a == letters[j]){
                index = j - key;
                if (index < 0){
                    index = letters.length - 1 + index;
                }
                return letters[index];
            }
        }
        return '/';
    }

    @Override
    public String toString () {
        return builderStr.toString();
    }

    public class Decrypt{

        private final int key;

        Decrypt (int key, String str){
            this.key = key;
            builderStr.append("\n");
            decrypt(str);
        }

        public String decrypt(String str){
            for (int i = 0; i < str.length(); i++) {
                char cryptLetter = decryptLetter(str.toLowerCase().charAt(i));
                if (cryptLetter != '/'){
                    builderStr.append(cryptLetter);
                }
            }
            return builderStr.toString();
        }

        private char decryptLetter(char a) {
            int index = 0;
            for (int j = 0; j < letters.length; j++){
                if ( a == ' ') {
                    return ' ';
                } else if (a == letters[j]){
                    index = j + key;
                    if (index > letters.length - 1){
                        index -= letters.length - 1;
                    }
                    return letters[index];
                }
            }
            return '/';
        }

        @Override
        public String toString () {
            return builderStr.toString();
        }
    }
}
