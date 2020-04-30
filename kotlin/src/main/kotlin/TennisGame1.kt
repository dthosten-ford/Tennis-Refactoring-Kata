class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var m_score1: Int = 0
    private var m_score2: Int = 0
    private var Love = "Love"
    private val Fifteen = "Fifteen"
    private val Thirty = "Thirty"
    private val forty = "Forty"

    override fun wonPoint(playerName: String) {
        if (playerName === "player1")
            m_score1 += 1
        else
            m_score2 += 1
    }

    override fun getScore(): String {

        if (playersHaveSamePoints()) {
            return getTieScore(":")
        } else if (chechickScoreGreaterThan4()) {
            return getScoreIfNotEqual("")
        } else {
            return getTempScore("")
        }

    }

    private fun getTempScore(score: String): String {
        var tempScore1 = 0
        var score1 = score
        for (i in 1..2) {
            if (i == 1)
                tempScore1 = m_score1
            else {
                score1 += "-"
                tempScore1 = m_score2
            }

            when (tempScore1) {
                0 -> score1 += Love
                1 -> score1 += Fifteen
                2 -> score1 += Thirty
                3 -> score1 += forty
            }
        }
        return score1
    }

    private fun getScoreIfNotEqual(score: String): String {
        var score1 = score
        val minusResult = m_score1 - m_score2
        if (minusResult == 1)
            score1 = "Advantage player1"
        else if (minusResult == -1)
            score1 = "Advantage player2"
        else if (minusResult >= 2)
            score1 = "Win for player1"
        else
            score1 = "Win for player2"
        return score1
    }

    private fun chechickScoreGreaterThan4() = m_score1 >= 4 || m_score2 >= 4

    private fun getTieScore(score: String): String {
        var score1 = score
        when (m_score1) {
            0 -> score1 = "Love-All"
            1 -> score1 = "Fifteen-All"
            2 -> score1 = "Thirty-All"
            else -> score1 = "Deuce"
        }
        return score1
    }

    private fun playersHaveSamePoints() = m_score1 == m_score2
}
