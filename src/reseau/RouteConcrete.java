package reseau;

public class RouteConcrete implements Route {
	
	private Ville ville1;
	private Ville ville2;
	private double distance;
	
	public RouteConcrete(Ville v, Ville w, double distance) {
		/*Constructor*/
		this.ville1 = v;
		this.ville2 = w;
		this.distance = distance;
	}
	
	public RouteConcrete(Route r, Route s) {
		/*Constructor*/
		if(r.appartient(s.ville1())) {
			this.ville1 = s.ville2(); 
		} else {
			this.ville1 = s.ville1();
		}
		if(s.appartient(r.ville1())) {
			this.ville2 = r.ville2();
		} else {
			this.ville2 = r.ville1();
		}
		this.distance = r.distance() + s.distance();
	}
	

	@Override
	public Ville ville1() {
		return ville1;
	}

	@Override
	public Ville ville2() {
		return ville2;
	}

	@Override
	public double distance() {
		return distance;
	}

	@Override
	public boolean appartient(Ville v) {
		return v.memeVille(this.ville1()) || v.memeVille(this.ville2());
	}

	@Override
	public boolean ontMemesVilles(Route r) {
		return this.appartient(r.ville1()) && this.appartient(r.ville2());
	}

	@Override
	public boolean memeRoute(Route r) {
		return this.ontMemesVilles(r) && this.distance() == r.distance();
	}

	@Override
	public boolean meilleur(Route r) {
		return r.distance() < this.distance();
	}

	@Override
	public boolean seSuivent(Route r) {
		return !this.ontMemesVilles(r) && (this.appartient(r.ville1())  || this.appartient(r.ville2()));
	}
	@Override
    public String toString() {
        return "[("+ this.ville1.nom()+"_"+this.ville1.population()+")_("+ this.ville2.nom()+"_"+this.ville2.population()+"):"+this.distance()+"]";
    }
	public static void main(String[] args) {
        Ville v1 = new VilleConcrete("Saint Brieuc", 45105);
        Ville v2 = new VilleConcrete("Rouen", 110169);
        Ville v3 = new VilleConcrete("Toulouse", 471941);
        Route r1 = new RouteConcrete(v1,v2,400.0);
        Route r2 = new RouteConcrete(v2,v3,800.0);
        Route r3 = new RouteConcrete(v2,v1,400.0);
        System.out.println(r1);
        System.out.println(r2.memeRoute(r3));
        System.out.println(r2.memeRoute(r1));
        Ville v4 = new VilleConcrete("Paris", 2185526);
        Route r4 = new RouteConcrete(v1,v4,448.7);
        System.out.println(r2);
        System.out.println(r1.seSuivent(r2));
        System.out.println(r2.seSuivent(r4));
        Route r5 = new RouteConcrete(v1,v2,600.5);
        System.out.println(r1.meilleur(r5));
        System.out.println(r5.meilleur(r1)); 
        Route r6 = new RouteConcrete(r1,r2);
        System.out.println(r6);
    }

}
