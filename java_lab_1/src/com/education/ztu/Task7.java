package com.education.ztu;

public class Task7 {
    public static void LatinAlphabet () {
        char[] latinAlphabet = generateLatinAlphabet();
        displayCharacterCodes(latinAlphabet);
    }

    private static char[] generateLatinAlphabet() {
        char[] alphabet = new char[26];
        char currentChar = 'A';
        for (int i = 0; i < 26; i++) {
            alphabet[i] = currentChar;
            currentChar++;
        }
        return alphabet;
    }

    private static void displayCharacterCodes(char[] alphabet) {
        for (char ch : alphabet) {
            System.out.println(ch + " ==> " + (int) ch);
        }
    }
}
