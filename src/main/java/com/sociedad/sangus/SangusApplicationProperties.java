package com.sociedad.sangus;

import java.io.InputStream;
import java.util.Properties;

public class SangusApplicationProperties {

	private static final String CONFIGURATION_FILE_NAME = "sangus.properties";

    private Properties properties;

    /**
     * Default Constructor
     */
    public SangusApplicationProperties(Environment environment) throws Exception {
        StringBuilder configurationPropertiesFilePathBuffer = new StringBuilder();
        configurationPropertiesFilePathBuffer.append("/conf/");
        configurationPropertiesFilePathBuffer.append(environment);
        configurationPropertiesFilePathBuffer.append('/');
        configurationPropertiesFilePathBuffer.append(CONFIGURATION_FILE_NAME);
        String configurationPropertiesFilePath = configurationPropertiesFilePathBuffer.toString();
        InputStream inputStream = SangusApplicationProperties.class.getResourceAsStream(configurationPropertiesFilePath);
        System.out.println("Properties: " + this.getClass().getClassLoader());
        if (inputStream == null) {
            throw new IllegalArgumentException("No puede leerse el archivo: " + configurationPropertiesFilePath);
        }
        this.properties = new Properties();
        this.properties.load(inputStream);
        inputStream.close();
    }

    public String getProperty(final String propertyName) {
        return this.properties.getProperty(propertyName);
    }

	public String[] getPropertyAsArray(final String propertyName) {
		String property = this.properties.getProperty(propertyName);
		return property != null ? property.split(",") : null;
	}

}