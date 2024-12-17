/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This class represents a Beverage that is a Smoothie. You can customize your smoothie by adding in fruits and protein powder
 * Due: 12/16/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nicholas Kim
*/
public class Smoothie extends Beverage{

	private int numFruits;
	private boolean proteinPowder;
	private static final double PROTEIN = 1.5;
	private static final double FRUITS = .5;
	
	public Smoothie(String name, Size size, int numFruits, boolean proteinPowder) {
		
		super(name, Type.SMOOTHIE, size);
		this.numFruits = numFruits;
		this.proteinPowder = proteinPowder;
		
	}

	public boolean equals(Object obj) {
		
		if(!super.equals(obj)) {
			
			return false;
			
		}
		Smoothie smoothie = (Smoothie) obj;
		if(numFruits == smoothie.numFruits && proteinPowder == smoothie.proteinPowder) {
			
			return true;
			
		}
		return false;
		
	}
		
	@Override
	public double calcPrice() {
		
		double price = addSizePrice();
		
		if(proteinPowder) {
			
			price += PROTEIN;
			
		}
		if(numFruits > 0 ) {
			
			price += numFruits * FRUITS;
			
		}
		return price;
		
	}
	
	public String toString() {
		
		String protein = "No Protein Powder";
		String fruits = "No Fruits";
		
		if(proteinPowder) {
			
			protein = "Protein Powder";
			
		}
		if(numFruits > 0) {
			
			fruits = "Fruits";
			
		}
		
		return super.toString() + " " + protein + " " + fruits + " " + calcPrice();
		
	}
	
	//Setters
	public void setNumFruits(int numFruits) {
		
		this.numFruits = numFruits;
		
	}
	
	public void setProteinPowder(boolean proteinPowder) {
		
		this.proteinPowder = proteinPowder;
		
	}
	
	//Getters 
	public int getNumFruits() {
		
		return numFruits;
		
	}
	
	public boolean getProteinPowder() {
		
		return proteinPowder;
		
	}
}
