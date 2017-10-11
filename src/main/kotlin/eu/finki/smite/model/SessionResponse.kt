package eu.finki.smite.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*


@JsonIgnoreProperties(ignoreUnknown = true)
class SessionResponse {

    @JsonProperty("ret_msg")
    var returnMessage: String? = null

    @JsonProperty("session_id")
    var sessionId: String? = null

    @JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy hh:mm:ss a")
    var timestamp: Date? = null

    override fun toString() = "SessionResponse{\n\tsessionId='$sessionId',\n\treturnMessage='$returnMessage',\n\ttimestamp='$timestamp'\n}"
}