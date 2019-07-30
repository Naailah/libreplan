package Projet;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import Configuration.PageProfilsListe;
import GR4.LibrePlan4.Outils;
import GR4.LibrePlan4.Test_connexion;

public class TestProjet extends Test_connexion {

	@Test
	public void projet() throws Exception {
		PageProjet page_projet = PageFactory.initElements(driver, PageProjet.class);
		PageNewProject page_new_projet = page_projet.addProject(driver);
		page_new_projet.checkForm();

		// Renseigner le champ Nom
		page_new_projet.renseignerNom("PROJET_TEST1");
		page_new_projet.decocherCase();
		Thread.sleep(1000);

		// Renseigner le champ code
		page_new_projet.renseignerCode("PRJTEST001");

		// Changer la date de début
		page_new_projet.changerDateDebut(5);

		// Changer la date de début
		page_new_projet.changerDateEcheance(15);

		// Cliquer sur accepter
		OngletWBS onglet = page_new_projet.cliquerAccepter(driver);

		// Vérifier la présence du menu Detail du projet
		onglet.verifierBoutonDetail();
		
		//Vérifier les onglets - menu vertical 
		onglet.verifierMenuVertical();
		
		//Vérifier les onglets - menu horizontal
		onglet.verifierMenuHorizontal();
		
		// Vérifier Bouton d'enregistrement
		onglet.verifierBoutonSave(driver);	
		
		// Vérifier Bouton d'annulation
		onglet.verifierBoutonAnnuler(driver);
		
		// Cliquer bouton annuler + vérifications
		onglet.cliquerBoutonAnnulerEdition(driver);
		
		//Cliquer sur le bouton annuler de la popup
		onglet.cliquerBoutonAnnulerPopup(driver);
		
		// Vérifier la présence du menu Detail du projet
		onglet.verifierBoutonDetail();
		
		// Vérifier la présence de l'onglet WBS
		onglet.verifierOngletWBS();
		
		// Cliquer bouton annuler + vérifications
		onglet.cliquerBoutonAnnulerEdition(driver);
		
		// Cliquer bouton OK
		 page_projet = onglet.cliquerBoutonOKPopup(driver);
		
		// Vérifier la création du projet 
		PageListeProjets page_liste_projets = page_projet.mouseoverCalendrier_Projet(driver);
		page_liste_projets.verifierProjet("PROJET_TEST1");
		
		//Vérifier les détails du projet
		String datePlus5 = Outils.datePlus(5);
		String datePlus15 = Outils.datePlus(15);
		page_liste_projets.verifierDetailsProjet(" PROJET_TEST1 PRJTEST001 "+datePlus5+" "+datePlus15+"  0 € 0 PRE-VENTES ");
		
		//Vérifier les icones
		page_liste_projets.verifierIcones();
	}
	
}