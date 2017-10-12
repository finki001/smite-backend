package eu.finki.smite.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
class Item {

    @Id
    @GeneratedValue
    @JsonIgnore
    var id: Int = -1

    @JsonProperty("DeviceName")
    var name: String? = null

    @JsonProperty("ChildItemId")
    var childItemId: Int = -1

    @JsonProperty("IconId")
    var iconId: Int = -1

    //    "ItemDescription":
//    {
//        "Description": "Physical Protection and Health.",
//        "Menuitems": [
//        {
//            "Description": "Health",
//            "Value": "+75"
//        },
//        {
//            "Description": "Physical Protection",
//            "Value": "+10"
//        }
//        ],
//        "SecondaryDescription": null
//    },

    @JsonProperty("ItemTier")
    var itemTier: Int = -1

    @JsonProperty("Price")
    var price: Int = -1

    @JsonProperty("RootItemId")
    var rootItemId: Int = -1

    @JsonProperty("ShortDesc")
    var shortDesc: String? = null

    @JsonProperty("StartingItem")
    var startingItem: Boolean = false

    @JsonProperty("Type")
    var type: String? = null

    @JsonProperty("itemIcon_URL")
    var iconUrl: String? = null

    override fun toString() = "Item{\n\tid='$id',\n\tname='$name'\n\t}"
}