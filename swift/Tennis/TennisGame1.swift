import Foundation

//test

class TennisGame1: TennisGame {
    private let playerOne: Player
    private let playerTwo: Player

    //this method's signature cannot be changed
    required init(player1: String, player2: String) {
        playerOne = Player(player1)
        playerTwo = Player(player2)
    }
    //TODO: BUNDLE players into GameScore object.
    //
    class Player {
        var name: String
        var score: Int = 0
        
        public func getName() -> String {
            return name
        }
        
        public func getScore() -> Int {
            return score
        }
        
//        public func setName(name: String) {
//            self.name = name
//        }
        //YAGNI
        init(_ name: String) {
            self.name = name
        }
    }
    //this method's signature cannot be changed
    func wonPoint(_ playerName: String) {
        if playerName == "player1" {//TODO: we can remove the constant.  use playerOne?
            playerOne.score += 1
        } else {
            playerTwo.score += 1
        }
    }

    //this method's signature cannot be changed
    var score: String? {
        if isTieScore(playerOne.score, playerTwo.score) {
            return getTieScore(playerOne.score)
        } else if isWinningScore(playerOne.score, playerTwo.score) {
            return getWinningScore(playerOne.score, playerTwo.score)
        } else {
            return updateScore(playerOne.score, playerTwo.score)
        }
    }

    private func isTieScore(_ score1: Int, _ score2: Int) -> Bool {
        return score1 == score2
    }
    
    private func isWinningScore(_ score1: Int, _ score2: Int) -> Bool {
        return score1>=4 || score2>=4
    }

    func getTieScore(_ score: Int) -> String {
        switch score
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
    
    
    func getWinningScore(_ score1: Int, _ score2: Int) -> String {
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
