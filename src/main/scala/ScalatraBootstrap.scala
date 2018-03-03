import com.avrisaac55.hackacm._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
    override def init(context: ServletContext) {
        val gameServlet = new GameServlet

        context.mount(gameServlet, "/*")
        context.mount(new LoginServlet(gameServlet), "/game/*")
    }
}