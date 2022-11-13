package miage.graphqljava.tutorial.teamGoals.competitions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Competition {
    String competition;
    Integer year;
    String round;
    String team1;
    String team2;
    Integer team1goals;
    Integer team2goals;
}
