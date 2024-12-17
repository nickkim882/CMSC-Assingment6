/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This class represents a beverage that is Alcohol that is only offered on the weekends.
 * Due: 12/16/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nicholas Kim
*/
public class Alcohol extends Beverage{

	private boolean offered;
	private static final double DRINK_OFFERED = 0.60;
	
	public Alcohol(String name, Size size, boolean offered) {
		
		super(name, Type.ALCOHOL, size);
		this.offered = offered;
		
	}
	
	public boolean equals(Object obj) {
	
		if(!super.equals(obj)) {
			
			return false;
			
		}
				
		Alcohol alc = (Alcohol) obj;
		if(offered == alc.offered) {
			
			return true;
			
		}
		return false;
		
	}
	
	public double calcPrice() {
		
		double price = addSizePrice();
		if(offered) {
			
			price += DRINK_OFFERED;
			
		}
		
		return price;
		
	}
	
	public String toString() {
		
		String check = "Not Offered";
		
		if(offered) {
			
			check = "Offered";
			
		}
		
		return super.toString() + " " + check + " " + calcPrice();
		
	}
	
	//Setter
	public void setOffered(boolean offered) {
		
		this.offered = offered;
		
	}
	
	//Getter
	public boolean getOffered() {
		
		return offered;
		
	}
}
