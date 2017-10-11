package eu.finki.smite.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Match {

    @JsonProperty("God")
    var godName: String?=null

    override fun toString() = "Match{godName='$godName'}"
}