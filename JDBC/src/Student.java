public class Student 
{ 
	int sId;
	String sName;
	int m1,m2,m3;
	double avg =0; 
	
	public Student()
	{
		
	}

	public Student(int sId, String sName, int m1, int m2, int m3) {
		
		this.sId = sId;
		this.sName = sName;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		
	}

	public String getResults()
	{
		avg= (m1+m2+m3)/3 ;
		if(avg>=40)
		{
			System.out.println("passed");
		}
			else
			{
				System.out.println("failed");
			}
		return sName;
		}
	
   public String getDivisions()
   {
	   if(avg>=90)
	   {
		   System.out.println("first class");
	   }
	   else if(avg<90 &avg>=70)
	   {
		   System.out.println("second class");
	   }
	   else if(avg<70&avg>=50)
	   {
		   System.out.println("third class");
	   }
	   else if(avg<50 & avg>=40)
	   {
		   System.out.println("fourth class");
		   
	   }
	   else
	   {
		   System.out.println("null");
	   }
	return sName;
	   
   }

   }
