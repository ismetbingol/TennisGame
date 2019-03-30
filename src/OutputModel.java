import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class OutputModel {

    @JsonProperty("results")
    private List<Result> results;

    public void setResults(List<Player> playerList) {
        List<Result> results = new ArrayList<>();
        for (Player player : playerList) {
            Result result = new Result(player, playerList.indexOf(player) + 1);
            results.add(result);
        }
        this.results = results;
    }
}
