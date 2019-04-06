package com.binaryheap.testing.simulations

import io.gatling.core.Predef._ // 2
import io.gatling.http.Predef._
import scala.concurrent.duration._



class BagControllerSimulation extends Simulation {
  val httpProtocol = http // 4
    .baseUrl("http://localhost:8080") // 5
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // 6
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("BasicSimulation") // 7
    .exec(http("request_1") // 8
    .get("/bags")) // 9
    .pause(5) // 10

  setUp(
    scn.inject(
      constantUsersPerSec(200) during (60 seconds) randomized, // 5
  ).protocols(httpProtocol))


}