package com.msg.push.actor

import akka.actor.ActorLogging
import akka.actor.Actor
import com.msg.push.ws.PushWsServer
import com.msg.push.Configuration

class WebsoketCenter extends Actor with ActorLogging {

    override def preStart(): Unit = {
        val termrs = new PushWsServer(Configuration.newWebsocketUri, Configuration.newWebsocketPort, context.system)
        termrs.run()
    }

    def receive = {
        case msg: String =>
            println("WebsoketCenter=" + msg)
        case _ =>
    }
}