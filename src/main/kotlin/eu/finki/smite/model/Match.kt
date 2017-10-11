package eu.finki.smite.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Match() {

    var id: Int = 0

    constructor(id: Int) : this()

    override fun toString() = "Match{id='$id'}"
}