package Resume;

import java.util.Scanner;

import Resume.UDao;
import Resume.UserLogin;

public class UserProgram
{
	public static Scanner sc = new Scanner(System.in);
	public static void acceptRecord( int choice, Login login )
	{
		/*if(choice==3 || choice == 2){
		System.out.print("UserID	:	");
		login.setID(sc.nextInt());
		}*/
		if( choice == 1)
		{
			System.out.print("UserName	:	");
			//sc.nextLine();
			login.setUsername(sc.next());
			System.out.print("Password	:	");
			login.setPassword(sc.next());
			System.out.print("Role	:	");
			login.setRole(sc.next());
		}
		else{
			System.out.println("UserName : ");
			login.setUsername(sc.next());
		}
	}
	public static int menuList()
	{
		System.out.println("0.Exit");
		System.out.println("1.Register Record");
		System.out.println("2.Validate Record");
		/*System.out.println("3.Delete Record");
		System.out.println("4.Select Record");*/
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}	
	public static void main(String[] args)
	{		
		
		try( UserDAO dao = new UserDAO();)
		{
			int choice;
			Login login = new Login();
			while( ( choice = UserProgram.menuList( ) ) != 0 )
			{
				switch( choice )
				{
					case 1:
						UserProgram.acceptRecord(choice, login);
						dao.RegisterUser(login);
						 break;
					case 2:
						UserProgram.acceptRecord(choice, login);
						String Test = dao.loginValidate(login.getUsername());
						if(Test != ""){
							System.out.println(Test);
							System.out.println("Email Is Exists..!!");
						}
						else{
							System.out.println("Invalid UserName..!!");
						}
						
						break;
					/*case 3:
						UserProgram.acceptRecord(choice, login);
						dao.delete(login);
						break;
					case 4:
						dao.getUsersList().forEach(System.out::println);
						break;*/					
				}
			}
		}
		catch(Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
