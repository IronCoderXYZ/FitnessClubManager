package fitnessclubmanager;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.InputMismatchException;

public class MembershipManagement {
    final private Scanner reader = new Scanner(System.in);

    private int getIntInput() {
        int choice = 0;

        while (choice == 0) {
            try {
                choice = reader.nextInt();

                if (choice == 0) {
                    throw new InputMismatchException();
                }
                reader.nextLine();
            }
            catch (InputMismatchException e) {
                reader.nextLine();
                System.out.println(e.getMessage());
            }
        }

        return choice;
    }

    private void printClubOptions() {
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public int getChoice() {
        System.out.println(
                "Welcome to the Fitness Center" + "\n"
                + "================================" + "\n"
                + "1) Add Member" + "\n"
                + "2) Remove Member" + "\n"
                + "3) Display Member Information" + "\n" + "\n"
                + "Please select an option, or enter -1 to exit."
        );

        int choice = getIntInput();
        return choice;
    }

    public String addMember(LinkedList<Member> m) {
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> cal;

        cal = (n) -> {
          switch (n) {
              case 1: return 900;
              case 2: return 950;
              case 3: return 1000;
              case 4: return 1200;
              default: return -1;
          }
        };

        System.out.println("Member's Name:");
        name = reader.nextLine();
        printClubOptions();
        club = getIntInput();
        while (club < 1 || club > 4) {
            System.out.println("Choice invalid, please try again.");
            printClubOptions();
            club = getIntInput();
        }

        if (m.size() > 0)
            memberID = m.getLast().getMemberID() + 1;
        else
            memberID = 1;

        if (club != 4) {
            fees = cal.calculateFees(club);
            mbr = new SingleClubMember('S', memberID, name, fees, club);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("Member added.");
        } else {
            fees = cal.calculateFees(club);
            mbr = new MultiClubMember('M', memberID, name, fees, 100);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("Member added.");
        }

        return mem;
    }

    public void removeMember(LinkedList<Member> m) {
        System.out.println("Member ID:");
        int memberID = getIntInput();

        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getMemberID() == memberID) {
                m.remove(i);
                System.out.println("Member removed.");
                return;
            }
        }

        System.out.println("Member not removed, was not found.");
    }

    public void printMemberInfo(LinkedList<Member> m) {
        System.out.println("Member ID:");
        int memberID = getIntInput();

        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getMemberID() == memberID) {
                System.out.println(m.get(i).toString());
            }
        }
    }
}
