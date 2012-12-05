package controllers

import org.scalatest._
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class ListSpec extends FlatSpec with ShouldMatchers {
    assert(Application.getTitle() === "Your new blank application is ready.")
}