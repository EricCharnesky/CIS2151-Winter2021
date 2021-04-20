
package designpatterns;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    
    private static FileWriter fileWriter = null;
    private static PrintWriter printWriter = null;
    
    public static void log(String message){
        if ( printWriter == null ){
            try {
                fileWriter = new FileWriter("log.txt");
                printWriter = new PrintWriter(fileWriter, true);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        
        printWriter.println(message);
        
    }
    
}
