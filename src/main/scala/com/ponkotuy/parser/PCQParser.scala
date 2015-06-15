package com.ponkotuy.parser

import scala.util.parsing.combinator._

object PCQParser extends RegexParsers {
  override def skipWhitespace = true
  override val whiteSpace = """(#.*\n|\s)+""".r

  def name = """[a-z\_]\w*""".r
  def typ = """[A-Z]\w*""".r
  def column = name ~ typ ^^ { case n ~ t => Column(n, t) }
  def columns = "{" ~> rep(column) <~ "}"

  def table = "table" ~> name ~ columns ^^ { case n ~ cs => Table(n, cs) }

  def apply(input: String): Either[String, Any] = parseAll(table, input) match {
    case Success(result, _) => Right(result)
    case NoSuccess(msg, _) => Left(msg)
  }

  case class Table(name: String, columns: List[Column])
  case class Column(name: String, typ: String)
}
