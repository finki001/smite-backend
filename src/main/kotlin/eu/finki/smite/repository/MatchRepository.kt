package eu.finki.smite.repository

import eu.finki.smite.model.Match
import org.springframework.data.repository.CrudRepository

interface MatchRepository : CrudRepository<Match, Long> {

    fun findByPlayerName(playerName: String)
}