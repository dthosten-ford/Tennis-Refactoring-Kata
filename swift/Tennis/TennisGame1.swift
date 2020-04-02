import Foundation

class TennisGame1: TennisGame {
    private let player1: String
    private let player2: String
    private var score1: Int
    private var score2: Int
    
    required init(player1: String, player2: String) {
        self.player1 = player1
        self.player2 = player2
        self.score1 = 0
        self.score2 = 0
    }

    func wonPoint(_ playerName: String) {
        if playerName == player1 {
            score1 += 1
        } else {
            score2 += 1
        }
    }
    
    var scoreIsTied: Bool { score1 == score2 }
    
    fileprivate func playerIsEligibleToWin(score1: Int, score2: Int) -> Bool {
        return score1>=4 || score2>=4
    }
    
    fileprivate func calculateScore() -> String {
        var tempScore = 0
        var score = ""
        for i in 1..<3
        {
            if i==1 { tempScore = score1 }
            else { score = "\(score)-"; tempScore = score2 }
            switch tempScore
            {
            case 0:
                score = "\(score)Love"
                
            case 1:
                score = "\(score)Fifteen"
                
            case 2:
                score = "\(score)Thirty"
                
            case 3:
                score = "\(score)Forty"
                
            default:
                break
                
            }
        }
        return score
    }
    
    fileprivate func calculateTiedScore() -> String {
        switch score1
        {
        case 0:
            return "Love-All"
            
        case 1:
            return "Fifteen-All"
            
        case 2:
            return "Thirty-All"
            
        default:
            return "Deuce"
        }
    }
    
    fileprivate func calculateAdvantageorWin() -> String {
        let minusResult = score1-score2
        if minusResult==1 { return "Advantage player1" }
        else if minusResult  == -1 { return "Advantage player2" }
        else if minusResult>=2 { return "Win for player1" }
        else { return "Win for player2" }
    }
    
    var score: String? {
        if scoreIsTied
        {
            return calculateTiedScore()
        }
        else if playerIsEligibleToWin(score1: score1, score2: score2)
        {
            return calculateAdvantageorWin()
        }
        else
        {
            return calculateScore()
        }
    }
    
    
}
