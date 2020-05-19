import static java.lang.Math.abs;

public class TennisGame1 implements TennisGame {

    static String[] scoreList = {"Love", "Fifteen", "Thirty", "Forty"};

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }
//goals for next session:
    //eat lunch.
    //simplify getScore
    //--run test!
    //eat 2nd lunch.
    //centralize getWinningScore logic.
    //pay taxes.
    //Strategy pattern.
    
    public void wonPoint(String playerName) {
        if (playerName == player1.name) {
            player1.score += 1;
        }
        else
            player2.score += 1;
    }

    public String getScore() {
        if (isTie())
            return getTieResult(player1.score);
        if(isAdvantageScore())
            return getAdvantageScore(player1, player2);
        //else if (isWinningScore())
            //return getWinningScore()
        if (isAdvantageOrWin())
            return getWinOrAdvantageResult(player1, player2);
        return getGameResult(player1.score, player2.score);
    }

    private String getAdvantageScore(Player player1, Player player2){
        return "Advantage " + getAdvantagePlayerName(player1, player2);
    }

    private boolean isAdvantageOrWin() {
        return player1.score >=4 || player2.score >=4;
    }

    private boolean isTie() {
        return player1.score == player2.score;
    }

    private String getGameResult(int playerOneScore, int playerTwoScore) {
        return scoreList[playerOneScore] + "-" + scoreList[playerTwoScore];
    }

    private String getAdvantagePlayerName(Player player1, Player player2){
        return (player1.score > player2.score) ? player1.name : player2.name;
    }

    private Boolean isAdvantageScore(){
        if (isAdvantageOrWin()) {
            int minusResult = player1.score - player2.score;
            return abs(minusResult)==1;
        }
        return false;
    }

    private String getWinOrAdvantageResult(Player player1, Player player2) {
        if (isAdvantageScore())
            return getAdvantageScore(player1, player2);
        return "Win for " + getAdvantagePlayerName(player1, player2);
    }

    private String getTieResult(int score) {
        if(score > 2) {
            return "Deuce";
        }
        return scoreList[score]+ "-All";
    }

    private class Player {
        private String name;
        private int score;

        Player(String name) {
            this.name = name;
        }
    }
}


