/**
 * Write a description of LogAnalyzer here.
 * 
 * @author MarcoSantss 
 * @version 04/11/2020
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer {
   private ArrayList<LogEntry> records;
   
   public LogAnalyzer(){
       records = new ArrayList<LogEntry>();
   }
   
   public void readFile(String fileName){
       FileResource resource = new FileResource(fileName);
       WebLogParser logParser = new WebLogParser();
       for(String line : resource.lines()){
          LogEntry parsedEntry = logParser.parseEntry(line);
          records.add(parsedEntry);
       }
        
   }
   
   public int countUniqueIPs(){
       ArrayList<String> uniqueIPs = new ArrayList<String>();
       for (LogEntry le : records){
           String ipAddr = le.getIpAddress();
           if (!uniqueIPs.contains(ipAddr))
                uniqueIPs.add(ipAddr);
       }
       return uniqueIPs.size();
   }
   
   public void printAllHigherThanNum(int num){
       for (LogEntry le : records){
           int statusCode = le.getStatusCode();
           if (statusCode > num)
                System.out.println(le);
       }
   }
   
   public ArrayList uniqueIPVisitsOnDay(String someday){
       ArrayList<String> uniqueIPVisits = new ArrayList<String>();
       for (LogEntry le : records){          
           Date dat = le.getAccessTime();
           String dayString = dat.toString();
           if (dayString.contains(someday))
                uniqueIPVisits.add(dayString);
       }
       return uniqueIPVisits;
   }
   
   public int countUniqueIPsInRange(int low, int high){
       ArrayList<LogEntry> ipsInRange = new ArrayList<LogEntry>();
       for (LogEntry le : records){
           int statusCode = le.getStatusCode();
           if (low <= statusCode && statusCode <= high)
                ipsInRange.add(le);
       }
       
       ArrayList<String> uniqueIPs = new ArrayList<String>();
       for (LogEntry le : ipsInRange){
           String ipAddr = le.getIpAddress();
           if (!uniqueIPs.contains(ipAddr))
                uniqueIPs.add(ipAddr);
       }
       return uniqueIPs.size();
   }
   
   public void printAll(){
         for (LogEntry le : records) {
             System.out.println(le);
         }
   }
   
   public HashMap<String, Integer> countVisitPerIP(){
       HashMap<String, Integer> counts = new HashMap<String, Integer>();
       for (LogEntry le : records) {
           String ip = le.getIpAddress();
           if(!counts.containsKey(ip)){
               counts.put(ip, 1);
           } else {
               counts.put(ip, counts.get(ip) + 1);
            }
       }
       return counts;
   }
   
   public int mostNumberVisitsByIP(HashMap<String, Integer> counts){
       return Collections.max(counts.values());
   }
   
   public ArrayList<String> iPsMostVisits(HashMap<String, Integer> counts){
       int numberVisits = mostNumberVisitsByIP(counts);
       ArrayList<String> iPs = new ArrayList<String>();
       for (Map.Entry<String, Integer> entry : counts.entrySet()) {    
           if(entry.getValue() == numberVisits)
              iPs.add(entry.getKey());          
       }
       return iPs;
   }
   
   public HashMap<String, ArrayList<String>> iPsForDays () {
        HashMap<String, ArrayList<String>> activity = new HashMap<String, ArrayList<String>>();
        for (LogEntry le : records) {
           Date date = le.getAccessTime();
           String day = date.toString().substring(4,10);
           ArrayList<String> today = activity.getOrDefault(day, new ArrayList<String>());
           today.add(le.getIpAddress());
           activity.put(day, today);
        }
        return activity;
    }
   
   public String dayWithMostIPVisits (HashMap<String, ArrayList<String>> byDays) {
        if (byDays == null || byDays.isEmpty()) return "";
        String dayWithMostVisits = "";
        for (String day : byDays.keySet()) {
            if (byDays.get(day).size() > byDays.getOrDefault(dayWithMostVisits, new ArrayList<String>()).size()) {
                dayWithMostVisits = day;
            }
        }
        return dayWithMostVisits;
    }
}


































