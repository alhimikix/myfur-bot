package xyz.myfur.bots.workers.impl


import org.telegram.telegrambots.api.objects.Update
import xyz.myfur.bots.workers.BotWorker
import xyz.myfur.bots.workers.abs.AbsWorker

@BotWorker("Музофон")
class MusicWorker : AbsWorker(){
    override fun getPatterns(): Array<Regex> {
        return arrayOf(Regex("хочу (музыку|песенку)",RegexOption.IGNORE_CASE))
    }

    override fun run(x: Update) {
        bot.sendMsg(x.message.chatId,"${x.message.from.userName} пока нету(")
    }
}