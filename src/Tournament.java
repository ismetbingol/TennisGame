import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "surface",
})
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Elemination.class, name = "elimination"),
        @JsonSubTypes.Type(value = League.class, name = "league")
})
public abstract class Tournament implements MatchInfo {

    @JsonProperty("id")
    private int id;
    @JsonProperty("surface")
    private String surface;

    public Tournament() {
    }

    public abstract void run(List<Player> playerList);

    public Player playMatch(Player playerOne, Player playerTwo) {
        Match match = new Match(this);
        return match.execute(playerOne, playerTwo);
    }

    public int getId() {
        return id;
    }

    public String getSurface() {
        return surface;
    }
}