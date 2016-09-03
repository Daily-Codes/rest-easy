/**
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved. 
 */
package org.me.resteasy.hw;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
public class IndexRest {
	
	@GET
	@Path("/rest/index")
	public String hello() {
		return "Hello World";
	}
}
