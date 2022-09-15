package app.core.database.entity.mapper

import app.core.database.entity.CountryEntity
import app.core.model.Country

object CountryEntityMapper : EntityMapper<List<Country>, List<CountryEntity>> {

    override fun asEntity(domain: List<Country>): List<CountryEntity> {
        return domain.map { pokemon ->
            CountryEntity(
                page = pokemon.page,
                name = pokemon.name,
                url = pokemon.url
            )
        }
    }

    override fun asDomain(entity: List<CountryEntity>): List<Country> {
        return entity.map { pokemonEntity ->
            Country(
                page = pokemonEntity.page,
                name = pokemonEntity.name,
                url = pokemonEntity.url
            )
        }
    }
}

fun List<Country>.asEntity(): List<CountryEntity> {
    return CountryEntityMapper.asEntity(this)
}

fun List<CountryEntity>.asDomain(): List<Country> {
    return CountryEntityMapper.asDomain(this)
}
