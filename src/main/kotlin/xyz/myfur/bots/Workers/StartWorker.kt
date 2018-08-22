package xyz.myfur.bots.Workers


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.telegram.telegrambots.api.objects.Update
import xyz.myfur.bots.TelegramBot
import xyz.myfur.dao.entities.User
import xyz.myfur.dao.repositories.ArtsRepository
import xyz.myfur.dao.repositories.ComicsRepository
import xyz.myfur.dao.repositories.UserRepository

@Service
class StartWorker{
    @Autowired
    lateinit var bot: TelegramBot
    @Autowired
    lateinit var users: UserRepository
    @Autowired
    lateinit var arts: ArtsRepository
    @Autowired
    lateinit var comics: ComicsRepository

    fun run(x: Update) {
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