package FamilyMembers;

public class Living extends FamilyMember{

    private String residence;

    public Living(String n, String bd, String r){
        super(n, bd);
        this.residence = r;
    }

    public String getInfo() {
        return this.residence;
    }
    
}
