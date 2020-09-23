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
    private let scoreKeeper: Score
    
    //this method's signature cannot be changed
    required init(player1: String, player2: String) {
        self.players = Players(playerOne:Player(player1), playerTwo: Player(player2))
        self.scoreKeeper = Score(self.players)
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
        if scoreKeeper.isTieScore(players) {
            return getTieScore(players.playerOne)
        } else if scoreKeeper.isWinningScore(players) {
            return getWinningScore(players)
        } else {
            return updateScore(players)
        }
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
    
    private func updateScore(_ players: Players) -> String {
        let score1 = players.playerOne.score
        let score2 = players.playerTwo.score
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
    
    //TODO: Create enum match outcome
    func getWinningScore(_ players: Players) -> String {
        let score1 = players.playerOne.score
        let score2 = players.playerTwo.score
        let scoreDifference = score1 - score2
        
        switch scoreDifference {
        case 1:
            return getAdvantageCall(players.playerOne)
        case -1:
            return getAdvantageCall(players.playerTwo)
        case 2...4:
            return getWinForCall(players.playerOne)
        default:
            return getWinForCall(players.playerTwo)
        }
    }
    
    func getAdvantageCall(_ player: Player) -> String {
        "Advantage " + player.name
    }
    
    func getWinForCall(_ player: Player) -> String {
        "Win for " + player.name
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

class Score {
    
    let players: Players
    
    init(_ players: Players) {
        self.players = players
    }
    
    func isTieScore(_ players: Players) -> Bool {
        return players.playerOne.score == players.playerTwo.score
    }
    
    func isWinningScore(_ players: Players) -> Bool {
        return players.playerOne.score>=4 || players.playerTwo.score>=4
    }
}
