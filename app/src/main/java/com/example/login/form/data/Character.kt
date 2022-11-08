package com.example.login.form.data


import com.google.gson.annotations.SerializedName

data class Connections(@SerializedName("groupAffiliation")
                       val groupAffiliation: String = "",
                       @SerializedName("relatives")
                       val relatives: String = "")


data class Character(@SerializedName("images")
                     val images: Images,
                     @SerializedName("appearance")
                     val appearance: Appearance,
                     @SerializedName("work")
                     val work: Work,
                     @SerializedName("name")
                     val name: String = "",
                     @SerializedName("powerstats")
                     val powerstats: Powerstats,
                     @SerializedName("id")
                     val id: Int = 0,
                     @SerializedName("biography")
                     val biography: Biography,
                     @SerializedName("slug")
                     val slug: String = "",
                     @SerializedName("connections")
                     val connections: Connections
)


data class Images(@SerializedName("md")
                  val md: String = "",
                  @SerializedName("sm")
                  val sm: String = "",
                  @SerializedName("xs")
                  val xs: String = "",
                  @SerializedName("lg")
                  val lg: String = "")


data class Work(@SerializedName("occupation")
                val occupation: String = "",
                @SerializedName("base")
                val base: String = "")


data class Biography(@SerializedName("firstAppearance")
                     val firstAppearance: String = "",
                     @SerializedName("placeOfBirth")
                     val placeOfBirth: String = "",
                     @SerializedName("aliases")
                     val aliases: List<String>?,
                     @SerializedName("fullName")
                     val fullName: String = "",
                     @SerializedName("publisher")
                     val publisher: String = "",
                     @SerializedName("alterEgos")
                     val alterEgos: String = "",
                     @SerializedName("alignment")
                     val alignment: String = "")


data class Powerstats(@SerializedName("strength")
                      val strength: Int = 0,
                      @SerializedName("durability")
                      val durability: Int = 0,
                      @SerializedName("combat")
                      val combat: Int = 0,
                      @SerializedName("power")
                      val power: Int = 0,
                      @SerializedName("speed")
                      val speed: Int = 0,
                      @SerializedName("intelligence")
                      val intelligence: Int = 0)


data class Appearance(@SerializedName("gender")
                      val gender: String = "",
                      @SerializedName("race")
                      val race: String = "",
                      @SerializedName("eyeColor")
                      val eyeColor: String = "",
                      @SerializedName("weight")
                      val weight: List<String>?,
                      @SerializedName("hairColor")
                      val hairColor: String = "",
                      @SerializedName("height")
                      val height: List<String>?)


