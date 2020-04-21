import Foundation

struct Player {
    let name: String
    var score: Int
}

class TennisGame1: TennisGame {
    private var playerOne: Player
    private var playerTwo: Player
    
    required init(player1: String, player2: String) {
        self.playerOne = Player(name: player1, score: 0)
        self.playerTwo = Player(name: player2, score: 0)
    }
    
    func wonPoint(_ playerName: String) {
        if playerName == playerOne.name {
            playerOne.score += 1
        } else {
            playerTwo.score += 1
        }
    }
    
    var scoreIsTied: Bool { playerOne.score == playerTwo.score }
    
    fileprivate func playerIsEligibleToWin(score1: Int, score2: Int) -> Bool {
        return playerOne.score >= 4 || playerTwo.score >= 4
    }
    
    fileprivate func calculateScore() -> String {
        return "\(scoreRepresentator(playerOne.score))-\(scoreRepresentator(playerTwo.score))"
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
        let winner: Player = (playerOne.score > playerTwo.score) ? playerOne : playerTwo
        
        let scoreDifference = abs(playerOne.score - playerTwo.score)
        
        if scoreDifference == 1 {
            return "Advantage \(winner.name)"
        }
        return "Win for \(winner.name)"
    }
    
    var score: String? {
        if scoreIsTied {
            return calculateTiedScore(playerOne.score)
        }
        else if playerIsEligibleToWin(score1: playerOne.score, score2: playerTwo.score) {
            return calculateAdvantageorWin()
        }
        else {
            return calculateScore()
        }
    }
}
