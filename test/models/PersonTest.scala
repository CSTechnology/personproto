package models

import org.specs._
import controllers._
import org.joda.convert.ToString
object PersonTest extends Specification {
  val perso1 = models.Person("testuser1", 10, "男")
  val perso2 = models.Person("testuser2", 20, "女")
  val perso3 = models.Person("testuser3", 30, "男")
  val perso4 = models.Person("testuser4", 40, "女")
  val perso5 = models.Person("testuser5", 50, "男")

  "PersonModelを登録する" in {
    PersonDAO.create(perso1)
    PersonDAO.create(perso2)
    PersonDAO.create(perso3)
    PersonDAO.create(perso4)
    PersonDAO.create(perso5)

    //登録件数確認
    PersonDAO.all().count(name => true) must be(5)
  }
  "PersonModel内容確認" in {
    val persons = PersonDAO.all()
    persons.foreach(person =>
      person.name match {
        case perso1.name =>
          person.age must be(perso1.age)
          person.sex.toString() must be matching (perso1.sex)
        case perso2.name =>
          person.age must be(perso2.age)
          person.sex.toString() must be matching (perso2.sex)
        case perso3.name =>
          person.age must be(perso3.age)
          person.sex.toString() must be matching (perso3.sex)
        case perso4.name =>
          person.age must be(perso4.age)
          person.sex.toString() must be matching (perso4.sex)
        case perso5.name =>
          person.age must be(perso5.age)
          person.sex.toString() must be matching (perso5.sex)
        case _ =>
          "error" must be("ユーザが存在しない")
      })
  }
  
  "PersonModelを一件取得" in {
    val personlist = PersonDAO.select(perso1.name)
    personlist(0).age must be(perso1.age)
    personlist(0).sex.toString() must be matching (perso1.sex)
  }

  "PersonModelを編集" in {
    val perso6 = models.Person(perso1.name, 60, "女")
    PersonDAO.updating(perso6, perso1.name)

    val persons = PersonDAO.all()
    persons.foreach(person =>
      person.name match {
        case perso1.name =>
          person.age must be(perso6.age)
          person.sex.toString() must be matching (perso6.sex)
        case perso2.name =>
          person.age must be(perso2.age)
          person.sex.toString() must be matching (perso2.sex)
        case perso3.name =>
          person.age must be(perso3.age)
          person.sex.toString() must be matching (perso3.sex)
        case perso4.name =>
          person.age must be(perso4.age)
          person.sex.toString() must be matching (perso4.sex)
        case perso5.name =>
          person.age must be(perso5.age)
          person.sex.toString() must be matching (perso5.sex)
        case _ =>
          "error" must be("ユーザが存在しない")
      })
  }

  "PersonModelを削除" in {
    PersonDAO.delete(perso1.name)
    PersonDAO.all().count(name => true) must be(4)
    PersonDAO.delete(perso2.name)
    PersonDAO.all().count(name => true) must be(3)
    PersonDAO.delete(perso3.name)
    PersonDAO.all().count(name => true) must be(2)
    PersonDAO.delete(perso4.name)
    PersonDAO.all().count(name => true) must be(1)
    PersonDAO.delete(perso5.name)
    PersonDAO.all().count(name => true) must be(0)
  }
}
