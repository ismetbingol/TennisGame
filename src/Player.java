import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id &&
                experience == player.experience &&
                gainExperience == player.gainExperience &&
                totalExperience == player.totalExperience &&
                hand.equals(player.hand) &&
                skills.equals(player.skills);
    }

    @Override
    public int compareTo(Player player) {
        if (this.gainExperience == player.gainExperience) {
            return player.experience - this.experience;
        }
        return player.gainExperience - this.gainExperience;
    }
}