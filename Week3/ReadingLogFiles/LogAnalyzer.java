
/**
 * Write a description of LogAnalyzer here.
 * 
 * @Shaoqing (your name) 
 * @Tuesday/15/Sep/2020 (a version number or a date)
 * start at 10:45AM
 * continue at 8:00AM
 * add comments, it spends me about 40 mintues
 */
import edu.duke.*;
import java.util.*;
public class LogAnalyzer {
    //think about the instance variables and use Constructor to initialize it.
    ArrayList<LogEntry> records;
    ArrayList<String> uniqueIp;
    HashMap<String, Integer> UniqueIps;
    HashMap<String, ArrayList<String>> IpsOnDays;
    public LogAnalyzer(){
        records = new ArrayList<LogEntry>();
        UniqueIps = new HashMap<String, Integer>();
        IpsOnDays = new HashMap<String, ArrayList<String>>();
        uniqueIp = new ArrayList<String>();
    }
    
    //read a file and get its all webLog
    public void readFile(){
        FileResource fr = new FileResource();
        for(String line: fr.lines()){
            LogEntry temp = WebLogParser.parseEntry(line);
            records.add(temp);
        }
    }
    
    // get the number of uniquelIps
    public int countUniqueIPs(){
        ArrayList<LogEntry> uniqueIps = new ArrayList<LogEntry>();
        for(LogEntry each: records){
            String ip = each.getIpAddress();
            if(!uniqueIps.contains(ip)){
                uniqueIps.add(each);
            }
        }
        return uniqueIps.size();
    }
    
    // print all LogEntry of records 
    public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
    }
    
    // print LogEntry whose statusCode is more than num
    public void printAllHigherThanNum(int num){
        for(LogEntry a: records){
            if(a.getStatusCode() > num){
                System.out.println(a);
            }
        }
    }
    
    //get the collection of ips of a certain day
    public ArrayList<String> uniqueIpVisitsOnDay(String someday){
        readFile();
        for(LogEntry a: records){
            String date = a.getAccessTime().toString();
            String time = date.substring(4,10);
            if(time.equals(someday)){
                if(!uniqueIp.contains(a.getIpAddress())){
                    uniqueIp.add(a.getIpAddress());   
                }
            }
        }
        return uniqueIp;
    }
    
    //get the number of uniqueIP's statusCode between low and high
    public int countUniqueIPInRange(int low, int high){
        int count = 0;
        readFile();
        for(LogEntry a: records){
            if(a.getStatusCode() >= low && a.getStatusCode() < high){
                if(!uniqueIp.contains(a.getIpAddress())){
                    count++;
                    uniqueIp.add(a.getIpAddress());
                }
            }
        }
        for(String a: uniqueIp){
            System.out.println(a);
        }
        return count;
    }
    
    //get a HashMap that maps an IP address to the number of times that IP address appears in records 
    public HashMap<String, Integer> countVisitsPerIP(){
        readFile();
        for(LogEntry a: records){
            if(!UniqueIps.containsKey(a.getIpAddress())){
                UniqueIps.put(a.getIpAddress(), 1);
            }
            else{
                UniqueIps.put(a.getIpAddress(), UniqueIps.get(a.getIpAddress()) + 1 );
            }
        }
        return UniqueIps;
    }
    
    //get the max number of ips in HashMap UniqueIps
    public int mostNumberVisitsByIP(HashMap<String, Integer> UniqueIps){
        int maxNum = 0;
        for(String Ip: UniqueIps.keySet()){
            if(UniqueIps.get(Ip) > maxNum){
                maxNum = UniqueIps.get(Ip);
            }
        }
        return maxNum;
    }
    
    //get an ArrayList of ips whose size is bigger than others
    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> UniqueIps){
        int maxNum = mostNumberVisitsByIP(UniqueIps);
        ArrayList<String> ipsMost = new ArrayList<String>();
        for(String Ip: UniqueIps.keySet()){
            if(UniqueIps.get(Ip) == maxNum){
                ipsMost.add(Ip);
            }
        }
        return ipsMost;
    }
    
    //get a HashMap that maps days to an ArrayList of ips
    
    //there are some bugs here. To be fixed
    
    /*when you write a method that is probably used by other methods, 
    you should wirte it with local variable to avoid some mistakes.
    */
    public HashMap<String, ArrayList<String>> iPsForDays(){
        ArrayList<String> days = new ArrayList<String>();
        readFile();
        for(LogEntry a: records){
            String date = a.getAccessTime().toString();
            String time = date.substring(4, 10);
            uniqueIp = uniqueIpVisitsOnDay2(time);   
            //If we want to make best use of uniqueIp, the right side should be
            // an ArrayList of ips on different days. 
            IpsOnDays.put(time, uniqueIp);
        }
        return IpsOnDays;
    }
    
    public ArrayList<String> uniqueIpVisitsOnDay2(String someday){
        ArrayList<String> ips = new ArrayList<String>();
        for(LogEntry a: records){
            String date = a.getAccessTime().toString();
            String time = date.substring(4,10);
            if(time.equals(someday)){
                    ips.add(a.getIpAddress());   
            }
        }
        //System.out.println(ips);
        return ips;
    }
    
    //get the day with most IP visits
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> IpsOnDays){
        int maxNum = 0;
        String dayOfMaxNum = "";
        for(String day: IpsOnDays.keySet()){
            if(IpsOnDays.get(day).size() > maxNum){
                maxNum =  IpsOnDays.get(day).size();
                dayOfMaxNum = day;
            }
        }
        return dayOfMaxNum;
    }
    
    //get ArrayList of ips with most visits on that day
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> IpsOnDays, String day){
        System.out.println(IpsOnDays);
        uniqueIp = IpsOnDays.get(day);
        System.out.println(uniqueIp);
        HashMap <String, Integer> ips = new HashMap <String, Integer>();
        int maxNum = 0;
        for(String a: uniqueIp){
            if(!ips.containsKey(a)){
                ips.put(a,1);
            }
            else{
                ips.put(a, ips.get(a) + 1);
            }
        }
        return iPsMostVisits(ips);
    }
}
