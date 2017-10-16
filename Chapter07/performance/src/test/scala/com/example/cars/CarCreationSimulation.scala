package com.example.cars

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._

class CarCreationSimulation extends Simulation {

  val httpConf: HttpProtocolBuilder = http
    .baseURL("http://test.car-manufacture.example.com/car-manufacture/resources")
    .acceptHeader("*/*")

  val scn: ScenarioBuilder = scenario("create_car")
    .exec(http("request_1")
      .get("/cars"))
    .exec(http("request_1")
      .post("/cars")
      .body(StringBody("""{"id": "X123A234", "color": "RED", "engine": "DIESEL"}""")).asJSON
      .check(header("Location").saveAs("locationHeader")))
    .exec(http("request_1")
      .get("${locationHeader}"))

  pause(1 second)

  setUp(
    scn.inject(rampUsersPerSec(10).to(20).during(10 seconds))
  ).protocols(httpConf)
    .constantPauses

}
