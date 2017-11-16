package com.platform.base.domain;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public abstract class BaseDomain<T> {
	private String id ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void generateId(){
		if(StringUtils.isBlank(this.id)){
			this.id=UUID.randomUUID().toString();
		}		
	}
	public void flushId(){
		this.id=UUID.randomUUID().toString();
	}
}
