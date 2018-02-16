
package Resume;
class Sub{
	private int ID;
	private String Name;
	private String Semester;
	private String Stream;
	private int MaxMarks;
	private String Type;
	
	public Sub(){
		
	}

	public Sub(int iD, String name, String semester, String stream, int maxMarks, String type) {
		
		this.ID = iD;
		this.Name = name;
		this.Semester = semester;
		this.Stream = stream;
		this.MaxMarks = maxMarks;
		this.Type = type;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSemester() {
		return Semester;
	}

	public void setSemester(String semester) {
		Semester = semester;
	}

	public String getStream() {
		return Stream;
	}

	public void setStream(String stream) {
		Stream = stream;
	}

	public int getMaxMarks() {
		return MaxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		MaxMarks = maxMarks;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	@Override
	public String toString() {
		return "Sub [ID=" + ID + ", Name=" + Name + ", Semester=" + Semester + ", Stream=" + Stream + ", MaxMarks="
				+ MaxMarks + ", Type=" + Type + "]";
	}
	
}

public class Subject {

}
