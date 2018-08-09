package xyz.myfur.bots

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.telegram.telegrambots.TelegramBotsApi
import org.telegram.telegrambots.api.methods.send.SendMessage
import org.telegram.telegrambots.api.objects.Update
import kotlin.concurrent.thread

@Service
class BotWorker(){
    @Autowired
    lateinit var bot: TelegramBot
    fun work(u: Update){
         thread {
             var message = u.message
             when(message.text.split(" ")[0]){
                 "/download"->{

                 }
                 "/lol"->{
                     bot.execute(SendMessage(message.chatId,"Lol").enableMarkdown(true).enableHtml(false))
                 }
             }
         }
    }
}