package fitnessclubmanager;

public class SingleClubMember extends Member {
    private int club;

    public SingleClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pClub) {
        super(pMemberType, pMemberID, pName, pFees);
        club = pClub;
    }

    public int getClub() {
        return club;
    }

    public void setClub(int pClub) {
        club = pClub;
    }

    @Override
    public String toString() {
        String output = super.toString() + String.format(
                "Club: %d", club
        );
        return output;
    }
}