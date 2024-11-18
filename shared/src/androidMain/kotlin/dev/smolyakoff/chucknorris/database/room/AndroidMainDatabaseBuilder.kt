package dev.smolyakoff.chucknorris.database.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers

fun databaseBuilder(ctx: Context): RoomDatabase.Builder<FactsDatabase> {

    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("facts_room.db")

    return Room.databaseBuilder<FactsDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
}

fun getFactsDatabase(ctx: Context): FactsDatabase {
    return databaseBuilder(ctx).build()
}