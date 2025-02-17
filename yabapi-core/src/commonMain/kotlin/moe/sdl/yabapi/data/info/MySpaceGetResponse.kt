@file:UseSerializers(BooleanJsSerializer::class)

package moe.sdl.yabapi.data.info

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import moe.sdl.yabapi.data.GeneralCode
import moe.sdl.yabapi.serializer.BooleanJsSerializer

@Serializable
public data class MySpaceGetResponse(
    @SerialName("code") val code: GeneralCode = GeneralCode.UNKNOWN,
    @SerialName("message") val message: String? = null,
    @SerialName("ttl") val ttl: Int? = null,
    @SerialName("data") val data: MySpace? = null,
)

@Serializable
public data class MySpace(
    @SerialName("mid") val mid: Int,
    @SerialName("name") val name: String,
    @SerialName("sex") val sex: String,
    @SerialName("face") val avatar: String,
    @SerialName("sign") val bio: String,
    @SerialName("rank") val rank: Int,
    @SerialName("level") val level: Int,
    @SerialName("jointime") val joinTime: Long,
    @SerialName("moral") val moral: Int,
    @SerialName("silence") val isBanned: Boolean,
    @SerialName("email_status") val hasEmailBind: Boolean,
    @SerialName("tel_status") val hasTelBind: Boolean,
    @SerialName("identification") val identification: Int,
    @SerialName("vip") val vip: UserVip,
    @SerialName("pendant") val pendant: Pendant,
    @SerialName("nameplate") val nameplate: UserNameplateData,
    @SerialName("official") val official: Official,
    @SerialName("birthday") val birthday: Long,
    @SerialName("is_tourist") val isTourist: Boolean,
    @SerialName("is_fake_account") val isFakeAccount: Boolean,
    @SerialName("pin_prompting") val pinPrompting: Boolean,
    @SerialName("is_deleted") val isDeleted: Boolean,
    @SerialName("in_reg_audit") val isRegAudit: Boolean,
    @SerialName("is_rip_user") val isRipUser: Boolean,
    @SerialName("profession") val profession: UserProfession,
    @SerialName("face_nft") val avatarNft: String,
    @SerialName("face_nft_new") val avatarNftNew: String,
    @SerialName("is_senior_member") val isSeniorMember: Boolean,
    @SerialName("level_exp") val levelExp: LevelInfo,
    @SerialName("coins") val coins: Double,
    @SerialName("following") val following: Int,
    @SerialName("follower") val follower: Int,
)
