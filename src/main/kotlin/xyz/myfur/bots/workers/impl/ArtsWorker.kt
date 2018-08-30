package xyz.myfur.bots.workers.impl


import org.telegram.telegrambots.api.objects.Update
import xyz.myfur.bots.workers.BotWorker
import xyz.myfur.bots.workers.abs.AbsWorker

@BotWorker("Рисунковед")
class ArtsWorker: AbsWorker() {
    override fun getPatterns(): Array<Regex> {
        return arrayOf(Regex("хочу арт",RegexOption.IGNORE_CASE))
    }

    override fun run(x: Update) {
        bot.sendMsg(x.message.chatId,"${x.message.from.userName} незя")
    }
}