package com.id.zul.submission4kade.database

data class FavoriteTeam(
    val id: Long?,
    val teamID: String?,
    val teamName: String?,
    val teamAka: String?,
    val teamYear: String?,
    val teamLeague: String?,
    val teamCountry: String?,
    val teamLogo: String?,
    val teamStadiumIcon: String?,
    val teamStadiumName: String?,
    val teamStadiumLocation: String?,
    val teamDescription: String?
) {
    companion object {
        const val TABLE_FAVORITE_TEAM: String = "TABLE_FAVORITE_TEAM"
        const val ID: String = "ID_"
        const val TEAM_ID: String = "TEAM_ID"
        const val TEAM_NAME: String = "TEAM_NAME"
        const val TEAM_AKA: String = "TEAM_AKA"
        const val TEAM_YEAR: String = "TEAM_YEAR"
        const val TEAM_LEAGUE: String = "TEAM_LEAGUE"
        const val TEAM_COUNTRY: String = "TEAM_COUNTRY"
        const val TEAM_LOGO: String = "TEAM_LOGO"
        const val TEAM_STADIUM_ICON: String = "TEAM_STADIUM_ICON"
        const val TEAM_STADIUM_NAME: String = "TEAM_STADIUM_NAME"
        const val TEAM_STADIUM_LOCATION: String = "TEAM_STADIUM_LOCATION"
        const val TEAM_DESCRIPTION: String = "TEAM_DESCRIPTION"
    }
}