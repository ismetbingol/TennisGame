import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "clay",
        "grass",
        "hard"
})
public class Skills {

    private static final class Fields{
        public static final String CLAY="clay";
        public static final String GRASS="grass";
        public static final String HARD="hard";
    }
    private Map<String,Integer> skillsMap=new HashMap();
    @JsonProperty(Fields.CLAY)
    public void setClay(int clayPoint) { this.skillsMap.put(Fields.CLAY,clayPoint); }
    @JsonProperty(Fields.GRASS)
    public void setGrass(int grassPoint){
        this.skillsMap.put(Fields.GRASS,grassPoint);
    }
    @JsonProperty(Fields.HARD)
    public void setHard(int hardPoint){
        this.skillsMap.put(Fields.HARD,hardPoint);
    }
    public int getSurfacePoint(String surface){
        return this.skillsMap.get(surface);
    }

  }