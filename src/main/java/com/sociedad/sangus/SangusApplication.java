package com.sociedad.sangus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.servlet.SparkApplication;

public class SangusApplication implements SparkApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SangusApplication.class);
 
	private Environment environment;
	private SangusApplicationProperties sangusApplicationProperties;
	
	public void init() {
		LOGGER.debug("Sangus Application init()");
		this.environment = Environment.parse();
        try {
			this.sangusApplicationProperties = new SangusApplicationProperties(this.environment);
        } catch (Exception e) {
			throw new IllegalArgumentException(String.format("No se pudieron cargar las propiedades de configuración para el ambiente %s", this.environment), e);
        }
	}

}