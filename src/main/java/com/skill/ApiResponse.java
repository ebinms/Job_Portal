package com.skill;

import java.io.Serializable;

public class ApiResponse implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int responseCode;

	private String responseMessage;

	private Object data;
	
	public ApiResponse(int responseCode, String responseMessage, Object data)
	{
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.data = data;
	}

	public ApiResponse()
	{
		super();
	}

	public int getResponseCode()
	{
		return responseCode;
	}

	public void setResponseCode(int responseCode)
	{
		this.responseCode = responseCode;
	}

	public String getResponseMessage()
	{
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage)
	{
		this.responseMessage = responseMessage;
	}

	public Object getData()
	{
		return data;
	}

	public void setData(Object data)
	{
		this.data = data;
	}
}
