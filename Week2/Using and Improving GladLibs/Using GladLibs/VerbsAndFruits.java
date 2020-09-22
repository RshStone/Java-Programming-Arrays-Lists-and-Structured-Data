
/**
 * Write a description of VerbsAndFruits here.
 * 
 * @shaoqing(your name) 
 * @09/09/2020 (a version number or a date)
 * start at 7:46am
 * I had though I finished at 8:31am but actually I was wrong.
 * The new ArrayList spent me almost 45 minutes to do it.
 * finished at 9:15am.
 */
import java.util.*;
import edu.duke.*;

public class VerbsAndFruits {
    private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    // add two ArrayList<String> verb and fruit
    private ArrayList<String> verbList;
    private ArrayList<String> fruitList;
    private ArrayList<String> tempList ;

    
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public VerbsAndFruits(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        tempList = new ArrayList<String>();
    }
    
    public VerbsAndFruits(String source){
        initializeFromSource(source);
        myRandom = new Random();
        tempList = new ArrayList<String>();
    }
    
    private void initializeFromSource(String source) {
        adjectiveList= readIt(source+"/adjective.txt"); 
        System.out.println("The adj size is " + adjectiveList.size());
        nounList = readIt(source+"/noun.txt");
        colorList = readIt(source+"/color.txt");
        countryList = readIt(source+"/country.txt");
        nameList = readIt(source+"/name.txt");      
        animalList = readIt(source+"/animal.txt");
        timeList = readIt(source+"/timeframe.txt");
        verbList = readIt(source + "/verb.txt");
        fruitList = readIt(source + "/fruit.txt");
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if (label.equals("country")) {
            return randomFrom(countryList);
        }
        if (label.equals("color")){
            return randomFrom(colorList);
        }
        if (label.equals("noun")){
            return randomFrom(nounList);
        }
        if (label.equals("name")){
            return randomFrom(nameList);
        }
        if (label.equals("adjective")){
            return randomFrom(adjectiveList);
        }
        if (label.equals("animal")){
            return randomFrom(animalList);
        }
        if (label.equals("timeframe")){
            return randomFrom(timeList);
        }
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        if (label.equals("verb")){
            return randomFrom(verbList);
        }
        if(label.equals("fruit")){
            return randomFrom(fruitList);
        }
        return "**UNKNOWN**";
    }
    
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);

        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        if(tempList == null){
            tempList.add(sub);
        }
        else{
            while(tempList.indexOf(sub) != -1){
                prefix = w.substring(0,first);
                suffix = w.substring(last+1);
                sub = getSubstitute(w.substring(first+1,last));
            }
            tempList.add(sub);
        }
        System.out.println("The size of tempList is " + tempList.size());
        
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate("datalong/madtemplate2.txt");
        /*
        System.out.println("The replaced words are =======");
        for(int i = 0; i <tempList.size(); i++ ){
            System.out.println(tempList.get(i));
        }
        System.out.println("The number of replaced words are " + tempList.size());
        tempList.clear();
        */
        printOut(story, 60);
    }
    

}
