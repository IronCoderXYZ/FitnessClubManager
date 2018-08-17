package fitnessclubmanager;

import java.util.LinkedList;

public class FitnessClubManager {
    public static void main(String[] args) {
        String mem;
        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();
        LinkedList<Member> members = fh.readFile();
        int choice = mm.getChoice();

        while (choice != -1) {
            switch (choice) {
                case 1:
                    mem = mm.addMember(members);
                    fh.appendFile(mem);
                    break;
                case 2:
                    mm.removeMember(members);
                    fh.overwriteFile(members);
                    break;
                case 3:
                    mm.printMemberInfo(members);
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
            choice = mm.getChoice();
        }
        System.out.println("Thanks for using Fitness Club Manager, have a great day!");
    }
}
