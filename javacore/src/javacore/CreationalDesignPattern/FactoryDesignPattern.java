package javacore.CreationalDesignPattern;

// Product Interface

interface Logger {
	void logger(String message);
}

// Concrete product class

class ConsoleLogger implements Logger {

	@Override
	public void logger(String message) {
		System.out.println("Console Logger: " + message);
	}

}

class FileLogger implements Logger {

	@Override
	public void logger(String message) {
		System.out.println("File Logger: " + message);
	}
}

class DatabaseLogger implements Logger {

	@Override
	public void logger(String message) {
		System.out.println("Database Logger: " + message);
	}
}

// factory class

class LoggerFactory{
	public static Logger getLogger(String type) {
		return switch(type) {
		case "console" -> new ConsoleLogger();
		case "file" -> new FileLogger();
		case "database" -> new DatabaseLogger();
		default -> throw new IllegalArgumentException();
		};
	}
}

public class FactoryDesignPattern {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("console");
		logger.logger("This a console log message");
		
		logger = LoggerFactory.getLogger("file");
		logger.logger("This a file log message");
		
		logger = LoggerFactory.getLogger("database");
		logger.logger("This a database log message");
		
		logger = LoggerFactory.getLogger("nosql");
		logger.logger("This a nosql log message");
	}
}
