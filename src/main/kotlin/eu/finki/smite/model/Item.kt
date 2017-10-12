package eu.finki.smite.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
class Item {

    @Id
    @GeneratedValue
    @JsonIgnore
    var id: Int = -1

    var name: String? = null

    override fun toString() = "Item{\n\tid='$id',\n\tname='$name'\n\t}"
}