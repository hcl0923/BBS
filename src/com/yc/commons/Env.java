package com.yc.commons;

import java.io.IOException;
import java.util.Properties;
public class Env extends Properties {
	private static Env instance=new Env();
	
	private Env() {
		try {
			this.load(Env.class.getClassLoader().getResourceAsStream("db.properties"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static Env getInstance() {
		return instance;
	}
}
