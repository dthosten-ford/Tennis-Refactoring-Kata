import Foundation

//test

class Player {
    var name: String
    var score: Int = 0
    
    public func getName() -> String {
        return name
    }
    
    public func getScore() -> Int {
        return score
    }
    
    //YAGNI
    init(_ name: String) {
        self.name = name
    }
}

class Players {
    let playerOne: Player
    let playerTwo: Player
    
    init(playerOne: Player, playerTwo: Player) {
        self.playerOne = playerOne
        self.playerTwo = playerTwo
    }
    
}

class TennisGame1: TennisGame {


    private let players: Players
    
    //this method's signature cannot be changed
    required init(player1: String, player2: String) {
        self.players = Players(playerOne:Player(player1), playerTwo: Player(player2))
    }
    
    // Players responsibility: combine 2 players.  get players names and scores. identify Who should get the point and then assigns  them the point.
    
    //this method's signature cannot be changed
    func wonPoint(_ playerName: String) {
        if playerName == players.playerOne.getName() {
            players.playerOne.score += 1
        } else {
            players.playerTwo.score += 1
        }
    }

    //this method's signature cannot be changed
    var score: String? {
        if isTieScore(players) {
            return getTieScore(players.playerOne)
        } else if isWinningScore(players) {
            return getWinningScore(players)
        } else {
            return updateScore(players.playerOne.score, players.playerTwo.score)
        }
    }

    private func isTieScore(_ players: Players) -> Bool {
        return players.playerOne.score == players.playerTwo.score
    }
    
    private func isWinningScore(_ players: Players) -> Bool {
        return players.playerOne.score>=4 || players.playerTwo.score>=4
    }

    func getTieScore(_ player: Player) -> String {
        switch player.score
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
    
    private func updateScore(_ score1: Int, _ score2: Int) -> String {
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
    
    
    func getWinningScore(_ players: Players) -> String {
        let score1 = players.playerOne.score
        let score2 = players.playerTwo.score
        var score = ""
        let minusResult = score1-score2
        if minusResult == 1 { score = "Advantage player1" }
        else if minusResult == -1 { score = "Advantage player2" }
        else if minusResult >= 2 { score = "Win for player1" }
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
