package models

import com.novus.salat._
import com.novus.salat.global._
import com.mongodb.casbah.Imports._
import com.novus.salat.annotations._
import com.novus.salat.dao._

case class Person(name: String, age: Int, sex: String)

object PersonDAO extends SalatDAO[models.Person, Int](collection = MongoConnection()("test")("person")) {

  def all(): List[Person] = PersonDAO.find(MongoDBObject.empty).toList

  def create(person: Person) {
    //PersonDAO.insert(Person(name = person.name, age = person.age, person.sex))
    PersonDAO.insert(person)
  }
  
  def delete(name: String) {
    PersonDAO.remove(MongoDBObject("name" -> name))
  }

  def select(name: String):List[Person] = {
    PersonDAO.findOne(MongoDBObject("name" -> name)).toList
  } 
    
  def updating(person: Person,oldname:String) = {
    val psersonDBObject = grater[Person].asDBObject(person)
    PersonDAO.update(MongoDBObject("name" -> oldname),psersonDBObject)
  }
}