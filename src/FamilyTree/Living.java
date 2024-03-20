public class Living extends FamilyMember{

    private String residence;

    public Living(String n, String bd, String r){
        super(n, bd);
        this.residence = r;
    }

    public String getResidence() {
        return this.residence;
    }
    
}
