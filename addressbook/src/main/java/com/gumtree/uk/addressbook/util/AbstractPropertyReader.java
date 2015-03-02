package com.gumtree.uk.addressbook.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public abstract class AbstractPropertyReader implements ApplicationContextAware {

	public Properties properties;

	protected String filename;

	protected ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void loadPropertiesFile() {
		try {
			this.properties = new Properties();
			Resource sourceFile = applicationContext.getResource(this.filename);
			File file = sourceFile.getFile();
			FileInputStream in = new FileInputStream(file);
			this.properties.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			//log.error("File Not Found for " + filename);
		} catch (IOException e) {
			//log.error("Error loading properties file " + filename);
		} catch (Exception e) {
			//log.error(e.getMessage() + " " + filename);
		}
	}
}
