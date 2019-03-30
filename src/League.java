import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class League extends Tournament{
    @Override
    public void run(List<Player> playerList) {
       List<Pair<Player,Player>> pairList=new ArrayList<>();
        for(Player playerOne:playerList){
            for(Player playerTwo:playerList){
                if(playerOne.equals(playerTwo)) continue;
                pairList.add(new Pair<>(playerOne,playerTwo));
            }
        }
        Collections.shuffle(pairList);
        for(Pair<Player,Player> playerPair:pairList) {
            Player playerOne=playerPair.getKey();
            Player playerTwo=playerPair.getValue();
            Player playerWon= playMatch(playerOne,playerTwo);
        }
    }
    @Override
    public int getWonPoint() {
        return 10;
    }
    @Override
    public int getLostPoint() {
        return 1;
    }
}
