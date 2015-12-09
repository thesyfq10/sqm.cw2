package g53sqm.jibble;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class WebProperty {
	
	String result = "";
	InputStream inputStream;
	
	public String getPropValues() throws IOException {
		
	     File file = new File("C:/Users/./../jibble/webfiles");
	        
	       
		
		
		
		 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			Date time = new Date(System.currentTimeMillis());
 
			// get the property value and print it out
			String user = prop.getProperty("user");
			String html_root = prop.getProperty("html_root");
			String port = prop.getProperty("port");
			String log_file = prop.getProperty("log_file");
			String console_logging = prop.getProperty("console_logging");
 
			String newLine = System.getProperty("line.separator");
			result = "Created by  " + user+ ". " + newLine+"port = " + port + newLine+
					"log_file = " + log_file + newLine + "console_logging_status =" + console_logging ;
			System.out.println(result + "\nProgram Ran on " + time + " by user=" + user);
			
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}

}