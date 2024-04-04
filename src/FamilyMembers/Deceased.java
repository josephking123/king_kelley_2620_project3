package FamilyMembers;

public class Deceased extends FamilyMember{

    private String dod;

    public Deceased(String n, String bd, String d){
        super(n, bd);
        this.dod = d;
    }

    @Override
    public String getInfo() {
        return dod;
    }
}
