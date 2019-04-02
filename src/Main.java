import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter intput json: ");
        String inputJson = scanner.next();
        System.out.print("Enter output json: ");
        String outputJson = scanner.next();
        JsonIO jsonIO = new JsonIO(inputJson, outputJson);
        InputModel inputModel = jsonIO.read();
        runTournaments(inputModel.getPlayers(), inputModel.getTournaments());
        Collections.sort(inputModel.getPlayers());
        OutputModel outputModel = new OutputModel();
        outputModel.setResults(inputModel.getPlayers());
        jsonIO.write(outputModel);
    }

    public static void runTournaments(List<Player> playerList, List<Tournament> tournamentList) {
        for (Tournament tournament : tournamentList) {
            tournament.run(playerList);
        }
    }
}
