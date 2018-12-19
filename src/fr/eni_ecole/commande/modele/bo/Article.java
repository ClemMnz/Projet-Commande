package fr.eni_ecole.commande.modele.bo;

import fr.eni_ecole.commande.exception.ArgumentException;
import fr.eni_ecole.commande.exception.PlusEnStockException;

public  abstract class Article {

	
	
		private String reference;
		private String marque;
		private String designation; 
		private float prixUnitaire;
		private int qteStock ; 
		
		public int getQteStock() {
			return qteStock;
		}
		public void setQteStock(int qteStock)throws ArgumentException {
			if(qteStock>0){
			this.qteStock = qteStock;}
			else{
				throw new ArgumentException("qtéStock", "Cet attribut est obligatoire");
				
			}
		}
		public String getReference() {
			return reference;
		}
		
		protected void setReference(String reference) throws ArgumentException {
			if(reference!=null && !reference.trim().equals(""))
			{
				this.reference = reference;
			}
			else
			{
				throw new ArgumentException("reference","Cet attribut est obligatoire.");
			}
		}
		public String getMarque() {
			return marque;
		}
		protected void setMarque(String marque) throws ArgumentException {
			if(marque!=null && !marque.trim().equals(""))
			{
				this.marque = marque;
			}
			else
			{
				throw new ArgumentException("marque","Cet attribut est obligatoire.");
			}
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) throws ArgumentException {
			if(designation!=null && !designation.trim().equals(""))
			{
				this.designation = designation;
			}
			else
			{
				throw new ArgumentException("designation","Cet attribut est obligatoire.");
			}
			
		}
		public float getPrixUnitaire() {
			return prixUnitaire;
		}
		public void setPrixUnitaire(float prixUnitaire) throws ArgumentException {
			if(prixUnitaire>0)
			{
				this.prixUnitaire = prixUnitaire;
			}
			else
			{
				throw new ArgumentException("prixUnitaire","Une valeur positive est attendue");
			}
		}		@Override
		public String toString() {
			return "Article [reference=" + reference + ", marque=" + marque + ", designation=" + designation
					+ ", prixUnitaire=" + prixUnitaire + ", qteStock=" + qteStock + "]";
		}


		protected void entrerStock(int qte){
			
			
		}
		protected void sortirStock(int qte) throws PlusEnStockException
		{
			if(qte<=this.qteStock)
			{
				this.qteStock-=qte;
			}
			else
			{
				throw new PlusEnStockException(this, qte);
			}
		}
}
