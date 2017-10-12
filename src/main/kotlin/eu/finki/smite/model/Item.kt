package eu.finki.smite.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*


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

    @JsonProperty("ItemDescription")
    @Transient
    var details: ItemDetails? = null

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

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
class ItemDetails {

    @Id
    var id: Int = -1

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    var item: Item? = null

    @JsonProperty("Description")
    var description: String? = null

    @JsonProperty("Menuitems")
    @OneToMany(cascade = arrayOf(CascadeType.REMOVE), mappedBy = "itemDetails")
    var menuItems: List<MenuItem>? = null
}

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
class MenuItem {

    @Id
    @GeneratedValue
    var id: Int = -1

    @JsonProperty("Description")
    var description: String? = null

    @JsonProperty("Value")
    var value: String? = null

    @ManyToOne
    @JoinColumn(name="item_details_id")
    var itemDetails: ItemDetails? = null
}