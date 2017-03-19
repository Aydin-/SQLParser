package sqlparser

import SQLParseRules._

object Parse {
	val parseMe = "parse-test.sql"
	def main( args: Array[String] ) = {
		println( s"Hello world!  Here's your AST: ${parseFromFile(parseMe)}" )
	}

	def parseFromFile( file: String ) = {
		ARule(
			new PackratReader( new lexical.Scanner( scala.io.Source.fromFile( file, "utf-8" ).getLines.mkString( "\n" )))
		)
	}
}
