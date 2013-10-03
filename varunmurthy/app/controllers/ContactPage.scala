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
      "message" -> text))

  def index = Action { implicit request =>
     Ok(views.html.contact.contact("Contact Me !")(contactForm))
//    Ok("Got request [" + request + "]")
  }

  def newContact = Action { implicit request =>
    contactForm.bindFromRequest.fold(
      errors => BadRequest(views.html.contact.contact("Failed")(errors)),

      data => {
        Contact.create(data._1, data._2, data._3)
        val response = "Hi " + data._1 + "! Thanks for reaching out. I'll get in touch"
        Redirect(routes.ContactPage.index).flashing(
          "success" -> response)
      })
  }

}