import java.io.IOException;
import java.util.Collections;
import java.util.List;
public class Main {

    public static void main(String []args)throws IOException {
        JsonIO jsonIO=new JsonIO("input.json","output.json");
        InputModel inputModel=jsonIO.read();
        runTournaments(inputModel.getPlayers(),inputModel.getTournaments());
        Collections.sort(inputModel.getPlayers());
        OutputModel outputModel=new OutputModel();
        outputModel.setResults(inputModel.getPlayers());
        jsonIO.write(outputModel);
    }
    public static void runTournaments(List<Player> playerList,List<Tournament> tournamentList){
        for(Tournament tournament:tournamentList){
            tournament.run(playerList);
        }
    }
}
