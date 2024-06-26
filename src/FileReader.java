import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import FamilyMembers.Deceased;
import FamilyMembers.FamilyMember;
import FamilyMembers.Living;

public class FileReader {

    public static ArrayList<FamilyMember> readInputFile(String filename) throws FileNotFoundException {
        ArrayList<FamilyMember> people = new ArrayList<>();
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            String[] array = line.split(", ");
            if (array.length == 3) {
                Deceased person = new Deceased(array[0], array[1], array[2]);
                people.add(person);
                System.out.println("Added " + person.getName());
            } else {
                Living person = new Living(array[0], array[1], array[2] + ", " + array[3]);
                people.add(person);
                System.out.println("Added " + person.getName());
            }
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
                String[] array = line.split(", ");
                if(array[1].compareTo("marriedto") == 0){
                    FamilyMember a = null;
                    FamilyMember b = null;
                    for(int i = 0; i < people.size(); i++){
                        if(array[0].compareTo(people.get(i).getName()) == 0){
                            a = people.get(i);
                        }
                        if(array[2].compareTo(people.get(i).getName()) == 0){
                            b = people.get(i);
                        }
                    }
                    a.addSpouse(b);
                    b.addSpouse(a);
                    System.out.println("Spouse added.");
                }
                else{
                    FamilyMember a = null;
                    FamilyMember b = null;
                    for(int i = 0; i < people.size(); i++){
                        if(array[0].compareTo(people.get(i).getName()) == 0){
                            a = people.get(i);
                        }
                        if(array[2].compareTo(people.get(i).getName()) == 0){
                            b = people.get(i);
                        }
                    }
                    if(b.getParents().size() == 2){
                        System.err.println("Cannot add second parent!");
                    }
                    else{
                        a.addChild(b);
                        b.addParent(a);
                        System.out.println("Parent / Child Relationship Added.");
                    }
                }
            }
            scanner.close();
            return people;
    }
}