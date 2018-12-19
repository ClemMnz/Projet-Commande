/**
 * 
 */
package fr.eni_ecole.commande.application;

import java.util.ArrayList;
import java.util.List;

import fr.eni_ecole.commande.exception.PoolCreateObjectException;
import fr.eni_ecole.commande.modele.bo.Article;
import fr.eni_ecole.commande.modele.bo.Catalogue;
import fr.eni_ecole.commande.modele.bo.Panier;
import fr.eni_ecole.commande.modele.bo.Ramette;
import fr.eni_ecole.commande.modele.bo.Stylo;
/*
import fr.eni_ecole.commande.enumeration.SortArticleEnum;
import fr.eni_ecole.commande.exception.PoolCreateObjectException;
import fr.eni_ecole.commande.modele.bo.Article;
import fr.eni_ecole.commande.modele.bo.Catalogue;
import fr.eni_ecole.commande.modele.bo.Commande;
import fr.eni_ecole.commande.modele.bo.LignePanier;
import fr.eni_ecole.commande.modele.bo.Panier;
import fr.eni_ecole.commande.modele.bo.Ramette;
import fr.eni_ecole.commande.modele.bo.Stylo;
*/
/**
 * @author Eni Ecole
 *
 */
public class AppliTestBO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Article> articles=null;
		Catalogue catalogue=null;
		try {
			//Constituer une liste d'articles
			articles = new ArrayList<Article>();
			
	        //********************************
	        // tester la gestion des articles
	        //********************************
			
			Stylo unBic = new Stylo("Bic", "BBOrange","Bic bille Orange", (float)1.2, 20, "Bleu");
			System.out.println("\nREM : Affichage d'un article Stylo 'Bic'");
			System.out.println(unBic.toString());
			System.out.println("---------------------------------------------------------------");
			Ramette uneRamette = new Ramette("Clairef", "CRA4S", "Ramette A4 Sup", (float)9, 20, 80);
			System.out.println("\nREM : Affichage d'un article Ramette 'Clairefontaine'");
			System.out.println(uneRamette.toString());
			System.out.println("---------------------------------------------------------------");
			 
			
			// Ajout des articles à la liste. 
			articles.add(unBic);
			articles.add(uneRamette);
			
			
			articles.add(new Stylo("Stypen", "PlumeS", "Stylo Plume Stypen", (float)5.5, 20, "jaune"));
			articles.add(new Stylo("Waterman", "WOBGreen", "Waterman Orion Bille vert",(float)5.5, 20, "vert"));
			articles.add(new Stylo("Parker", "PlumeP", "Stylo Plume Parker", (float)5.5, 5, "noir"));
			
			Article[] articlesAAjouter =new Article[articles.size()];
			for(int i=0;i<articles.size();i++)
			{
				articlesAAjouter[i]=articles.get(i);
			}
			
			System.out.println("\nREM : Affichage du catalogue");
			//charger les articles dans le catalogue
			catalogue = new Catalogue(articlesAAjouter);
			System.out.println(catalogue.toString());		
			System.out.println("---------------------------------------------------------------");
			
			//tester la remontée d'exceptions sur la création d'un article
			try{
				articles.add(new Stylo(" ",null," ",-2.3f,-10," "));
			} catch (PoolCreateObjectException e){
				System.err.println(e.getMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		//******************
		//tester le Panier
		//******************
		Panier panier = new Panier();
		try {
			//à l'ajout d'une ligne dans le panier, le stock virtuel de l'article doit diminuer
			//On ne peut commander plus que ce qu'il y a dans le stock virtuel (PlusEnStockException)
			panier.addLigne(articles.get(0), 2);
			System.out.println("\nREM : Affichage de l'article de la premiere ligne du panier");
			System.out.println(panier.getLigne(0).getArticle());
			System.out.println("---------------------------------------------------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("ERREUR : " + e.getMessage());
		}

		
		try {
			panier.addLigne(articles.get(1), 13);
			panier.addLigne(articles.get(2), 12);
			System.out.println("\nREM : Un article n'a pas une quantité suffisante en stock");
			//déclencher l'exception PlusEnStockException
			panier.addLigne(articles.get(3), 30);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("ERREUR : " + e.getMessage());
		}
		
		try {
			System.out.println("\nREM : Affichage du panier - Ajout");
			System.out.println(panier.toString());
			System.out.println("---------------------------------------------------------------");
			
			System.out.println("\nREM : Affichage du catalogue - Stock à jour");
			//on réaffiche le catalogue (les stocks sont à jour)
			//Catalogue catalogue = new Catalogue(articles);
			System.out.println(catalogue.toString());		
			System.out.println("---------------------------------------------------------------");
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("ERREUR : " + e.getMessage());
		}
		/*
		try {
			System.out.println("\nREM : Modification du panier");
			//modifier une ligne du panier
			panier.updateLigne(0, 3); // +1 de BBOrange
			panier.updateLigne(1, 12); // -1 de CRA4S
			//supprimer une ligne du panier
			panier.removeLigne(2); // suppression de PlumeS
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("ERREUR : " + e.getMessage());
		}

		try {
			System.out.println("\nREM : Affichage du panier - Modification");
			System.out.println(panier.toString());
			System.out.println("---------------------------------------------------------------");
			
			System.out.println("\nREM : Affichage du catalogue - Stock à jour");
			//on réaffiche le catalogue (les stocks sont à jour)
			Catalogue catalogue = new Catalogue(articles);
			System.out.println(catalogue.toString());	
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("ERREUR : " + e.getMessage());
		}
		
		Commande commande = null;
		try {
			commande = new Commande(panier,"Edmond BOSAPIN");
			//Visualiser la commande de Edmond BOSAPIN
			System.out.println("\nREM : Affichage de la commande");
			System.out.println(commande.toString());
			System.out.println("---------------------------------------------------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//**************************
		//tester le tri du Catalogue
		//**************************
		/*Catalogue catalogue = new Catalogue(articles);
		catalogue.sort(SortArticleEnum.DEFAULT);
		System.out.println("\nREM : Affichage du catalogue - Tri sur prix");
		System.out.println(catalogue.toString());		
		System.out.println("---------------------------------------------------------------");
		
		catalogue.sort(SortArticleEnum.MARQUE);
		System.out.println("\nREM : Affichage du catalogue - Tri sur marque");
		System.out.println(catalogue.toString());		
		System.out.println("---------------------------------------------------------------");
		*/
		//***************************
		//tester le clonage du panier
		//***************************
		/*try {
			Panier panierClone = null;

			panierClone=(Panier)panier.clone();

			if (panierClone!=null){
				System.out.println("\nREM : Comparer les panier suite au clonage");
				System.out.println(unitTestClone_toString(panier,panierClone));		
				System.out.println("---------------------------------------------------------------");
				
				//modifier le clone
				panierClone.removeLigne(0);
				panierClone.updateLigne(0, 5);
				panierClone.addLigne(catalogue.getArticlesAuCatalogue().get(4), 6);
	
				
				System.out.println("\nREM : Comparer les paniers suite à modification du clone");
				System.out.println(unitTestClone_toString(panier,panierClone));		
				System.out.println("---------------------------------------------------------------");
			}
		} catch (CloneNotSupportedException e) {
			System.err.println("impossible de cloner le panier");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ 

	}
	
  //méthodes de validation du clonage
  
  /**
   * Tester le clonage
   * @param clone
   * @return
   */
  /*public static String unitTestClone_toString(Panier origine, Panier clone){
		StringBuffer bf =new StringBuffer();
		bf.append("Panier  : origine -> " + origine.hashCode() + " clone -> " + clone.hashCode() + " \n");
		bf.append("Conteneur Lignes : origine -> " + origine.getLignesPanier().hashCode() + " clone -> " + clone.getLignesPanier().hashCode() + " \n");
		bf.append("\nDetail lignes origine -> \n");
		for (LignePanier ligne : origine.getLignesPanier()) {
			bf.append("ligne origine -> " + ligne.toString() + "\n");
		}
		bf.append("\nDetail lignes clone -> \n");
		for (LignePanier ligne : clone.getLignesPanier()) {
			bf.append("ligne clone -> " + ligne.toString() + "\n");
		}
		bf.append("\nMontant : origine -> " + origine.getMontant() + " clone -> " + clone.getMontant() + " \n\n");
		return bf.toString();
  }*/

}
