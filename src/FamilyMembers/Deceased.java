public class Deceased extends FamilyMember{

    private String dod;

    public Deceased(String n, String bd, String d){
        super(n, bd);
        this.dod = d;
    }

    public String getDOD() {
        return dod;
    }

}
