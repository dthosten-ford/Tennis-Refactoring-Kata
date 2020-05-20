import Foundation

class Player {
    let name: String
    var points: Int
    
    init(name: String, points: Int) {
        self.name = name
        self.points = points
    }
}

class TennisGame1: TennisGame {
    private var playerOne: Player
    private var playerTwo: Player
    private let tennisRules = TennisRules()
    private let scoreFormatter = ScoreFormatter()
    private let strategies: [RulesAndScores] = [PlayerTied(), PlayerAdvantage() ,RegularPlay()]
    private let altStrategies: [AltRulesAndScores] = [.playerWon]
    
    required init(player1: String, player2: String) {
        self.playerOne = Player(name: player1, points: 0)
        self.playerTwo = Player(name: player2, points: 0)
    }

    func wonPoint(_ playerName: String) {
        let player = playerForName(playerName)
        player?.points += 1
    }
    
    func playerForName(_ player: String) -> Player? {
        let players = [playerOne, playerTwo]
        return players.first(where: { $0.name == player })
    }

    var score: String? {
        if let altScore = altStrategies.compactMap { $0.getPossibleScore(playerOne, playerTwo) }.first {
            return altScore
        }
        return strategies.compactMap { $0.getPossibleScore(playerOne, playerTwo) }.first
    }
}

protocol RulesAndScores {
    func IshouldBeUsed()-> Bool
    func getPossibleScore(_ player1: Player, _ player2: Player) -> String?
}

class PlayerWon: RulesAndScores {
    func IshouldBeUsed() -> Bool {
        //If FeatureToggle / Gate is ON
    }
    
    
    func getPossibleScore(_ player1: Player,
                          _ player2: Player) -> String? {
        guard case .playerWon(let player) = TennisRules().calculateGameState(from: player1, player2) else { return nil}
        return ScoreFormatter().winner(player.name)
    }
}
class PlayerWon2021: RulesAndScores {
    func IshouldBeUsed() -> Bool {
        //If FeatureToggle / Gate is OFF
    }
    
    
    func getPossibleScore(_ player1: Player,
                          _ player2: Player) -> String? {
        guard case .playerWon(let player) = TennisRules().calculateGameState(from: player1, player2) else { return nil}
        return ScoreFormatter().winner(player.name)
    }
}

class PlayerTied: RulesAndScores {
    func IshouldBeUsed() -> Bool {
        <#code#>
    }
    
    
    func getPossibleScore(_ player1: Player,
                          _ player2: Player) -> String? {
        guard case .tiedScore(let score) = TennisRules().calculateGameState(from: player1, player2) else { return nil}
        return ScoreFormatter().calculateTiedScore(score)
    }
}

class PlayerAdvantage: RulesAndScores {
    func IshouldBeUsed() -> Bool {
        <#code#>
    }
    
    
    func getPossibleScore(_ player1: Player,
                          _ player2: Player) -> String? {
        guard case .playerHasAdvantage(let player) = TennisRules().calculateGameState(from: player1, player2) else { return nil}
        return ScoreFormatter().formattedMessage(forAdvantagePlayer: player.name)
    }
}

class RegularPlay: RulesAndScores {
    
    func getPossibleScore(_ player1: Player,
                          _ player2: Player) -> String? {
        return ScoreFormatter().calculateRegularScore(playerOnePoints: player1.points, playerTwoPoints: player2.points)
    }
}

struct AltRulesAndScores {
    private let rule: (Player, Player) -> String?

    func getPossibleScore(_ player1: Player, _ player2: Player) -> String? {
        rule(player1, player2)
    }

    static var playerWon: AltRulesAndScores {
        return AltRulesAndScores { p1, p2 -> String? in
            guard case .playerWon(let player) = TennisRules().calculateGameState(from: p1, p2) else { return nil}
            return ScoreFormatter().winner(player.name)
        }
    }
}

class TennisRules {
    
    enum GameState {
        case regularPlay
        case tiedScore(Int)
        case playerHasAdvantage(Player)
        case playerWon(Player)
    }
    
    func calculateGameState(from player1: Player, _ player2: Player) -> GameState {
        if let winner = getWinner(from: player1, player2) {
            return .playerWon(winner)
        }
        //if Gate ....
        if scoreIsTied(score1: player1.points, score2: player2.points) {
            return .tiedScore(player1.points)
        }
        
        if let player = getAdvantage(from: player1, player2) {
            //f gate ...
            return .playerHasAdvantage(player)
        }
        return .regularPlay
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
    func calculateRegularScore(playerOnePoints: Int, playerTwoPoints: Int) -> String {
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
