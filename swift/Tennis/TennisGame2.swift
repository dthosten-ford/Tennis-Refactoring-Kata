import Foundation

class TennisGame2: TennisGame {
    private let player1Name: String
    private let player2Name: String
    private var P1point: Int = 0
    private var P2point: Int = 0

    required init(player1: String, player2: String) {
        player1Name = player1
        player2Name = player2
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
        
        if P1point == P2point && P1point < 3 {
           score = getScore(point1: P1point, point2: P2point)
        }
        if P1point==P2point && P1point>2
        { score = "Deuce" }

        if P1point > 0 && P2point==0
        {
            P1res = getPoint(P1point)
            P2res = "Love"
            score = "\(P1res)-Love"
        }
        
        if P2point > 0 && P1point==0
        {
            P2res = getPoint(P2point)
            P1res = "Love"
            score = "\(P1res)-\(P2res)"
        }
        
        if (P1point>P2point && P1point < 4)
        {
            P1res = getPoint(P1point)
            if (P2point==1 || P2point==2) {
                P2res = getPoint(P2point)
            }
            score = "\(P1res)-\(P2res)"
        }
        
        if P2point>P1point && P2point < 4 {
            P2res = getPoint(P2point)
            if (P1point==1 || P1point==2) {
                P1res = getPoint(P1point)
            }
            score = "\(P1res)-\(P2res)"
        }
        
        if let newScore = advantageorWinForPlayer() {
            score = newScore
        }
        
        return score
    }

    func advantageorWinForPlayer() -> String? {
        var score: String?
        
        if P1point > P2point && P2point >= 3
        {
            score = "Advantage player1"
        }
        
        if P2point > P1point && P1point >= 3
        {
            score = "Advantage player2"
        }
        
        if P1point>=4 && P2point>=0 && (P1point-P2point)>=2
        {
            score = "Win for player1"
        }
        if P2point>=4 && P1point>=0 && (P2point-P1point)>=2
        {
            score = "Win for player2"
        }
         return score
    }
    
   private func setP1Score(number: Int) {
        
        for _ in 0..<number {
            P1Score()
        }
        
    }

    private func setP2Score(number: Int) {
        
        for _ in 0..<number {
            P2Score()
        }
        
    }
    
    private func P1Score() {
        P1point+=1
    }
    
    private func P2Score() {
        P2point+=1
    }
    
    func wonPoint(_ playerName: String) {
        if playerName == "player1" {
            P1Score()
        } else {
            P2Score()
        }
    }
}
