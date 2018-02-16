package Resume;
class MarksDetail{
	private int ID;
	private int SubjectID;
	private int StudentID;
	private String ResultDate;
	private int Score;
	private String Status;
	
	public MarksDetail(){
		
	}

	public MarksDetail(int iD, int subjectID, int studentID, String resultDate, int score, String status) {
		
		this.ID = iD;
		this.SubjectID = subjectID;
		this.StudentID = studentID;
		this.ResultDate = resultDate;
		this.Score = score;
		this.Status = status;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getSubjectID() {
		return SubjectID;
	}

	public void setSubjectID(int subjectID) {
		SubjectID = subjectID;
	}

	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public String getResultDate() {
		return ResultDate;
	}

	public void setResultDate(String resultDate) {
		ResultDate = resultDate;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "MarksDetail [ID=" + ID + ", SubjectID=" + SubjectID + ", StudentID=" + StudentID + ", ResultDate="
				+ ResultDate + ", Score=" + Score + ", Status=" + Status + "]";
	}
	
}

public class Marks {

}
