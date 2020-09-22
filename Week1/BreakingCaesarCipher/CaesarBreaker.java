
/**
 * Write a description of CaesarBreaker here.
 * 
 * @Shaoqing (your name) 
 * @01/09/2020 (a version number or a date)
 */
import edu.duke.*;
public class CaesarBreaker {
    
    //Decrypts a message that was encrypted with one key, using statistical letter frequencies of English text. 
    
    // Write the method halfOfString in the CaesarBreaker class that has two parameters, 
    //a String parameter named message and an int parameter named start. 
    //This method should return a new String that is every other character from message starting with the start position. 
    //For example, the call halfOfString(“Qbkm Zgis”, 0) returns the String “Qk gs” and the call halfOfString(“Qbkm Zgis”, 1) returns the String “bmZi”.
    public String halfOfString(String message, int start){
        String result = "";
        for(int i = start; i < message.length(); i += 2){
            result = result + message.charAt(i);
        }
        return result;
    }
    public int [] countLetters(String message) {
        int [] counters = new int [26];
        for (int i = 0; i < 26; i++) {
            counters[i] = 0;
        }
        System.out.println(counters);
        String alph = "abcdefghijklmnopqrstuvwxyz";
        message = message.toLowerCase();
        for (int i = 0; i < message.length(); i++) {
            int position = alph.indexOf(message.charAt(i));
            if (position != -1) counters[position] += 1;
        }
        return counters;
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
    public String decrypt(String message) {
        Experience cc = new Experience();
        int[] freqs = countLetters(message);
        int maxDex = indexOfMax(freqs);
        int dkey = maxDex-4;
        if (dkey < 0) dkey = 26 - (4 - maxDex);
        return cc.encrypt(message, 26-dkey);
}
    public void testdecrypt() {
        Experience cc = new Experience();
        String message = cc.encrypt("Let's have a teeeeeeest!", 17);
        System.out.println(message);
        message = decrypt(message);
        System.out.println(message);
        
    }
    // Write the method getKey in the CaesarBreaker class that has one parameter, a String s. 
    // This method should call countLetters to get an array of the letter frequencies in String s and 
    //then use maxIndex to calculate the index of the largest letter frequency, which is the location of the encrypted letter ‘e’, 
    //which leads to the key, which is returned.
    public int getKey(String s) {
        int [] freqs = countLetters(s);
        int maxDex = indexOfMax(freqs);
        int dkey = maxDex-4;
        if (dkey < 0) dkey = 26 - (4 - maxDex);
        return dkey;
    }
    // Write the method decryptTwoKeys in the CaesarBreaker class that has one parameter, 
    //a String parameter named encrypted that represents a String that was encrypted with the two key algorithm discussed in the previous lesson. 
    //This method attempts to determine the two keys used to encrypt the message, prints the two keys, 
    //and then returns the decrypted String with those two keys. 
    public String decryptTwoKeys(String encrypted) {
        Experience cc = new Experience();
        String part_1 = halfOfString(encrypted, 0);
        String part_2 = halfOfString(encrypted, 1);
        
        int dkey2 = getKey(part_2);
        int dkey1 = getKey(part_1);
        
        System.out.println("The two keys are " + dkey1 + " and " + dkey2);
        
        String newinput1 = cc.encrypt(part_1, 26-dkey1);
        String newinput2 = cc.encrypt(part_2, 26-dkey2);
        
        int n1 = newinput1.length();
        int n2 = newinput2.length();
        String newinput = new String();
        if (n1 > n2) {
            for (int i = 0; i < n2; i++) {
                newinput = newinput + newinput1.substring(i, i+1);
                newinput = newinput + newinput2.substring(i, i+1);
            }
            newinput = newinput + newinput1.substring(n1-1, n1);
        }
        
        if (n1 == n2) {
            for (int i = 0; i < n2; i++) {
                newinput = newinput + newinput1.substring(i, i+1);
                newinput = newinput + newinput2.substring(i, i+1);
            }
        }
        
        if (n1 < n2) {
            for (int i = 0; i < n1; i++) {
                newinput = newinput + newinput1.substring(i, i+1);
                newinput = newinput + newinput2.substring(i, i+1);
            }
            newinput = newinput + newinput2.substring(n2-1, n2);
        }
        
        return(newinput);
    }
    
    public void testdecryptTwoKeys() {
        /*Experience cc = new Experience();
        FileResource fr = new FileResource();
        String encrypted =fr.asString();*/
        String encrypted = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        System.out.println(decryptTwoKeys(encrypted));
        
        
        //String encrypted = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        //System.out.println(decryptTwoKeys(encrypted));
        
    }
}
