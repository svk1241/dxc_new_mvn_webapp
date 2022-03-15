package pratice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppendText 
{
	public static void main(String[] args) 
	{
	 StringBuilder sb = new StringBuilder();
     try
       {
     	 
           
          String filename= "C:\\Users\\ssankarshna\\OneDrive - DXC Production\\Desktop\\plain.txt";
          FileWriter fw = new FileWriter(filename,true); 
          fw.write("java is a platform independent");
          fw.close();
        
          
        }
        catch(IOException ioe)
        {
         System.err.println("IOException: " + ioe.getMessage());
        }
     }
	

}
