
public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (isTieScore(player1Score, player2Score)) {
            return getTieScore(player1Score);
        } else if (isAdvantageScenario()) {
            return getScoreForAdvantageScenario(player1Score - player2Score);
        } else {
            return getCurrentScore(player1Score) + "-" + getCurrentScore(player2Score);
        }
    }

    private String getCurrentScore(int tempScore) {
        switch(tempScore)
        {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }

    private String getScoreForAdvantageScenario(int pointDeference) {
        String score;
        if (pointDeference==1) score ="Advantage player1";
        else if (pointDeference ==-1) score ="Advantage player2";
        else if (pointDeference>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private boolean isAdvantageScenario() {
        return player1Score >=4 || player2Score >=4;
    }

    private String getTieScore(int points) {
        String score;
        switch (points)
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

    private boolean isTieScore(int m_score1, int m_score2) {
        return m_score1 == m_score2;
    }
}
