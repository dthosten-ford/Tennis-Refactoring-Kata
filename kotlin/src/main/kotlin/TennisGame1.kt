//TODO pick from where we are left off Enum, avoid duplications, extract some methods into classes

class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    //this should be commit are not
    private var player1Points = 0

    private var player2Points = 0

    override fun wonPoint(playerName: String) {
        if (playerName === player1Name)
            player1Points += 1
        else
            player2Points += 1
    }

    override fun getScore(): String = when {
        isTie() -> getTieScore()
        isAdvantage() -> getAdvantageScore()
        else -> getMatchScore()
    }

    private fun isAdvantage() = player1Points >= 4 || player2Points >= 4

    private fun getAdvantageScore(): String {
        val minusResult = player1Points - player2Points
        return when {
            minusResult == 1 -> "Advantage $player1Name"
            minusResult == -1 -> "Advantage $player2Name"
            minusResult >= 2 -> "Win for $player1Name"
            else -> "Win for $player2Name"
        }
    }

    private fun getMatchScore(): String = getScoreForPoints(player1Points) + "-" + getScoreForPoints(player2Points)

    private fun getScoreForPoints(points: Int): String = enumValues<PlayerScore>()[points].score

    private fun isTie() = player1Points == player2Points

    private fun getTieScore(): String {
        return if (player1Points <= 2) {
            "${getScoreForPoints(player1Points)}-All"
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
