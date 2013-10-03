package controllers

import play.api._
import play.api.mvc._
import play.api.templates.Html
import play.api.data.Form
import play.api.data.Forms._
import models._

object AboutPage extends Controller {
  def index = Action(implicit request =>
    	Ok(views.html.about.about("Varun Murthy | About Page"))
      )
}