
/**
 * Write a description of Tester here.
 * 
 * @Shaoqing (your name) 
 * @15/09/2020 (a version number or a date)
 * start at 7:57AM
 * understand it completely at about 9:00AM
 * finished at 10:04AM
 */
import java.util.*;

public class Tester {
    LogAnalyzer la;

    public Tester() {
        la = new LogAnalyzer();
    }

    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le.toString());
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    public void testLogAnalyzer() {
        la.readFile();
        la.printAll();
    }

    public void testUniqueIp() {
        la.readFile();
        System.out.println(la.countUniqueIPs());
    }

    public void testPrintAllHigherThanNum() {
        la.readFile();
        la.printAllHigherThanNum(400);
    }

    public void testUniqueIpVisitOnDay() {
        ArrayList<String> uniqueIp = la.uniqueIpVisitsOnDay("Sep 24");
        for (String a : uniqueIp) {
            System.out.println(a);
        }
        System.out.println(uniqueIp.size());
    }

    public void testCountUniqueIPsInRange() {
        int num = la.countUniqueIPInRange(200, 299);
        System.out.println("num is " + num);
    }

    public void testCountVisitsPerIP() {
        HashMap<String, Integer> UniqueIps = la.countVisitsPerIP();
        System.out.println(UniqueIps);
    }

    public void testMostNumberVisitsByIP() {
        System.out.println("The max number is " + la.mostNumberVisitsByIP(la.countVisitsPerIP()));
    }

    public void testIPsMostVisits() {
        System.out.println("The ips are most visited are " + la.iPsMostVisits(la.countVisitsPerIP()));
    }
    
    public void testIPsForDays(){
            HashMap<String,ArrayList<String>>ips = la.iPsForDays();
            for(String a: ips.keySet()){
               System.out.println(a);
               System.out.println(ips.get(a));
               System.out.println();
            }
    }
    
    public  void testDayWithMostIPVisits(){
        HashMap<String, ArrayList<String>> IpsOnDays = la.iPsForDays();
        System.out.println(IpsOnDays);
        String day = la.dayWithMostIPVisits(IpsOnDays);
        System.out.println(day);
    }
    
    public void testIPsWithMostVisitsOnDay(){
        HashMap<String, ArrayList<String>> IpsOnDays = la.iPsForDays();
        System.out.println(la.iPsWithMostVisitsOnDay(IpsOnDays, "Sep 30"));
    }
}
