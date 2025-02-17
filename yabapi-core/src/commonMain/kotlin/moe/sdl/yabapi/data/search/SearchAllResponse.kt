@file:UseSerializers(BooleanJsSerializer::class)

package moe.sdl.yabapi.data.search

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import moe.sdl.yabapi.data.GeneralCode
import moe.sdl.yabapi.data.GeneralCode.UNKNOWN
import moe.sdl.yabapi.data.search.results.SearchResult
import moe.sdl.yabapi.serializer.BooleanJsSerializer

@Serializable
public data class SearchAllResponse(
    @SerialName("code") val code: GeneralCode = UNKNOWN,
    @SerialName("message") val message: String? = null,
    @SerialName("ttl") val ttl: Int? = null,
    @SerialName("data") val data: SearchAllData? = null,
)

@Serializable
public data class SearchAllData(
    @SerialName("seid") override val seid: String,
    @SerialName("page") override val page: Int,
    @SerialName("pagesize") override val pageSize: Int,
    @SerialName("numResults") override val numResults: Int,
    @SerialName("numPages") override val numPages: Int,
    @SerialName("suggest_keyword") override val suggestKeyword: String,
    @SerialName("rqt_type") override val rqtType: String,
    @SerialName("cost_time") override val costTime: Map<String, String>,
    @SerialName("exp_list") override val expList: Map<String, String>,
    @SerialName("egg_hit") override val eggHit: Boolean,
    @SerialName("pageinfo") override val pageInfo: Map<String, SearchNumInfo>,
    @SerialName("top_tlist") val typeList: Map<String, Int>,
    @SerialName("show_column") override val showColumn: Int,
    @SerialName("show_module_list") val moduleList: List<String>,
    @SerialName("result") override val result: SearchAllResultData,
) : SearchData() {
    public val resultFlatted: List<SearchResult> by lazy {
        result.value.flatMap { it.data.orEmpty() }
    }
}

@Serializable
public data class SearchNumInfo(
    @SerialName("numPages") val numPages: Int? = null,
    @SerialName("numResults") val numResults: Int,
    @SerialName("total") val total: Int,
    @SerialName("pages") val pages: Int,
)
