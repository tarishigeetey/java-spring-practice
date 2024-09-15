package javacore.CreationalDesignPattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

interface Prototype extends Cloneable {
	Prototype clone() throws CloneNotSupportedException;
}

class Circle1 implements Prototype {
	private int radius;
	
	private int[] dimensions;

	public Circle1(int radius, int[] dimensions) {
		this.radius = radius;
		this.dimensions = dimensions;
	}

	public int getRadius() {
		return this.radius;
	}
	
	public int[] getDimensions() {
		return this.dimensions;
	}

	@Override
	public Circle1 clone() throws CloneNotSupportedException {
		Circle1 cloned =  (Circle1) super.clone(); // shallow copy
		
		cloned.dimensions = dimensions.clone(); // deep copy
		
		return cloned;
	}
}

// Prototype registry to manage prototype 

class PrototypRegistry {
	private Map<String, Prototype> prototypes = new HashMap<>();

	public void addPrototypes(String key, Prototype prototype) {
		prototypes.put(key, prototype);
	}

	public Prototype getPrototype(String key) throws CloneNotSupportedException {
		Prototype prototype = prototypes.get(key);
		if (prototype != null) {
			return prototype.clone();
		}
		return null;
	}

}

public class PrototypeDesignPattern {
	public static void main(String[] args) {
		PrototypRegistry registry = new PrototypRegistry();

		Circle1 circlePrototype = new Circle1(5, new int[] {1,2,3});
		registry.addPrototypes("Circle", circlePrototype);
		
		Circle1 circlePrototype2 = new Circle1(10, new int[] {4,5,6});
		registry.addPrototypes("Circle2", circlePrototype2);

		try {
			Circle1 clonedCircle = (Circle1) registry.getPrototype("Circle2");
			System.out.println("Radius of cloned Circle: " + clonedCircle.getRadius());
			System.out.println("Dimensions of Cloned Circle: " + Arrays.toString(clonedCircle.getDimensions()));
			
			clonedCircle.getDimensions()[0] = 9;
			
			System.out.println("Original Circle2 Dimensions: " + Arrays.toString(circlePrototype2 .getDimensions()));
			System.out.println("Cloned Circle Dimensions after modification: " + Arrays.toString(clonedCircle.getDimensions()));
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
