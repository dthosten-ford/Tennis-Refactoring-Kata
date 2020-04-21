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
        if (playerOneScore == playerTwoScore)
            return getTieResult(playerOneScore);
        else if (playerOneScore >=4 || playerTwoScore >=4)
            return getWinOrAdvantageResult();
        return getGameResult(playerOneScore, playerTwoScore);
    }

    private String getGameResult(int playerOneScore, int playerTwoScore) {
        return scoreList[playerOneScore] + "-" + scoreList[playerTwoScore];
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

    private String getTieResult(int score) {
        if(score > 2) {
            return "Deuce";
        }
        return scoreList[score]+ "-All";
    }
}
