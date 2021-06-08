// Students: Matan Eshel,Gil Ya'akov, Ron Gandelman, Eliyahu Latin
// Project Name: Task2
// Date: 29/04/2021
// Group number: 17
package CarServiceCenter;

import java.util.*;

public class TestMobilePhone {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		CarServiceCenter c = new CarServiceCenter();
		c.financeDepartment.addPayment(100, "Gil", "0547236694", "Tiers");
		c.financeDepartment.addPayment(300, "Dani", "0545637998", "Electric");
		c.financeDepartment.addPayment(300, "Dani", "0545637998", "Electric");
		c.financeDepartment.printPayments();
	}
}
