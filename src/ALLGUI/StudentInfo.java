package ALLGUI;
import java.sql.Date;
class Student{
	private int StudentId;
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String BirthDate;
	private String EmailId;
	private int MobileNo;
	private String Hobby;
	private String Company;
	private String PlaceDate;
	
	public Student(){
		
	}
	public Student(int StudentId,String FirstName,String MiddleName,String LastName,String BirthDate,String EmailId, int MobileNo,String Hobby,String Company,String PlaceDate){
	this.StudentId = StudentId;
	this.FirstName = FirstName;
	this.MiddleName = MiddleName;
	this.LastName = LastName;
	this.BirthDate = BirthDate;
	this.EmailId = EmailId;
	this.MobileNo = MobileNo;
	this.Hobby = Hobby;
	this.Company = Company;
	this.PlaceDate = PlaceDate;
	}
	
	
		public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(String date) {
		BirthDate = date;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public int getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(int mobileNo) {
		MobileNo = mobileNo;
	}
	public String getHobby() {
		return Hobby;
	}
	public void setHobby(String hobby) {
		Hobby = hobby;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getPlaceDate() {
		return PlaceDate;
	}
	public void setPlaceDate(String placeDate) {
		PlaceDate = placeDate;
	}
		public String toString(){
		return this.StudentId+" "+this.FirstName+" "+this.MiddleName+" "+this.LastName+" "+this.BirthDate+" "+this.EmailId+" "+this.MobileNo+" "+this.Hobby+" "+this.Company+" "+this.PlaceDate;
	}
		
}
public class StudentInfo {
	public static void main(String [] args){
		/*Student stu = new Student(1,"Divay","Mohan","Chaudhary","13/05/1996","divaymohan05@gmail.com","8149958193","playing Cricket","Sunbeam","12/2/2013");
	    System.out.println(stu.toString());
	    */
	}
}
