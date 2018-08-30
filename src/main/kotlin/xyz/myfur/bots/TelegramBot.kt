package xyz.myfur.bots

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.telegram.telegrambots.TelegramBotsApi
import org.telegram.telegrambots.api.methods.send.SendMessage
import org.telegram.telegrambots.api.objects.Update
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import xyz.myfur.bots.workers.BotWorker
import xyz.myfur.bots.workers.abs.AbsWorker
import javax.annotation.PostConstruct
import kotlin.concurrent.thread

@Service
class TelegramBot(@Autowired
                  val botApi: TelegramBotsApi
                 /* @Autowired
                  val botWorker: BotWorker*/) : TelegramLongPollingBot() {
    companion object {
        lateinit var comixpath:String
        lateinit var artpath:String
    }
    @PostConstruct
    fun post() {
        loadconfig()
        botApi.registerBot(this)
    }

    private val listeners = HashSet<AbsWorker>()

    fun addWorker(listener: AbsWorker): Boolean {
        if (!listeners.contains(listener)&&listener::class.java.isAnnotationPresent(BotWorker::class.java))
            println("${listener::class.java.getAnnotation(xyz.myfur.bots.workers.BotWorker::class.java).name} подключен к работникам")
            listeners.add(listener)
        return true
    }

    private fun loadconfig() {
        comixpath = Config.comicsPath.toString()
        artpath   = Config.comicsPath.toString()

    }

    var param: String = Config.botToken


    override fun getBotToken(): String {
        return param
    }

    override fun getBotUsername(): String {
        return ""
    }

    override fun onUpdateReceived(message: Update) {
        thread {
            listeners.forEach { worker ->
                val patterns = worker.getPatterns()
                patterns.forEach {
                    if (it.matches(message.message.text)){
                        worker.run(message)
                        return@forEach
                    }
                }
            }
        }
    }


    fun sendApiM(x: SendMessage) {
        sendApiMethod(x)
    }

    fun sendMsg(id: String, message: String) {
        val msg = SendMessage(id, message).apply { enableMarkdown(true) }
        sendApiMethod(msg)
    }

    fun sendMsg(id: Long, message: String) {
        val msg = SendMessage(id, message).apply { enableMarkdown(true) }
        sendApiMethod(msg)
    }

}