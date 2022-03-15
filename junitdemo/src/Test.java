import com.dxc.demo.Utility;
public class Test {
public static void main(String[] args) 
{
		Utility u =new Utility();
		assert u.sum(10, 20)==30 :  "sum did not return expected  value 40";
		System.out.println(u.sum(10, 20)==30);
		System.out.println(u.sum(10, -20)==-10);
		System.out.println(u.sum(-10, 20)==10);
		System.out.println(u.sum(-10, -20)==-30);
		System.out.println(u.sqr(10)==100);
       // System.out.println(u.power(5, 3)==125);
	}

}
