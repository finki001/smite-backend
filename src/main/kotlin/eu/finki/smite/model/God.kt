package eu.finki.smite.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Lob

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
class God {

    @Id
    @GeneratedValue
    @JsonIgnore
    var id: Int = -1

    var name: String? = null

    @JsonProperty("id")
    var godId: Int = -1

    @JsonProperty("godAbility1_URL")
    var ability1IconUrl: String? = null

    @JsonProperty("godAbility2_URL")
    var ability2IconUrl: String? = null

    @JsonProperty("godAbility3_URL")
    var ability3IconUrl: String? = null

    @JsonProperty("godAbility4_URL")
    var ability4IconUrl: String? = null

    @JsonProperty("godAbility5_URL")
    var passiveIconUrl: String? = null

    @JsonProperty("godIcon_URL")
    var iconUrl: String? = null

    @JsonProperty("Ability1")
    var ability1Name: String? = null

    @JsonProperty("Ability2")
    var ability2Name: String? = null

    @JsonProperty("Ability3")
    var ability3Name: String? = null

    @JsonProperty("Ability4")
    var ability4Name: String? = null

    @JsonProperty("Ability5")
    var passiveName: String? = null

    @JsonProperty("AttackSpeed")
    var attackSpeed: Double? = null

    @JsonProperty("AttackSpeedPerLevel")
    var attackSpeedPerLevel: Double? = null

    @JsonProperty("HP5PerLevel")
    var hp5PerLevel: Double? = null

    @JsonProperty("Health")
    var health: Int=-1

    @JsonProperty("HealthPerFive")
    var healthPerFive: Int=-1

    @JsonProperty("HealthPerLevel")
    var healthPerLevel: Double? = null

    @JsonProperty("Lore")
    @Lob
    var Lore: String? = null

    @JsonProperty("MP5PerLevel")
    var mp5PerLevel: Double? = null

    @JsonProperty("MagicProtection")
    var magicProtection: Int=-1

    @JsonProperty("MagicProtectionPerLevel")
    var magicProtectionPerLevel: Double? = null

    @JsonProperty("MagicalPower")
    var magicalPower: Int=-1

    @JsonProperty("MagicalPowerPerLevel")
    var magicalPowerPerLevel: Double? = null

    @JsonProperty("Mana")
    var mana: Int=-1

    @JsonProperty("ManaPerFive")
    var manaPerFive: Double? = null

    @JsonProperty("ManaPerLevel")
    var manaPerLevel: Int=-1

    @JsonProperty("OnFreeRotation")
    var onFreeRotation: String? = null

    @JsonProperty("Pantheon")
    var pantheon: String? = null

    @JsonProperty("PhysicalPower")
    var physicalPower: Int=-1

    @JsonProperty("PhysicalPowerPerLevel")
    var physicalPowerPerLevel: Double? = null

    @JsonProperty("PhysicalProtection")
    var physicalProtection: Int=-1

    @JsonProperty("PhysicalProtectionPerLevel")
    var physicalProtectionPerLevel: Double? = null

    @JsonProperty("Pros")
    var pros: String? = null

    @JsonProperty("Roles")
    var roles: String? = null

    @JsonProperty("Speed")
    var speed: Int = -1

    @JsonProperty("Title")
    var title: String? = null

    @JsonProperty("Type")
    var type: String? = null

    override fun toString() = "God{\n\tid='$id',\n\tgodId='$godId',\n\tname='$name',\n\t}"
}