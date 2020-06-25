
class Player
{

    public int Point;
}
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    private Player Player1 = new Player();

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (Player1.Point
                == P2point && Player1.Point
                < 4)
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
        if (Player1.Point
                ==P2point && Player1.Point
                >=3)
            score = "Deuce";
        
        if (Player1.Point
                > 0 && P2point==0)
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
        if (P2point > 0 && Player1.Point
                ==0)
        {
            if (P2point==1)
                P2res = "Fifteen";
            if (P2point==2)
                P2res = "Thirty";
            if (P2point==3)
                P2res = "Forty";
            
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
        
        if (Player1.Point
                >P2point && Player1.Point
                < 4)
        {
            if (Player1.Point
                    ==2)
                P1res="Thirty";
            if (Player1.Point
                    ==3)
                P1res="Forty";
            if (P2point==1)
                P2res="Fifteen";
            if (P2point==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        if (P2point>Player1.Point
                && P2point < 4)
        {
            if (P2point==2)
                P2res="Thirty";
            if (P2point==3)
                P2res="Forty";
            if (Player1.Point
                    ==1)
                P1res="Fifteen";
            if (Player1.Point
                    ==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }
        
        if (Player1.Point
                > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (P2point > Player1.Point
                && Player1.Point
                >= 3)
        {
            score = "Advantage player2";
        }
        
        if (Player1.Point
                >=4 && P2point>=0 && (Player1.Point
                -P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && Player1.Point
                >=0 && (P2point-Player1.Point
        )>=2)
        {
            score = "Win for player2";
        }
        return score;
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
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}