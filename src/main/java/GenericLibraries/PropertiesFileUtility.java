package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//This class contains all reusable methods to perform operations on Properties file

public class PropertiesFileUtility {
	private Properties property;
	
	//This method is used to initialize properties file
	
	public void propertyFileInitialization(String filepath)
	{
		FileInputStream fis=null;
		try
		{
			fis=new FileInputStream(filepath);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		property=new Properties();
		try
		{
			property.load(fis);			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//This method returns the data from properties file based on the key passed
	
	public String fetchproperty(String key)
	{
		return property.getProperty(key);
	}	
}