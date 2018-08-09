package xyz.myfur


import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
class MyFurApplicationTests(

){

    val logger = LoggerFactory.getLogger(this::class.java)

    @Before
    fun beforeTests(): Unit {
        println("start test")
    }

    @Test
    fun contextLoads() {
        //throw Exception("Bad")

    }
    @After
    fun after(): Unit {
        println("All work")
    }
}
