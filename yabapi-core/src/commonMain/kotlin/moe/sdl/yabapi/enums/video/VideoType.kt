package moe.sdl.yabapi.enums.video

import kotlinx.serialization.Serializable
import moe.sdl.yabapi.consts.internal.WWW
import moe.sdl.yabapi.serializer.data.VideoTypeSerializer
import moe.sdl.yabapi.util.Logger
import kotlin.native.concurrent.SharedImmutable

@SharedImmutable
private val logger by lazy { Logger("VideoType") }

@Serializable(VideoTypeSerializer::class)
public sealed class VideoType(
    public val name: String,
    public val code: String,
    public val tid: Int,
    public val route: String,
    public val parent: VideoType? = null,
) {
    public fun getUrl(): String = "$WWW$route"

    override fun toString(): String  = "$tid($name)"

    public companion object {
        // Long list, register video type, can replace with Annotation Processor, but KSP in experimental.
        public fun getAllTypes(): List<VideoType> = listOf(
            All, Unknown,
            Douga, Douga.MAD, Douga.MMD, Douga.Voice, Douga.Other, Douga.GarageKit, Douga.Tokusatsu,
            Anime, Anime.Serial, Anime.Finish, Anime.Information, Anime.Official,
            Guochuang, Guochuang.Donghua, Guochuang.Original, Guochuang.Puppetry, Guochuang.MotionComic, Guochuang.MotionComic, Guochuang.Information,
            Music, Music.Original, Music.Cover, Music.Vocaloid, Music.Electronic, Music.Perform, Music.MV, Music.Live, Music.Other,
            Dance, Dance.Otaku, Dance.Hiphop, Dance.Star, Dance.China, Dance.ThreeD, Dance.Demo,
            Game, Game.Standalone, Game.ESports, Game.Mobile, Game.Online, Game.Board, Game.GMV, Game.Music, Game.Mugen,
            Knowledge, Knowledge.Science, Knowledge.SocialScience, Knowledge.HumanityHistory, Knowledge.Business, Knowledge.Campus, Knowledge.Career, Knowledge.Design, Knowledge.Skill,
            Tech, Tech.Digital, Tech.Application, Tech.ComputerTech, Tech.Industry, Tech.DIY,
            Car, Car.Life, Car.Culture, Car.Geek, Car.Smart, Car.Strategy,
            Sports, Sports.Ball, Sports.Aerobics, Sports.Atheletic, Sports.Culture, Sports.Comprehensive,
            Life, Life.Funny, Life.Home, Life.HandMake, Life.Painting, Life.Daily,
            Food, Food.Make, Food.Measurement, Food.Rural, Food.Record,
            Animal, Animal.Cat, Animal.Dog, Animal.Panda, Animal.Wild, Animal.Reptiles, Animal.Composite,
            Kichiku, Kichiku.Guide, Kichiku.MAD, Kichiku.ManualVocaloid, Kichiku.Theatre, Kichiku.Course,
            Fashion, Fashion.Makeup, Fashion.Clothing, Fashion.Catwalk, Fashion.Trends,
            Information, Information.Hotspot, Information.Global, Information.Social, Information.Multiple,
            Entertainment, Entertainment.Variety, Entertainment.Star,
            Cinephile, Cinephile.Cinecism, Cinephile.Montage, Cinephile.ShortFilm, Cinephile.TrailerInfo,
            Documentary, Documentary.History, Documentary.Science, Documentary.Military, Documentary.Travel,
            Movie, Movie.Chinese, Movie.West, Movie.Japan, Movie.Other,
            TV, TV.Mainland, TV.Overseas,
        )

        public fun getAllUrl(): List<String> = getAllTypes().map { it.getUrl() }
        public fun fromTid(tid: Int): VideoType = getAllTypes().firstOrNull { it.tid == tid } ?: run {
            logger.debug { "Unexpected VideoType Id: $tid, fallback to Unknown" }
            Unknown
        }

        public fun fromCode(string: String): VideoType =
            getAllTypes().firstOrNull { it.code == string.lowercase() } ?: Unknown
    }
}

public object All : VideoType("全部", "all", 0, "")

public object Unknown : VideoType("未知", "unknown", -1, "")

