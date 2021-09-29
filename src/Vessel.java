
public abstract class Vessel {

	protected double litres;
	private double maxLitres;
	
	public Vessel(double maxLitres) {
		litres = 0;
		this.maxLitres = maxLitres;
	}
	
	public abstract double pour(Vessel v, double amount);
	
	public abstract void fill(double amount);
	
	public double getLitres() {
		return litres;
	}
	
	public double getCapacity() {
		return maxLitres;
	}
}

class PlasticCup extends Vessel {
	
	public PlasticCup(double maxLitres) {
		super(maxLitres);
	}
	
	public double pour(Vessel v, double amount) {
		v.fill(amount);
		return v.getLitres();
	}
	
	public void fill(double amount) {
		litres += amount;
	}
}

class FilteredJug extends Vessel {
	
	private int numberOfUses;
	
	public FilteredJug(double maxLitres) {
		super(maxLitres);
		numberOfUses = 0;
	}
	
	public double pour(Vessel v, double amount) {
		v.fill(amount);
		return v.getLitres();
	}
	public void fill(double amount) {
		if(numberOfUses <= 30) {
			litres += amount;
		}
		else {
			return;
		}
	}
	
class WineGlass extends Vessel {
	
	private boolean isBroken;
	
	public WineGlass(double maxLitres) {
		super(maxLitres);
		isBroken = false;
	}
	public double pour(Vessel v, double amount) {
		if(isBroken)
			return -1.0;
		v.fill(amount);
		return v.getLitres();
	}
	
	public void fill(double amount) {
		if(isBroken)
			return;
		litres += amount;
	}
	
}
	
}