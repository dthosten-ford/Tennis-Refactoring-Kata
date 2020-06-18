import Foundation

struct Player {
    let name: String
    var point: Int
}

class TennisGame2: TennisGame {
    private var playerOne: Player
    private var playerTwo: Player

    required init(player1: String, player2: String) {
        playerOne = Player(name: player1, point: 0)
        playerTwo = Player(name: player2, point: 0)
    }
    
    func getScore(point1: Int, point2: Int) -> String {
        var score = ""
        switch (point1) {
        case 0: score = "Love"
        case 1: score = "Fifteen"
        case 2: score = "Thirty"
        default: break
        }
        return  "\(score)-All"
    }
    
    func getPoint(_ point: Int) -> String {
        var score = ""
        if (point==1)
        { score = "Fifteen" }
        if (point==2)
        { score = "Thirty" }
        if (point==3)
        { score = "Forty" }
        if (point==4)
        { score = "Love" }
        
        return score
    }
    
    var score: String? {
        var score = ""
        var P1res: String = ""
        var P2res: String = ""
        
        if playerOne.point == playerTwo.point && playerOne.point < 3 {
           score = getScore(point1: playerOne.point, point2: playerTwo.point)
        }
        if playerOne.point==playerTwo.point && playerOne.point>2
        { score = "Deuce" }

        if playerOne.point > 0 && playerTwo.point==0
        {
            P1res = getPoint(playerOne.point)
            P2res = "Love"
            score = "\(P1res)-Love"
        }
        
        if playerTwo.point > 0 && playerOne.point==0
        {
            P2res = getPoint(playerTwo.point)
            P1res = "Love"
            score = "\(P1res)-\(P2res)"
        }
        
        if (playerOne.point>playerTwo.point && playerOne.point < 4)
        {
            P1res = getPoint(playerOne.point)
            if (playerTwo.point==1 || playerTwo.point==2) {
                P2res = getPoint(playerTwo.point)
            }
            score = "\(P1res)-\(P2res)"
        }
        
        if playerTwo.point>playerOne.point && playerTwo.point < 4 {
            P2res = getPoint(playerTwo.point)
            if (playerOne.point==1 || playerOne.point==2) {
                P1res = getPoint(playerOne.point)
            }
            score = "\(P1res)-\(P2res)"
        }
        
        if let newScore = advantageorWinForPlayer() {
            score = newScore
        }
        
        return score
    }
//TODO: Make this functional, eventually (i.e. pass in the player objects)
    func advantageorWinForPlayer() -> String? {
        var score: String?
        
        if playerOne.point > playerTwo.point && playerTwo.point >= 3
        {
            score = "Advantage " + playerOne.name
        }
        
        if playerTwo.point > playerOne.point && playerOne.point >= 3
        {
            score = "Advantage " + playerTwo.name
        }
        
        if playerOne.point>=4 && playerTwo.point>=0 && (playerOne.point-playerTwo.point)>=2
        {
            score = "Win for " + playerOne.name
        }
        if playerTwo.point>=4 && playerOne.point>=0 && (playerTwo.point-playerOne.point)>=2
        {
            score = "Win for " + playerTwo.name
        }
         return score
    }
    
   private func setP1Score(number: Int) {
        
        for _ in 0..<number {
            playerOne.point+=1
        }
        
    }

    private func setP2Score(number: Int) {

        for _ in 0..<number {
            playerTwo.point+=1
        }
        
    }
    
  
    func wonPoint(_ playerName: String) {
        //playerOne.wonPoint(playerName)
        //playerTwo.wonPoint(playerName)
        if playerName == "player1" {
            playerOne.point+=1
        } else {
            playerTwo.point+=1
        }
    }
}
