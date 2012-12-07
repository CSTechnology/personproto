package models

import com.novus.salat._
import com.novus.salat.global._
import com.mongodb.casbah.Imports._
import play.api.data.Form


case class Person(name:String,age:Int,sex:String) 

object Person{
  val collection = MongoConnection()("test")("person")
  
  def find = {}
  
  def save(person:Person) = {
    val me = Person(name=person.name, age=person.age, sex=person.sex)
    val g = grater[Person]
    collection += g.asDBObject(me)
    //collection += MongoDBObject("id"->1, "name"->"me", "age"->27)
  }
  
  def delete = {}
  
  def update = {}
}
