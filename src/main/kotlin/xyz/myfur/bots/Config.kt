package xyz.myfur.bots

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

object Config {

    var helloMsg:String
    var comicsPath:Path
    var botToken:String
    var artPath:Path

    init {
        File(System.getProperty("user.dir")+"/start.text").apply {
            if(!exists()){
                createNewFile()
                FileOutputStream(this).write(Config::class.java.classLoader.getResourceAsStream("start.text").readBytes())
            }
        }
        File(System.getProperty("user.dir")+"/config.properties").apply {
            if(!exists()){
                createNewFile()
                FileOutputStream(this).write(Config::class.java.classLoader.getResourceAsStream("config.properties").readBytes())
            }
        }

        helloMsg = FileInputStream(System.getProperty("user.dir")+"/start.text").bufferedReader().readText()
        var config =Properties()
        config.load(FileInputStream(System.getProperty("user.dir")+"/config.properties"))
        botToken = config.getProperty("botToken")
        comicsPath = Paths.get(config.getProperty("comicsPath"))
        artPath =    Paths.get(config.getProperty("artPath"))
    }


}