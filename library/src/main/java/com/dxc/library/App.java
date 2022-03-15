package com.dxc.library;
import java.util.Scanner;
import com.dxc.library.ui.BookUI;
import com.dxc.library.ui.MemberUI;
import com.dxc.library.ui.TransactionUI;
public class App
{
	public static void main(String[ ] args)
	{
		Scanner sc = new Scanner(System.in);
		mainMenu(sc);
	}
	public static void mainMenu(Scanner sc)
	{
	    while(true)
		{
	    	System.out.println("-------------D X C L I B R A R Y-----------");
			System.out.println("1. Book Menu");
			System.out.println("2. Member Menu");
			System.out.println("3. Check In");
			System.out.println("4. Check Out");
			System.out.println("5. E X I T");
			System.out.print("Select Your option :-  ");
			int opt = sc.nextInt();
			sc.nextLine();
			switch(opt)
			{
				case 1:
					bookMenu(sc);
					break;
				case 2:
					memberMenu(sc);
					break;
				case 3:
					checkInMenu(sc);
					break;
				case 4:
					checkOutMenu(sc);
					break;
				case 5:
					System.exit(1);
				default:
					System.out.println("Enter Correct Option Between 1 - 5");
			}
		}
	}
	public static void bookMenu(Scanner sc)
	{
		System.out.println("-------------D X C L I B R A R Y-----------");
		System.out.println("1. Add a new Book");
		System.out.println("2. Delete a Existing Book");
		System.out.println("3. Modify an Existing Book");
		System.out.println("4. Show an Book Details");
		System.out.println("5. Show All Books Details");
		System.out.println("6. Back to Main Menu");
		System.out.print("Select Your Option :- ");
		int opt = sc.nextInt();
		sc.nextLine();
		switch(opt)
		{
		   case 1:
			  System.out.println(BookUI.addBookDetails(sc));
			   break;
		   case 2:
			  System.out.println(BookUI.deleteBook(sc));
			   break;
		   case 3:
			  System.out.println(BookUI.modifyBook(sc));
			   break; 
		   case 4:
			   BookUI.showBookDetails(sc);
			   break;
		   case 5:
			   BookUI.showAllBooks();
			   break;
		   case 6:
			   return;
		  default :
			  System.out.println("Please enter Correct option between 1-6");
		}
	}
	public static void memberMenu(Scanner sc)
	{
		System.out.println("-------------D X C L I B R A R Y-----------");
		System.out.println("1. Add a new member");
		System.out.println("2. Delete a Existing Member");
		System.out.println("3. Modify an Existing Member");
		System.out.println("4. Show an Member Details");
		System.out.println("5. Show All Members Details");
	    System.out.println("6. Back to Main Menu");
	    int opt =sc.nextInt();
	    sc.nextLine();
	    switch(opt)
	    {
	    case 1:
	    	System.out.println(MemberUI.insertMemberDetails(sc));
	    	break;
	    case 2:
	    	System.out.println(MemberUI.deleteMemberDetails(sc));
	    	break;
	    case 3:
	    	System.out.println(MemberUI.modifyMemberDetails(sc));
	    	break;
	    case 4:
	    	MemberUI.showMemberDetails(sc);
	    	break;
	    case 5:
	    	MemberUI.showAllMembersDetails();
	    	break;
	    case 6:
	    	return;
	    	default:
	    		System.out.println("please enter option  between  1 to 6");
	    
	    	
	    	
	    
	    }
	}
	
	public static void checkInMenu(Scanner sc)
	{
		System.out.println(TransactionUI.issueBookTransaction(sc));
		
	}
	public static void checkOutMenu(Scanner sc)
	{
		System.out.println(TransactionUI.returnBookTransaction(sc));
		
	}
}