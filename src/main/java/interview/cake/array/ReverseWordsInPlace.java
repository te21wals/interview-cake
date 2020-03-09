package interview.cake.array;

public class ReverseWordsInPlace {
    public static void reverseCharsInPlace(char[] letters,
                                           int startIndx,
                                           int finishIndx) {
        int i = startIndx;
        int j = finishIndx;

        while (i < j) {
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
            i++;
            j--;
        }
    }

    public static void reverseCharsInPlace(char[] letters) {
        reverseCharsInPlace(letters, 0, letters.length - 1);
    }

    public static void reverseWordsInPlace(char[] letters) {
        // reverse the whole arr of chars to get reversed word spacing correct
        reverseCharsInPlace(letters);

        int startOfWordIndex = 0;
        for (int i = 0; i <= letters.length; i++) {
            if (i == letters.length || letters[i] == ' ') {
                reverseCharsInPlace(letters, startOfWordIndex, i -1);
                startOfWordIndex = i + 1;
            }
        }
    }

    public static void main(String[] args) {
        char[] input = "window that up open you dont".toCharArray();
        reverseWordsInPlace(input);
        System.out.println(input);
    }
}
