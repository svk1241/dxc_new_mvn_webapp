package pratice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class ReadLinesFromFile 
{
	public static void main(String[] args) 
	{
		BufferedReader br =null;
		String str=" ";
		try
		{
			LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream("C:\\Users\\ssankarshna\\OneDrive - DXC Production\\Desktop\\plain.txt")));
			while (((str = reader.readLine()) != null) && reader.getLineNumber() <= 3){
                System.out.println(str);
            }
           reader.close();
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			
		}
	}

}
