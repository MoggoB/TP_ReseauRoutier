package reseau;

public class VilleConcrete implements Ville {
    private String nom;
    private int population;

    public VilleConcrete(String nom, int population){
        //Constructor
        //return a town called "nom" and
        //whose number of inhabitants is "population"
        this.nom = nom;
        this.population = population;
    }

    @Override
    public String nom() {
        return nom;
    }

    @Override
    public int population() {
        return population;
    }

    @Override
    public boolean memeVille(Ville v) {
        return (this.population() == v.population()) && (this.nom().equals(v.nom()));
    }

    @Override
    public String toString() {
        //the name of the city and its population in brackets
        return "("+ this.nom()+"_"+this.population()+")";
    }

    public static void main(String[] args) {
        Ville v1 = new VilleConcrete("Saint Brieuc", 45105);
        Ville v2 = new VilleConcrete("Rouen", 110169);
        System.out.println(v1);
        System.out.println(v1.memeVille(v2));
        Ville v3 = new VilleConcrete("Rouen", 110169);
        System.out.println(v3.memeVille(v2));
    }

}