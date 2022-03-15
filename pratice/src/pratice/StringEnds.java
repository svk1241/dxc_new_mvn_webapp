package pratice;

public class StringEnds 
{
	public boolean ends(String s)
	{
		int len=s.length();
		//System.out.println(len);
		String ng="ng";
		if(len<2)
			return false;
		else if(ng.equals(s.substring(len-2,len)))
			return true;
		else
			return false;
		
	}
	public static void main(String[] args)
	{
		String str ="strings";
		StringEnds se =new StringEnds();
		System.out.println("The given strings is:"+str);
		System.out.println("The string containing ng at last: "+se.ends(str));
		
		
		
	}

}
