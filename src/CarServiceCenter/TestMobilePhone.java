// Students: Matan Eshel,Gil Ya'akov, Ron Gandelman, Eliyahu Latin
// Project Name: Task2
// Date: 29/04/2021
// Group number: 17
package CarServiceCenter;

import java.util.*;

public class TestMobilePhone {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		//CarServiceCenter c = new CarServiceCenter();
		//c.mainMenu();
		Person m = new Person("Max", "100");
		Calendar c = Calendar.getInstance();
		c.set(2022, 05, 1, 13, 31, 00);
	    Date date = c.getTime(); // Initialize date
		Payment p = new Payment(123456, 106, "Tiers", date, m);
		Payment p2 = (Payment) p.clone();
		Set<Payment> set = new HashSet<Payment>();
		//System.out.println(p);
		//System.out.println(p2);
		//set.add(p);
		//set.add(p2);
		System.out.println(p.equals(p2));

	}
}
