package pratice;

import java.util.Arrays;

public class RemoveDuplicates 
{
	public static void main(String[] args) 
	{
		int [] a= {3,5,2,3,6,8,5,3,1};
		Arrays.sort(a);//12333568
		int len=a.length;
		int[] temp =new int[a.length];
		int j=0;
		for(int i=0; i<len-1;i++)
		{
			if(a[i]!=a[i+1])
			{
				temp[j]=a[i];
			j++;
			}
		}
			temp[j++]=a[len-1];
			for(int k=0;k<j;k++)
			{
				System.out.println(temp[k]);
			}
			
		}
		
	}


