package at.stefangeyer.challonge.model.query;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MatchQuery {
    /**
     * winnerId can be either a long identifying the winner of the match or the string "tie" to declare the match as tied.
     **/
    private Object winnerId;
    private Integer votesForPlayer1;
    private Integer votesForPlayer2;
    private String scoresCsv;

    public static class MatchQueryBuilder {
        public MatchQueryBuilder winnerId(final Long winnerId) {
            this.winnerId = winnerId;
            return this;
        }
        public MatchQueryBuilder tie() {
            this.winnerId = "tie";
            return this;
        }
    }
}
