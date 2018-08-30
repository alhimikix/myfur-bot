package xyz.myfur.bots.workers

import org.springframework.stereotype.Component
import java.lang.annotation.Inherited

@Retention
@Target(AnnotationTarget.CLASS)
@Component
@Inherited
annotation class BotWorker(val name:String)