
//Notes:  How can we organize this to better meet SRP?
// What are the responsibilities?
// Movements
// Scoring

//What would OCP look like here?



public class TennisGame2 implements TennisGame
{
    //players points
    public int P1point = 0;
    public int P2point = 0;

    //create global variables of points
    private static final String SCORE_LOVE = "0";
    private static final String SCORE_FIFTEEN = "15";
    private static final String SCORE_THIRTY = "30";
    private static final String SCORE_FORTY = "40";

    //player result
    public String P1result = "";
    public String P2result = "";

    //player name
    private String player1Name;
    private String player2Name;

    private Player player1 = new Player();



    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }


    //responsible to get player score

    //can remove dependency on those global variables, we need to add return type.
    //passes players as parameters and get result back.
    //consolidate player related logic to player class.
    public String getScore(){
        String score = "";
        //******* can refactor this if blocks
        if (player1.playerPoint == P2point && player1.playerPoint < 4)
        {
            score = getPlayerScore(player1.playerPoint);
            score += "-All";
        }
        if (player1.playerPoint==P2point && player1.playerPoint>=3)
            score = "Deuce";

        if (player1.playerPoint > 0 && P2point==0)
        {
//            getPlayerScore(P1point);

            P2result = "Love";
            P1result = getPlayerScore(player1.playerPoint);
            score = P1result + "-" + P2result;
        }

        //******* can refactor this If blocks

        if (P2point > 0 && player1.playerPoint==0)
        {

            P2result = getPlayerScore(P2point);

            P1result = "Love";
            score = P1result + "-" + P2result;
        }

        if (player1.playerPoint>P2point && player1.playerPoint < 4)
        {
            if(getPlayerScore(P2point) != "")
                P2result = getPlayerScore(P2point);

            score = getPlayerScore(player1.playerPoint) + "-" + P2result;
        }
        if (P2point>player1.playerPoint && P2point < 4)
        {
            P2result = getPlayerScore(P2point);
            if(getPlayerScore(player1.playerPoint) != "")
                P1result = getPlayerScore(player1.playerPoint);

            score = P1result + "-" + P2result;
        }

        // switch or strategy pattern
        if (player1.playerPoint > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }

        if (P2point > player1.playerPoint && player1.playerPoint >= 3)
        {
            score = "Advantage player2";
        }

        if (player1.playerPoint>=4 && P2point>=0 && (player1.playerPoint-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && player1.playerPoint>=0 && (P2point-player1.playerPoint)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    private String getPlayerScore(int palyerPoint) {
        if (palyerPoint ==0)
            return  "Love";
        if (palyerPoint==1)
            return "Fifteen";
        if (palyerPoint==2)
            return "Thirty";
        if (palyerPoint==3)
            return "Forty";
        return "";
    }

    public void SetP1Score(int number){

        for (int i = 0; i < number; i++)
        {
            P1Score();
        }

    }

    public void SetP2Score(int number){

        for (int i = 0; i < number; i++)
        {
            P2Score();
        }

    }

    public void P1Score(){
        P1point++;
        player1.playerPoint++;
    }
    
    public void P2Score(){
        P2point++;

    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }

   public class Score {


   }

   public class Player {

        private String playerScore;

        private int playerPoint;

        public void setPoint (int point) {playerPoint = point;}

        public int getPoint() {return playerPoint;}

        public void setScore (String score) {playerScore = score;}

        public String getScore() {return playerScore;}
   }
}