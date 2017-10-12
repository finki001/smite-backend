package eu.finki.smite

import eu.finki.smite.service.SmiteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/api")
class ApiController {

    @Autowired
    lateinit var smiteService: SmiteService

    @GetMapping("/gods/{godId}")
    @ResponseBody
    fun getGodById(@PathVariable(value = "godId") godId: Int) = smiteService.getGodById(godId)

    @GetMapping("/gods")
    @ResponseBody
    fun getAllGods() = smiteService.getGods()

    @GetMapping("/items")
    @ResponseBody
    fun getAllItems() = smiteService.getItems()

    @GetMapping("/gods/update")
    @ResponseBody
    fun updateGods() = smiteService.updateGods()

    @GetMapping("/items/update")
    @ResponseBody
    fun updateItems() = smiteService.updateItems()

    @GetMapping("/matches/{playerName}")
    @ResponseBody
    fun getMatchesForPlayerName(@PathVariable(value = "playerName") playerName: String) = smiteService.getMatchesForPlayerName(playerName)
}
