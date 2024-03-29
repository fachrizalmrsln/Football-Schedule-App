package com.id.zul.submission5kade.model.match

import com.google.gson.annotations.SerializedName
import java.util.*

data class PreviousResults(
    @SerializedName("idEvent")
    var idEvent: String? = null,
    @SerializedName("idSoccerXML")
    var idSoccerXML: String? = null,
    @SerializedName("strEvent")
    var strEvent: String? = null,
    @SerializedName("strFilename")
    var strFilename: String? = null,
    @SerializedName("strSport")
    var strSport: String? = null,
    @SerializedName("idLeague")
    var idLeague: String? = null,
    @SerializedName("strLeague")
    var strLeague: String? = null,
    @SerializedName("strSeason")
    var strSeason: String? = null,
    @SerializedName("strDescriptionEN")
    var strDescriptionEN: Any? = null,
    @SerializedName("strHomeTeam")
    var strHomeTeam: String? = null,
    @SerializedName("strAwayTeam")
    var strAwayTeam: String? = null,
    @SerializedName("intHomeScore")
    var intHomeScore: String? = null,
    @SerializedName("intRound")
    var intRound: String? = null,
    @SerializedName("intAwayScore")
    var intAwayScore: String? = null,
    @SerializedName("intSpectators")
    var intSpectators: Any? = null,
    @SerializedName("strHomeGoalDetails")
    var strHomeGoalDetails: Any? = null,
    @SerializedName("strHomeRedCards")
    var strHomeRedCards: Any? = null,
    @SerializedName("strHomeYellowCards")
    var strHomeYellowCards: Any? = null,
    @SerializedName("strHomeLineupGoalkeeper")
    var strHomeLineupGoalkeeper: Any? = null,
    @SerializedName("strHomeLineupDefense")
    var strHomeLineupDefense: Any? = null,
    @SerializedName("strHomeLineupMidfield")
    var strHomeLineupMidfield: Any? = null,
    @SerializedName("strHomeLineupForward")
    var strHomeLineupForward: Any? = null,
    @SerializedName("strHomeLineupSubstitutes")
    var strHomeLineupSubstitutes: Any? = null,
    @SerializedName("strHomeFormation")
    var strHomeFormation: Any? = null,
    @SerializedName("strAwayRedCards")
    var strAwayRedCards: Any? = null,
    @SerializedName("strAwayYellowCards")
    var strAwayYellowCards: Any? = null,
    @SerializedName("strAwayGoalDetails")
    var strAwayGoalDetails: Any? = null,
    @SerializedName("strAwayLineupGoalkeeper")
    var strAwayLineupGoalkeeper: Any? = null,
    @SerializedName("strAwayLineupDefense")
    var strAwayLineupDefense: Any? = null,
    @SerializedName("strAwayLineupMidfield")
    var strAwayLineupMidfield: Any? = null,
    @SerializedName("strAwayLineupForward")
    var strAwayLineupForward: Any? = null,
    @SerializedName("strAwayLineupSubstitutes")
    var strAwayLineupSubstitutes: Any? = null,
    @SerializedName("strAwayFormation")
    var strAwayFormation: Any? = null,
    @SerializedName("intHomeShots")
    var intHomeShots: Any? = null,
    @SerializedName("intAwayShots")
    var intAwayShots: Any? = null,
    @SerializedName("dateEvent")
    var dateEvent: Date? = null,
    @SerializedName("strDate")
    var strDate: String? = null,
    @SerializedName("strTime")
    var strTime: String? = null,
    @SerializedName("strTVStation")
    var strTVStation: Any? = null,
    @SerializedName("idHomeTeam")
    var idHomeTeam: String? = null,
    @SerializedName("idAwayTeam")
    var idAwayTeam: String? = null,
    @SerializedName("strResult")
    var strResult: Any? = null,
    @SerializedName("strCircuit")
    var strCircuit: Any? = null,
    @SerializedName("strCountry")
    var strCountry: Any? = null,
    @SerializedName("strCity")
    var strCity: Any? = null,
    @SerializedName("strPoster")
    var strPoster: Any? = null,
    @SerializedName("strFanart")
    var strFanart: Any? = null,
    @SerializedName("strThumb")
    var strThumb: Any? = null,
    @SerializedName("strBanner")
    var strBanner: Any? = null,
    @SerializedName("strMap")
    var strMap: Any? = null,
    @SerializedName("strLocked")
    var strLocked: String? = null
)