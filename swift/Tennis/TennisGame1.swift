import Foundation

//test

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
        if playerName == "player1" {
            score1 += 1
        } else {
            score2 += 1
        }
    }

    private func isTieScore() -> Bool {
        return score1 == score2
    }
    
    private func isWinningScore() -> Bool {
        return score1>=4 || score2>=4
    }
    
    var score: String? {
        if isTieScore() {
            return getTieScore()
        } else if isWinningScore() {
            return getWinningScore()
        } else {
            return updateScore()
        }
    }

    func getTieScore() -> String {
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
    
    private func updateScore() -> String {
        var tempScore = 0
        var score = ""
        for i in 1..<3
        {
            if i==1 {
                tempScore = score1
            } else {
                score = "\(score)-"; tempScore = score2
            }
            score = getReadableScore(value: tempScore, score: score)
        }
        return score
    }
    
    
    func getWinningScore() -> String {
        var score = ""
        let minusResult = score1-score2
        if minusResult==1 { score = "Advantage player1" }
        else if minusResult  == -1 { score = "Advantage player2" }
        else if minusResult>=2 { score = "Win for player1" }
        else { score = "Win for player2" }
        return score

    }
    func getReadableScore(value: Int, score: String) -> String {
        switch value {
        case 0:
            return "\(score)Love"

        case 1:
            return "\(score)Fifteen"

        case 2:
            return "\(score)Thirty"

        case 3:
            return "\(score)Forty"

        default:
            return "Error"
        }
    }
    
}
