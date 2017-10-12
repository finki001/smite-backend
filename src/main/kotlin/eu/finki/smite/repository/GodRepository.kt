package eu.finki.smite.repository

import eu.finki.smite.model.God
import org.springframework.data.repository.CrudRepository

interface GodRepository : CrudRepository<God, Long> {

    fun findByGodId(godInt: Int)
}