package Resume;
import java.util.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Resume.AcademicsDetails;
import Resume.AcademicsDao;

public class AcademicsProgram
{
	public static Scanner sc = new Scanner(System.in);
	public static void acceptRecord( int choice, Academics academic) throws ParseException
	{
		//SimpleDateFormat sd = new SimpleDateFormat("YYYY/mm/dd");
		if(choice == 3 || choice  == 1){
			if(choice == 1){
				System.out.println("StudentID :");
				academic.setStudentId(sc.nextInt());
				
				
			}
			else{
		System.out.print(" ID	:	");
		academic.setID(sc.nextInt());
			}
		}
		
		else{
		System.out.print("ID	:	");
		academic.setID(sc.nextInt());
		//System.out.print("StudentID "	);
		//sc.nextLine();
		//extracur.setStudentId(sc.nextInt());
		//System.out.print("Exam:  ");
		//academic.setExam(sc.next());
		System.out.print("Institute : ");
		academic.setInstitute(sc.next());
		System.out.print("University : ");
		academic.setUniversity(sc.next());
		System.out.print("YearOfPassing: ");
		java.util.Date ud = new java.util.Date(sc.next());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("YYYY-MM-dd");
		String date=sdf.format(ud);
		academic.setYearOfPassing(date);
		System.out.print("Score : ");
		academic.setScore(sc.next());
		
		}
		}
	
	public static int menuList()
	{
		System.out.println("0.Exit");
		System.out.println("1.Search Record");
		System.out.println("2.Update Record");
		System.out.println("3.Delete Record");
		System.out.println("4.Select Record");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}	
	public static void main(String[] args)
	{		
		try( AcademicsDao dao = new AcademicsDao();)
		{
			int choice;
			Academics academics = new Academics();
			while( ( choice = AcademicsProgram.menuList( ) ) != 0 )
			{
				switch( choice )
				{
					case 1:
						AcademicsProgram.acceptRecord(choice, academics);
						dao.search(academics);
						 break;
					case 2:
						AcademicsProgram.acceptRecord(choice, academics);
						dao.update(academics);
						break;
					case 3:
						AcademicsProgram.acceptRecord(choice,academics);
						dao.delete(academics);
						break;
					case 4:
						dao.getAcademicList().forEach(System.out::println);
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
