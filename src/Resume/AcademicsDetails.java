package Resume;
class Academics{
	private int ID;
	private int StudentId;
	private String Exam;
	private String Institute;
	private String University;
	private String YearOfPassing;
	private String Score;
	
	public Academics(){
		
		
	}
	

	public Academics(int ID,int studentId, String exam, String institute, String university, String yearOfPassing,
			String score) {
		this.ID=ID;
		this.StudentId = studentId;
		this.Exam = exam;
		this.Institute = institute;
		this.University = university;
		this.YearOfPassing = yearOfPassing;
		this.Score = score;
	}
	


	@Override
	public String toString() {
		return "Academics [StudentId=" + StudentId + ", Exam=" + Exam + ", Institute=" + Institute + ", University="
				+ University + ", YearOfPassing=" + YearOfPassing + ", Score=" + Score + "]";
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


	public String getExam() {
		return Exam;
	}


	public void setExam(String exam) {
		Exam = exam;
	}


	public String getInstitute() {
		return Institute;
	}


	public void setInstitute(String institute) {
		Institute = institute;
	}


	public String getUniversity() {
		return University;
	}


	public void setUniversity(String university) {
		University = university;
	}


	public String getYearOfPassing() {
		return YearOfPassing;
	}


	public void setYearOfPassing(String yearOfPassing) {
		YearOfPassing = yearOfPassing;
	}


	public String getScore() {
		return Score;
	}


	public void setScore(String score) {
		Score = score;
	}


	
}	
public class AcademicsDetails{
	public static void main(String [] args){
		Academics acd = new Academics();
		acd.setStudentId(1);
		acd.setExam("SE");
		acd.setInstitute("AISSMS");
		acd.setYearOfPassing("2018");
		acd.setScore("90");
		
		System.out.println(acd.toString());
		
		
		
	}
	

}
