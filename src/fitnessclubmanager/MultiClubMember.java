package fitnessclubmanager;

public class MultiClubMember extends Member {
    private int membershipPoints;

    public MultiClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pMembershipPoints) {
        super(pMemberType, pMemberID, pName, pFees);
        membershipPoints = pMembershipPoints;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }
    
    public void setMembershipPoints(int pMembershipPoints) {
        membershipPoints = pMembershipPoints;
    }

    @Override
    public String toString() {
        String output = super.toString() + String.format(
                "Points: %d", membershipPoints
        );
        return output;
    }
}
