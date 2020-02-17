package reseau;

public interface Ville {

	/**
	 * @method 	 nom
     * @param    none
     * @return   city name
     */
    String nom();

    /**
     * @method 	 population
     * @param    none
     * @return   the number of inhabitants of the city
     */
    int population();

    /**
     * @method 	 memeVille
     * @param    one city
     * @return   true if the cities v and this are the same (same name and same number of inhabitants), false otherwise
     */
    boolean memeVille(Ville v);

}