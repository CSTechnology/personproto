package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index(getTitle()))
  }
  
  def getTitle() = "Your new blank application is ready."
}