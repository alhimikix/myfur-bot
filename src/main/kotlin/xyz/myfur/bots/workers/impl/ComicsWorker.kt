package xyz.myfur.bots.workers.impl


import org.springframework.beans.factory.annotation.Value
import org.telegram.telegrambots.api.objects.Update
import xyz.myfur.bots.workers.BotWorker
import xyz.myfur.bots.workers.abs.AbsWorker

@BotWorker("Комиксовед")
class ComicsWorker: AbsWorker() {
    override fun getPatterns(): Array<Regex> {
        return arrayOf(Regex("хочу комикс",RegexOption.IGNORE_CASE))
    }

    @Value(value = "\${name}")
    lateinit var name:String

    override fun run(x: Update) {
        bot.sendMsg(x.message.chatId,"${x.message.from.userName} незя")
    }
}