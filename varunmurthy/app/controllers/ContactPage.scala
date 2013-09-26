package controllers

import play.api._
import play.api.mvc._
import play.api.templates.Html
import play.api.data.Form
import play.api.data.Forms._
import models._

object ContactPage extends Controller {

  val contactForm = Form(
		  tuple(
    "name" -> text,
    "email" -> nonEmptyText,
    "message" -> text
    )
  )

  def index = Action {
    Ok(views.html.contact.contact("Testing"))
  }

  def receiveContact = Action {
    Ok("")
  }

  def newContact = Action { implicit request =>
    contactForm.bindFromRequest.fold(
      errors => BadRequest(views.html.contact.testcontacts(Contact.all())),
      name, email, message => {
        Contact.create(name, email, message)
        Redirect(routes.Contact.index)
      })
  }

}