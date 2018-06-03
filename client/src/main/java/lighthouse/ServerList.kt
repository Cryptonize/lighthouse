package lighthouse

import lighthouse.utils.I18nUtil.tr

/**
 * Hard-coded list of project servers so the app can randomly pick between them and load balance the work.
 */
public object ServerList {
    enum class SubmitType { EMAIL, WEB }
    class Entry(val hostName: String, val submitAddress: String, val instructions: String, val submitType: SubmitType)

    val servers = listOf(
            Entry("server.lighthouse.cash", "projects@lighthouse.cash", tr("Submission via email. Project must be legal under EU law."), SubmitType.EMAIL)
    )
    @JvmField val hostnameToServer: Map<String, Entry> = servers.map { Pair(it.hostName, it) }.toMap()

    fun pickRandom(): Entry = servers[(Math.random() * servers.size).toInt()]
}
