package fr.eni.editions.exceptions;

import java.util.ArrayList;

public class CaMarchePasException extends Exception {
	public CaMarchePasException()
	{
		super();
	}
	public CaMarchePasException(String message)
	{
		super(message);
	}
	public CaMarchePasException(Throwable cause)
	{
		super(cause);
	}
	public CaMarchePasException(String message, Throwable cause)
	{
		super(message, cause);
	}	
}
