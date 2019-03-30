import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({
        "order",
        "player_id",
        "gained_experience",
        "total_experience"
        })
public class Result {
    private int order;
    private Player player;
    public Result(Player player, int order){
        this.player=player;
        this.order=order;
    }
    @JsonProperty("order")
    public int getOrder() {return order;}
    @JsonProperty("player_id")
    public int getPlayerId() {return player.getId();}
    @JsonProperty("gained_experience")
    public int getGainedExperience() {return player.getGainExperience();}
    @JsonProperty("total_experience")
    public int getTotalExperience() {return player.getTotalExperience();}
}
