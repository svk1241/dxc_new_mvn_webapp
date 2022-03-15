package com.dxc.hibernate.hibdemo2;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.dxc.hibernate.hibdemo2.entity.Book;
import com.dxc.hibernate.hibdemo2.entity.Course;
import com.dxc.hibernate.hibdemo2.entity.Department;
import com.dxc.hibernate.hibdemo2.entity.Employee;
import com.dxc.hibernate.hibdemo2.entity.Passport;
import com.dxc.hibernate.hibdemo2.entity.Person;
import com.dxc.hibernate.hibdemo2.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;


public class App 
{
    public static void main( String[] args )
    {
    	StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure().build();
    	MetadataSources sources =new MetadataSources(registry);
    	Metadata mdata =sources.getMetadataBuilder().build();
    	SessionFactory factory = mdata.buildSessionFactory();
    	Session session =factory.openSession();
    	CriteriaBuilder builder = session.getCriteriaBuilder();
    	CriteriaQuery<Long> cqry = builder.createQuery(Long.class);
    	Root<Book> root =cqry.from(Book.class);
    	cqry.select(builder.count(root));
    	List<Long> list = session.createQuery(cqry).getResultList();
        for(long l :list)
    	System.out.println(l+"Rows are there in book table");
    	
    	
        session.close();
    	factory.close();
    }
}






/*Person p =session.get(Person.class, 101);
if(p!=null)
{
	System.out.println(p.getName()+" " +p.getAge());
	System.out.println(p.getPassport().getPassportNo()+" "+p.getPassport().getIssueAuthority());
	System.out.println(p.getPassport().getIssusedDate()+" "+p.getPassport().getExpireDate());
}
Passport pp= session.get(Passport.class, "AXY321");
if(p!=null)
{
	System.out.println(pp.getIssueAuthority()+" "+pp.getIssusedDate()+" "+pp.getExpireDate());
	System.out.println(pp.getPerson().getSsn()+" "+pp.getPerson().getName()+" "+pp.getPerson().getAge());
}*/
/*Passport pport = new Passport("AXY321","GovtofIndia",LocalDate.of(2019,10,20),LocalDate.of(2029,8,20));
Person pson = new Person(102,"Eswar",35,pport); 
      session.save(pport);
    	session.save(pson);
    	session.beginTransaction().commit();*/
/*  Employee e1 = new Employee(101,"Ajay",1000);
    	Employee e2 = new Employee(102,"Eswar",1500);
    	Employee e3 = new Employee(103,"Chandu",1200);
    	Employee e4 = new Employee(104,"Dinesh",1800);
    	Employee e5 = new Employee(105,"Babu",5000);
    	ArrayList<Employee>el1 = new ArrayList<Employee>();
    	el1.add(e1); el1.add(e2);
    	Department d1 = new Department(10,"Sales","Mumbai",el1);
    	ArrayList<Employee> el2= new ArrayList<Employee>();
    	el2.add(e3); el2.add(e4); el2.add(e5);
    	Department d2 = new Department(20,"Marketing","Chennai",el2);
    	session.save(d1); session.save(d2);
    	session.save(e1);   session.save(e2);
    	session.save(e3);   session.save(e4);
    	session.save(e5);   
    	
    	
    	session.beginTransaction().commit(); */
/*   Department d = session.get(Department.class, 10);
        if(d!=null)
        {
        	System.out.println(d.getDepartmentNmae()+" "+d.getDepartmentLocation());
        	for(Employee e : d.getElist())
        	System.out.println(e.getEmployeeNo()+" "+e.getEmployeeName()+" "+e.getSalary());
        	
       }
        Employee e1 =session.get(Employee.class, 103);
        if(e1!=null)
        {
        	System.out.println("\n");
        	System.out.println(e1.getEmployeeName()+" "+e1.getSalary());
        	System.out.println(e1.getDepartment().getDepartmentNmae());
        	System.out.println(e1.getDepartment().getDepartmentLocation());
        } 
          */
/*  Student s = session.get(Student.class, 102);
    	if(s!=null)
    	{
    		System.out.println(s.getStudentName()+" "+s.getPhone());
    		for(Course c: s.getClist())
    			System.out.println(c.getCourseId()+" "+c.getCourseName()+" "+c.getDuration()+" "+c.getFee());
    		
    	}
    	Course c1 = session.get(Course.class, 7004);
    	if(c1!=null)
    	{
    		System.out.println(c1.getCourseName()+" "+c1.getDuration()+" "+c1.getFee());
    		for(Student s1: c1.getSlist())
    			System.out.println(s1.getStudentId()+" "+s1.getStudentName()+" "+s1.getPhone());
    	}
        */
/*   Query <Book> qry = session.createQuery("from Book");
    	List<Book> blist =qry.getResultList();
    	for(Book b : blist)
    		System.out.println(b.getBookId()+" "+b.getBookTitle()+ " "+b.getAuthor()+" "+b.getPrice());
    	  */
/*  Query<Person> qry = session.createQuery("from Person");
    	for(Person p : qry.list())
    	{
    		System.out.println(p.getSsn()+" "+p.getName()+" "+p.getAge());
    		System.out.println(p.getPassport().getPassportNo()+" "+p.getPassport().getExpireDate());
    		System.out.println("\n");
    	}  */
