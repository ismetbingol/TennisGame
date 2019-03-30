import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "players",
        "tournaments"
})
public class InputModel {
    @JsonProperty("players")
    private List<Player> players = null;
    @JsonProperty("tournaments")
    private List<Tournament> tournaments = null;
    public List<Player> getPlayers() {
        return players;
    }
    public List<Tournament> getTournaments() {
        return tournaments;
    }
    public InputModel() {}
    public InputModel(List<Player> players, List<Tournament> tournaments) {
        this.players = players;
        this.tournaments = tournaments;
    }
}