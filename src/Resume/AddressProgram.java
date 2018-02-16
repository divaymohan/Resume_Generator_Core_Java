package Resume;
import java.sql.ResultSet;

import java.util.Scanner;

import Resume.AddressDao;
import Resume.Address;

public class AddressProgram
{
	public static Scanner sc = new Scanner(System.in);
	public static void acceptRecord( int choice, Addr address )
	{
		if(choice == 2){
		System.out.print("Address ID	:	");
		address.setID(sc.nextInt());
		}
		else{
		System.out.print("AddressID	:	");
		address.setID(sc.nextInt());
		System.out.print("City: "	);
		//sc.nextLine();
		address.setCity(sc.nextLine());
		System.out.print("State:  ");
		address.setState(sc.nextLine());
		System.out.print("Country : ");
		address.setCountry(sc.nextLine());
		System.out.print("Pin: ");
		address.setPin(sc.nextInt());
		System.out.print("Line1 : ");
		address.setLine1(sc.nextLine());
		System.out.print("Line2:  ");
		address.setLine2(sc.nextLine());
		}
		}
	
	public static int menuList()
	{
		System.out.println("0.Exit");
		//System.out.println("1.Search Record");
		System.out.println("1.Update Record");
		System.out.println("2.Delete Record");
		System.out.println("3.Select Record");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}	
	public static void main(String[] args)
	{		
		try( AddressDao dao = new AddressDao();)
		{
			int choice;
			Addr address = new Addr();
			while( ( choice = AddressProgram.menuList( ) ) != 0 )
			{
				switch( choice )
				{
					/*case 1:
						Program.acceptRecord(choice, student);
						dao.search(student);
						 break;*/
					case 1:
						AddressProgram.acceptRecord(choice, address);
						dao.update(address);
						break;
					case 2:
						AddressProgram.acceptRecord(choice,address);
						dao.delete(address);
						break;
					case 3:
						dao.getAddressList().forEach(System.out::println);
						break;					
				}
			}
		}
		catch(Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
