package fitnessclubmanager;

public class Member {
    private char memberType;
    private int memberID;
    private String name;
    private double fees;

    public Member(char pMemberType, int pMemberID, String pName, double pFees) {
        memberType = pMemberType;
        memberID = pMemberID;
        name = pName;
        fees = pFees;
    }

    public char getMemberType() {
        return memberType;
    }

    public void setMemberType(char pMemberType) {
        memberType = pMemberType;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int pMemberID) {
        memberID = pMemberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double pFees) {
        fees = pFees;
    }

    @Override
    public String toString() {
        String output = String.format(
                "Type: %c, ID: %d, Name: %s, Fees: %f", memberType, memberID, name, fees
        );
        return output;
    }
}
