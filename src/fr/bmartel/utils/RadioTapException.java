package fr.bmartel.utils;

/**
 * Radiotap custom exception
 * 
 * @author Bertrand Martel
 *
 */
public class RadioTapException extends Exception{

	private static final long serialVersionUID = 1L;

	public RadioTapException(String message)
	{
		super(message);
	}
	
	public RadioTapException()
	{
		super();
	}
}
