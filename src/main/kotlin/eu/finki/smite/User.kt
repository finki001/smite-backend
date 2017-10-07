package eu.finki.smite

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = 0

    lateinit var name: String

    lateinit var email: String

    constructor(name: String, email: String) : this() {
        this.name = name
        this.email = email
    }
}