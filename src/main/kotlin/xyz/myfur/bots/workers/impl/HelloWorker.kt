package xyz.myfur.bots.workers.impl



import org.telegram.telegrambots.api.objects.Update
import xyz.myfur.bots.workers.BotWorker
import xyz.myfur.bots.workers.abs.AbsWorker


@BotWorker("Комиксовед")
class HelloWorker : AbsWorker(){
    override fun getPatterns(): Array<Regex> {
        return arrayOf(Regex("(привет|hello)",RegexOption.IGNORE_CASE))
    }

    override fun run(x: Update) {
        bot.sendMsg(x.message.chatId,"Привет ${x.message.from.firstName}")
    }
}