package controllers

import play.api._
import play.api.mvc._
import play.api.templates.Html

object Contact extends Controller {
  def index = Action {
     Ok(views.html.contact.contact("Testing"))
  }
}