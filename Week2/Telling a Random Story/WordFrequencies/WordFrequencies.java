
/**
 * Write a description of WordFrequencies here.
 * 
 * @shaoqing (your name) 
 * @08/09/2020 (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class WordFrequencies {
    private ArrayList<String>myWords;
    private ArrayList<Integer>myFreqs;
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    // use findUnique method to store the words to myWords, myFreqs
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String word: fr.words()){
            word = word.toLowerCase();
            if(!myWords.contains(word)){
                myWords.add(word);
                myFreqs.add(1);
            }
            else{
                int index = myWords.indexOf(word);
                int curNum = myFreqs.get(index);
                myFreqs.set(index,curNum + 1);
            }
        }
        int maxIndex = 0;
        int max = 0;
        String maxStr = "";
        for(int i = 0; i < myWords.size(); i++){
            if(maxStr == ""){
                maxStr = myWords.get(i);
            }
            else if(myFreqs.get(i) > max){
                max = myFreqs.get(i);
                maxIndex = i;
                maxStr = myWords.get(i);
            }
        }
        System.out.println("Unique words: " + myWords.size());
        System.out.printf("index:%d words:%s how many times: %d", maxIndex, maxStr, max);
    }
    
    public void test(){
        findUnique();
    }
}    
    
