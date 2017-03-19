package sqlparser

import scala.util.parsing.combinator._
import scala.util.parsing.combinator.syntactical._
import scala.collection.mutable.ListBuffer
import scala.annotation.tailrec

import SQLAST._

object SQLParseRules extends StandardTokenParsers with PackratParsers with Parsers {
	lexical.reserved += ()
	lazy val dummyRule: A = "a" ~ ident ^^ { case "a" ~ vv => A(vv) }
}
