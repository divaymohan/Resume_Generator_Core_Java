package Resume;
import java.util.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Resume.ProjectDao;
import Resume.ProjectDetails;

public class ProjectProgram
{
	public static Scanner sc = new Scanner(System.in);
	public static void acceptRecord( int choice, Project project) throws ParseException
	{
		//SimpleDateFormat sd = new SimpleDateFormat("YYYY/mm/dd");
		if(choice == 3 || choice  == 1){
			if(choice == 1){
				System.out.println("StudentID :");
				project.setStudentId(sc.nextInt());
				
				
			}
			else{
		System.out.print(" ID	:	");
		project.setID(sc.nextInt());
			}
		}
		
		else{
		System.out.print("ID	:	");
		project.setID(sc.nextInt());
		//System.out.print("StudentID "	);
		//sc.nextLine();
		//extracur.setStudentId(sc.nextInt());
		System.out.print("Team Size:  ");
		project.setTeamSize(sc.nextInt());
		System.out.print("Duration : ");
		project.setDuration(sc.next());
		System.out.print("Technology: ");
		project.setTechnology(sc.next());
		System.out.println("Title: ");
		project.setTitle(sc.next());
		System.out.println("Descriptions: ");
		project.setDescription(sc.next());
		
		
		
		
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
		try( ProjectDao dao = new ProjectDao();)
		{
			int choice;
			Project project = new Project();
			while( ( choice = ProjectProgram.menuList( ) ) != 0 )
			{
				switch( choice )
				{
					case 1:
						ProjectProgram.acceptRecord(choice, project);
						dao.search(project);
						 break;
					case 2:
						ProjectProgram.acceptRecord(choice, project);
						dao.update(project);
						break;
					case 3:
						ProjectProgram.acceptRecord(choice,project);
						dao.delete(project);
						break;
					case 4:
						dao.getProjectList().forEach(System.out::println);
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
