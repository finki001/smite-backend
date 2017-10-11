package eu.finki.smite.model

import javax.xml.bind.DatatypeConverter
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object Maestro {
    @Throws(NoSuchAlgorithmException::class)
    @JvmStatic fun main(args: Array<String>) {

        val hash = "35454B055CC325EA1AF2126E27707052"
        val password = "ILoveJava"

        val md = MessageDigest.getInstance("MD5")
        md.update(password.toByteArray())
        val digest = md.digest()
        val myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase()

        println(myHash == hash)
    }
}
