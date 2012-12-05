package controllers

import org.specs._

import controllers._
object SpecsUnitTest extends Specification {
  "'hello world' has 11 characters" in {
     "hello world".size must_== 11
  }
  "'hello world' matches 'h.* w.*'" in {
     "hello world" must be matching("h.* w.*")
  }
  
  "Index Page Title matches 'Your new application is ready." in {
    Application.getTitle must be matching("Y.* blank.*r.*")
  }
}