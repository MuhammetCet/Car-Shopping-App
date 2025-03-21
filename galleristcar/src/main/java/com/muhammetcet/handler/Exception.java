package com.muhammetcet.handler;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exception<E> {

	
	
	private String path;
	
	private String hostName;
	
	private Date createTime;
	
	private E message;
	
	
	
}
