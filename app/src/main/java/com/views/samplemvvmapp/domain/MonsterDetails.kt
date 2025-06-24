package com.views.samplemvvmapp.domain

import com.google.gson.annotations.SerializedName

data class MonsterDetails(
    @SerializedName("index") var index: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("desc") var desc: String? = null,
    @SerializedName("size") var size: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("subtype") var subtype: String? = null,
    @SerializedName("alignment") var alignment: String? = null,
    @SerializedName("hit_points") var hitPoints: Int? = null,
    @SerializedName("hit_dice") var hitDice: String? = null,
    @SerializedName("hit_points_roll") var hitPointsRoll: String? = null,
    @SerializedName("strength") var strength: Int? = null,
    @SerializedName("dexterity") var dexterity: Int? = null,
    @SerializedName("constitution") var constitution: Int? = null,
    @SerializedName("intelligence") var intelligence: Int? = null,
    @SerializedName("wisdom") var wisdom: Int? = null,
    @SerializedName("charisma") var charisma: Int? = null,
    @SerializedName("languages") var languages: String? = null,
    @SerializedName("challenge_rating") var challengeRating: Double? = null,
    @SerializedName("proficiency_bonus") var proficiencyBonus: Int? = null,
    @SerializedName("xp") var xp: Int? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null
)
