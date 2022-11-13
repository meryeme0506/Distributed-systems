package miage.graphqljava.tutorial.teamGoals.team;

import miage.graphqljava.tutorial.teamGoals.competitions.Competition;
import miage.graphqljava.tutorial.teamGoals.pages.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Team {
    public static Page getLastRateBySourceAndDest() {
        String url = "https://jsonmock.hackerrank.com/api/football_matches?year=2011&team1=Barcelona&page=1";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Page> response = restTemplate.getForEntity(url, Page.class);
        Page res = response.getBody();
        System.out.println(res);
        return res;
    }

    /**
     *
     * @param year year's competition
     * @param page the number of the page
     * @param team the first team
     * @return the number of goals scored by the first team
     */
    public static Integer team1goal(String year, String page, String team) {
        String url = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&team1=" + team;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Page> response = restTemplate.getForEntity(url, Page.class);
        Page res = response.getBody();
        List<Competition> matches = res.getData();
        Integer countTeam1goals = 0;
        for (Competition m : matches) {
            countTeam1goals += m.getTeam1goals();
        }
        return countTeam1goals;
    }

    /**
     *
     * @param year year's competition
     * @param page the number of the page
     * @param team the first team
     * @return the number of goals scored by the second team
     */
    public static Integer team2goal(String year, String page, String team) {
        String url = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&team1=" + team;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Page> response = restTemplate.getForEntity(url, Page.class);
        Page res = response.getBody();
        List<Competition> matches = res.getData();
        Integer countTeam2goals = 0;
        for (Competition m : matches) {
            countTeam2goals += m.getTeam2goals();
        }
        return countTeam2goals;
    }


    public static void main(String[] args) {
        getLastRateBySourceAndDest();
        Integer x=team1goal("2011","1","Barcelona");
        Integer y=team2goal("2011","1","AC Milan");
        System.out.println("Team 1 goals : "+x+", Team 2 goals : "+y);

    }

}

