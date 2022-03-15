package pratice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRW 
{
	public static void main(String[] args) 
	{
		  StringBuilder sb = new StringBuilder();
	        String strLine = "";
	        try
	          {
	        	  FileReader reader = new FileReader("C:\\\\Users\\\\ssankarshna\\\\OneDrive - DXC Production\\\\Desktop\\\\plain.txt");
	              int character;
	   
	              while ((character = reader.read()) != -1) {
	                  System.out.print((char) character);
	              }
	             String filename= "C:\\Users\\ssankarshna\\OneDrive - DXC Production\\Desktop\\plain.txt";
	             FileWriter fw = new FileWriter(filename,true); 
	             fw.write("java is a platform");
	             fw.close();
	           
	              reader.close();
	           }
	           catch(IOException ioe)
	           {
	            System.err.println("IOException: " + ioe.getMessage());
	           }
	        }
		
	}



