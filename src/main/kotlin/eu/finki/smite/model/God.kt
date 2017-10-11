package eu.finki.smite.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class God() {

    var id: Int = 0

    constructor(id: Int) : this()

    override fun toString() = "God{id='$id'}"
}