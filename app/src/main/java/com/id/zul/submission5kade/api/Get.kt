package com.id.zul.submission5kade.api

import android.net.Uri
import com.id.zul.submission5kade.BuildConfig

object Get {

    fun getTeams(leagueID: String?): String {
        return Uri.parse(BuildConfig.BASE_URL)
            .buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.API_KEY)
            .appendPath("search_all_teams.php")
            .appendQueryParameter("l", leagueID)
            .build()
            .toString()
    }

    fun getTeamDetail(teamID: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.API_KEY)
            .appendPath("lookupteam.php")
            .appendQueryParameter("id", teamID)
            .build()
            .toString()
    }

    fun getPreviousMatch(leagueID: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.API_KEY)
            .appendPath("eventspastleague.php")
            .appendQueryParameter("id", leagueID)
            .build()
            .toString()
    }

    fun getNextMatch(leagueID: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.API_KEY)
            .appendPath("eventsnextleague.php")
            .appendQueryParameter("id", leagueID)
            .build()
            .toString()
    }

    fun getMatchDetail(matchID: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.API_KEY)
            .appendPath("lookupevent.php")
            .appendQueryParameter("id", matchID)
            .build()
            .toString()
    }

    fun getSearchMatch(query: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.API_KEY)
            .appendPath("searchevents.php")
            .appendQueryParameter("e", query)
            .build()
            .toString()
    }

    fun getDetailLeague(leagueID: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.API_KEY)
            .appendPath("lookupleague.php")
            .appendQueryParameter("id", leagueID)
            .build()
            .toString()
    }

    fun getClassement(leagueID: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.API_KEY)
            .appendPath("lookuptable.php")
            .appendQueryParameter("l", leagueID)
            .build()
            .toString()
    }

    fun getSearchTeam(query: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.API_KEY)
            .appendPath("searchteams.php")
            .appendQueryParameter("t", query)
            .build()
            .toString()
    }

    fun getPlayer(teamID: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.API_KEY)
            .appendPath("lookup_all_players.php")
            .appendQueryParameter("id", teamID)
            .build()
            .toString()
    }

    fun getPlayerDetails(playerID: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.API_KEY)
            .appendPath("lookupplayer.php")
            .appendQueryParameter("id", playerID)
            .build()
            .toString()
    }

}