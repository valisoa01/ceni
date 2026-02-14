package Classes;

public class Vote {
    private int id;
    private Candidate candidate;
    private Voter voter;
    private VoteType voteType;

    public Vote() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", candidate=" + candidate +
                ", voter=" + voter +
                ", voteType=" + voteType +
                '}';
    }
}
