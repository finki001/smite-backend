package eu.finki.smite.repository

import eu.finki.smite.model.Item
import org.springframework.data.repository.CrudRepository

interface ItemRepository : CrudRepository<Item, Long>