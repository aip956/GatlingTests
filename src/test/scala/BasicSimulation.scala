import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

    val httpProtocol = http
        .baseUrl("http://localhost:8000") // replace with my API baseUrl
        .acceptHeader("application/json")

    val scn = scenario("Basic Test")
        .exec(http(Request_1")
            .get("/endpoint") // replace with my endpoint
            .check(status.is(200)))

    setUp(
        scn.inject(atOnceUsers(10)) // simulates 10 users hitting endpoint at atOnceUsers
    ).protocols(httpProtocol)
}