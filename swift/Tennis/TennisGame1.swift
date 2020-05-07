import Foundation

struct Player {
    let name: String
    var points: Int
}

class TennisGame1: TennisGame {
    private var playerOne: Player
    private var playerTwo: Player
    
    private let scoreFormatter = ScoreFormatter()
    
    required init(player1: String, player2: String) {
        self.playerOne = Player(name: player1, points: 0)
        self.playerTwo = Player(name: player2, points: 0)
    }
    //TODO:
    func wonPoint(_ playerName: String) {
        if playerName == playerOne.name {
            playerOne.points += 1
        } else {
            playerTwo.points += 1
        }
    }
    
    var score: String? {
        if TennisRules().scoreIsTied(score1: playerOne.points, score2: playerTwo.points) {
            return scoreFormatter.calculateTiedScore(playerOne.points)
        }
        else if TennisRules().playerIsEligibleToWin(score1: playerOne.points, score2: playerTwo.points) {
            return calculateAdvantageorWin()
        }
        else {
            return scoreFormatter.calculateScore(playerOnePoints: playerOne.points, playerTwoPoints: playerTwo.points)
        }
    }
    
    fileprivate func calculateAdvantageorWin() -> String {
        
        if let advantagePlayer = TennisRules().getAdvantage(from: playerOne, playerTwo) {
            return "Advantage \(advantagePlayer.name)"
        }
        
        let winner = TennisRules().leadingPlayer(from: playerOne, playerTwo)
        return scoreFormatter.winner(winner.name)
    }
}

class TennisRules {
    
    func leadingPlayer(from p1: Player, _ p2: Player) -> Player {
        return p1.points > p2.points ? p1 : p2
    }
    
    func getAdvantage(from p1: Player, _ p2: Player) -> Player? {
        let scoreDifference = getScoreDifference(from: p1, p2)
        let leadPlayer = leadingPlayer(from: p1, p2)
        return scoreDifference == 1 ? leadPlayer : nil
    }
    
    func getScoreDifference(from p1 : Player, _ p2: Player) -> Int{
        return abs(p1.points - p2.points)
    }
    
    func scoreIsTied(score1: Int, score2: Int) -> Bool {
        return score1 == score2
    }
    
    func playerIsEligibleToWin(score1: Int, score2: Int) -> Bool {
        return score1 >= 4 || score2 >= 4
    }
}

class ScoreFormatter {
    fileprivate func calculateScore(playerOnePoints: Int, playerTwoPoints: Int) -> String {
        return "\(scoreRepresentator(playerOnePoints))-\(scoreRepresentator(playerTwoPoints))"
    }
    
    fileprivate func calculateTiedScore( _ score: Int) -> String {
        guard score < 3 else {
            return "Deuce"
        }
        
        return scoreRepresentator(score) + "-All"
    }
    
    func scoreRepresentator(_ score: Int) -> String {
        if let finalScore = ScoreRepresentator(rawValue: score) {
            return finalScore.description
        }
        return ""
    }
    
    func winner(_ name: String) -> String {
        return "Win for \(name)"
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
