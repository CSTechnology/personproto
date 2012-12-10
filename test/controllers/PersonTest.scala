package controllers

import org.specs._

import controllers._
object PersonTest extends Specification {
  "登録画面表示" in {
	PersonController.index.toString() must startWith("Action")
  } 
  "一覧画面表示" in {
	PersonController.list.toString() must startWith("Action")
  } 
  "登録処理" in {
	PersonController.submitEntry.toString() must startWith("Action")
  } 
  "削除処理" in {
	PersonController.delete.toString() must startWith("Action")
  } 
  "編集画面を表示" in {
	PersonController.edit("test").toString() must startWith("Action")
  } 
  "更新処理" in {
	PersonController.submitUpdate.toString() must startWith("Action")
  } 
}
