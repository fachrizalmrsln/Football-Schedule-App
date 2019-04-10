package com.id.zul.submission3kade.api

import android.net.Uri
import com.id.zul.submission3kade.BuildConfig

object Get {

    fun getTeams(league: String?): String {
        return Uri.parse(BuildConfig.BASE_URL)
            .buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.API_KEY)
            .appendPath("search_all_teams.php")
            .appendQueryParameter("l", league)
            .build()
            .toString()
    }

    fun getTeamDetail(id: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.API_KEY)
            .appendPath("lookupteam.php")
            .appendQueryParameter("id", id)
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

    fun getMatchDetail(id: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.API_KEY)
            .appendPath("lookupevent.php")
            .appendQueryParameter("id", id)
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

    fun getDetailLeague(id: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.API_KEY)
            .appendPath("lookupleague.php")
            .appendQueryParameter("id", id)
            .build()
            .toString()
    }

}