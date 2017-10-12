package eu.finki.smite.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
class God {

    @Id
    @GeneratedValue
    @JsonIgnore
    var id: Int = -1

    var name: String? = null

    var godId: Int = -1

    override fun toString() = "God{\n\tid='$id',\n\tgodId='$godId',\n\tname='$name',\n\t}"
}