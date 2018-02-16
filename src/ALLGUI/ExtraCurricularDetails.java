package ALLGUI;
import java.util.Date;
class ExtraCurricular{
	private int ID;
	private int StudentId;
	private String Achievement;
	private String Description;
	private String Date;
	
	public ExtraCurricular(){
		
	}

	public ExtraCurricular(int id,int studentId, String achievement, String description, String date) {
		ID = id;
		StudentId = studentId;
		Achievement = achievement;
		Description = description;
		Date = date;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public String getAchievement() {
		return Achievement;
	}

	public void setAchievement(String achievement) {
		Achievement = achievement;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	@Override
	public String toString() {
		return "ExtraCurricular [ID=" + ID + ", StudentId=" + StudentId + ", Achievement=" + Achievement
				+ ", Description=" + Description + ", Date=" + Date + "]";
	}

		
}
 

public class ExtraCurricularDetails {
	public static void main(String [] args){
		//ExtraCurricular exc = new ExtraCurricular(1,1,"C & C++ ","TE",12/02/2014);
		
		//System.out.println(exc.toString());
	}
}
