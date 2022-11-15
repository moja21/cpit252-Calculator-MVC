package calculator;

import java.io.IOException;

import java.io.PrintWriter;
import java.io.FileWriter;

public class Logger {

    
    private static final String logFile = "output.txt";
    private static Logger instance = null;
    private static PrintWriter writer;
  
    private Logger(){

    }
    
    public static Logger log() {
        try {
            if (instance == null) {
                FileWriter fw = new FileWriter(logFile);
                writer = new PrintWriter(fw, true);
                instance = new Logger();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return instance;
    }

    public void info(String output) {
        writer.println("output is : "+ output);
    }

    public void error(String message) {
        writer.println("Error: " + message);
    }
}