
/**
 * Write a description of WordPlay here.
 * 
 * @Shaoqing(your name) 
 * @30/08/2020 (a version number or a date)
 */
import java.io.*;
public class WordPlay {
    public boolean isVowel(char ch){
        String vowel = "aeiouAEIOU";
        if(vowel.indexOf(ch) != -1){
            return true;
        }
        return false;
    }
    public String replaceVowels(String phrase, char ch){
        StringBuilder replace = new StringBuilder(phrase);
        for(int i = 0; i < replace.length(); i++){
            if(isVowel(replace.charAt(i)) == true){
                replace.setCharAt(i, ch);
            }
        }
        return replace.toString();
    }
    public void testReplaceVowels(){
        System.out.println(replaceVowels("Hello World", '*'));
    }
    
    //in StringBuilder Class indexOf(String,int) is not indexOf(char,int)
    //in String Class, it's ok.
    //找两个数的话不如遍历再判断来得简单干脆
     public String emphasize(String phrase, char ch){
        StringBuilder emphasize = new StringBuilder(phrase);
        for (int i = 0; i < emphasize.length(); i++){
            if (emphasize.charAt(i) == ch || emphasize.charAt(i) == Character.toUpperCase(ch)){
                if (i % 2 == 0){
                    emphasize.setCharAt(i, '*');
                }
                else{
                    emphasize.setCharAt(i, '+');
                }
            }
        }
        return emphasize.toString();
    }
    public void testEmphasize(){
        System.out.println(emphasize("Mary Bella Abracadabra",'a'));
        
        //System.out.println(emphasize("Mary Bella Abracadabra",'a'               ));
    }

}
