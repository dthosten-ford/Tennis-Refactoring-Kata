import kotlin.math.abs

//TODO pick from where we are left off Enum, avoid duplications, extract some methods into classes

class TennisGame1(player1Name: String, player2Name: String) : TennisGame {

    // this should be commit are not
    private var player1 = Player(player1Name)
    private var player2 = Player(player2Name)

    override fun wonPoint(playerName: String) {
        val player = getPlayer(playerName)
        player.points +=1
    }

    private fun getPlayer( playerName : String):Player{
        if(playerName == player1.name)
            return player1
        return player2
    }

    override fun getScore(): String = when {
        isTie() -> getTieScore()
        isAdvantage() -> getAdvantageScore()
        else -> getMatchScore()
    }

    private fun isAdvantage() = player1.points >= 4 || player2.points >= 4

    private fun getAdvantageScore(): String {
        val scoreDifferential =abs( player1.points - player2.points)
        val winningPlayer = findWinningPlayer()
        if(scoreDifferential==1)
            return "Advantage " + winningPlayer.name
        return "Win for " + winningPlayer.name
    }

    private fun findWinningPlayer(): Player {
        if(player1.points > player2.points)
            return player1
        return player2

    }

    private fun getMatchScore(): String = getScoreForPoints(player1.points) + "-" + getScoreForPoints(player2.points)

    private fun getScoreForPoints(points: Int): String = enumValues<PlayerScore>()[points].score

    private fun isTie() = player1.points == player2.points

    private fun getTieScore(): String {
        return if (player1.points <= 2) {
            "${getScoreForPoints(player1.points)}-All"
        } else {
            "Deuce"
        }
    }
}

enum class PlayerScore(val score: String){
    LOVE("Love"),
    FIFTEEN("Fifteen"),
    THIRTY("Thirty"),
    FORTY("Forty")
}

data class Player(val name: String, var points: Int  = 0)
