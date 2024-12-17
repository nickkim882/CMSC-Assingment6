/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This class represents a Beverage that is a Coffee. You can customize your coffee with extra shot or extra syrup
 * Due: 12/16/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nicholas Kim
*/
public class Coffee extends Beverage{
	
	private boolean extraShot;
	private boolean extraSyrup;
	private static final double EXTRA_PRICE = 0.5;
	
	public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup){
			
		super(name, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
		
	}
	
	public String toString() {
		
		String extra1 = "No Extra Shot";
		String extra2 = "No Extra Syrup";
		if(extraShot) {
			
			extra1 = "Extra Shot";
			
		}
		if(extraSyrup) {
			
			extra2 = "Extra Syrup";
			
		}
		
		return super.toString() + " " + extra1 + " " + extra2 + " " + calcPrice();
		
	}
	
	@Override
	public double calcPrice() {
		
		double price = addSizePrice();
		
		if(extraShot) {
			
			price += EXTRA_PRICE;
			
		}
		if(extraSyrup) {
			
			price += EXTRA_PRICE;
			
		}
		
		return price;
	}
	
	public boolean equals(Object obj) {
		
		if(!super.equals(obj)) {
			
			return false;
			
		}
		Coffee coffee = (Coffee) obj;
		if(extraShot = coffee.extraShot && extraSyrup == coffee.extraSyrup) {
			
			return true;
			
		}
		return false;
		
	}
	
	//setters
	public void setExtraShot(boolean extraShot) {
		
		this.extraShot = extraShot;
		
	}
	
	public void setExtraSyrup(boolean extraSyrup) {
		
		this.extraSyrup = extraSyrup;
		
	}
	
	//getters
	public boolean getExtraShot() {
		
		return extraShot;
		
	}
	
	public boolean getExtraSyrup() {
		
		return extraSyrup;
		
	}

}
