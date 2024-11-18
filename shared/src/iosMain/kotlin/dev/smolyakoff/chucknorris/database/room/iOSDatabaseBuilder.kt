package dev.smolyakoff.chucknorris.database.room

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

fun getFactsDatabase(): FactsDatabase {
    return getDatabaseBuilder().build()
}


private fun getDatabaseBuilder(): RoomDatabase.Builder<FactsDatabase> {
    val dbFilePath = documentDirectory() + "/facts_room.db"
    return Room.databaseBuilder<FactsDatabase>(
        name = dbFilePath,
    )
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
}


@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}
