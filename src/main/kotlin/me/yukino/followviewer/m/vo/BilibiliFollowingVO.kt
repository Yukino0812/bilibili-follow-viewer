package me.yukino.followviewer.m.vo

data class BilibiliFollowingVO(
    val code: Int?,
    val `data`: Data?,
    val message: String?,
    val ttl: Int?
) {
    data class Data(
        val list: List<User?>?,
        val re_version: Int?,
        val total: Int?
    ) {
        data class User(
            val attribute: Int?,
            val contract_info: ContractInfo?,
            val face: String?,
            val mid: Int?,
            val mtime: Int?,
            val official_verify: OfficialVerify?,
            val sign: String?,
            val special: Int?,
            val uname: String?,
            val vip: Vip?
        ) {
            data class ContractInfo(
                val is_contract: Boolean?,
                val is_contractor: Boolean?,
                val ts: Int?,
                val user_attr: Int?
            )

            data class OfficialVerify(
                val desc: String?,
                val type: Int?
            )

            data class Vip(
                val accessStatus: Int?,
                val avatar_subscript: Int?,
                val avatar_subscript_url: String?,
                val dueRemark: String?,
                val label: Label?,
                val nickname_color: String?,
                val themeType: Int?,
                val vipDueDate: Long?,
                val vipStatus: Int?,
                val vipStatusWarn: String?,
                val vipType: Int?
            ) {
                data class Label(
                    val bg_color: String?,
                    val bg_style: Int?,
                    val border_color: String?,
                    val label_theme: String?,
                    val path: String?,
                    val text: String?,
                    val text_color: String?
                )
            }
        }
    }
}