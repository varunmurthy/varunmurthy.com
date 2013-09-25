package controllers

import play.api._
import play.api.mvc._
import play.api.templates.Html

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.home.home("Varun Murthy | Home"))
  }
}