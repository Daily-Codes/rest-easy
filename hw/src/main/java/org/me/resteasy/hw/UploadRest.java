/**
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved. 
 */
package org.me.resteasy.hw;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.annotations.providers.multipart.PartType;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
@Path("/rest")
public class TestApp {
	
	public static class FileForm {
		private byte[] file;
		public byte[] getFile() {
			return file;
		}
		@FormParam("file")
	    @PartType(MediaType.APPLICATION_OCTET_STREAM)
		public void setFile(byte[] file) {
			this.file = file;
		}
	}
	
	@GET
	@Path("/hello")
	public String hello() {
		return "Hello World";
	}

	@Path("/upload")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String upload(MultipartFormDataInput input) {
		List<InputPart> parts = input.getFormDataMap().get("file");
		InputPart inputPart = null == parts || parts.isEmpty() ? null : parts.get(0);
		if (null == inputPart) {
			return "ERROR";
		}
		try {
			System.out.println(inputPart.getMediaType());
			InputStream inputStream = inputPart.getBody(InputStream.class, null);
			byte[] bytes = IOUtils.toByteArray(inputStream);
			System.out.println(new String(bytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "OK";
	}

	@Path("/upload1")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String upload(@MultipartForm FileForm ff) {
		System.out.println(null == ff ? null : new String(ff.getFile()));
		return "OK";
	}
	
}
