package Resume;
import java.util.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Resume.ExtraCurricularDao;
import Resume.ExtraCurricularDetails;

public class ExtraCurricularProgram
{
	public static Scanner sc = new Scanner(System.in);
	public static void acceptRecord( int choice, ExtraCurricular extracur) throws ParseException
	{
		//SimpleDateFormat sd = new SimpleDateFormat("YYYY/mm/dd");
		if(choice == 3 || choice  == 1){
			if(choice == 1){
				System.out.println("StudentID :");
				extracur.setStudentId(sc.nextInt());
				
				
			}
			else{
		System.out.print(" ID	:	");
		extracur.setID(sc.nextInt());
			}
		}
		
		else{
		System.out.print("ID	:	");
		extracur.setID(sc.nextInt());
		//System.out.print("StudentID "	);
		//sc.nextLine();
		//extracur.setStudentId(sc.nextInt());
		System.out.print("Achievement:  ");
		extracur.setAchievement(sc.next());
		System.out.print("Description : ");
		extracur.setDescription(sc.next());
		System.out.print("Date: ");
		java.util.Date ud = new java.util.Date(sc.next());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("YYYY-MM-dd");
		String date=sdf.format(ud);
		extracur.setDate(date);
		
		
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
		try( ExtraCurricularDao dao = new ExtraCurricularDao();)
		{
			int choice;
			ExtraCurricular extracur = new ExtraCurricular();
			while( ( choice = ExtraCurricularProgram.menuList( ) ) != 0 )
			{
				switch( choice )
				{
					case 1:
						ExtraCurricularProgram.acceptRecord(choice, extracur);
						dao.search(extracur);
						 break;
					case 2:
						ExtraCurricularProgram.acceptRecord(choice, extracur);
						dao.update(extracur);
						break;
					case 3:
						ExtraCurricularProgram.acceptRecord(choice,extracur);
						dao.delete(extracur);
						break;
					case 4:
						dao.getCurricularList().forEach(System.out::println);
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
