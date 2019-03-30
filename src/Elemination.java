import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Elemination extends Tournament {
    @Override
    public void run(List<Player> playerList) {
        List<Player> currentPlayers = playerList;
        List<Player> wonPlayers = playerList;
        while (wonPlayers.size() != 1) {
            currentPlayers = wonPlayers;
            wonPlayers = new ArrayList<Player>();
            for (int i = 0; i < currentPlayers.size(); i += 2) {
                Player playerOne = currentPlayers.get(i);
                Player playerTwo = currentPlayers.get(i + 1);
                Player playerWon = playMatch(playerOne, playerTwo);
                wonPlayers.add(playerWon);
            }
        }
    }

    @Override
    public int getWonPoint() {
        return 20;
    }

    @Override
    public int getLostPoint() {
        return 10;
    }
}
