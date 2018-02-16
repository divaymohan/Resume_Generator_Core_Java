package Resume;
import java.sql.ResultSet;

import java.util.Scanner;

import Resume.SubjectDao;
import Resume.Subject;

public class SubjectProgram
{
	public static Scanner sc = new Scanner(System.in);
	public static void acceptRecord( int choice, Sub subject )
	{
		if(choice == 3 || choice == 1){
		System.out.print("SubjectID	:	");
		subject.setID(sc.nextInt());}
		else{
			if(choice !=5){
		System.out.print("SubjectID	:	");
		subject.setID(sc.nextInt());
		}
		System.out.print("Name: "	);
		//sc.nextLine();
		subject.setName(sc.next());
		System.out.print("Semester: ");
		subject.setSemester(sc.next());
		System.out.print("Stream: ");
		subject.setStream(sc.next());
		System.out.print("MaxMark");
		subject.setMaxMarks(sc.nextInt());
		System.out.print("Type	: ");
		subject.setType(sc.next());
		}
		}
	
	public static int menuList()
	{
		System.out.println("0.Exit");
		System.out.println("1.Search Record");
		System.out.println("2.Update Record");
		System.out.println("3.Delete Record");
		System.out.println("4.Select Record");
		System.out.println("5.Insert Record");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}	
	public static void main(String[] args)
	{		
		try( SubjectDao dao = new SubjectDao();)
		{
			int choice;
			Sub subject = new Sub();
			while( ( choice = SubjectProgram.menuList( ) ) != 0 )
			{
				switch( choice )
				{
					case 1:
						SubjectProgram.acceptRecord(choice, subject);
						dao.search(subject);
						 break;
					case 2:
						SubjectProgram.acceptRecord(choice, subject);
						dao.update(subject);
						break;
					case 3:
						SubjectProgram.acceptRecord(choice, subject);
						dao.delete(subject);
						break;
					case 4:
						dao.getSubjectList().forEach(System.out::println);
						break;
					case 5:
						SubjectProgram.acceptRecord(choice, subject);
						dao.insert(subject);
				}
			}
		}
		catch(Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
