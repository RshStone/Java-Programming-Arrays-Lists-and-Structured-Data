
/**
 * Write a description of Experience here.
 * 
 * @Shaoqing (your name) 
 * @01/09/2020 (a version number or a date)
 */
import java.io.*;
public class Experience {
    public String encrypt(String input, int key){
        String alphbet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted = alphbet.substring(key, 26) + alphbet.substring(0,key);
        String result = "";
        for(int i = 0; i < input.length(); i++){
            int index = alphbet.indexOf(input.charAt(i));
            if(index != -1){
                result = result + shifted.charAt(index);
            }
            else{
                index = alphbet.toLowerCase().indexOf(input.charAt(i));
                if(index != -1){
                    result = result + shifted.toLowerCase().charAt(index);
                }
                else{
                    result = result + input.charAt(i);
                }
            }
        }
        return result;
    }
    
    public void testEncrypt(){
        String input = "Can you imagine life WITHOUT the internet AND computers in your pocket?" ;
        String result = encrypt(input, 15);
        System.out.println("key is " + 15 + "\n" + result);
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        //split the input into two strings
        String one = "";
        String two = "";
        for(int i = 0; i < input.length(); i += 2){
            one = one + input.charAt(i);
        }
        for(int i = 1; i < input.length(); i += 2){
            two = two + input.charAt(i);
        }
        // encrypt two string
        one = encrypt(one, key1);
        two = encrypt(two, key2);
        // sub the two string
        //Qbkm Zgis                 "Qk gs"  "bmZi"
        String result= "";
        int length = Math.min(one.length(),two.length());
        for(int i = 0; i < length; i++){
            result = result + one.charAt(i) + two.charAt(i);
        }
        if(one.length() > length) result = result + one.substring(length,length + 1);
        if(two.length() > length) result = result + two.substring(length,length + 1);
        return result;
    }
    
    public void testEncryptTwoKeys(){
        String input = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        String result = encryptTwoKeys(input, 14, 24);
        System.out.println(result);
    }
    //Io iwjv jz dv bcm kjvammmikz mwju edbc twpz pvb wi awm v ncmxmqnm xvzog. TMGT TJCY!
}