public object Douga : VideoType("动画", "douga", 1, "/v/douga") {
    public object MAD : VideoType("MAD·AMV", "mad", 24, "/v/douga/mad", Douga)
    public object MMD : VideoType("MMD·3D", "mmd", 25, "/v/douga/mmd", Douga)
    public object Other : VideoType("综合", "other", 27, "/v/douga/other", Douga)
    public object Voice : VideoType("短片·手书·配音", "voice", 47, "/v/douga/voice", Douga)
    public object GarageKit : VideoType("手办·模玩", "garage_kit", 210, "/v/douga/garage_kit", Douga)
    public object Tokusatsu : VideoType("特摄", "tokusatsu", 86, "/v/douga/other", Douga)
}

public object Anime : VideoType("番剧", "anime", 13, "/anime") {
    public object Serial : VideoType("连载动画", "serial", 33, "/v/anime/serial", Anime)
    public object Finish : VideoType("完结动画", "finish", 32, "/v/anime/finish", Anime)
    public object Information : VideoType("资讯", "information", 51, "/v/anime/information", Anime)
    public object Official : VideoType("官方延伸", "official", 152, "/v/anime/official", Anime)
}

public object Guochuang : VideoType("国创", "guochuang", 167, "/guochuang") {
    public object Donghua : VideoType("国产动画", "chinese", 153, "/v/guochuang/chinese", Guochuang)
    public object Original : VideoType("国产原创相关", "original", 168, "/v/guochuang/original", Guochuang)
    public object Puppetry : VideoType("布袋戏", "puppetry", 169, "/v/guochuang/puppetry", Guochuang)
    public object MotionComic : VideoType("布袋戏", "motioncomic", 195, "/v/guochuang/motioncomic", Guochuang)
    public object Information : VideoType("资讯", "information", 170, "/v/guochuang/information", Guochuang)
}

public object Music : VideoType("音乐", "music", 3, "/v/music") {
    public object Original : VideoType("原创音乐", "original", 28, "/v/music/original", Music)
    public object Cover : VideoType("翻唱", "cover", 31, "/v/music/cover", Music)
    public object Vocaloid : VideoType("VOCALOID·UTAU", "vocaloid", 30, "/v/music/vocaloid", Music)
    public object Electronic : VideoType("电音", "electronic", 194, "/v/music/electronic", Music)
    public object Perform : VideoType("演奏", "perform", 59, "/v/music/perform", Music)
    public object MV : VideoType("MV", "mv", 193, "/v/music/mv", Music)
    public object Live : VideoType("音乐现场", "live", 29, "/v/music/live", Music)
    public object Other : VideoType("音乐综合", "other", 130, "/v/music/other", Music)
}

public object Dance : VideoType("舞蹈	", "dance", 129, "/v/dance") {
    public object Otaku : VideoType("宅舞", "otaku", 20, "/v/dance/otaku", Dance)
    public object Hiphop : VideoType("街舞", "hiphop", 198, "/v/dance/hiphop", Dance)
    public object Star : VideoType("明星舞蹈", "star", 199, "/v/dance/star", Dance)
    public object China : VideoType("中国舞", "china", 200, "/v/dance/china", Dance)
    public object ThreeD : VideoType("舞蹈综合", "three_d", 154, "/v/dance/three_d", Dance)
    public object Demo : VideoType("舞蹈教程", "demo", 156, "/v/dance/demo", Dance)
}

public object Game : VideoType("游戏", "game", 4, "/v/game") {
    public object Standalone : VideoType("单机游戏", "stand_alone", 17, "/v/game/stand_alone", Game)
    public object ESports : VideoType("电子竞技", "esports", 171, "/v/game/esports", Game)
    public object Mobile : VideoType("手机游戏", "mobile", 172, "/v/game/mobile", Game)
    public object Online : VideoType("网络游戏", "online", 65, "/v/game/online", Game)
    public object Board : VideoType("桌游棋牌", "board", 173, "/v/game/board", Game)
    public object GMV : VideoType("GMV", "gmv", 121, "/v/game/gmv", Game)
    public object Music : VideoType("音游", "music", 136, "/v/game/music", Game)
    public object Mugen : VideoType("Mugen", "mugen", 19, "/v/game/mugen", Game)
}

