/**
 * Write a description of WordPlay here.
 * 
 * @author MarcoSants 
 * @version 04/04/2020
 */

public class WordPlay {
    private static String vowels = "AEIOUaeiou";
    
    public boolean isVowel(char ch){
        return (vowels.indexOf(ch) >= 0); 
    }
    
    public String replaceVowels(String phrase, char ch){
        StringBuilder phraseChanged = new StringBuilder(phrase);
        for (int i=0; i<phraseChanged.length(); i++){
            char currChar = phraseChanged.charAt(i);
            if (isVowel(currChar))
                phraseChanged.setCharAt(i, ch);
        }
        return phraseChanged.toString();
    }
    
    public String emphasize(String phrase, char ch){
        StringBuilder phraseChanged = new StringBuilder(phrase);
        for (int i=0; i<phraseChanged.length(); i++){
            char currChar = phraseChanged.charAt(i);
            if (currChar == ch && i % 2 == 0)
                phraseChanged.setCharAt(i, '*');
            else if (currChar == ch && i % 2 != 0) 
                phraseChanged.setCharAt(i, '+');
        }
        return phraseChanged.toString();
    }
    
    public void testIsVowel(){
        char noVowel = 'f';
        char vowel = 'i';
        System.out.println("Is Vowel " + noVowel + " ? " + isVowel(noVowel));
        System.out.println("Is Vowel " + vowel  + " ? " + isVowel(vowel));
    }
    
    public void testReplaceVowels(){
        String phrase = "Hello World";
        char ch = '*';
        System.out.println(replaceVowels(phrase, ch));
    }
    
        public void testEmphasize(){
        String phrase = "Mary Bella Abracadabra";
        char ch = 'a';
        System.out.println(emphasize(phrase, ch));
    }
}
