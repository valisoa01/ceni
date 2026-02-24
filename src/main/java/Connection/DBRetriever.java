package Connection;

import Classes.CandidateVoteCount;
import Classes.VoteType;
import Classes.VoteTypeCount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBRetriever {

    public long countAllVotes() {
        String sql = """
            select count(id) as total_votes from vote
            """;
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            if (rs.next()) {
                return rs.getLong("total_votes");
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return 0;
    }
    public List<VoteTypeCount> countVotesByType()
    {
        List<VoteTypeCount> resultats = new ArrayList<>();
        String sql = """
                select vote_type, count(id) as count
                from vote
                group by vote_type
                order by vote_type
                """;
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement  ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
               VoteType voteType =VoteType.valueOf(rs.getString("vote_type"));
               long count = rs.getLong("count");

               resultats.add( new VoteTypeCount(voteType, count));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultats;
    }
    public List<CandidateVoteCount> countValidVotesByCantidate()
    {
        List<CandidateVoteCount> resultats = new ArrayList<>();
        String sql = """
                SELECT candidate.name AS candidate_name,
                       COUNT(CASE WHEN vote.vote_type = 'VALID' THEN 0 END) AS valid_vote
                FROM vote join candidate on vote.candidate_id = candidate.id
                GROUP BY  candidate.name
                ORDER BY candidate_name;
                """;
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                String candidateName = rs.getString("candidate_name");
                long count = rs.getLong("valid_vote");

                resultats.add(new CandidateVoteCount(candidateName, count));
            }
         }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultats;
    }
 }
