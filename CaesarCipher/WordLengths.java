/**
 * Write a description of WordLengths here.
 * 
 * @author MarcoSants 
 * @version 04/04/2020
 */

import edu.duke.*;
import java.util.Collections;

public class WordLengths {
    public int[] countWordLengths(FileResource resource, int[] counts){
        for(String s : resource.words()){
            int lengthString = s.length();
            if(!Character.isLetter(s.charAt(0)))
               lengthString -= 1;
            if(!Character.isLetter(s.charAt(s.length()-1)))
               lengthString -= 1;
            
            if (lengthString < 0)
                continue;
            if (lengthString >= 30)
                counts[30]++;
            else
                counts[lengthString]++; 
        }
        return counts;
    }
    
    public int indexOfMax(int[] values){
        int maxIndex = 0;
        int maxValue = values[maxIndex];
        for(int i = 0; i < values.length; i++){
            if(values[i] > maxValue){
                maxValue = values[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public void testCountWordLengths(){
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        countWordLengths(fr, counts);
        for(int i = 0; i < counts.length; i++)
            System.out.println(i + " : " + counts[i]);
        System.out.println("Max index : " + indexOfMax(counts));
    }
}
