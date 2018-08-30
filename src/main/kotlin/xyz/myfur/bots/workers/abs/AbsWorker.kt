package xyz.myfur.bots.workers.abs

import org.springframework.beans.factory.annotation.Autowired
import org.telegram.telegrambots.api.objects.Update
import xyz.myfur.bots.TelegramBot
import xyz.myfur.dao.repositories.ArtsRepository
import xyz.myfur.dao.repositories.ComicsRepository
import xyz.myfur.dao.repositories.UserRepository
import javax.annotation.PostConstruct

abstract class AbsWorker{
    @Autowired
    lateinit var bot: TelegramBot
    @Autowired
    lateinit var users: UserRepository
    @Autowired
    lateinit var arts: ArtsRepository
    @Autowired
    lateinit var comics: ComicsRepository

    @PostConstruct
    fun postCreate(){
        bot.addWorker(this)
    }
    abstract fun run(message:Update)
    abstract fun getPatterns(): Array<Regex>
}