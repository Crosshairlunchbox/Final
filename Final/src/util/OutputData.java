package util;




import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Output Data method is used to output/save character information to a .txt file
 * @author Mr. Chad Steffl, S02269293
 * @version 1.3, 12/11/16, Final Project, CSC 241
 */
public class OutputData {
    /**
     * PrintWriter that will be used to save data
     */
    PrintWriter pw; 
    
    /**
     * File location to save character data to.
     * File must be named "CharData.txt" for import/load to work.
     * 
     * File should be located in "util" folder with InputData file
     * As long as directory is correctly set this class will create a new
     * file named "CharData.txt" in directory
     */
    File charData = 
            new File("C:\\Users\\ZipZoomBang\\Documents\\FRCC\\CSC 241\\Final Project\\Final\\build\\classes\\util\\CharData.txt");
    /**
     * Initialize the data output by setting the .txt file location
     */
    @SuppressWarnings("CallToPrintStackTrace")
    public void initialize(){
        try {
            pw  = new PrintWriter(charData);
            charData.createNewFile();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Closes the printWriter
     */   
    public void close(){
        pw.close();
    }
    
    /**
     * Print an array of integers to file
     * @param statScores 
     */
    public void printStats(int[] statScores){
        for (int stat : statScores){
            pw.print(stat + ", ");
        }
    }
    
    /**
     * Print any single Object to file
     * @param <T>
     * @param object 
     */
    public <T> void  printObject(T object){
        pw.print(object + ", ");
    } 
}
    


