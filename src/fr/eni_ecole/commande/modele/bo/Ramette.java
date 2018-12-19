package fr.eni_ecole.commande.modele.bo;

import fr.eni_ecole.commande.exception.ArgumentException;
import fr.eni_ecole.commande.exception.PoolCreateObjectException;

public class Ramette extends Article {
	
	private int grammage; 

	public int getGrammage() {
		return grammage;
	}
	public void setGrammage(int grammage)throws ArgumentException 
	{
		this.grammage = grammage;
	}
	public Ramette(String marque, String ref, String designation, float pu, int qte, int grammage)throws PoolCreateObjectException
	{
		this(marque,ref,designation,pu,grammage);
		try {
			this.setQteStock(qte);
		} catch (ArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Ramette(String marque, String ref, String designation, float pu, int grammage)throws PoolCreateObjectException {
		try {
			this.setMarque(marque);
			this.setReference(ref);
			this.setDesignation(designation);
			this.setPrixUnitaire(pu);
			this.setGrammage(grammage);
		} catch (ArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Override
	public String toString() {
		return super.toString()+" Ramette [grammage=" + grammage + "]";
	}
}
