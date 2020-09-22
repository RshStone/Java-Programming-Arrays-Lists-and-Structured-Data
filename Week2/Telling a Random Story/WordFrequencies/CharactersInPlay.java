
/**
 * Write a description of CharactersInPlay here.
 * 
 * @shaoqing (your name) 
 * @08/09/2020 (a version number or a date)
 * strat1:53pm 2:05 understand this assignment 
 * 2:16 know each method I should write
 * 2:42finished
 */ 
import java.util.*;
import edu.duke.*;
public class CharactersInPlay {
    private ArrayList<String> charName;
    private ArrayList<Integer> charNum;
    
    public CharactersInPlay(){
        charName = new ArrayList<String>();
        charNum = new ArrayList<Integer>();
    }
    public void update(String person){
        if(charName.contains(person)){
            int index = charName.indexOf(person);
            int num = charNum.get(index);
            charNum.set(index,num + 1);
        }
        else{
            charName.add(person);
            charNum.add(1);
        }
    }
    public void findAllCharacters(){
        FileResource fr = new FileResource();
        for(String line: fr.lines()){
            if(line.indexOf(".") != -1){
                int index = line.indexOf(".");
                String name = line.substring(0,index);
                update(name);
            }
        }
    }
    public void tester(){
        findAllCharacters();
        int maxTime = 0;
        String str = "";
        for(int i = 0; i < charName.size(); i++){
            System.out.println("Character:" + charName.get(i) + "|||| charNum: " + charNum.get(i));
        }
        System.out.println("=========");
        /*for(int i = 0; i < charName.size(); i++){
            if(charNum.get(i) > maxTime){
                maxTime = charNum.get(i);
                str = charName.get(i);
            }
        }
        System.out.println("The most speaking part in the file is "+ str + " " + maxTime);*/
        charactersWithNumParts(10, 15);
    }
    public void charactersWithNumParts(int num1, int num2){
        for(int i = 0; i < charName.size(); i++){
            if( num2 >= charNum.get(i) && charNum.get(i) >= num1){
                System.out.println("Character:" + charName.get(i) + "|||| charNum: " + charNum.get(i));
            }
        }
    }
}
