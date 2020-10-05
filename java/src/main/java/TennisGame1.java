class Player {
    public String name;
    public int points;
}

public class TennisGame1 implements TennisGame {
    private Player playerOne = new Player();
    private Player playerTwo = new Player();

    public TennisGame1(String player1Name, String player2Name) {
        this.playerOne.name = player1Name;
        this.playerTwo.name = player2Name;
    }
//What keyboard shortcuts do you recall seeing?
    //Extract functions/methods
    //testing build - ctrl+shift+F10
    //selecting code  Ctrl+m or ctrl + shift + M
    //renaming variable or method name  Shift+F6
    //Finding refactorings ctrl +shift+alt+T
    //inline method ctl+alt+N
    //format code  ctl+alt+L


    
    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            playerOne.points += 1;
        } else {
            playerTwo.points += 1;
        }
    }

    public String getScore() {
        if (isTie()) return
                getTieScore();
        if (isWinningScore()) return
                getWinningScore();
        return getInPlayScore("");
    }

    //    @org.jetbrains.annotations.NotNull
    private String getInPlayScore(String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = playerOne.points;
            else {
                score += "-";
                tempScore = playerTwo.points;
            }
            score = fooBar(score, tempScore);
        }
        return score;
    }

    private String fooBar(String score, int tempScore) {
        switch (tempScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
    }

    //    @org.jetbrains.annotations.NotNull
    private String getWinningScore() {
        String score;
        int minusResult = playerOne.points - playerTwo.points;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private boolean isWinningScore() {
        return playerOne.points >= 4 || playerTwo.points >= 4;
    }

    //    @org.jetbrains.annotations.NotNull
    private String getTieScore() {
        String score;
        switch (playerOne.points) {
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

    private boolean isTie() {
        return playerOne.points == playerTwo.points;
    }
}
