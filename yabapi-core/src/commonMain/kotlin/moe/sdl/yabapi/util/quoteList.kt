package moe.sdl.yabapi.util

import kotlin.native.concurrent.SharedImmutable

@SharedImmutable
public val quoteList: List<String> by lazy {
    listOf(
        "叔叔我啊，真的要生气了", "你所热爱的，就是你的生活", "你妈什么时候死啊?", "我没改变B站",
        "LV4会员每年将免费获得3个月的“大会员”", "LV5会员每年将免费获得6个月的“大会员”", "LV6会员每年将免费获得9个月的“大会员",
        "B站未来有可能会倒闭，但绝不会变质", "资本把周宇翔变成了鬼", "汉奸是因利益而产生的，和过去或现在无关", "我没改变B站",
        "2021年准备让b站市值翻几倍?", "诶哟哟，我一般是不看市值，最重要的是用户满意度"
    )
}
