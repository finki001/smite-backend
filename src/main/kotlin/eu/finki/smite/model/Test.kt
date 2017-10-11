package eu.finki.smite.model

import eu.finki.smite.Application
import org.slf4j.LoggerFactory
import org.springframework.web.client.RestTemplate
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.bind.DatatypeConverter


private val log = LoggerFactory.getLogger(Application::class.java)

private const val URL_BACKEND_HOST = "http://api.smitegame.com/smiteapi.svc/"
private const val URL_CREATE_SESSION = "createsession"
private const val URL_MATCH_HISTORY = "getmatchhistory"

private const val DEV_ID = 1187
private const val AUTHENTICATION_KEY = "7B0A5FE00FF0484CAAB0CFABBEE52AA6"
private var sessionId: String? = null

fun main(args: Array<String>) {
    createSessionId()
    log.info("Matches: ${getMatchHistory("gane5ha").size}")
}

fun createSessionId() {
    val url = URL_CREATE_SESSION
    val timestamp = createTimeStamp()
    val signature = createSignature(url, timestamp)
    val finalUrl = "$URL_BACKEND_HOST${url}Json/$DEV_ID/$signature/$timestamp"
    val restTemplate = RestTemplate()
    val createSessionResponse = restTemplate.getForObject(finalUrl, SessionResponse::class.java)
    sessionId = createSessionResponse.sessionId
}

fun getMatchHistory(playerName: String): Array<Match> {
    val url = URL_MATCH_HISTORY
    val timestamp = createTimeStamp()
    val signature = createSignature(url, timestamp)
    val finalUrl = "$URL_BACKEND_HOST${url}Json/$DEV_ID/$signature/$sessionId/$timestamp/$playerName"
    val restTemplate = RestTemplate()
    val matchHistoryResponse = restTemplate.getForEntity(finalUrl, Array<Match>::class.java)
    return matchHistoryResponse.body
}

fun createTimeStamp() = SimpleDateFormat("yyyyMMddHHmmss").apply {
    timeZone = TimeZone.getTimeZone("UTC")
}.format(Date())

fun createSignature(url: String, timestamp: String): String {
    return DatatypeConverter.printHexBinary(
            MessageDigest.getInstance("MD5").apply {
                update("$DEV_ID$url$AUTHENTICATION_KEY$timestamp".toByteArray())
            }.digest()
    )
}