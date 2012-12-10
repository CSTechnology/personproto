package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import models.Person
import models.PersonDAO

object PersonController extends Controller {
  val form = Form(mapping(
    "name" -> text.verifying("名前は必須入力です。", { name => !name.isEmpty() }),
    "age" -> number.verifying("お酒は20歳から99歳まで", { age => age >= 20 && age < 100 }),
    "sex" -> text)(Person.apply)(Person.unapply))

  case class Persons(sakujo: String)

  val PersonsForm = Form(mapping("sakujo" -> text)(Persons.apply)(Persons.unapply))
    //val PersonsForm = Form(mapping("nozao" -> text))

  //登録画面初期表示
  def index = Action { implicit request =>
    Ok(views.html.person(form))
  }

  //登録
  def submitEntry = Action { implicit request =>
    form.bindFromRequest.fold(
      errors => BadRequest(views.html.person(errors)),
      person =>
        {
          PersonDAO.create(person)
          Ok(views.html.person_confirm(person))
        })
  }

  //一覧表示
  def list = Action {
    val persons = PersonDAO.all()
    Ok(views.html.person_list(persons))
  }
    
  //削除
  def delete = Action { implicit request =>
    val delnames = PersonsForm.bindFromRequest.data
    delnames.foreach { delname =>
    	PersonDAO.delete(delname._1)
    }
    Redirect(routes.PersonController.list) 
  }
  
  //編集
  def edit(name: String) = Action {
    Ok("編集")
  }
}