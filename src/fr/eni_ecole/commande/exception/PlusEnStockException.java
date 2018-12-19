package fr.eni_ecole.commande.exception;

import fr.eni_ecole.commande.modele.bo.Article;

public class PlusEnStockException extends Exception{
	
	 
		
		private Article articleManquant;
		private int qteDemandee;
		
		
		public PlusEnStockException(Article articleManquant, int qte) {
			this.articleManquant = articleManquant;
			this.qteDemandee = qte;
		}
	
	
}
