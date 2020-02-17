package reseau;

import java.util.List;

public interface Reseau extends Iterable<Route>{
	
	/**
	 * @method 	 taille
     * @param    none
     * @return   the number of roads in the network
     */
	int taille();
	
	/**
	 * @method 	 routes
     * @param    none
     * @return   the list of network routes
     */
	List<Route> routes();
	
	/**
	 * @method 	 routes
     * @param    one city
     * @return   the list of roads of the network this that start from the city v
     */
	List<Route> routes(Ville v);
	
	/**
	 * @method 	 route
     * @param    an int 
     * @return   the i-th road of the network
     */
	Route route(int i);
	
	/**
	 * @method 	 ajouterRoute
	 * adds the road r to the network
     * @param    a road
     * @return   none
     */
	void ajouterRoute(Route r);
	
	/**
	 * @method 	 estDans
     * @param    a road
     * @return   true if the road r is the same as one of the roads in the network, false otherwise
     */
	boolean estDans(Route r);
	
	/**
	 * @method 	 bonneRoute
     * @param    a road
     * @return   true if the road r connects two cities that are not connected by a better road (shorter than r) in the network, false otherwise
     */
	boolean bonneRoute(Route r);
	
	/**
	 * @method 	 unionReseaux
     * @param    a network
     * @return   a network that contains the best roads of res and this (shorter roads connecting the same cities)
     */
	Reseau unionReseaux(Reseau res);
	
	/**
	 * @method 	 produitRoutes
     * @param    a network
     * @return   a network that contains the best (shortest) roads r formed by a road of res followed by a road of this
     */
	Reseau produitRoutes(Reseau  res);
	
	/**
	 * @method 	 chemins3
     * @param    none
     * @return   a network that contains the shortest roads that can be taken from any city to any city by crossing a maximum of three roads (two cities) of this
     */
	Reseau chemins3();

	/**
	 * @method 	 chemins
	 * Generalization of chemins3 method
     * @param    none
     * @return   a network that contains the shortest roads that can be taken from any city to any city of this
     */
	Reseau chemins();
}
