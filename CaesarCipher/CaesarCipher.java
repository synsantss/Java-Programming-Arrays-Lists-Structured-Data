/**
 * Write a description of CaesarCipher here.
 * 
 * @author MarcoSants 
 * @version 04/04/2020
 */

import edu.duke.*;

public class CaesarCipher {
    private String alphabetUpperCase;
    private String alphabetLowerCase;
    private String shiftedAlphabetUpperCase;
    private String shiftedAlphabetLowerCase;
    private int mainKey;
    
    public CaesarCipher(int key){
        alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabetUpperCase = alphabetUpperCase.substring(key) + alphabetUpperCase.substring(0, key);
        shiftedAlphabetLowerCase = alphabetLowerCase.substring(key) + alphabetLowerCase.substring(0, key);
        mainKey = key;
    }
    
    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            
            if (Character.getType(currChar) == Character.UPPERCASE_LETTER){
                int idx = alphabetUpperCase.indexOf(currChar);
                if (idx != -1){
                    char newChar = shiftedAlphabetUpperCase.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            } else {
                int idx = alphabetLowerCase.indexOf(currChar);
                if (idx != -1){
                    char newChar = shiftedAlphabetLowerCase.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }
    
    public int[] countLetters(String input){
        int[] count = new int[26];
        String alph = "abcdefghijklmnopqrstuvwxyz"; 
        String inputLowerCase = input.toLowerCase();
        for(int k=0; k < inputLowerCase.length(); k++){
            char ch = inputLowerCase.charAt(k);
            int index = alph.indexOf(ch);
            if (index != -1)
                count[index] += 1;
        }
        return count;
    }
    
    public int maxIndex(int[] values){
        int maxIndex = 0;
        for(int i = 0; i < values.length; i++){
            if(values[i] > values[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public String decrypt(String encrypted){
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if(maxDex < 4)
            dkey = 26 - (4 - maxDex);
            
        CaesarCipher cc = new CaesarCipher(26 - dkey); 
        return cc.encrypt(encrypted);
    }
    
    public void testCaesar(){
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        //String message1 = "At noon beeeeeeeeeee in the conference room with your hat on for a surprise party. YELL LOUD!";
        String message1 = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encrypted = encrypt(message1);
        System.out.println("encrypted: " + encrypted);
        String decrypted = decrypt(encrypted);
        System.out.println("decrypted: " + decrypted);
    }
}




















