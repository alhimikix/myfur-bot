package xyz.myfur.bots

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.telegram.telegrambots.api.objects.Update
import xyz.myfur.bots.Workers.ArtsWorker
import xyz.myfur.bots.Workers.ComicsWorker
import xyz.myfur.bots.Workers.HelloWorker
import xyz.myfur.bots.Workers.StartWorker

@Suppress("UNUSED_EXPRESSION")
@Service
class BotWorker {
    @Autowired
    lateinit var bot: TelegramBot
    @Autowired
    lateinit var startWorker: StartWorker
    @Autowired
    lateinit var comicsWorker: ComicsWorker
    @Autowired
    lateinit var helloWorker: HelloWorker
    @Autowired
    lateinit var artsWorker: ArtsWorker


    fun work(u: Update) {
        if (u.message.text.startsWith("/")) {
            command(u)
        } else message(u)
    }

    fun command(x: Update) {
        val msg = x.message?.text?.removePrefix("/").orEmpty()
        when {
            isPattern("start",msg) -> startWorker.run(x)
            isPattern("hello",msg) -> helloWorker.run(x)
            isPattern("comics",msg) -> comicsWorker.run(x)
        }
    }

    fun message(x: Update) {
        val msg = x.message?.text.orEmpty().toLowerCase().trim()
        when {
            isPattern("hello",msg) -> helloWorker.run(x)
            isPattern("хочу комикс",msg) -> comicsWorker.run(x)
            else -> {

            }
        }
        isPattern("ня",msg).apply {
            if (this) {
                bot.sendMsg(x.message.chatId, "Ня, " + x.message.from.userName)
            }
        }

    }

    fun isPattern(pattern: String,msg:String,option: RegexOption = RegexOption.IGNORE_CASE): Boolean {
        return Regex(pattern,option).containsMatchIn(msg)
    }
}