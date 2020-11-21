/**
 * Write a description of CaesarCipher here.
 * 
 * @author MarcoSants 
 * @version 04/05/2020
 */

import edu.duke.*;

public class CaesarCipherTwo {
    private String alphabetUpperCase;
    private String alphabetLowerCase;
    private String shiftedAlphabetUpperCaseKey1;
    private String shiftedAlphabetLowerCaseKey1;
    private String shiftedAlphabetUpperCaseKey2;
    private String shiftedAlphabetLowerCaseKey2;
    private int key1;
    private int key2;
    
    public CaesarCipherTwo(int key1, int key2){
        alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabetUpperCaseKey1 = alphabetUpperCase.substring(key1) + alphabetUpperCase.substring(0, key1);
        shiftedAlphabetLowerCaseKey1 = alphabetLowerCase.substring(key1) + alphabetLowerCase.substring(0, key1);
        shiftedAlphabetUpperCaseKey2 = alphabetUpperCase.substring(key2) + alphabetUpperCase.substring(0, key2);
        shiftedAlphabetLowerCaseKey2 = alphabetLowerCase.substring(key2) + alphabetLowerCase.substring(0, key2);
        key1 = key1;
        key2 = key2;
    }
       
    public String encryptTwoKeys (String input){
        StringBuilder encrypted = new StringBuilder(input);        
       
        for (int i = 0; i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            
            if (Character.getType(currChar) == Character.UPPERCASE_LETTER){
                int idx = alphabetUpperCase.indexOf(currChar);
                if (idx != -1 && i % 2 == 0){
                    char newChar = shiftedAlphabetUpperCaseKey1.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                } else if (idx != -1 && i % 2 != 0){
                    char newChar = shiftedAlphabetUpperCaseKey2.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            } else {
                int idx = alphabetLowerCase.indexOf(currChar);
                if (idx != -1 && i % 2 == 0){
                    char newChar = shiftedAlphabetLowerCaseKey1.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                } else if(idx != -1 && i % 2 != 0){
                    char newChar = shiftedAlphabetLowerCaseKey2.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }
    
    public int[] countLetters(String input){
        int[] count = new int[26];
        String inputLowerCase = input.toLowerCase();
        for(int k=0; k < inputLowerCase.length(); k++){
            char ch = inputLowerCase.charAt(k);
            int index = alphabetLowerCase.indexOf(ch);
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
    
    public String halfOfString(String message, int start){
        StringBuilder messageSelected = new StringBuilder();   
        for(int k=0; k < message.length(); k++){
            if (k % 2 == start){
                messageSelected.append(message.charAt(k));
            }
        }
        return messageSelected.toString();
    }
    
    public int getKey(String s){
        int[] letters = countLetters(s); 
        int maxDex = maxIndex(letters);
        int dkey = maxDex - 4;
        if(maxDex < 4)
            dkey = 26 - (4 - maxDex);
        return dkey;
    }
    
    public String decryptTwoKeys(String encrypted){
        String part1 = halfOfString(encrypted, 0);
        String part2 = halfOfString(encrypted, 1);
        int keyPart1 = getKey(part1);
        int keyPart2 = getKey(part2);
        System.out.println("Key 1: " + keyPart1 + "\nKey 2: " + keyPart2);
        
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - keyPart1, 26 - keyPart2); 
        return cc.encryptTwoKeys(encrypted);
    }
    
    public void testEncryptTwoKeys(){
        FileResource fr = new FileResource();
        String message1 = fr.asString();
        //String message1 = "At noon beeeeeeeeeee in the conference room with your hat on for a surprise party. YELL LOUD!";
        //String message1 = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        String encrypted = encryptTwoKeys(message1);
        //System.out.println("encrypted: " + encrypted);
        String decrypted = decryptTwoKeys(message1);
        System.out.println("decrypted: " + decrypted);
    }
    
    public void testHalfOfString(){
        System.out.println(halfOfString("Qbkm Zgis", 0));
        System.out.println(halfOfString("Qbkm Zgis", 1));
    }
}




















