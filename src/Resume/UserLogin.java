package Resume;

class Login{
	private int ID;
	private String username;
	private String password;
	private String role;
	
	public Login(){
		
	}
	
	public Login(int ID,String userlogin,String password,String role){
		this.ID=ID;
		this.username = userlogin;
		this.password = password;
		this.role = role;
	}
	public int getID(){
		return ID;
		
	}
	public void setID(int ID){
		this.ID=ID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String toString()
	{
		return this.username +" "+ this.password +" " +this.role;	
	}
	
	
}
public class UserLogin{
	public static void main(String [] args){
		Login L = new Login();
		L.setUsername("Diksha");
		L.setPassword("dikraj");
		L.setRole("User");
		
		System.out.println(L.toString());
	
}
}
