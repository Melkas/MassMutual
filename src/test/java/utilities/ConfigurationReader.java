package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	
	private static Properties properties;
	static{
		try {
			properties = new Properties();
			FileInputStream inputStream = new FileInputStream("/Users/Mustafa/eclipse-workspace/MassMutualAssessment/configuration/configration.properties");
			properties.load(inputStream);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		return properties.getProperty(key);
	}
	
	public static String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
	
}