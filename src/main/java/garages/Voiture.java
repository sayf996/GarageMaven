package garages;

import java.io.PrintStream;
import java.util.*;

public class Voiture {

	private final String immatriculation;
	private final List<Stationnement> myStationnements = new LinkedList<>();

	public Voiture(String i) {
		if (null == i) {
			throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
		}

		immatriculation = i;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Fait rentrer la voiture au garage 
         * Précondition : la voiture ne doit pas être déjà dans un garage
	 *
	 * @param g le garage où la voiture va stationner
	 * @throws java.lang.Exception Si déjà dans un garage
	 */
	public void entreAuGarage(Garage g) throws Exception {
		// Et si la voiture est déjà dans un garage ?
                if(this.estDansUnGarage()){
                    throw new Exception ("The car is already in a Garage");
                }
		Stationnement s = new Stationnement(this, g);
		myStationnements.add(s);
	}

	/**
	 * Fait sortir la voiture du garage 
         * Précondition : la voiture doit être dans un garage
	 *
	 * @throws java.lang.Exception si la voiture n'est pas dans un garage
	 */
	public void sortDuGarage() throws Exception {
		if (this.estDansUnGarage()){                                       
                    Stationnement lastStationnement = myStationnements.get(this.myStationnements.size()-1);
                    lastStationnement.terminer();                                      
                }
                else {
                    throw new Exception("The Car is not in the garage yet");
                }
                }
	

	/**
	 * @return l'ensemble des garages visités par cette voiture
	 */
	public Set<Garage> garagesVisites() {
		Set<Garage> garagesVisites = new HashSet<>();
                Iterator<Stationnement> stationnementsIt = myStationnements.iterator();
                while (stationnementsIt.hasNext()){
                     garagesVisites.add(stationnementsIt.next().getGarage());
        }
                return garagesVisites;
                
	}

	/**
	 * @return vrai si la voiture est dans un garage, faux sinon
	 */
	public boolean estDansUnGarage() {
		if (!myStationnements.isEmpty()){
                    Stationnement lastStationnement = myStationnements.get(myStationnements.size()-1);
                    if(lastStationnement.estEnCours()){
                    return true;
                    }
                }
                return false;
        }
                
                    
		// Vrai si le dernier stationnement est en cours
	


	/**
	 * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste des dates d'entrée / sortie dans ce
	 * garage
	 * <br>Exemple :
	 * <pre>
	 * Garage Castres:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 *		Stationnement{ entree=28/01/2019, en cours }
	 *  Garage Albi:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 * </pre>
	 *
	 * @param out l'endroit où imprimer (ex: System.out)
	 */
	public void imprimeStationnements(PrintStream out) {
		 Iterator<Garage> garagesIterator = this.garagesVisites().iterator();                
                while (garagesIterator.hasNext()){
                    Iterator<Stationnement> stationnementIt = myStationnements.iterator();
                    Garage garage = garagesIterator.next();
                    out.println(garage.toString());
                    while (stationnementIt.hasNext()){
                        Stationnement place = stationnementIt.next();
                        if (garage.equals(place.getGarage())) {
                            out.println(place.toString());
	}

}}}}
