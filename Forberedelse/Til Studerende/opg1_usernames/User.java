package opg1_usernames;


public class User  {

	public User(String name){
	}
	
	@Override
	public String toString() {
		return null;
	}
	
	// Opg. 1b
	public String makeUserName(){
		return null;
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
//		System.out.println(user1.makeUserName());
//		System.out.println(user2.makeUserName());
//		System.out.println(user3.makeUserName());

	}
}
