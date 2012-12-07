package models

import com.novus.salat._
import com.novus.salat.global._
import com.mongodb.casbah.Imports._
import play.api.data.Form
import com.novus.salat.annotations._
import com.novus.salat.dao._

case class Person(name: String, age: Int, sex: String)

object PersonDAO extends SalatDAO[models.Person, Int](collection = MongoConnection()("test")("person")) {

  def all(): List[Person] = PersonDAO.find(MongoDBObject.empty).toList

  def create(person: Person) {
    PersonDAO.insert(Person(name = person.name, age = person.age, person.sex))
  }

  def delete(name: String) {
    PersonDAO.remove(MongoDBObject("name" -> name))
  }

  def update = {
  }
}