package CarServiceCenter;

import java.util.*;

import javax.swing.JOptionPane;

public class Finance {
	
	protected HashMap<Integer,Payment> Payments;
	private int Profit;
	
	protected Finance() {
		this.Payments = new HashMap<Integer,Payment>();
		this.Profit = 0;
	}

	protected int getProfit() {
		return Profit;
	}
	protected void setProfit(int profit) {
		Profit = profit;
	}
	protected void addPayment(int Bill, String OwnerName,String OwnerCellPhone, String PaymentDescription) throws CloneNotSupportedException {
		Random rand = new Random();
		// Generate random integers in range 0 to 99999
		Integer PaymentID = rand.nextInt(99999);
		while(Payments.containsKey(PaymentID)) {PaymentID = rand.nextInt(99999);}
		Person temp = new Person(OwnerName,OwnerCellPhone);
		Calendar c = Calendar.getInstance();
		Date date = c.getTime(); // Initialize date
		Payment p = new Payment(PaymentID, Bill, PaymentDescription, date, temp);
		Payment p1 = p.clone();
		this.Payments.put(PaymentID, p1);
		Profit+=Bill;
	}
    protected void deletePayment() throws InputMismatchException,NumberFormatException{
    	int PaymentID = Integer.parseInt(JOptionPane.showInputDialog("PaymentID:")); // Read user input
	    if(PaymentID < 0 || PaymentID > 99999) { // Input integrity check
	    	JOptionPane.showMessageDialog(null,"InValid input","ERROR",JOptionPane.PLAIN_MESSAGE);
	    	return;
	    }
	    if(!(Payments.containsKey(PaymentID))) {
	    	JOptionPane.showMessageDialog(null,"No Such PaymentID","ERROR",JOptionPane.PLAIN_MESSAGE);
	    	return;
	    }
	    this.Payments.remove(PaymentID);
	}
    // Search Payment by ID and print it
    protected void searchPaymentById() throws InputMismatchException,NumberFormatException{
    	int PaymentID = Integer.parseInt(JOptionPane.showInputDialog("PaymentID:")); // Read user input
	    if(PaymentID < 0 || PaymentID > 99999) { // Input integrity check
	    	JOptionPane.showMessageDialog(null,"InValid input","ERROR",JOptionPane.PLAIN_MESSAGE);
	    	return;
	    }
	    if(!(Payments.containsKey(PaymentID))) {
	    	JOptionPane.showMessageDialog(null,"No Such PaymentID","ERROR",JOptionPane.PLAIN_MESSAGE);
	    	return;
	    }
	    JOptionPane.showMessageDialog(null,Payments.get(PaymentID),"Note",JOptionPane.PLAIN_MESSAGE);
	}
	@Override
	public String toString() {
	    return "Profit: " + this.getProfit() + "\n" + this.Payments.toString();
	}
	protected void printPayments() {
		JOptionPane.showMessageDialog(null,this,"Payments",JOptionPane.PLAIN_MESSAGE);
	}
	    // User menu
		protected void menu() {
			while(true) {
				OptionPane menu = new OptionPane(this.printMenu());
				switch (menu.option) {
				  case "1":
					  try {
					    this.deletePayment();
					    }catch(Exception e) {
						  JOptionPane.showMessageDialog(null,"InValid input","ERROR",JOptionPane.PLAIN_MESSAGE);
					    }
				        break;
				  case "2":
					  try {
						this.searchPaymentById();
						}catch(Exception e) {
						  JOptionPane.showMessageDialog(null,"InValid input","ERROR",JOptionPane.PLAIN_MESSAGE);
						}
				        break;
				  case "3":
					    JOptionPane.showMessageDialog(null,this.getProfit(),"Profit",JOptionPane.PLAIN_MESSAGE); // Print the profit
				        break;
				  case "4":
					    this.printPayments();
					    break;
				  case "5":
					    return;
				  default:
					    JOptionPane.showMessageDialog(null,"No such option","ERROR",JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
		// Printing the menu
		protected String printMenu() {
			String str1,str2,str3,str4,str5,str6;
			str1 = "1. Delete Payment\n";
			str2 = "2. Search Payment By Payment ID\n";
			str3 = "3. Print Total Profit\n";
			str4 = "4. Print Finance Department\n";
			str5 = "5. Exit\n";
			str6 = "Enter option:\n";
			return str1+str2+str3+str4+str5+str6;
		}
}
