package eu.finki.smite.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
class Match {

    @Id
    @GeneratedValue
    @JsonIgnore
    var id: Int = -1

    @JsonProperty("God")
    var godName: String? = null

    var playerName: String? = null

    override fun toString() = "Match{\n\tid='$id',\n\tgodName='$godName',\n\tplayerName='$playerName'\n\t}"
}