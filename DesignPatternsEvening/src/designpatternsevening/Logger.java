
package designpatternsevening;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Logger {
    
    private static PrintWriter logger;
    
    public Logger(String fileName){
        if ( logger == null ){
            try {
                logger = new PrintWriter(fileName);
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public static PrintWriter getLogger(){
        return logger;
    }
    
    
}
