package dev.smolyakoff.chucknorris.features.fact.local

import androidx.room.Dao
import androidx.room.Insert
import dev.smolyakoff.chucknorris.database.room.FactDBO

@Dao
interface FactsDao {

    @Insert
    suspend fun insertFact(fact: FactDBO)

}
