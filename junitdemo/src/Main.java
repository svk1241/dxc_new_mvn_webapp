import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
public class Main 
{
    public static void main(String[] args)
    {
    	List<Integer> list = Arrays.asList(2,3,4,5,6);
      	list.stream().map(x->x*x).forEach(System.out::println);
    }
}













/*import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main 
{
public static void main(String[] args) 
{
	  List<Integer> list = Arrays.asList(100,20,30,40);
	  List<Integer> sortedList =list.stream().sorted().collect(Collectors.toList());
	  for(int i : sortedList)
		  System.out.println(i);
	}

} */
