package com.revature.bankapp.form;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.Util;

public abstract class Form {
	
	protected String name;
	protected boolean success;
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);
	public Form(String name) {
		this.name = name;
		success = false;
	}

	private void displayTitle() {
		LOGGER.info("\n***********");
		LOGGER.info(name);
		LOGGER.info("***********\n");
	}
	
	public void captureDataAndPerformAction() {
		while (!success) {
			displayTitle();
			captureData();
			action();
		}
	}
	
	public abstract void captureData();
	
	public abstract void action();

}
