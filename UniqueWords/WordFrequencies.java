/**
 * Write a description of WordFrequencies here.
 * 
 * @author MarcoSants 
 * @version 04/08/2020
 */

import edu.duke.*;
import java.util.ArrayList;
import java. util.Collections;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        for(String s : resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
            } else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value + 1);
            }
        }
    }
    
    public int findIndexOfMax (){
        Integer maxVal = Collections.max(myFreqs);
        Integer maxIdx = myFreqs.indexOf(maxVal);
        return maxIdx;
    }
    
    public void testFindUnique(){
        findUnique();
        System.out.println("# unique words: " + myWords.size());
        for(int i = 0; i < myWords.size(); i++){
            System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));
        }
        int index = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: " + myWords.get(index) + " -> " + myFreqs.get(index));
    }
}


























