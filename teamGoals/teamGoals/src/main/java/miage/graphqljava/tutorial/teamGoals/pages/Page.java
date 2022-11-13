package miage.graphqljava.tutorial.teamGoals.pages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miage.graphqljava.tutorial.teamGoals.competitions.Competition;
import org.springframework.web.util.pattern.PathPattern;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Page {
    Integer page;
    Integer per_page;
    Integer total;
    Integer total_page;
    List<Competition> data;
}
