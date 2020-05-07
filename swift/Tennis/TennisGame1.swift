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
    
    // TODO: Finish the switch statements
    var score: String? {
        switch TennisRules().calculateGameState(from: playerOne, playerTwo) {
        case .playerWon(let winner):
            return scoreFormatter.winner(winner.name)
        case .tiedScore(let score):
            break
        default:
            break
        }
        if TennisRules().scoreIsTied(score1: playerOne.points, score2: playerTwo.points) {
            return scoreFormatter.calculateTiedScore(playerOne.points)
        }
            
        if let advantagePlayer = TennisRules().getAdvantage(from: playerOne, playerTwo) {
            return scoreFormatter.formattedMessage(forAdvantagePlayer: advantagePlayer.name)
        }
        return scoreFormatter.calculateScore(playerOnePoints: playerOne.points, playerTwoPoints: playerTwo.points)
    }
}

class TennisRules {
    
    enum GameState {
        case regularPlay
        case tiedScore(Int)
        case playerHasAdvantage(Player)
        case playerWon(Player)
        case undefined
    }
    
    func calculateGameState(from player1: Player, _ player2: Player) -> GameState {
        if let winner = getWinner(from: player1, player2) {
            return .playerWon(winner)
        }
        
        return .undefined
    }
    
    func leadingPlayer(from p1: Player, _ p2: Player) -> Player {
        return p1.points > p2.points ? p1 : p2
    }
    
    func getAdvantage(from p1: Player, _ p2: Player) -> Player? {
        guard playerIsEligibleToWin(score1: p1.points, score2: p2.points) else { return nil }
        let scoreDifference = getScoreDifference(from: p1, p2)
        let leadPlayer = leadingPlayer(from: p1, p2)
        return scoreDifference == 1 ? leadPlayer : nil
    }
    
    private func getWinner(from p1: Player, _ p2: Player) -> Player? {
        guard playerIsEligibleToWin(score1: p1.points, score2: p2.points) else { return nil }
        return getScoreDifference(from: p1, p2) > 1 ? leadingPlayer(from: p1, p2) : nil
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
    func calculateScore(playerOnePoints: Int, playerTwoPoints: Int) -> String {
        return "\(scoreRepresentator(playerOnePoints))-\(scoreRepresentator(playerTwoPoints))"
    }
    
    func calculateTiedScore( _ score: Int) -> String {
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
    
    func formattedMessage(forAdvantagePlayer player: String) -> String {
        return "Advantage \(player)"
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
