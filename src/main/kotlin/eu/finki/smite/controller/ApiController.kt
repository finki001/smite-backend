package eu.finki.smite.controller

import eu.finki.smite.model.God
import eu.finki.smite.model.Item
import eu.finki.smite.model.Match
import eu.finki.smite.service.SmiteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import java.util.logging.Level.INFO
import java.util.logging.Logger

@Controller
class ApiController {

    val logger: Logger = Logger.getLogger(javaClass.simpleName)

    @Autowired
    lateinit var smiteService: SmiteService

    @GetMapping("/")
    @ResponseBody
    fun home() = "Smite API"

    @GetMapping("/gods/{godId}")
    @ResponseBody
    fun getGodById(@PathVariable(value = "godId") godId: Int) {
        logger.log(INFO, "getGodById($godId")
        return smiteService.getGodById(godId)
    }

    @GetMapping("/gods")
    @ResponseBody
    fun getAllGods(): MutableIterable<God>? {
        logger.log(INFO, "getAllGods()")
        return smiteService.getGods()
    }

    @GetMapping("/items")
    @ResponseBody
    fun getAllItems(): MutableIterable<Item>? {
        logger.log(INFO, "getAllItems()")
        return smiteService.getItems()
    }

    @GetMapping("/gods/update")
    @ResponseBody
    fun updateGods(): String {
        logger.log(INFO, "updateGods()")
        return smiteService.updateGods()
    }

    @GetMapping("/items/update")
    @ResponseBody
    fun updateItems(): String {
        logger.log(INFO, "updateItems()")
        return smiteService.updateItems()
    }

    @GetMapping("/matches/{playerName}")
    @ResponseBody
    fun getMatchesForPlayerName(@PathVariable(value = "playerName") playerName: String): Array<Match> {
        logger.log(INFO, "getMatchesForPlayerName($playerName)")
        return smiteService.getMatchesForPlayerName(playerName)
    }
}