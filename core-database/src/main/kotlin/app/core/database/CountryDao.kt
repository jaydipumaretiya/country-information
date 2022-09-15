package app.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.core.database.entity.CountryEntity

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonList(pokemonList: List<CountryEntity>)

    @Query("SELECT * FROM country WHERE page = :page_")
    suspend fun getPokemonList(page_: Int): List<CountryEntity>

    @Query("SELECT * FROM country WHERE page <= :page_")
    suspend fun getAllPokemonList(page_: Int): List<CountryEntity>
}
