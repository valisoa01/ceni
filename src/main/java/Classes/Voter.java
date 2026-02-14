package Classes;

public class Voter {
    private int id;
    private String name;
    private Candidate candidate;

    public Voter() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", candidate=" + candidate +
                '}';
    }
}
