
/**
 * Write a description of WordsInFiles here.
 * 
 * @shaoqing (your name) 
 * @09/09/2020 (a version number or a date)
 * start at 4:11PM
 * understand this assignment 4:30PM
 * pause at 5:14PM
 * continue from 1:10PM 
 * read some articles 1:36PM
 * finished at 2:13PM
 */
import edu.duke.*;
import java.io.File;
import java.util.*;


public class WordsInFiles {
    private HashMap<String, ArrayList<String>> Map;
    public WordsInFiles(){
        Map = new HashMap<String, ArrayList<String>>();
    }
    //Write a private void method named ​ addWordsFromFile​that has one parameter ​ f​of
    //type File. This method should add all the words from ​ f​into the map.
    public void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        for(String word: fr.words()){
            if(!Map.containsKey(word)){
                ArrayList<String> file = new ArrayList<String>();
                file.add(f.getName());
                Map.put(word,file);
            }
            else{
                // it is not easy to readble
                (Map.get(word)).add(f.getName());
                Map.put(word,Map.get(word));
            }
            
        }
    }
    //Write a void method named ​ buildWordFileMap​that has no parameters. This method
    //first clears the map, and then uses a DirectoryResource to select a group of files.
    public void buildWordFileMap(){
        Map.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    //Write the method ​ maxNumber​that has no parameters. This method returns the
    //maximum number of files any word appears in, considering all words from a group of
    //files.
    public int maxNumber(){
        int maxNum = 0;
        String word = "";
        for(String s: Map.keySet()){
            ArrayList a = Map.get(s);
            if(a.size() > maxNum){
                maxNum = a.size();
                word = s;
            }
        }
        System.out.println("Word: " + word + "maxNum: " + maxNum);
        return maxNum;
    }
    //Write the method ​ wordsInNumFiles​that has one integer parameter called ​ number​ .
    //This method returns an ArrayList of words that appear in exactly ​ number​files.
    public ArrayList wordsInNumFiles(int number){
        ArrayList<String> word = new ArrayList<String>();
        for(String s: Map.keySet()){
            if(number == Map.get(s).size() ){
                word.add(s);
            }
        }
        return word;
    }
    //Write the void method ​ printFilesIn​that has one String parameter named ​ word​ . This
    //method prints the names of the files this word appears in, one filename per line.
    public void printFilesIn(String word){
        ArrayList file = Map.get(word);
        for(int i = 0; i < file.size(); i++){
            System.out.println(file.get(i));
        }
    }
    //Write the void method ​ tester​that has no parameters.
    public void tester(){
        buildWordFileMap();
        System.out.println("Size " + Map.size());
        /*int maxNum = maxNumber();
        ArrayList <String> a = wordsInNumFiles(maxNum);
        System.out.println(a.size());
        for(int i = 0; i < a.size(); i++){
            System.out.println(a.get(i));
            printFilesIn(a.get(i));
        }
        */
        /*
        int count = 0;
        for(String s: Map.keySet()){
            if(Map.get(s).size() == 4){
                count++;
            }
        }
        System.out.println(count);
        */
        printFilesIn("tree");
    }
    
}
