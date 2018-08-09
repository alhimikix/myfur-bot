package xyz.myfur.configs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.TelegramBotsApi

@Configuration
class MainConfig {
    @Bean
    fun botApiTelegram(): TelegramBotsApi {
        ApiContextInitializer.init()
        return TelegramBotsApi()
    }
}