/**
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved. 
 */
package org.me.resteasy.hw;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
public class RestApplication extends Application {
	

	/* (non-Javadoc)
	 * @see javax.ws.rs.core.Application#getClasses()
	 */
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(IndexRest.class);
		classes.add(UploadRest.class);
		return classes;
	}
	
}
