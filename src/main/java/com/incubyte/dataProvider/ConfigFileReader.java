package com.incubyte.dataProvider;

import com.incubyte.enums.DriverType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= "configFile/configuration.properties";


    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) {
            try{
                return Long.parseLong(implicitlyWait);
            }catch(NumberFormatException e) {
                throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
            }
        }
        return 30;
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("baseURL");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public String getEmailId() {
        String emailId = properties.getProperty("EmailID");
        if(emailId != null) return emailId;
        else throw new RuntimeException("Email Id not specified in the Configuration.properties file.");
    }
    public String getPassword() {
        String password = properties.getProperty("Password");
        if(password != null) return password;
        else throw new RuntimeException("password not specified in the Configuration.properties file.");
    }

    public DriverType getBrowserType() {
        String browserName = properties.getProperty("browser");
        if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
        else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else if(browserName.equals("edge")) return DriverType.EDGE;
        else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

}
