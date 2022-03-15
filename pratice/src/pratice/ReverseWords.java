package pratice;

public class ReverseWords 
{
	public void reverseWordsInSentence(String s)
	{
		String strWords[]= s.split(" ");
		String rev= " ";
		for(String sw:strWords)
		{
			StringBuilder sb = new StringBuilder(sw);
			//System.out.print(sb.reverse()+ " ");
			sb =sb.reverse();
			//rev += sb.toString() + " ";
			System.out.print(sb+" ");
		}
		
		
	}


public static void main(String args[])
{
	String str = "This is a test string";
	System.out.println("The given string is:" +str);
	System.out.print("The string reversed word by word is:"  );
	ReverseWords rw = new ReverseWords();
	rw.reverseWordsInSentence(str);
	
	
}
}