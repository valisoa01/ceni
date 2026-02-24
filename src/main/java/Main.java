import Classes.VoteTypeCount;
import Connection.DBRetriever;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DBRetriever dbRetriever = new DBRetriever();
       long totalVotes = dbRetriever.countAllVotes();

    System.out.println("total_votes " + totalVotes);

        List<VoteTypeCount> resultats  = dbRetriever.countVotesByType();
        System.out.println(resultats);
    }
}

