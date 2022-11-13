package miage.graphqljava.tutorial.teamGoals;

import miage.graphqljava.tutorial.teamGoals.team.Team;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeamGoalsApplication {
	private Team team;
	public static void main(String[] args) {
		SpringApplication.run(TeamGoalsApplication.class, args);
	}

}
