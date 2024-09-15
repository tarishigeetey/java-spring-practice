package javacore.CreationalDesignPattern;

// Product class
class Computer {

	// required parameters
	private String HDD;
	private String RAM;

	// Optional Parameters
	private boolean isGraphicCardEnabled;
	private boolean isBluetoothEnabled;

	public String getHDD() {
		return HDD;
	}

	public String getRAM() {
		return RAM;
	}

	public boolean isGraphicCardEnabled() {
		return isGraphicCardEnabled;
	}

	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}

	// Private constructor to enforce object creation through Builder

	private Computer(ComputerBuilder builder) {
		this.HDD = builder.HDD;
		this.RAM = builder.RAM;
		this.isGraphicCardEnabled = builder.isGraphicCardEnabled;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}

	public static class ComputerBuilder {
		// required parameters
		private String HDD;
		private String RAM;

		// Optional Parameters
		private boolean isGraphicCardEnabled;
		private boolean isBluetoothEnabled;
		
		public ComputerBuilder setGraphicCardEnabled(boolean isGraphicCardEnabled) {
			this.isGraphicCardEnabled = isGraphicCardEnabled;
			return this;
		}

		public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}

		public ComputerBuilder(String hdd, String ram) {
			this.HDD = hdd;
			this.RAM = ram;
		}
		
		public Computer build() {
			return new Computer(this);
		}
	}
}

public class BuilderDesignPattern {
	public static void main(String[] args) {
		Computer computer = new Computer.ComputerBuilder("500 GB", "8 GB")
				.setGraphicCardEnabled(true)
				.setBluetoothEnabled(true)
				.build();
		
		System.out.println("HDD: " + computer.getHDD());
		System.out.println("RAM " + computer.getRAM());
		System.out.println("Graphic Card Enabled: " + computer.isGraphicCardEnabled());
		System.out.println("BlurTooth Enabled: " + computer.isBluetoothEnabled());
	}
}
