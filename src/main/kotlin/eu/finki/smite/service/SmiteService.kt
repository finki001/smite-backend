package eu.finki.smite.service

import eu.finki.smite.model.Match
import eu.finki.smite.model.SessionResponse
import eu.finki.smite.repository.GodRepository
import eu.finki.smite.repository.ItemRepository
import eu.finki.smite.repository.MatchRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.bind.DatatypeConverter

@Component
class SmiteService {

    companion object {
        private const val URL_BACKEND_HOST = "http://api.smitegame.com/smiteapi.svc/"
        private const val URL_CREATE_SESSION = "createsession"
        private const val URL_MATCH_HISTORY = "getmatchhistory"

        private const val DEV_ID = 1187
        private const val AUTHENTICATION_KEY = "7B0A5FE00FF0484CAAB0CFABBEE52AA6"
    }

    @Autowired
    lateinit var godRepository: GodRepository

    @Autowired
    lateinit var itemRepository: ItemRepository

    @Autowired
    lateinit var matchRepository: MatchRepository

    private var sessionId: String? = null
    private val restTemplate = org.springframework.web.client.RestTemplate()

    fun getGods() = godRepository.findAll()

    fun getItems() = itemRepository.findAll()

    fun getMatchesForPlayerName(playerName: String): Array<Match> {
        val url = URL_MATCH_HISTORY
        val timestamp = createTimeStamp()
        val signature = createSignature(url, timestamp)
        if (sessionId == null) {
            createSessionId()
        }
        val finalUrl = "$URL_BACKEND_HOST${url}Json/$DEV_ID/$signature/$sessionId/$timestamp/$playerName"
        return restTemplate.getForEntity(finalUrl, Array<Match>::class.java).body
    }

    fun getGodById(godId: Int) = godRepository.findByGodId(godId)

    fun updateGods(): String {
        return "Gods updated"
    }

    fun updateItems(): String {
        return "Items updated"
    }

    private fun createSessionId(): String? {
        val url = URL_CREATE_SESSION
        val timestamp = createTimeStamp()
        val signature = createSignature(url, timestamp)
        val finalUrl = "$URL_BACKEND_HOST${url}Json/$DEV_ID/$signature/$timestamp"
        sessionId = restTemplate.getForObject(finalUrl, SessionResponse::class.java).sessionId
        return sessionId
    }

    private fun createTimeStamp() = SimpleDateFormat("yyyyMMddHHmmss").apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }.format(Date())

    private fun createSignature(url: String, timestamp: String): String {
        return DatatypeConverter.printHexBinary(
                MessageDigest.getInstance("MD5").apply {
                    update("$DEV_ID$url$AUTHENTICATION_KEY$timestamp".toByteArray())
                }.digest()
        ).toLowerCase()
    }
}