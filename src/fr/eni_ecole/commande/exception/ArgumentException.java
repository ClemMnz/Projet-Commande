package fr.eni_ecole.commande.exception;

public class ArgumentException extends Exception {

	
	public ArgumentException (String attributName, String message){
		super("attribut:"+attributName+" ("+message+")");
		
	}
	
}
