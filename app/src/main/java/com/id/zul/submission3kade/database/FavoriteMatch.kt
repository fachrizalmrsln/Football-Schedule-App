package com.id.zul.submission3kade.database

data class FavoriteMatch(
    val id: Long?,
    val matchId: String?,
    val matchHomeTeam: String?,
    val matchAwayTeam: String?,
    val matchHomeLogo: String?,
    val matchAwayLogo: String?,
    val matchLeague: String?,
    val matchDate: String?,
    val matchTime: String?,
    val matchHomeScore: String?,
    val matchAwayScore: String?,
    val matchHomeSoccer: String?,
    val matchAwaySoccer: String?,
    val matchHomeShoot: String?,
    val matchAwayShoot: String?
) {
    companion object {
        const val TABLE_FAVORITE_MATCH: String = "TABLE_FAVORITE_MATCH"
        const val ID: String = "ID_"
        const val MATCH_ID: String = "MATCH_ID"
        const val MATCH_HOME_TEAM: String = "MATCH_HOME_TEAM"
        const val MATCH_AWAY_TEAM: String = "MATCH_AWAY_TEAM"
        const val MATCH_HOME_LOGO: String = "MATCH_HOME_LOGO"
        const val MATCH_AWAY_LOGO: String = "MATCH_AWAY_LOGO"
        const val MATCH_LEAGUE: String = "MATCH_LEAGUE"
        const val MATCH_DATE: String = "MATCH_DATE"
        const val MATCH_TIME: String = "MATCH_TIME"
        const val MATCH_HOME_SCORE: String = "MATCH_HOME_SCORE"
        const val MATCH_AWAY_SCORE: String = "MATCH_AWAY_SCORE"
        const val MATCH_HOME_SOCCER: String = "MATCH_HOME_SOCCER"
        const val MATCH_AWAY_SOCCER: String = "MATCH_AWAY_SOCCER"
        const val MATCH_HOME_SHOOT: String = "MATCH_HOME_SHOOT"
        const val MATCH_AWAY_SHOOT: String = "MATCH_AWAY_SHOOT"
    }
}