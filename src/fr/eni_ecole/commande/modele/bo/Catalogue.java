package fr.eni_ecole.commande.modele.bo;

import java.util.Arrays;

public class Catalogue {

	private Article[] articlesAuCatalogue;
	
	/**
	 * @return the articlesAuCatalogue
	 */
	public Article[] getArticlesAuCatalogue() {
		return articlesAuCatalogue;
	}

	public Catalogue(Article[] articlesAuCatalogue) {
		this.articlesAuCatalogue=Arrays.copyOf(articlesAuCatalogue, articlesAuCatalogue.length);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String chaine= "Catalogue [articlesAuCatalogue=" + System.lineSeparator(); 
		for(Article a:this.articlesAuCatalogue)
		{
			if(a!=null)
			{
				chaine+="\t"+a.toString()+System.lineSeparator();
			}
		}
		chaine+="]";
		return chaine;
	}

	
	
}










