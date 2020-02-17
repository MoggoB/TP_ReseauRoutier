package reseau;

public interface Route {
	
	/**
	 * @method 	 ville1
     * @param    none
     * @return   the first city at the end of the road 
     */
	Ville ville1();

	/**
	 * @method 	 ville2
     * @param    none
     * @return   the second city at the end of the road 
     */
	Ville ville2();
	
	/**
	 * @method 	 distance
     * @param    none
     * @return   the distance between these two cities (length of the road)
     */
	double distance();
	
	/**
	 * @method 	 appartient
     * @param    one city
     * @return   true if the city is one of the two towns on the road, false otherwise
     */
	boolean appartient(Ville v);
	
	/**
	 * @method 	 ontMemesVilles
     * @param    one road
     * @return   true if the roads r and this connect the same cities, false otherwise
     */
	boolean ontMemesVilles(Route r);

	/**
	 * @method 	 memeRoute
     * @param    one road
     * @return   true if the roads are the same, false otherwise
     */
	boolean memeRoute(Route r);
	
	/**
	 * @method 	 meilleur
     * @param    one road
     * @return   true if the road r is strictly shorter than the road this, false otherwise
     */
	boolean meilleur(Route r);
	
	/**
	 * @method 	 seSuivent
     * @param    one road
     * @return   true if the roads r and this are different and connected by the same city, false otherwise
     */
	boolean seSuivent(Route r);

}
