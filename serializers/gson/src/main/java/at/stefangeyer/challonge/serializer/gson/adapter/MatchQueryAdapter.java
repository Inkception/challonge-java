package at.stefangeyer.challonge.serializer.gson.adapter;

import at.stefangeyer.challonge.model.query.MatchQuery;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class MatchQueryAdapter implements JsonSerializer<MatchQuery> {

    @Override
    public JsonElement serialize(MatchQuery query, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject entity = new JsonObject();

        if (query.getWinnerId() != null) {
            Object winnerId = query.getWinnerId();

            // janky casting, but this should work for the time being
            if (winnerId instanceof Long) {
                entity.addProperty("winner_id", (long)query.getWinnerId());
            } else {
                entity.addProperty("winner_id", (String)query.getWinnerId());
            }
        }

        if (query.getVotesForPlayer1() != null) {
            entity.addProperty("player1_votes", query.getVotesForPlayer1());
        }

        if (query.getVotesForPlayer2() != null) {
            entity.addProperty("player2_votes", query.getVotesForPlayer2());
        }

        if (query.getScoresCsv() != null) {
            entity.addProperty("scores_csv", query.getScoresCsv());
        }

        return entity;
    }
}
