import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "hand",
        "experience",
        "skills"
})
public class Player implements Comparable<Player> {
    private int id;
    private String hand;
    private int experience;
    private int gainExperience;
    private int totalExperience;
    private Skills skills;

    public Player() {
    }

    public int getId() {
        return id;
    }

    public String getHand() {
        return hand;
    }

    public int getExperience() {
        return experience;
    }

    public void addExperience(int exprienceGain) {
        this.gainExperience += exprienceGain;
        totalExperience = experience + this.gainExperience;
    }

    public int getGainExperience() {
        return gainExperience;
    }

    public int getTotalExperience() {
        return totalExperience;
    }

    public Skills getSkills() {
        return skills;
    }

    @Override
    public int compareTo(Player player) {
        if (this.gainExperience == player.gainExperience) {
            return player.experience - this.experience;
        }
        return player.gainExperience - this.gainExperience;
    }
}