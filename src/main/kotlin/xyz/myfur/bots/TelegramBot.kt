package xyz.myfur.bots

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.telegram.telegrambots.TelegramBotsApi
import org.telegram.telegrambots.api.objects.Update
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import javax.annotation.PostConstruct

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
        comixpath = "./comics/"
        artpath   = "./arts/"

    }

    var param: String = "661747027:AAEQc3QpwmNPAaJJ78HpiY2Eh37sQejOIaA"


    override fun getBotToken(): String {
        return param;
    }

    override fun getBotUsername(): String {
        return "NePidor"
    }

    override fun onUpdateReceived(p0: Update) {
        botWorker.work(p0)
    }

}