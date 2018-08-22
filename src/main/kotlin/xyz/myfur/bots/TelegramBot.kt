package xyz.myfur.bots

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.telegram.telegrambots.TelegramBotsApi
import org.telegram.telegrambots.api.methods.send.SendMessage
import org.telegram.telegrambots.api.objects.Update
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import javax.annotation.PostConstruct
import kotlin.concurrent.thread

@Service
class TelegramBot(@Autowired
                  val botApi: TelegramBotsApi,
                  @Autowired
                  val botWorker: BotWorker) : TelegramLongPollingBot() {
    companion object {
        lateinit var comixpath:String
        lateinit var artpath:String

    }
    @PostConstruct
    fun post() {
        loadconfig()
        botApi.registerBot(this)
    }

    private fun loadconfig() {
        comixpath = Config.comicsPath.toString()
        artpath   = Config.comicsPath.toString()

    }

    var param: String = Config.botToken


    override fun getBotToken(): String {
        return param;
    }

    override fun getBotUsername(): String {
        return "NePidor"
    }

    override fun onUpdateReceived(message: Update) {
        thread {
            botWorker.work(message)
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