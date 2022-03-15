import graphics.Circle;
import graphics.FirstImpl;
import com.dxc.bean.Employee;
public class MyFirstJava {

	public static void main(String[] args) 
	{
		System.out.println("hello");
		Circle c =new Circle(5.4);
		System.out.println(c.area());
		FirstImpl fi=new FirstImpl();
		System.out.println(fi.sum(20, 30));
		System.out.println(fi.sqr(5));
		Employee e=new Employee();
		/*System.out.println(e.setEmpid(26));
		System.out.println(e.getEmpid());
		System.out.println(e.getName());
		System.out.println(e.getSalary()); */
		
	

	}

}
