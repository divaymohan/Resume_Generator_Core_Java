package ALLGUI;
class Project{
	private int ID;
	private int StudentId;
	private String ProjectType;
	private int TeamSize;
	private String Duration;
	private String Technology;
	private String Title;
	private String Description;
	
	public Project(){
		
	}

	public Project(int ID,int studentId, String projectType, int teamSize, String duration, String technology, String title,String description) {
		this.ID=ID;
		this.StudentId = studentId;
		this.ProjectType = projectType;
		this.TeamSize = teamSize;
		this.Duration = duration;
		this.Technology = technology;
		this.Title = title;
		this.Description = description;
	}

	@Override
	public String toString() {
		return "Project [StudentId=" + StudentId + ", ProjectType=" + ProjectType + ", TeamSize=" + TeamSize
				+ ", Duration=" + Duration + ", Technology=" + Technology + ", Title=" + Title + ", Description="
				+ Description + "]";
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

	public String getProjectType() {
		return ProjectType;
	}

	public void setProjectType(String projectType) {
		ProjectType = projectType;
	}

	public int getTeamSize() {
		return TeamSize;
	}

	public void setTeamSize(int teamSize) {
		TeamSize = teamSize;
	}

	public String getDuration() {
		return Duration;
	}

	public void setDuration(String duration) {
		Duration = duration;
	}

	public String getTechnology() {
		return Technology;
	}

	public void setTechnology(String technology) {
		Technology = technology;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

		
}
public class ProjectDetails {
	public static void main(String [] args){
		Project acd = new Project();
		acd.setID(1);
		acd.setStudentId(1);
		acd.setProjectType("TE_Project");
		acd.setTeamSize(4);
		acd.setDuration("15 days");
		acd.setTechnology("JDBC");
		acd.setTitle("Resume Builder");
		acd.setDescription("with JBBC");
		
		System.out.println(acd.toString());
	}
	

}