/*  Query<Department> qry = session.createQuery("from Department");
    	for(Department d : qry.list())
    	{
    		System.out.println(d.getDepartmentNo()+" "+d.getDepartmentNmae()+" "+d.getDepartmentLocation());
    		for( Employee e : d.getElist())
    		System.out.println(e.getEmployeeNo()+" "+e.getEmployeeName()+" "+e.getSalary());
    		System.out.println("\n");
    	} */
/*   Query<Student> qry = session.createQuery("from Student");
    	for(Student s : qry.list())
    	{
    		System.out.println(s.getStudentId()+" "+s.getStudentName()+" "+s.getPhone());
    		for( Course c : s.getClist())
    		System.out.println(c.getCourseId()+" "+c.getCourseName()+" "+c.getDuration());
    		System.out.println("\n");
    	} */
/*   Query<Object[]> qry = session.createQuery("select b.bookTitle,b.author,b.price from Book  b");
    	for(Object[] obj : qry.list())
    	{
    		for(int i =0;i<obj.length;i++)
    			System.out.println(obj[i]+"        ");
    		
    		System.out.println();
    	}
    	 */
/*     	//Query<Book> qry = session.createQuery("from Book b where b.subject=?1");
    	Query<Book> qry = session.createQuery("from Book b where b.subject=:subject");
    	//qry.setParameter(1, "java");
    	qry.setParameter("subject", "java");
    	for(Book b  : qry.list())
    	{
    		
    			System.out.println(b.getBookId()+"        "+b.getAuthor()+" "+b.getBookTitle()+" "+b.getPrice());
    		
    		System.out.println();
    	} */
/*  NativeQuery qry = session.createSQLQuery("select * from Book where subject =:subject");
    	qry.setParameter("subject", "java");
    	List<Object[][]> l = qry.list();
    	for(Object[]obj : l)
    	
    	{
    		for(int i =0;i<obj.length;i++)
    			System.out.print(obj[i]+"        ");
    		
    		System.out.println();
    	} */
/*  Query<Book> qry = session.createNamedQuery("getBookBySubject",Book.class);
    	qry.setParameter("sub","java");
    	for(Book b : qry.list())
    		System.out.println(b.getBookTitle()+" "+b.getAuthor()+" "+b.getPublisher()+" "+b.getPrice());
    	
    	 */
/* Query<Book> qry = session.createNamedQuery("getAllBooks",Book.class);
    	//qry.setParameter("sub","java");
    	for(Book b : qry.list())
    		System.out.println(b.getBookTitle()+" "+b.getAuthor()+" "+b.getPublisher()+" "+b.getPrice());
    	  */
/* Criteria crt = session.createCriteria(Book.class);
    	//crt.add(Restrictions.ilike("subject", "java"));
    	//crt.add(Restrictions.eq("bookTitle", "How to c++"));
    	crt.add(Restrictions.between("price", 450.0,700.0));
    	List<Book> blist =crt.list();
    	for(Book b : blist)
    		System.out.println(b.getBookTitle()+" "+b.getAuthor()+ " "+b.getPublisher()+" "+b.getPrice());
    	  */
/*	LogicalExpression leAnd = Restrictions.and(Restrictions.eq("subject","java"),Restrictions.eq("price",700.0));
crt.add(leAnd);*/
/*Criteria crt = session.createCriteria(Book.class);
//crt.add(Restrictions.ilike("subject", "java"));
//crt.add(Restrictions.eq("bookTitle", "How to c++"));
//crt.addOrder(Order.asc("bookTitle"));*/
/* LogicalExpression leOr = Restrictions.or(Restrictions.eq("subject","cpp"),Restrictions.eq("price",500.0));
    	crt.add(leOr);
    	List<Book> blist =crt.list();
    	for(Book b : blist)
    		System.out.println(b.getBookTitle()+" "+b.getAuthor()+ " "+b.getPublisher()+" "+b.getPrice());
    	 */
/*  CriteriaQuery<Book> cqry = session.getCriteriaBuilder().createQuery(Book.class);
    	Root<Book> root =cqry.from(Book.class);
    	cqry.select(root);
    	List<Book> blist = session.createQuery(cqry).list();
    	for(Book b: blist)
    		System.out.println(b.getBookId()+" "+b.getBookTitle()+" "+b.getBookTitle()+" "+b.getAuthor()+" "+b.getPublisher()+ ""+b.getPrice());
    	*/
/*  CriteriaBuilder builder = session.getCriteriaBuilder();
    	CriteriaQuery<Book> cqry = builder.createQuery(Book.class);
    	Root<Book> root =cqry.from(Book.class);
    	cqry.select(root);
    	//cqry.where(builder.equal(root.get("subject"),"java"));
    	//List<Book> blist = session.createQuery(cqry).list();
    	cqry.orderBy(builder.asc(root.get("bookTitle")));
    	List <Book>blist = session.createQuery(cqry).getResultList();
    	for(Book b: blist)
    		System.out.println(b.getBookId()+" "+b.getBookTitle()+" "+b.getBookTitle()+" "+b.getAuthor()+" "+b.getPublisher()+ ""+b.getPrice());
    	      // System.out.println(b); */