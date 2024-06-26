package FamilyMembers;

import java.util.ArrayList;

public abstract class FamilyMember {

    private String name;
    private String birthday;
    private ArrayList<FamilyMember> parents;
    private ArrayList<FamilyMember> children;
    private FamilyMember spouse;

    public FamilyMember(String n, String bd){
        this.name = n;
        this.birthday = bd;
        this.parents = new ArrayList<FamilyMember>();
        this.children = new ArrayList<FamilyMember>();
    }

    public void addParent(FamilyMember p){
        if(this.parents.size() < 2){
            this.parents.add(p);
        }
        else{
            System.out.println("This FamilyMember already has two parents.");
        }
    }

    public void addChild(FamilyMember c){
        this.children.add(c);
    }

    public void addSpouse(FamilyMember s){
        this.spouse = s;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }    

    public ArrayList<FamilyMember> getParents() {
        return parents;
    }

    public ArrayList<FamilyMember> getChildren() {
        return children;
    }

    public FamilyMember getSpouse() {
        if(this.spouse == null){
            System.out.println("This FamilyMember has no spouse.");
            return null;
        }
        else{
            return spouse;
        }
        
    }

    public abstract String getInfo();
}
