
/**
 * Write a description of CodonCount here.
 * 
 * @Shaoqing (your name) 
 * @09/09/2020 (a version number or a date)
 * start at 2:05PM
 * understand the requestment  2:20PM
 */
import java.util.*;
import edu.duke.*;
public class CodonCount {
    private HashMap<String, Integer> DNA;
    public CodonCount(){
        //initialize the HashMap variable
        DNA = new HashMap<String, Integer>();
    }
    // is method will build a new map of codons mapped to
    //their counts from the string ​ dna​with the reading frame with the position ​ start​(a value of
    //0, 1, or 2).               
    public void buildCodonMap(int start, String dna){
        if(DNA != null){
            DNA.clear();
        }
        while(start + 3 < dna.length()){
            String a = dna.substring(start,start + 3);
            if(DNA.containsKey(a)){
                DNA.put(a,DNA.get(a) + 1);
            }
            else{
                DNA.put(a, 1);
            }
            start += 3;
        }
        
    }
    //Write a method named ​ getMostCommonCodon​that has no parameters. This method
    //returns a String, the codon in a reading frame that has the largest count
    public String getMostCommonCodon(){
        int maxCount = 0;
        int count = 0;
        String maxStr = "";
        for(String a: DNA.keySet()){
            count = DNA.get(a);
            if(count > maxCount){
                maxStr = a;
                maxCount = count;
            }
        }
        return maxStr;
    }
    // Write a void method named ? printCodonCounts?that has two int parameters, ? start?and
    //end? . This method prints all the codons in the HashMap along with their counts if their
    //count is between ? start?and ? end? , inclusive.
    public void printCodonCounts(int start, int end){
        int count = 1;
        for(String a: DNA.keySet()){
            if(count >= start && count <= end){
                System.out.println(a + " " + DNA.get(a));
            }
            count++;
            if(count > end){
                break;
            }
        }
    }
    //Write a tester method that prompts the user for a file that contains a DNA strand (could
    //be upper or lower case letters in the file, convert them all to uppercase, since case
    //should not matter). 
    public void tester(){
        FileResource fr  = new FileResource();
        String a = fr.asString().toLowerCase();
        buildCodonMap(0, a);
        printCodonCounts(1,100);
        String mostCommon = getMostCommonCodon();
        System.out.println("The most common word is " + mostCommon + " " + DNA.get(mostCommon));
        
        buildCodonMap(1, a);
        printCodonCounts(1,125);
        mostCommon = getMostCommonCodon();
        System.out.println("The most common word is " + mostCommon + " " + DNA.get(mostCommon));
        
        buildCodonMap(2, a);
        printCodonCounts(1,115);
        mostCommon = getMostCommonCodon();
        System.out.println("The most common word is " + mostCommon + " " + DNA.get(mostCommon));
        
    }
}
