public class TennisGame1 implements TennisGame {
    
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String player1Name;
    private String player2Name;
    static String[] scoreList = {"Love", "Fifteen", "Thirty", "Forty"};

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
            score = getGameResult(playerOneScore, playerTwoScore);
        }
        return score;
    }

    private String getGameResult(int playerOneScore, int playerTwoScore) {
        return getScore(playerOneScore) + "-" + getScore(playerTwoScore);
    }

    private String getScore(int tempScore) {
        return scoreList[tempScore];
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
