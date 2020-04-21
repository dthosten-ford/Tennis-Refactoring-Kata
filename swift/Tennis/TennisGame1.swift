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
        return "\(scoreRepresentator(score1))-\(scoreRepresentator(score2))"
    }
    
    fileprivate func scoreRepresentator(_ score: Int) -> String {
        
        switch score {
        case 0:
            return "Love"
        case 1:
            return "Fifteen"
        case 2:
            return "Thirty"
        case 3:
            return "Forty"
        default:
            return ""
        }
    }
    
    fileprivate func calculateTiedScore( _ score: Int) -> String {
        guard score < 3 else {
            return "Deuce"
        }
        
        return scoreRepresentator(score) + "-All"
    }
    
    fileprivate func calculateAdvantageorWin() -> String {
        let minusResult = score1-score2
        if minusResult==1 {
            return "Advantage player1"
        } else if minusResult  == -1 {
            return "Advantage player2"
        } else if minusResult>=2 {
            return "Win for player1"
        }
        return "Win for player2"
    }
    
    var score: String? {
        if scoreIsTied {
            return calculateTiedScore(score1)
        }
        else if playerIsEligibleToWin(score1: score1, score2: score2) {
            return calculateAdvantageorWin()
        }
        else {
            return calculateScore()
        }
    }
}
