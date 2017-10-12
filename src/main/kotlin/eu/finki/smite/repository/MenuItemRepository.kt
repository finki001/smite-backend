package eu.finki.smite.repository

import eu.finki.smite.model.MenuItem
import org.springframework.data.repository.CrudRepository

interface MenuItemRepository : CrudRepository<MenuItem, Long>