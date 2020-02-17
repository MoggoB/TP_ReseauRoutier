package reseau;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReseauConcrete implements Reseau {

	private List<Route> routes;
	
	public ReseauConcrete() {
		/*Constructor*/
		routes = new ArrayList<Route>();
	}
	

	@Override
	public Iterator<Route> iterator() {
		return routes.iterator();
	}

	@Override
	public int taille() {
		return routes.size();
	}

	@Override
	public List<Route> routes() {
		return routes;
	}

	@Override
	public List<Route> routes(Ville v) {
		List<Route> tmp = new ArrayList<Route>();
		for(Route route:this.routes()) {
			if(route.appartient(v)) {
				tmp.add(route);
			}
		}
		return tmp;
	}

	@Override
	public Route route(int i) {
		return this.routes().get(i);
	}

	@Override
	public void ajouterRoute(Route r) {
		this.routes().add(r);
	}

	@Override
	public boolean estDans(Route r) {
		return this.routes.contains(r);
	}

	@Override
	public boolean bonneRoute(Route r) { 
		for(Route route:this.routes()) {
			if(route.ontMemesVilles(r)) {
				return route.meilleur(r);
			}
		}
		return true;
	}
	

	@Override
	public Reseau unionReseaux(Reseau res) {
		Reseau union = new ReseauConcrete();
		//add all route_this
		union.routes().addAll(this.routes());
		for(Route route_res:res.routes()) {
			if(union.bonneRoute(route_res)) {
				//replace route_this by route_res in union if route_res is better than route_this
				for(Route route:union.routes()) {
					if(route.ontMemesVilles(route_res)) {
						union.routes().remove(route);
						break;
					}
				}
				union.ajouterRoute(route_res);
			}
		}
		return union;
	}

	@Override
	public Reseau produitRoutes(Reseau res) {
		Reseau produit = new ReseauConcrete();
		//compare roads this and res two by two
		for(Route route_this:this.routes()) {
				for(Route route_res:res.routes()) {
					if(route_this.seSuivent(route_res) ) {
						Route new_route = new RouteConcrete(route_this, route_res);
						if(!produit.estDans(new_route) && produit.bonneRoute(new_route)) {
							//replace the road that is already in produit with the best road
							produit.routes().removeIf(route_produit -> route_produit.ontMemesVilles(new_route));
							produit.ajouterRoute(new_route);
						}
					}
				}
		}
		return produit;
	}

	@Override
	public Reseau chemins3() {
		Reseau produit2 = this.produitRoutes(this);
		Reseau union = this.unionReseaux(produit2);
		Reseau produit3 = this.produitRoutes(produit2);
		return union.unionReseaux(produit3);


	}

	@Override
	public Reseau chemins() {
		Reseau chemins = new ReseauConcrete();
		chemins.routes().addAll(this.routes());
		for(int i=0; i<this.taille(); i++) {
			Reseau produit = this.produitRoutes(chemins);
			chemins = chemins.unionReseaux(produit);
		}
		return chemins;
	}

	@Override
    public String toString() {
		String str = "";
		for(Route route:this.routes()) {
			str+=route.toString()+".";
		}
		return str;
    }
	
	public static void main(String[] args) {
		
		// Ville

		Ville arras = new VilleConcrete("Arrras", 40000);
		Ville nantes = new VilleConcrete("Nantes", 300000);
		Ville strasbourg = new VilleConcrete("Strasbourg", 270000);
		Ville paris = new VilleConcrete("Paris", 2000000);
		Ville lyon = new VilleConcrete("Lyon", 500000);
		Ville brest = new VilleConcrete("Brest", 100000);
		Ville marseille = new VilleConcrete("Marseille", 800000);
		Ville poitiers = new VilleConcrete("Poitiers", 90000);
		Ville bordeaux = new VilleConcrete("Bordeaux", 200000);
		Ville montpellier = new VilleConcrete("Montpellier", 200000);

		// Route

		Route arras_nantes = new RouteConcrete(arras, nantes,561.0);
		Route arras_strasb = new RouteConcrete(arras, strasbourg, 522.0);
		Route arras_paris = new RouteConcrete(arras, paris, 185.0);
		Route nantes_brest = new RouteConcrete(nantes, brest, 298.0);
		Route nantes_paris = new RouteConcrete(nantes, paris, 386.0);
		Route nantes_bord = new RouteConcrete(nantes, bordeaux, 334);
		Route strasb_lyon = new RouteConcrete(strasbourg, lyon, 494.0);
		Route strasb_montp = new RouteConcrete(strasbourg, montpellier, 797);
		Route strasb_mars = new RouteConcrete(strasbourg, marseille, 809);
		Route brest_paris = new RouteConcrete(brest, paris, 593);
		Route paris_lyon = new RouteConcrete(paris, lyon, 465);
		Route paris_poitier = new RouteConcrete(paris, poitiers, 338);
		Route lyon_mars = new RouteConcrete(lyon, marseille, 315);
		Route lyon_montp = new RouteConcrete(lyon, montpellier, 303);
		Route mars_montp = new RouteConcrete(marseille, montpellier, 171);
		Route poitier_bord = new RouteConcrete(poitiers, bordeaux, 237);
		Route poitier_montp = new RouteConcrete(poitiers, montpellier, 557);


		// Reseau

		Reseau res = new ReseauConcrete();

		res.ajouterRoute(arras_nantes);
		res.ajouterRoute(arras_paris);
		res.ajouterRoute(arras_strasb);
		res.ajouterRoute(nantes_brest);
		res.ajouterRoute(nantes_paris);
		res.ajouterRoute(nantes_bord);
		res.ajouterRoute(strasb_lyon);
		res.ajouterRoute(strasb_montp);
		res.ajouterRoute(strasb_mars);
		res.ajouterRoute(brest_paris);
		res.ajouterRoute(paris_lyon);
		res.ajouterRoute(paris_poitier);
		res.ajouterRoute(lyon_mars);
		res.ajouterRoute(lyon_montp);
		res.ajouterRoute(mars_montp);
		res.ajouterRoute(poitier_bord);
		res.ajouterRoute(poitier_montp);


		// Chemins
		
		Reseau chemins = res.chemins();


		System.out.println(chemins.taille());
		System.out.println(chemins);
    }

}
