import org.scalatra._
import javax.servlet.ServletContext

import com.avrisaac555.hackacm.{GameServlet, LoginServlet}

class ScalatraBootstrap extends LifeCycle {
    override def init(context: ServletContext) {
        val gameServlet = new GameServlet

        context.mount(gameServlet, "/game/*")
        context.mount(new LoginServlet(gameServlet), "/*")
    }
}