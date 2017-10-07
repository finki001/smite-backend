package eu.finki.smite

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/demo")
class MainController {

    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping("/add")
    @ResponseBody
    fun addNewUser(@RequestParam name: String, @RequestParam email: String): String {
        val newUser = User(name, email)
        userRepository.save(newUser)
        return "Saved"
    }

    @GetMapping("/all")
    @ResponseBody
    fun getAllUsers() = userRepository.findAll()
}