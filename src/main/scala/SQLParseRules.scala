package sqlparser

import sqlparser.SQLAST._

import scala.util.parsing.combinator._
import scala.util.parsing.combinator.syntactical._

object SQLParseRules extends StandardTokenParsers with PackratParsers with Parsers {
  lexical.reserved += ( "," )
  lazy val dummyRule: Parser[A] = "a" ~ ident ^^ { case "a" ~ vv => A(vv) }
}
