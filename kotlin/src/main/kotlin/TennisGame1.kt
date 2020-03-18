class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

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

    private fun getMatchScore(): String {
        var tempPoints: Int
        var score = ""
        for (index in 1..2) {
            val pair = determinePlayerForPoints(index, score)
            score = pair.first
            tempPoints = pair.second
            when (tempPoints) {
                0 -> score += "Love"
                1 -> score += "Fifteen"
                2 -> score += "Thirty"
                3 -> score += "Forty"
            }
        }
        return score
    }

    private fun determinePlayerForPoints(index: Int, score: String): Pair<String, Int> = when (index) {
        1 -> Pair(score, player1Points)
        else -> Pair("$score-", player2Points)
    }

    private fun isTie() = player1Points == player2Points

    private fun getTieScore(): String =
            when (player1Points) {
                0 -> "Love-All"
                1 -> "Fifteen-All"
                2 -> "Thirty-All"
                else -> "Deuce"
            }
}
