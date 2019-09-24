package opg1_usernames;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserMap {
    public static void main(String[] args) {
        Map<String,User> map = new HashMap<String,User>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter full name:");
        String fullname = sc.nextLine();
        while (!fullname.equalsIgnoreCase("")) {
            User user = new User(fullname);
            String userName = user.makeUserName();
            int i = 0;
            while (map.containsKey(i== 0 ? userName: userName + i)) {
                i++;
            }
            if( i > 0){
                userName += i;
            }
            map.put(userName,user);
            fullname = sc.nextLine();
        }
        System.out.println(map);
    }
}