public object Knowledge : VideoType("知识", "knowledge", 36, "/v/knowledge") {
    public object Science : VideoType("科学科普", "science", 201, "/v/knowledge/science", Knowledge)
    public object SocialScience : VideoType("社科·法律·心理", "social_science", 124, "/v/knowledge/social_science", Knowledge)
    public object HumanityHistory : VideoType("人文历史", "humanity_history", 228, "/v/knowledge/humanity_history", Knowledge)
    public object Business : VideoType("财经商业", "business", 207, "/v/knowledge/finance", Knowledge)
    public object Campus : VideoType("校园学习", "campus", 208, "/v/knowledge/campus", Knowledge)
    public object Career : VideoType("职业职场", "career", 209, "/v/knowledge/career", Knowledge)
    public object Design : VideoType("设计·创意", "design", 229, "/v/knowledge/design", Knowledge)
    public object Skill : VideoType("野生技术协会", "skill", 122, "/v/knowledge/skill", Knowledge)
}

public object Tech : VideoType("科技", "tech", 188, "/v/tech") {
    public object Digital : VideoType("数码", "digital", 95, "/v/tech/digital", Tech)
    public object Application : VideoType("软件应用", "application", 230, "/v/tech/application", Tech)
    public object ComputerTech : VideoType("计算机技术", "computer_tech", 231, "/v/tech/computer_tech", Tech)
    public object Industry : VideoType("工业·工程·机械", "industry", 232, "/v/tech/industry", Tech)
    public object DIY : VideoType("极客DIY", "diy", 233, "/v/tech/diy", Tech)
}

public object Sports : VideoType("运动", "sports", 234, "/v/sports") {
    public object Ball : VideoType("篮球·足球", "basketballfootball", 235, "/v/sports/basketballfootball", Sports)
    public object Aerobics : VideoType("健身", "aerobics", 164, "/v/sports/aerobics", Sports)
    public object Atheletic : VideoType("竞技体育", "athletic", 236, "/v/sports/culture", Sports)
    public object Culture : VideoType("运动文化", "culture", 237, "/v/sports/culture", Sports)
    public object Comprehensive : VideoType("运动综合", "comprehensive", 238, "/v/sports/comprehensive", Sports)
}

public object Car : VideoType("汽车", "car", 223, "/v/car") {
    public object Life : VideoType("汽车生活", "life", 176, "/v/car/life", Car)
    public object Culture : VideoType("汽车文化", "culture", 224, "/v/car/culture", Car)
    public object Geek : VideoType("汽车极客", "geek", 225, "/v/car/geek", Car)
    public object Smart : VideoType("智能出行", "smart", 226, "/v/car/smart", Car)
    public object Strategy : VideoType("购车攻略", "strategy", 227, "/v/car/strategy", Car)
}

public object Life : VideoType("生活", "life", 160, "/v/life") {
    public object Funny : VideoType("搞笑", "funny", 138, "/v/life/funny", Life)
    public object Home : VideoType("家居房产", "home", 239, "/v/life/home", Life)
    public object HandMake : VideoType("手工", "handmake", 161, "/v/life/handmake", Life)
    public object Painting : VideoType("绘画", "painting", 162, "/v/life/painting", Life)
    public object Daily : VideoType("日常", "daily", 21, "/v/life/daily", Life)
}

public object Food : VideoType("美食", "food", 211, "/v/food") {
    public object Make : VideoType("美食制作", "make", 76, "/v/food/make", Food)
    public object Detective : VideoType("美食侦探", "detective", 212, "/v/food/detective", Food)
    public object Measurement : VideoType("美食测评", "measurement", 213, "/v/food/measurement", Food)
    public object Rural : VideoType("田园美食", "rural", 214, "/v/food/rural", Food)
    public object Record : VideoType("美食记录", "record", 215, "/v/food/record", Food)
}

