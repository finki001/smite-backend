package eu.finki.smite.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
class SessionResponse {

    @Id
    @GeneratedValue
    @JsonIgnore
    var id: Int = -1

    @JsonProperty("ret_msg")
    var returnMessage: String? = null

    @JsonProperty("session_id")
    var sessionId: String? = null

    @JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy hh:mm:ss a")
    var timestamp: Date? = null

    override fun toString() = "SessionResponse{\n\tid='$id',\n\tsessionId='$sessionId',\n\treturnMessage='$returnMessage',\n\ttimestamp='$timestamp'\n}"
}