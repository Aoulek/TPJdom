package tpjdom.pk;
import java.io.*; 
import org.jdom.*; 
import org.jdom.output.*; 

public class JDOM1 {
	// Nous allons commencer notre arborescence en créant la racine XML "personnes".
	static Element racine = new Element("personnes"); 
	// On crée un nouveau Document JDOM basé sur la racine que l'on vient de créer
	static org.jdom.Document document = new Document(racine);
	// Ajouter ces deux méthodes à notre classe JDOM1
	static void affiche() { try { 
		// On utilise ici un affichage classique avec getPrettyFormat()
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat()); 
		sortie.output(document, System.out); 
		} catch (java.io.IOException e) { } } 
	static void enregistre(String fichier) { try {
		
	
	
	// On utilise ici un affichage classique avec getPrettyFormat()
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat()); 
		// Remarquez qu'il suffit simplement de créer une instance deFileOutputStream
		// avec en argument le nom du fichier pour effectuer lasérialisation.
		sortie.output(document, new FileOutputStream(fichier)); 
		} catch (java.io.IOException e) { } } 
	static void ajouterEtudiant(String pnom,String pprenom, String pclasse) { try { 
		// On crée un nouvel Element etudiant et on l'ajoute en tant qu'Element deracine
		Element etudiant = new Element("etudiant"); 
		racine.addContent(etudiant); 
		// On crée un nouvel Attribut classe et on l'ajoute à etudiant
		Attribute classe = new Attribute("classe", pclasse); 
		etudiant.setAttribute(classe); 
		// On crée les élements nom et prenom
		Element nom = new Element("nom"); 
		Element prenom = new Element("prenom"); 
		// On remplie les textes des élements nom et prenom
		nom.setText(pnom); 
		prenom.setText(pprenom); 
		// On ajoute le contenu des élements nom et prenom à l'élement étudiant
		etudiant.addContent(nom); 
		etudiant.addContent(prenom); 
		} catch (Exception e) { } } 
	public static void main(String[] args) { 
		JDOM1.ajouterEtudiant("SARSRI", "Hamid", "LSI1"); 
		JDOM1.ajouterEtudiant("KRIMI", "Nihal", "LSI2"); 
		JDOM1.ajouterEtudiant("SALMI", "Jawad", "LSI3"); 
		JDOM1.ajouterEtudiant("RAHALI", "Imad", "LSI3");  
		JDOM1.enregistre("Exercice1.xml"); JDOM1.affiche(); } 


}