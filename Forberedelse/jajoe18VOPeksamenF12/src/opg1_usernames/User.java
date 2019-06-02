package opg1_usernames;


import java.util.Date;

public class User  {
	private String fullName;
	private Date createdAt;

	public User(String name){
		this.fullName = name;
		this.createdAt = new Date();
	}
	
	@Override
	public String toString() {
		return "User: " + fullName + " - " + createdAt.toString();
	}
	
	// Opg. 1b
	public String makeUserName(){
		String userName = "";
		String[] nameArray = fullName.split(" ");
		String firstName = nameArray[0];
		String lastName = nameArray[nameArray.length-1];
		if(firstName.length() > 2 && lastName.length() > 3) {
			userName += firstName.substring(0,2).toLowerCase() + lastName.substring(0,3).toLowerCase();
		}
		if(firstName.length() <= 2 || lastName.length() <= 3) {
			userName += firstName.substring(0,2).toLowerCase() + lastName.substring(0,2).toLowerCase();
		}
		userName = userName.replace("æ","ae");
		userName = userName.replace("ø","oe");
		userName = userName.replace("å","aa");
		System.out.println(userName);
		return userName;
	}

	public static void main(String [] arg){
		
		// Til test af opg. 1a
		User user1 = new User("Joachim Holger Waldemar Christian");
		System.out.println(user1);
		
		User user2 = new User("Ib Bo");
		System.out.println(user2);
		
		User user3 = new User("Åge Bøgeskov");
		System.out.println(user3);

		// Til test af opg. 1b 
		System.out.println(user1.makeUserName());
		System.out.println(user2.makeUserName());
		System.out.println(user3.makeUserName());

	}
}
