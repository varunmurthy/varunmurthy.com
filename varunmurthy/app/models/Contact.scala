package models

import anorm._
import anorm.SqlParser._
import play.api.Play.current
import play.api.db.DB

case class Contact(id: Long, name: String, email: String, message: String)
case class Email(id: Long, body: String)

object Contact {

  val contact = {
    get[Long]("id") ~
      get[String]("name") ~
      get[String]("email") ~
      get[String]("message") map {
        case id ~ name ~ email ~ message => Contact(id, name, email, message)
      }
  }
  
  def all(): List[Contact] = {
    DB.withConnection { implicit c =>
      SQL("select * from task").as(contact *)
    }
  }

  def create(name: String, email: String, message: String) {
    DB.withConnection { implicit c =>
      SQL("insert into contact (name, email, message) values ({label}, {email}, {message})").on(
        'name -> name, 'email -> email, 'message -> message).executeUpdate()
    }
  }

}