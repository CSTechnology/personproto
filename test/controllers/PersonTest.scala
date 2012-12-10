package controllers

import org.specs._

import controllers._
object PersonTest extends Specification {
  "Person登録ページを表示する" in {
	PersonController.index.toString() must startWith("Action")
  } 
  "Person一覧ページを表示する" in {
	PersonController.list.toString() must startWith("Action")
  } 
  "Person登録処理" in {
	PersonController.submitEntry.toString() must startWith("Action")
  } 
  "Personを削除する" in {
	PersonController.delete.toString() must startWith("Action")
  } 
}
