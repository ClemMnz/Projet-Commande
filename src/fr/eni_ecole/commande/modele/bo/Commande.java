package fr.eni_ecole.commande.modele.bo;

import java.util.Date;

public class Commande {

	private String numero ; 
	private String nomClient; 
	private Date dateCommande;
	private float montant;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	@Override
	public String toString() {
		return "Commande [numero=" + numero + ", nomClient=" + nomClient + ", dateCommande=" + dateCommande
				+ ", montant=" + montant + "]";
	} 
	
	
	
	
}
