package fr.eni_ecole.commande.modele.bo;

public class LigneCommande extends Ligne {

	
	private int numero; 
	
	public LigneCommande(int numero, int qte,Article article, float prix) {
		super(qte, prix);
		this.setNumero(numero);
		 
		
		
	}
	
	
	public LigneCommande(int qte, float prix) {
		super(qte, prix);
		// TODO Auto-generated constructor stub
	}


	public LigneCommande(int numero, LignePanier ligne){
		 
		this.setNumero(numero);
		
		
		
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setPrix(float prix){
		this.prix= prix; 
		
	}
	@Override
	public String toString() {
		return "LigneCommande [numero=" + numero + "]";
	}

	
}
