public class TennisGame1 implements TennisGame {
    
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    static String[] scoreList = {"Love", "Fifteen", "Thirty", "Forty"};

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }
//goals for next session:
    //find a way to make getWinOrAdvantageResult simpler.
    //Strategy pattern.
    
    public void wonPoint(String playerName) {
        if (playerName == player1.name)
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    public String getScore() {
        if (playerOneScore == playerTwoScore)
            return getTieResult(playerOneScore);
        else if (playerOneScore >=4 || playerTwoScore >=4)
            return getWinOrAdvantageResult(playerOneScore, playerTwoScore);
        return getGameResult(playerOneScore, playerTwoScore);
    }

    private String getGameResult(int playerOneScore, int playerTwoScore) {
        return scoreList[playerOneScore] + "-" + scoreList[playerTwoScore];
    }
    

    private String getWinOrAdvantageResult(int playerOneScore, int playerTwoScore) {
        String score;
        //Show advantage score for player with the advantage
        //show winning score for player who is the winner.

        int minusResult = playerOneScore - playerTwoScore;
        /*switch (playerOneScore - playerTwoScore){
            case 1: return "Advantage player1";
            case -1: return "Advantage player2";
            case (2 >=
            default:
        }*/
        if (minusResult==1) score ="Advantage "+player1.name;
        else if (minusResult ==-1) score ="Advantage " + player2.name;
        else if (minusResult>=2) score = "Win for " + player1.name;
        else score ="Win for " + player2.name;
        return score;
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

        public Player(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }
}


