package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import models.Person

object PersonController extends Controller {
  val form = Form(mapping(
    "name" -> text.verifying("名前は必須入力です。", { name => !name.isEmpty() }),
    "age" -> number.verifying("お酒は20歳から99歳まで", { age => age >= 20 && age < 100 }),
    "sex" -> text)(Person.apply)(Person.unapply))

  def index = Action { implicit request =>
    Ok(views.html.person(form))
  }

  def submitEntry = Action { implicit request =>
    form.bindFromRequest.fold(
      errors => BadRequest(views.html.person(errors)),
      person =>
        {
          Person.save(person)
          Ok(views.html.person_confirm(person))
        })
  }

  def add = Action { implicit request =>
    Ok("hoge")
  }

  def confirm = Action {
    Ok("hoge")
  }
}