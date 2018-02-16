package Resume;
import java.util.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Resume.MarksDao;
import Resume.Marks;

public class MarksProgram
{
	public static Scanner sc = new Scanner(System.in);
	public static void acceptRecord( int choice, MarksDetail mark) throws ParseException
	{
		//SimpleDateFormat sd = new SimpleDateFormat("YYYY/mm/dd");
		if(choice == 3 || choice  == 1){
			
				System.out.println("ID :");
				mark.setID(sc.nextInt());
				
				
			
		
				}
		
		
		else{
		System.out.print("ID	:	");
		mark.setID(sc.nextInt());
		//System.out.print("StudentID "	);
		//sc.nextLine();
		//extracur.setStudentId(sc.nextInt());
		System.out.print("Result Date:  ");
		java.util.Date ud = new java.util.Date(sc.next());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("YYYY-MM-dd");
		String date=sdf.format(ud);
		mark.setResultDate(date);
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
		try( MarksDao dao = new MarksDao();)
		{
			int choice;
			MarksDetail mark= new MarksDetail();
			while( ( choice = MarksProgram.menuList( ) ) != 0 )
			{
				switch( choice )
				{
					case 1:
						MarksProgram.acceptRecord(choice, mark);
						dao.search(mark);
						 break;
					case 2:
						MarksProgram.acceptRecord(choice, mark);
						dao.update(mark);
						break;
					case 3:
						MarksProgram.acceptRecord(choice,mark);
						dao.delete(mark);
						break;
					/*case 4:
						dao.getProjectList().forEach(System.out::println);
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
