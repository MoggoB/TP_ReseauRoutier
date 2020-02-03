package reseau;

public interface Ville {

    String nom();
    //return city name

    int population();
    //return the number of inhabitants of the city

    boolean memeVille(Ville v);
    // return true if the cities v and this are the same.
    //(same name and same number of inhabitants)
}