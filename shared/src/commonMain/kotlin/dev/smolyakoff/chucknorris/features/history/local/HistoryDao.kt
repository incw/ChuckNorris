package dev.smolyakoff.chucknorris.features.history.local

import androidx.room.Dao
import androidx.room.Query
import dev.smolyakoff.chucknorris.database.room.FACTS_TABLE_NAME
import dev.smolyakoff.chucknorris.database.room.FactDBO
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    
    @Query("SELECT * FROM $FACTS_TABLE_NAME")
    suspend fun factsAsFlow(): List<FactDBO>

}