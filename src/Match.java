import java.util.*;

public class Match {

    private static final int EXHIBITION_POINT = 1;
    private static final int LEFT_HAND_POINT = 2;
    private static final int BIGGER_EXPERINCE_POINT = 3;
    private static final int SURFACE_POINT = 4;
    private final static String LEFT = "left";
    private MatchInfo matchInfo;

    public Match(MatchInfo matchInfo) {
        this.matchInfo = matchInfo;
    }

    public Player execute(Player playerOne, Player playerTwo) {
        givePointForExhibitionStart(playerOne, playerTwo);
        givePointForLeftHand(playerOne);
        givePointForLeftHand(playerTwo);
        givePointForBiggerExperience(playerOne, playerTwo);
        givePointAccoringToSurface(playerOne, playerTwo);
        return winnerOfMatch(playerOne, playerTwo);
    }

    private void givePointForExhibitionStart(Player playerOne, Player playerTwo) {
        playerOne.addExperience(EXHIBITION_POINT);
        playerTwo.addExperience(EXHIBITION_POINT);
    }

    private void givePointForLeftHand(Player player) {
        if (player.getHand() == LEFT) {
            player.addExperience(LEFT_HAND_POINT);
        }
    }

    private void givePointForBiggerExperience(Player playerOne, Player playerTwo) {
        if (playerTwo.getExperience() < playerOne.getExperience()) {
            playerOne.addExperience(BIGGER_EXPERINCE_POINT);
        } else if (playerOne.getExperience() < playerTwo.getExperience()) {
            playerTwo.addExperience(BIGGER_EXPERINCE_POINT);
        }
    }

    private void givePointAccoringToSurface(Player playerOne, Player playerTwo) {
        int playerOneSurfacePoint = getSurfacePoint(playerOne);
        int playerTwoSurfacePoint = getSurfacePoint(playerTwo);
        if (playerOneSurfacePoint < playerTwoSurfacePoint) {
            playerTwo.addExperience(SURFACE_POINT);
        } else if (playerTwoSurfacePoint < playerOneSurfacePoint) {
            playerOne.addExperience(SURFACE_POINT);
        }
    }

    private int getSurfacePoint(Player player) {
        return player.getSkills().getSurfacePoint(matchInfo.getSurface());
    }

    private void givePointForExhitionResult(Player playerWon, Player playerLost) {
        playerWon.addExperience(matchInfo.getWonPoint());
        playerLost.addExperience(matchInfo.getLostPoint());
    }

    private Player winnerOfMatch(Player playerOne, Player playerTwo) {
        Random random = new Random();
        double rand = random.nextDouble();
        double sumOfTwoExperience = playerOne.getTotalExperience() + playerTwo.getTotalExperience();
        double probabilityOne = playerOne.getTotalExperience() / sumOfTwoExperience;
        double probabilityTwo = playerTwo.getTotalExperience() / sumOfTwoExperience;
        if (rand < probabilityOne) {
            givePointForExhitionResult(playerOne, playerTwo);
            return playerOne;
        }
        givePointForExhitionResult(playerTwo, playerOne);
        return playerTwo;
    }
}
