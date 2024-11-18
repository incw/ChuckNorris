package dev.smolyakoff.chucknorris.database.room

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

fun getRoomDatabase(
    builder: RoomDatabase.Builder<FactsDatabase>
): FactsDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
