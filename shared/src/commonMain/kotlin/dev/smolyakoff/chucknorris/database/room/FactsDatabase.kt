package dev.smolyakoff.chucknorris.database.room

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import dev.smolyakoff.chucknorris.features.fact.local.FactsDao
import dev.smolyakoff.chucknorris.features.history.local.HistoryDao

const val FACTS_TABLE_NAME = "facts"

@Database(entities = [FactDBO::class], version = 1)
@ConstructedBy(FactsDatabaseConstructor::class)
abstract class FactsDatabase : RoomDatabase() {

    abstract fun factsDao(): FactsDao

    abstract fun historyDao(): HistoryDao

}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object FactsDatabaseConstructor : RoomDatabaseConstructor<FactsDatabase>

@Entity(FACTS_TABLE_NAME)
data class FactDBO(

    @PrimaryKey(autoGenerate = false)

    val id: String,
    val imageURL: String,
    val fact: String
)
