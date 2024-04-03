package FamilyTree;

import java.util.ArrayList;
import FamilyMembers.FamilyMember;

public class Client {

    private ArrayList<FamilyMember> familyTree;

    public Client() {
        this.familyTree = new ArrayList<>();
    }

    public ArrayList<FamilyMember> getFamilyTree() {
        return familyTree;
    }

    public void addFamilyMember(FamilyMember member) {
        familyTree.add(member);
    }

    public void removeFamilyMember(FamilyMember member) {
        familyTree.remove(member);
    }
}
