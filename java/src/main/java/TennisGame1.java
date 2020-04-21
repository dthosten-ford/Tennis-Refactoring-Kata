import java.util.ArrayList;
import java.util.List;

public class TennisGame1 implements TennisGame {
    
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (playerOneScore == playerTwoScore)
        {
            score = getTieResult();
        }
        else if (playerOneScore >=4 || playerTwoScore >=4)
        {
            score = getWinOrAdvantageResult();
        }
        else
        {
            score = getGameResult(score, playerOneScore, playerTwoScore);
        }
        return score;
    }

    private String getGameResult(String score, int playerOneScore, int playerTwoScore) {
        int tempScore;
        List<String> scoreList = new ArrayList<String>();
        scoreList.add("Love");
        scoreList.add("Fifteen");
        scoreList.add("Thirty");
        scoreList.add("Forty");

        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = playerOneScore;
            else { score+="-"; tempScore = playerTwoScore; }

            score+=scoreList.get(tempScore);

        }
        return score;
    }

    private String getWinOrAdvantageResult() {
        String score;
        int minusResult = playerOneScore - playerTwoScore;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private String getTieResult() {
        String score;
        switch (playerOneScore)
        {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            default:
                    score = "Deuce";
                break;

        }
        return score;
    }
}
