package Resume;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Resume.Student_Dao;
import Resume.StudentInfo;

public class StudentProgram
{
	public static Scanner sc = new Scanner(System.in);
	public static void acceptRecord( int choice, Student student ) throws ParseException
	{
		//SimpleDateFormat sd=new SimpleDateFormat("DD/MM/YYYY"); 
		if(choice == 3 || choice == 1){
		System.out.print("StudentID	:	");
		student.setStudentId(sc.nextInt());}
		else{
		System.out.print("StudentID	:	");
		student.setStudentId(sc.nextInt());
		System.out.print("FIRST_NAME: "	);
		//sc.nextLine();
		student.setFirstName(sc.next());
		System.out.print("Middle_Name: ");
		student.setMiddleName(sc.next());
		System.out.print("Last_Name	: ");
		student.setLastName(sc.next());
		System.out.print("Mobile No	: ");
		student.setMobileNo(sc.nextInt());
		System.out.print("Birth_Date	: ");
		java.util.Date ud = new java.util.Date(sc.next());
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("YYYY-MM-dd HH:MM:SS");
		String date=sdf.format(ud);
		student.setBirthDate(date);
		System.out.print("Hobbies: ");
		student.setHobby(sc.next());
		System.out.print("Company: ");
		student.setCompany(sc.next());
		System.out.print("Placed_Date: ");
		java.util.Date ud1 = new java.util.Date(sc.next());
		java.text.SimpleDateFormat sdf1=new java.text.SimpleDateFormat("YYYY-MM-dd HH:MM:SS");
		String date1=sdf1.format(ud1);
		student.setPlaceDate(date1);
		}
		}
	
	public static int menuList()
	{
		System.out.println("0.Exit");
		System.out.println("1.Search Record");
		System.out.println("2.Update Record");
		System.out.println("3.Delete Record");
		System.out.println("4.Select Record");
		System.out.println("5.GetUser Record");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}	
	public static void main(String[] args)
	{		
		try( Student_Dao dao = new Student_Dao();)
		{
			int choice;
			Student student = new Student();
			while( ( choice = StudentProgram.menuList( ) ) != 0 )
			{
				switch( choice )
				{
					case 1:
						StudentProgram.acceptRecord(choice, student);
						dao.search(student);
						 break;
					case 2:
						StudentProgram.acceptRecord(choice, student);
						dao.update(student);
						break;
					case 3:
						StudentProgram.acceptRecord(choice, student);
						dao.delete(student);
						break;
					case 4:
						dao.getStudentList().forEach(System.out::println);
						break;
						
					case 5:
						String Test = dao.getUser("Divay");
						if(Test != ""){
							System.out.println("ID is : " + Test);
						}
						else{
							System.out.println("Id Not Exists..!!");
						}
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
