
class Player
{

    public int Point;
}
public class TennisGame2 implements TennisGame{

    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    private Player Player1 = new Player();
    private Player Player2 = new Player();

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (isNormalScore(Player1.Point
                == Player2.Point, Player1))
        {
            if (Player1.Point
                    ==0)
                score = "Love";
            if (Player1.Point
                    ==1)
                score = "Fifteen";
            if (Player1.Point
                    ==2)
                score = "Thirty";
            score += "-All";
        }
        score = getTieScore(score, Player1.Point
                == Player2.Point, Player1, "Deuce");

        if (Player1.Point
                > 0 && Player2.Point==0)
        {
            if (Player1.Point
                    ==1)
                P1res = "Fifteen";
            if (Player1.Point
                    ==2)
                P1res = "Thirty";
            if (Player1.Point
                    ==3)
                P1res = "Forty";
            
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (Player2.Point > 0 && Player1.Point
                ==0)
        {
            if (Player2.Point==1)
                P2res = "Fifteen";
            if (Player2.Point==2)
                P2res = "Thirty";
            if (Player2.Point==3)
                P2res = "Forty";
            
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
        
        if (isNormalScore(Player1.Point
                >Player2.Point, Player1))
        {
            score = calculateNormalScore();
        }
        if (isNormalScore(Player2.Point>Player1.Point, Player2))
        {
            score = calculateNormalScoreForPlayer2Leading();
        }

        score = getAdvantageScore(score);

        score = getWinScore(score);
        return score;
    }

    private String getTieScore(String score, boolean b, Player player1, String deuce) {
        if (b && player1.Point
                >= 3)
            score = deuce;
        return score;
    }

    private String getWinScore(String score) {
        if (Player1.Point
                >=4 && Player2.Point>=0 && (Player1.Point
                -Player2.Point)>=2)
        {
            score = "Win for player1";
        }
        if (Player2.Point>=4 && Player1.Point
                >=0 && (Player2.Point-Player1.Point
        )>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    private String getAdvantageScore(String score) {
        score = getTieScore(score, Player1.Point
                > Player2.Point, Player2, "Advantage player1");

        score = getTieScore(score, Player2.Point > Player1.Point, Player1, "Advantage player2");
        return score;
    }

    private String calculateNormalScoreForPlayer2Leading() {
        String score;
        if (Player2.Point==2)
            P2res="Thirty";
        if (Player2.Point==3)
            P2res="Forty";
        if (Player1.Point
                ==1)
            P1res="Fifteen";
        if (Player1.Point
                ==2)
            P1res="Thirty";
        score = P1res + "-" + P2res;
        return score;
    }

    private String calculateNormalScore() {
        String score;
        if (Player1.Point
                ==2)
            P1res="Thirty";
        if (Player1.Point
                ==3)
            P1res="Forty";
        if (Player2.Point==1)
            P2res="Fifteen";
        if (Player2.Point==2)
            P2res="Thirty";
        score = P1res + "-" + P2res;
        return score;
    }

    private boolean isNormalScore(boolean b, Player player1) {
        return b && player1.Point
                < 4;
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

        Player1.Point++;
    }
    
    public void P2Score(){
        Player2.Point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}