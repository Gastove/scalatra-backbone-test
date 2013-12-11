package com.gastove.sjstest

import org.scalatra._
import scalate.ScalateSupport
import org.scalatra.json._
import org.json4s.{DefaultFormats, Formats}

class MyScalatraServlet extends ScalatraServlet with JacksonJsonSupport {

  case class Book(
    title: String,
    author: String,
    releaseDate: Int,
    keywords: String
  )

  object Books {
    val all = List(
      Book(
        "JavaScript: The Good Parts",
        "Douglas Crockford",
        2008,
        "JavaScript Programming"
      ),
      Book(
        "The Little Book of CoffeeScript",
        "Alex MacCaw",
        2012,
        "CoffeeScriptProgramming"
      ),
      Book(
        "Scala for the Impatient",
        "Cay S. Horstman",
        2012,
        "Scala Programming"
      ),
      Book(
        "American Psycho",
        "Bret Easton Ellis",
        1991,
        "Novel Splatter"
      ),
      Book(
        "Eloquent JavaScript",
        "Marijn Haverbeke",
        2011,
        "JavaScript Programming"
      )
    )
  }

  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  // Get an array of all books
  get("/") {
    Books.all
  }

  // Get a book by id
  get("/:id") {}


}
