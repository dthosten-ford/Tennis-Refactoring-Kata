import Foundation

struct Player {
    let name: String
    var points: Int
}

class TennisGame1: TennisGame {
    private var playerOne: Player
    private var playerTwo: Player
    
    required init(player1: String, player2: String) {
        self.playerOne = Player(name: player1, points: 0)
        self.playerTwo = Player(name: player2, points: 0)
    }
    
    func wonPoint(_ playerName: String) {
        if playerName == playerOne.name {
            playerOne.points += 1
        } else {
            playerTwo.points += 1
        }
    }
    
    fileprivate func calculateScore() -> String {
        return "\(ScoreFormatter().scoreRepresentator(playerOne.points))-\(ScoreFormatter().scoreRepresentator(playerTwo.points))"
    }
    
    fileprivate func calculateTiedScore( _ score: Int) -> String {
        guard score < 3 else {
            return "Deuce"
        }
        
        return ScoreFormatter().scoreRepresentator(score) + "-All"
    }
    
    
    var score: String? {
        if TennisRules().scoreIsTied(score1: playerOne.points, score2: playerTwo.points) {
            return calculateTiedScore(playerOne.points)
        }
        else if TennisRules().playerIsEligibleToWin(score1: playerOne.points, score2: playerTwo.points) {
            return calculateAdvantageorWin()
        }
        else {
            return calculateScore()
        }
    }
    
    fileprivate func calculateAdvantageorWin() -> String {
        let winner: Player = (playerOne.points > playerTwo.points) ? playerOne : playerTwo
        
        let scoreDifference = abs(playerOne.points - playerTwo.points)
        
        if scoreDifference == 1 {
            return "Advantage \(winner.name)"
        }
        return "Win for \(winner.name)"
    }
    
}

enum ScoreRepresentator: Int, CustomStringConvertible {
    case love
    case fifteen
    case thirty
    case forty
    
    var description: String {
        switch self {
        case .love:
            return "Love"
        case .fifteen:
            return "Fifteen"
        case .thirty:
            return "Thirty"
        case .forty:
            return "Forty"
        }
   }
}

class TennisRules {
    
    func scoreIsTied(score1: Int, score2: Int) -> Bool {
        return score1 == score2
    }
    
    func playerIsEligibleToWin(score1: Int, score2: Int) -> Bool {
        return score1 >= 4 || score2 >= 4
    }
}

class ScoreFormatter {
    func scoreRepresentator(_ score: Int) -> String {
        if let finalScore = ScoreRepresentator(rawValue: score) {
            return finalScore.description
        }
        return ""
    }
}
