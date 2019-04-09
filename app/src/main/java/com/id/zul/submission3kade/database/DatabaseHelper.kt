package com.id.zul.submission3kade.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DatabaseHelper(ctx: Context) :
    ManagedSQLiteOpenHelper(ctx, "FavoriteDatabase.db", null, 1) {

    companion object {
        private var instance: DatabaseHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DatabaseHelper {
            if (instance == null)
                instance =
                    DatabaseHelper(ctx.applicationContext)
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {

        //crete table favorite match
        db.createTable(
            FavoriteMatch.TABLE_FAVORITE_MATCH, true,
            FavoriteMatch.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FavoriteMatch.MATCH_ID to TEXT + UNIQUE,
            FavoriteMatch.MATCH_HOME_TEAM to TEXT,
            FavoriteMatch.MATCH_AWAY_TEAM to TEXT,
            FavoriteMatch.MATCH_HOME_LOGO to TEXT,
            FavoriteMatch.MATCH_AWAY_LOGO to TEXT,
            FavoriteMatch.MATCH_LEAGUE to TEXT,
            FavoriteMatch.MATCH_DATE to TEXT,
            FavoriteMatch.MATCH_TIME to TEXT,
            FavoriteMatch.MATCH_HOME_SCORE to TEXT,
            FavoriteMatch.MATCH_AWAY_SCORE to TEXT,
            FavoriteMatch.MATCH_HOME_SOCCER to TEXT,
            FavoriteMatch.MATCH_AWAY_SOCCER to TEXT,
            FavoriteMatch.MATCH_HOME_SHOOT to TEXT,
            FavoriteMatch.MATCH_AWAY_SHOOT to TEXT
        )

        //create table favorite team
        db.createTable(
            FavoriteTeam.TABLE_FAVORITE_TEAM, true,
            FavoriteTeam.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FavoriteTeam.TEAM_ID to TEXT + UNIQUE,
            FavoriteTeam.TEAM_NAME to TEXT,
            FavoriteTeam.TEAM_AKA to TEXT,
            FavoriteTeam.TEAM_YEAR to TEXT,
            FavoriteTeam.TEAM_LEAGUE to TEXT,
            FavoriteTeam.TEAM_COUNTRY to TEXT,
            FavoriteTeam.TEAM_LOGO to TEXT,
            FavoriteTeam.TEAM_STADIUM_ICON to TEXT,
            FavoriteTeam.TEAM_STADIUM_NAME to TEXT,
            FavoriteTeam.TEAM_STADIUM_LOCATION to TEXT,
            FavoriteTeam.TEAM_DESCRIPTION to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(FavoriteMatch.TABLE_FAVORITE_MATCH, true)
        db.dropTable(FavoriteTeam.TABLE_FAVORITE_TEAM, true)
    }
}

val Context.database: DatabaseHelper
    get() = DatabaseHelper.getInstance(applicationContext)