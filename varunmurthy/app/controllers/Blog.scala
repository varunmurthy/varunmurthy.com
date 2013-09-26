package controllers

import play.api._
import play.api.mvc._
import play.api.templates.Html

object Blog extends Controller {
	def index = Action {
	  Ok(views.html.blog.blog())
	}
}