package xyz.myfur.dao.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import xyz.myfur.dao.entities.User
@Repository
interface UserRepository:CrudRepository<User,Long>{
    fun findByTelegramid(telegramid: Long): List<User>
}
@Repository
interface ComicsRepository:CrudRepository<User,Long>

@Repository
interface ArtsRepository:CrudRepository<User,Long>{

}
