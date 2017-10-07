package eu.finki.smite

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>