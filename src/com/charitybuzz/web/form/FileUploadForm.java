package com.charitybuzz.web.form;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 
 * @author Administrator
 * 
 */
public class FileUploadForm {


	private CommonsMultipartFile file;


	public CommonsMultipartFile getFile() {
		return file;
	}


	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SIMPLE_STYLE);
	}
}
