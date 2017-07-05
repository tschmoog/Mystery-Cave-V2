import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;

/**
 * UserLog maintains a record of the players journey through Mystery Cave and writes this to a text file. 
 * 
 * @author 163318
 * @version 2.0
 */
public class UserLog
{
    int i; 
    /**
     * Constructor for objects of class UserLog 
     * Initialises the move count to 1 when called. 
     */
    public UserLog()
    {
        int i = 1;

    }

    /**
     * writeToFile writes input string to an external text file. 
     * 
     * @param  x   a string to be written to the file 
     */
    public void writeToFile(String x)
    {
        try{
            File text = new File("Journey.txt");
            FileWriter fw = new FileWriter(text, true); 
            PrintWriter pw = new PrintWriter(fw);
            pw.append("\nMove " + i + ": ");
            i = i + 1;
            pw.append(x);
            pw.close();
        }catch (IOException e) {
            System.out.println("USER LOG ERROR!!!");        
        }

    }
}
