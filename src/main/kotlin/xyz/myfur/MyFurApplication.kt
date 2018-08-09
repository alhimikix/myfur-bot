package xyz.myfur


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.File
import java.net.URLDecoder


@SpringBootApplication
class MyFurApplication

fun main(args: Array<String>) {

    runApplication<MyFurApplication>(*args)
}

fun getJarFile(clasz:Any):String {
    val url = clasz::class.java.protectionDomain.codeSource.location
    val f = File(url.toURI())
    return URLDecoder.decode(f.parentFile.absolutePath, "UTF-8")
}
