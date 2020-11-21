/**
 * Write a description of WordFrequencies here.
 * 
 * @author MarcoSants 
 * @version 04/08/2020
 */

import edu.duke.*;
import java.util.ArrayList;
import java. util.Collections;

public class CharactersInPlay {
    
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public CharactersInPlay(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void update (String person){
            person = person.toLowerCase();
            int index = myWords.indexOf(person);
            if (index == -1){
                myWords.add(person);
                myFreqs.add(1);
            } else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value + 1);
            }
    }
    
    public void findAllCharacters(){
        FileResource resource = new FileResource();
        for(String s : resource.lines()){
            int index = s.indexOf(".");
            if (index != -1){
                update(s.substring(0, index));
            } 
        }
    }
        
    public void charactersWithNumParts(int num1, int num2){
        for(int i = 0; i < myWords.size(); i++){
            if(myFreqs.get(i) >= num1 && myFreqs.get(i) <= num2)
                System.out.println("Selected: " + i + ": " + myFreqs.get(i) + " - " + myWords.get(i));
        }
    }
    
    public void test(){
        int num1 = 10;
        int num2 = 15;
        findAllCharacters();
        for(int i = 0; i < myWords.size(); i++){
            System.out.println(i + ": " + myFreqs.get(i) + " - " + myWords.get(i));
        }
        charactersWithNumParts(num1, num2);
        myWords.clear();
        myFreqs.clear();
    }
}
