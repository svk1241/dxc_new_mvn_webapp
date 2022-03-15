package pratice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestWord 
{ 
	public static void main(String [ ] args) throws FileNotFoundException {
    new LongestWord().findLongestWords();
}

public String findLongestWords() throws FileNotFoundException 
{

    String longest_word = "";
    String str;
    Scanner sc = new Scanner(new File("C:\\Users\\ssankarshna\\OneDrive - DXC Production\\Desktop\\plain.txt"));


  while (sc.hasNext()) 
  {
     str = sc.next();
    if (str.length() > longest_word.length()) 
    {
     longest_word = str;
    }

}
   System.out.println("\n"+longest_word+"\n");
    return longest_word;
  }
}

