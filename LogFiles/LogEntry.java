/**
 * Write a description of LogEntry here.
 * 
 * @author MarcoSantss 
 * @version 04/11/2020
 */

import java.util.*;

public class LogEntry{
       String ipAddress;
       Date accessTime;
       String request;
       int statusCode;
       int bytesReturned;

       public LogEntry(String ipAddress, Date accessTime, String request, int statusCode, int bytesReturned){
           this.ipAddress = ipAddress;
           this.accessTime = accessTime;
           this.request = request;
           this.statusCode = statusCode;
           this.bytesReturned = bytesReturned;
       }
       
       public String getIpAddress(){
           return this.ipAddress;
       }
       
       public Date getAccessTime(){
           return this.accessTime;
       }
       
       public String getRequest(){
           return this.request;
       }
       
       public int getStatusCode(){
           return this.statusCode;
       }
       
       public int getBytesReturned(){
           return this.bytesReturned;
       }
       
       public String toString(){
           return this.ipAddress + " " + this.accessTime + " " + this.request + " " + this.statusCode + " " + this.bytesReturned;
       }
}































