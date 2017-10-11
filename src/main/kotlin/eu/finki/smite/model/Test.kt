package eu.finki.smite.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import eu.finki.smite.Application
import org.slf4j.LoggerFactory
import org.springframework.web.client.RestTemplate
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.bind.DatatypeConverter


private val log = LoggerFactory.getLogger(Application::class.java)

private val URL_BACKEND_HOST = "http://api.smitegame.com/smiteapi.svc/"
private val URL_CREATE_SESSION = "createsession"
private val URL_MATCH_HISTORY = "getmatchhistory"

private val DEV_ID = 1187
private val AUTHENTICATION_KEY = "7B0A5FE00FF0484CAAB0CFABBEE52AA6"

fun main(args: Array<String>) {
    //        RestTemplate restTemplate = new RestTemplate();
    //        Match quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Match.class);
    //        log.info(quote.toString());
    //    val responseEntity = RestTemplate().getForEntity("http://localhost:8000/api/gods", Array<God>::class.java)
    //    val gods = responseEntity.body
    //    val contentType = responseEntity.headers.contentType
    //    val statusCode = responseEntity.statusCode

    val url = URL_CREATE_SESSION
    val timestamp = createTimeStamp()
    val signature = createSignature(url, timestamp)
    val finalUrl = "$URL_BACKEND_HOST${url}Json/$DEV_ID/$signature/$timestamp"
    println("final url: $finalUrl")
    val restTemplate = RestTemplate()
    val createSessionResponse = restTemplate.getForObject(finalUrl, SessionResponse::class.java)
    log.info(createSessionResponse.toString())
}

fun createTimeStamp(): String {
    val sdf = SimpleDateFormat("yyyyMMddHHmmss")
    sdf.timeZone = TimeZone.getTimeZone("UTC")
    return sdf.format(Date())
}

fun createSignature(url: String, timestamp: String): String {
    val input = "$DEV_ID$url$AUTHENTICATION_KEY$timestamp"
    println("input: $input")
    val md = MessageDigest.getInstance("MD5")
    md.update(input.toByteArray())
    val hashy = DatatypeConverter.printHexBinary(md.digest())
    println("hash: $hashy")
    return hashy.toLowerCase()
}

@JsonIgnoreProperties(ignoreUnknown = true)
class SessionResponse {

    @JsonProperty("ret_msg")
    var returnMessage: String? = null

    @JsonProperty("session_id")
    var sessionId: String? = null

    @JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy hh:mm:ss a")
    var timestamp: Date? = null

    override fun toString()="SessionResponse{\n\tsessionId='$sessionId',\n\treturnMessage='$returnMessage',\n\ttimestamp='$timestamp'\n}"
}