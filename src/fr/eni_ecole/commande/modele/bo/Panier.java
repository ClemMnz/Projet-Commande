package fr.eni_ecole.commande.modele.bo;

import java.util.List;

import fr.eni_ecole.commande.exception.PlusEnStockException;

public class Panier {

	private float montant;
	private LignePanier[] lignesPanier; 

	public float getMontant() {
		return montant;
	}
	public LignePanier getLignesPanier(int index){
		return null;
		
	}
	public Panier(){
		this.lignesPanier= new LignePanier[50]; 
		
	}
	
	
	
	public LignePanier getLigne(int index)
	{
		return this.lignesPanier[index];
	}
	
	public void addLigne(Article article, int qte) throws PlusEnStockException
	{
		for(int i=0;i<this.lignesPanier.length;i++)
		{
			if(this.lignesPanier[i]==null)
			{
				article.sortirStock(qte);
				this.lignesPanier[i]=new LignePanier(article, qte);
				break;
			}
		}
	}
	
	public void removeLigne(int index){
		
		
	}
	 public void updateLigne(int index, int newQte) throws PlusEnStockException
	 {
		 if()
		 {
			 
		 }
		 else{
			 
			throw new PlusEnStockException(null, newQte);  
		 }
		 
	 }
	 /*
	 public Panier clone() throws CloneNotSupportedException
	 {}*/
	@Override
	public String toString() {
		return "Panier [montant=" + montant + "]";
	}

	 
}
