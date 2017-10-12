package eu.finki.smite.repository

import eu.finki.smite.model.ItemDetails
import org.springframework.data.repository.CrudRepository

interface ItemDetailsRepository : CrudRepository<ItemDetails, Long>