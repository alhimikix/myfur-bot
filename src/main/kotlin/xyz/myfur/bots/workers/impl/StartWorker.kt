package xyz.myfur.bots.workers.impl


import org.telegram.telegrambots.api.objects.Update
import xyz.myfur.bots.workers.BotWorker
import xyz.myfur.bots.workers.abs.AbsWorker
import xyz.myfur.dao.entities.User

@BotWorker("Главный помошник")
class StartWorker: AbsWorker(){
    override fun getPatterns(): Array<Regex> {
        return arrayOf(Regex("(начнем работу|/start)"))
    }


    override fun run(x: Update) {
        var u = users.findByTelegramid(x.message.from.id.toLong())
        val us = x.message.from
        if (u.isEmpty()) {
            var user = User(0,us.firstName,us.id.toLong(),us.userName,"",null)
            println(u.toString())
            users.save(user)
            bot.sendMsg(x.message.chatId, "Привет, ${x.message.from.userName} ты тут впервые))")
            bot.sendMsg(x.message.chatId, "Ты теперь зарегистрирован")
        }else
        {
            bot.sendMsg(x.message.chatId, "Привет, ${x.message.from.userName}")
        }
    }
}