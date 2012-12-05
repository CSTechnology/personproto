package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._

object Person  extends Controller  {
  case class User(name:String,age:Int,sex:String)
  
    val form = Form(mapping(
    "name" -> text.verifying("名前は必須入力です。", { name => !name.isEmpty()  }),
    "age" -> number.verifying("お酒は20歳から99歳まで", { age => age >= 20 && age < 100 }),
    "sex" -> text)(User.apply)(User.unapply))
	    
	  def index = Action { implicit request =>
      	Ok(views.html.person(form))
	  }

	  def submitEntry = Action { implicit request =>
	  form.bindFromRequest.fold(
			errors => BadRequest(views.html.person(errors)),
	        User => Ok(views.html.person_confirm(User)))
	    }
	  
	  def add = TODO 
	  
	  def confirm  = Action{
	    Ok("hoge")
	  }

}