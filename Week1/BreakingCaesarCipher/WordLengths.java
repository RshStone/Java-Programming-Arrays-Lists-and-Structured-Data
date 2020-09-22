
/**
 * Write a description of Part1 here.
 * 
 * @Shaoqing (your name) 
 * @01/09/2020 (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class WordLengths {
    public void countWordLengths(FileResource resource, int[] counts){
        for(String word: resource.words()){
            int length = word.length();
            System.out.println(word);
            if(word.length() == 1 && Character.isLetter(word.charAt(0)) ){
                counts[1]++;
            }
            else if(word.length() == 1 && !Character.isLetter(word.charAt(0))){
                counts[0]++;
            }
            else if(!Character.isLetter(word.charAt(0)) && !Character.isLetter(word.charAt(length-1))){
                counts[length-2]++;
            }
            
            else if(!Character.isLetter(word.charAt(0)) || !Character.isLetter(word.charAt(length-1))){
                counts[length-1]++;
            }
            else{
                counts[length]++;
            }
        }
        for(int i = 0; i < counts.length; i++){
            System.out.println("count[" + i + "]" + counts[i]);
        }
    }
    
    public int indexOfMax(int[] counts){
        int index = 0;
        int maxValue = 0;
        for(int i = 0; i < counts.length; i++){
            if(maxValue == 0 ){
                maxValue = counts[i];
            }
            if(counts[i] > maxValue){
                maxValue = counts[i];
                index = i;
            }
        }
        return index;
    }
    public void test1(){
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        countWordLengths(resource, counts);
        int index = indexOfMax(counts);
        System.out.println("Max of index is " + index);
    }
}
