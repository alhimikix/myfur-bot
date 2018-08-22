package xyz.myfur.bots.Workers


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.telegram.telegrambots.api.objects.Update
import xyz.myfur.bots.TelegramBot
import xyz.myfur.dao.repositories.ArtsRepository
import xyz.myfur.dao.repositories.ComicsRepository
import xyz.myfur.dao.repositories.UserRepository

@Service
class ComicsWorker {
    @Autowired
    lateinit var bot: TelegramBot
    @Autowired
    lateinit var users: UserRepository
    @Autowired
    lateinit var arts: ArtsRepository
    @Autowired
    lateinit var comics: ComicsRepository

    fun run(x: Update) {

    }
}