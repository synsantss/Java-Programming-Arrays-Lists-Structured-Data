/**
 * Write a description of class Tester here.
 * 
 * @author MarcoSantss 
 * @version 04/11/2020
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le.toString());
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
       LogAnalyzer logAnalyzer = new LogAnalyzer(); 
       logAnalyzer.readFile("short-test_log");
       logAnalyzer.printAll();
    }
    
    public void testUniqIP(){
         LogAnalyzer logAnalyzer = new LogAnalyzer(); 
         logAnalyzer.readFile("weblog2_log");
         int uniqueIPs = logAnalyzer.countUniqueIPs();
         System.out.println("There are " + uniqueIPs + " IPs");
    }
    
    
    public void testPrintAllHigherThanNum(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log");
        logAnalyzer.printAllHigherThanNum(200);
    }
    
    public void testUniqueIPVisitsOnDay(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog2_log");
        String day = "Sep 24";
        ArrayList<String> days = new ArrayList<String>();
        days = logAnalyzer.uniqueIPVisitsOnDay(day);
        System.out.println(days.size());
        for (int i = 0; i < days.size() ; i++)
            System.out.println(days.get(i));
    }
    
    public void testCountUniqueIPsInRange(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog2_log");
        System.out.println("countUniqueIPsInRange: " + logAnalyzer.countUniqueIPsInRange(200,299));
    }
    
    public void testCountVisitPerIPStats(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog2_log");
        HashMap<String, Integer> counts = logAnalyzer.countVisitPerIP();
        System.out.println("countVisitPerIP: " + counts);
        System.out.println("mostNumberVisitsByIP: " + logAnalyzer.mostNumberVisitsByIP(counts));
        System.out.println("iPsMostVisits: " + logAnalyzer.iPsMostVisits(counts));
    }
    
    public void testIPsForDaysStats(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog2_log");
        HashMap<String, ArrayList<String>> iPsDays = logAnalyzer.iPsForDays();
        System.out.println("iPsForDays: " + iPsDays);
        System.out.println("dayWithMostIPVisits: " + logAnalyzer.dayWithMostIPVisits(iPsDays));
    }
}



































