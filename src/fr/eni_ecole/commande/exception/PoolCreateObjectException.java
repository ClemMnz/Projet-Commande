package fr.eni_ecole.commande.exception;

import java.util.List;

public class PoolCreateObjectException extends Exception {

	private Exception [] exceptions= new Exception [20]; 
	
	public void addException(Exception e)
	{
		for(int i=0; i<this.exceptions.length; i++){
			if(exceptions[i]==null){
				exceptions[i]=e;
				break; 
			}
		}
	}
	
	public int size()
	{
		int compteur=0;
		for(Exception e:this.exceptions)
		{
			if(e!=null)compteur++;
		}
		return compteur;
	}
	
	public String getMessage()
	{
		String message="";
		for(Exception e:this.exceptions)
		{
			if(e!=null)
			{
				message+=e.getMessage()+System.lineSeparator();
			}
		}
		return message;
	}
		
	}
	

