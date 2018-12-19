package fr.eni_ecole.commande.modele.bo;

public abstract class Ligne {
	

	protected int qte; 
	protected float prix;
	private Article article; 
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Ligne(Article article, int qte) {
		this.setArticle(article);
		this.setQte(qte);
	}
	
	

	@Override
	public String toString() {
		return "Ligne [qte=" + qte + ", prix=" + prix + "]";
	}
	
	
	
}
