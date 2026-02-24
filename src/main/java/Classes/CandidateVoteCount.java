package Classes;

public class CandidateVoteCount {
    private String candidateName;
    private Long validVoteCount;

    public CandidateVoteCount(String candidateName, Long validVoteCount) {
        this.candidateName = candidateName;
        this.validVoteCount = validVoteCount;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public Long getValidVoteCount() {
        return validVoteCount;
    }

    public void setValidVoteCount(Long validVoteCount) {
        this.validVoteCount = validVoteCount;
    }

    @Override
    public String toString() {
        return "CandidateVoteCount{" +
                "candidateName='" + candidateName + '\'' +
                ", validVoteCount=" + validVoteCount +
                '}';
    }
}
