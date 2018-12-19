package fr.eni_ecole.commande.modele.bo;

import fr.eni_ecole.commande.exception.ArgumentException;
import fr.eni_ecole.commande.exception.PoolCreateObjectException;

public class Stylo extends Article{

	private String couleur;

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) throws ArgumentException {
		if(couleur!=null && !couleur.trim().equals(""))
		{
			this.couleur = couleur;
		}
		else
		{
			throw new ArgumentException("couleur","Cet attribut est obligatoire.");
		}
		
	}

	public Stylo(String marque, String ref, String designation, float pu, int qte, String couleur)throws PoolCreateObjectException
	{
		PoolCreateObjectException pcoe= new PoolCreateObjectException(); 
		try {
			this.setMarque(marque);
			
		} 
		catch (ArgumentException e) 
		{
		
			pcoe.addException(e);
		} 
		try 
		{
			this.setReference(ref);
			
		}
		catch (ArgumentException e)
		{
			pcoe.addException(e);
		}
		try {
			this.setDesignation(designation);
		} 
		catch (ArgumentException e)
		{
			pcoe.addException(e);
			}
		try {
			this.setPrixUnitaire(pu);
		} 
		catch (ArgumentException e)
		{
			pcoe.addException(e);
		}
		try {
			this.setQteStock(qte);
		} 
		catch (ArgumentException e)
		{
			
			pcoe.addException(e);
		}
		try {
			
			this.setCouleur(couleur);
			
		} catch (ArgumentException e) {
			
			pcoe.addException(e);
		} 
		if(pcoe.size()>0)
		{
			throw pcoe;
		}
	}
	
	public Stylo(String marque, String ref, String designation, float pu, String couleur) throws PoolCreateObjectException {
		PoolCreateObjectException pcoe = new PoolCreateObjectException();
		try {
			this.setMarque(marque);
		} catch (ArgumentException e) {
			pcoe.addException(e);
		}
		try {
			this.setReference(ref);
		} catch (ArgumentException e) {
			pcoe.addException(e);
		}
		try {
			this.setDesignation(designation);
		} catch (ArgumentException e) {
			pcoe.addException(e);
		}
		try {
			this.setPrixUnitaire(pu);
		} catch (ArgumentException e) {
			pcoe.addException(e);
		}
		try {
			this.setCouleur(couleur);
		} catch (ArgumentException e) {
			pcoe.addException(e);
		}
		if(pcoe.size()>0)
		{
			throw pcoe;
		}
	}
		
	@Override
	public String toString() {
		return "Stylo [couleur=" + couleur + "]";
	} 
	
	
}