public object Animal : VideoType("动物圈", "animal", 217, "/v/animal") {
    public object Cat : VideoType("喵星人", "cat", 218, "/v/animal/cat", Animal)
    public object Dog : VideoType("汪星人", "dog", 219, "/v/animal/dog", Animal)
    public object Panda : VideoType("大熊猫", "panda", 220, "/v/animal/panda", Animal)
    public object Wild : VideoType("野生动物", "wild_animal", 221, "/v/animal/wild_animal", Animal)
    public object Reptiles : VideoType("爬宠", "reptiles", 222, "/v/animal/reptiles", Animal)
    public object Composite : VideoType("动物综合", "animal_composite", 75, "/v/animal/animal_composite", Animal)
}

public object Kichiku : VideoType("鬼畜", "kichiku", 119, "/v/kichiku") {
    public object Guide : VideoType("鬼畜调教", "guide", 22, "/v/kichiku/guide", Kichiku)
    public object MAD : VideoType("音MAD", "mad", 26, "/v/kichiku/mad/v/kichiku/mad", Kichiku)
    public object ManualVocaloid : VideoType("人力VOCALOID", "manual_vocaloid", 126, "/v/kichiku/manual_vocaloid", Kichiku)
    public object Theatre : VideoType("鬼畜剧场", "theatre", 216, "/v/kichiku/theatre", Kichiku)
    public object Course : VideoType("教程演示", "course", 127, "/v/kichiku/course", Kichiku)
}

public object Fashion : VideoType("时尚", "Fashion", 155, "/v/fashion") {
    public object Makeup : VideoType("美妆", "makeup", 157, "/v/fashion/makeup", Fashion)
    public object Clothing : VideoType("服饰", "clothing", 158, "/v/fashion/clothing", Fashion)
    public object Catwalk : VideoType("T台", "catwalk", 159, "/v/fashion/catwalk", Fashion)
    public object Trends : VideoType("风尚标", "trends", 192, "/v/fashion/trends", Fashion)
}

public object Information : VideoType("资讯", "information", 202, "/v/information") {
    public object Hotspot : VideoType("热点", "hotspot", 203, "/v/information/hotspot", Information)
    public object Global : VideoType("环球", "global", 204, "/v/information/global", Information)
    public object Social : VideoType("社会", "social", 205, "/v/information/social", Information)
    public object Multiple : VideoType("综合", "multiple", 206, "/v/information/multiple", Information)
}

public object Entertainment : VideoType("娱乐", "ent", 5, "/v/ent") {
    public object Variety : VideoType("综艺", "variety", 71, "/v/ent/variety", Entertainment)
    public object Star : VideoType("明星", "star", 137, "/v/ent/star", Entertainment)
}

public object Cinephile : VideoType("影视", "cinephile", 181, "/v/cinphile") {
    public object Cinecism : VideoType("影视杂谈", "cinecism", 182, "/v/cinephile/cinecism", Cinephile)
    public object Montage : VideoType("影视剪辑", "montage", 183, "/v/cinephile/montage", Cinephile)
    public object ShortFilm : VideoType("短片", "shortfilm", 85, "/v/cinephile/shortfilm", Cinephile)
    public object TrailerInfo : VideoType("预告·资讯", "trailer_info", 184, "/v/cinephile/trailer_info", Cinephile)
}

public object Documentary : VideoType("纪录片", "documentary", 177, "/documentary") {
    public object History : VideoType("人文·历史", "history", 37, "/v/documentary/history", Documentary)
    public object Science : VideoType("科学·探索·自然", "science", 178, "/v/documentary/science", Documentary)
    public object Military : VideoType("军事", "military", 179, "/v/documentary/military", Documentary)
    public object Travel : VideoType("社会·美食·旅行", "travel", 180, "/v/documentary/travel", Documentary)
}

public object Movie : VideoType("电影", "movie", 23, "/movie") {
    public object Chinese : VideoType("华语电影", "chinese", 147, "/v/movie/chinese", Movie)
    public object West : VideoType("欧美电影", "west", 145, "/v/movie/west", Movie)
    public object Japan : VideoType("日本电影", "japan", 146, "/v/movie/japan", Movie)
    public object Other : VideoType("其他国家", "movie", 83, "/v/movie/movie", Movie)
}

public object TV : VideoType("电视剧", "tv", 11, "/tv") {
    public object Mainland : VideoType("国产剧", "mainland", 185, "/v/tv/mainland", TV)
    public object Overseas : VideoType("海外剧", "overseas", 187, "/v/tv/overseas", TV)
}
