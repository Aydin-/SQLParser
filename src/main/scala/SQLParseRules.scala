package sqlparser

import sqlparser.SQLAST._

import scala.util.parsing.combinator._
import scala.util.parsing.combinator.syntactical._

object SQLParseRules extends StandardTokenParsers with PackratParsers with Parsers {
	lazy val sqlObjectIdentifier: Parser[SQLObjectIdentifierRule] = sqlProvenance ~ sqlVariant
	lazy val sqlProvenance: Parser[SQLProvenanceRule] = arc1 ~ arc2 ~ arc3
	lazy val sqlVariant: Parser[SQLVariantRule] = sqlEdition ~ sqlConformance
	lazy val sqlEdition: Parser[SQLEditionRule] = y1987 | y1989 | y1992 | y1999 | y200n
	lazy val y1987: Parser[Y1987Rule] = "0" | ("edition1987" ~ leftParen ~ "0" ~ rightParen)
	lazy val y1989: Parser[Y1989Rule] = y1989base ~ y1989package
	lazy val sqlConformance: Parser[SQLConformanceRule] = level ~ bindings ~ parts ~ packages
	lazy val level: Parser[LevelRule] = low | intermediate | high
	lazy val low: Parser[LowRule] = "0" | "Low" ~ leftParen ~ "0" ~ rightParen
	lazy val intermediate: Parser[IntermediateRule] = "1" | "Intermediate" ~ leftParen ~ "1" ~ rightParen
	lazy val high: Parser[HighRule] = "2" | "High" ~ leftParen ~ "2" ~ rightParen
	lazy val arc1: Parser[Arc1Rule] = "iso" | "1" | "iso" leftParen 1 rightParen
	lazy val arc2: Parser[Arc2Rule] = "standard" | "0" | ("standard" ~ leftParen ~ "0" ~ rightParen)
	lazy val arc3: Parser[Arc3Rule] = "9075"
	lazy val leftParen: Parser[LeftParenRule] = "("
	lazy val rightParen: Parser[RightParenRule] = ")"
	lazy val sqlTerminalCharacter: Parser[SqlTerminalCharacterRule] = sqlLanguageCharacter
	lazy val sqlLanguageCharacter: Parser[SqlLanguageCharacterRule] = simpleLatinLetter | digit | sqlSpecialCharacter
	lazy val simpleLatinLetter: Parser[SimpleLatinLetterRule] = simpleLatinUpperCaseLetter | simpleLatinLowerCaseLetter
	lazy val simpleLatinUpperCaseLetter: Parser[SimpleLatinUpperCaseLetterRule] = "A" | "B" | "C" | "D" | "E" | "F" | "G" |
	  	"H" | "I" | "J" | "K" | "L" | "M" | "N" | "O" | "P" | "Q" | "R" | "S" | "T" | "U" | "V" | "W" | "X" | "Y" | "Z"
	lazy val simpleLatinLowerCaseLetter: Parser[SimpleLatinLowerCaseLetterRule] = "a" | "b" | "c" | "d" | "e" | "f" | "g" |
		"h" | "i" | "j" | "k" | "l" | "m" | "n" | "o" | "p" | "q" | "r" | "s" | "t" | "u" | "v" | "w" | "x" | "y" | "z"
	lazy val digit: Parser[DigitRule] = "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"
	lazy val sqlSpecialCharacter: Parser[SqlSpecialCharacterRule] = space | doubleQuote | percent | ampersand | quote |
 	 	leftParen | rightParen | asterisk | plusSign | comma | minusSign | period | solidus | colon | semicolon |
		lessThanOperator | equalsOperator | greaterThanOperator | questionMark | leftBracket | rightBracket | circumflex |
		underscore | verticalBar | leftBrace | rightBrace
	/*
	<left bracket or trigraph> ::= <left bracket> | <left bracket trigraph>
	<right bracket or trigraph> ::= <right bracket> | <right bracket trigraph>
	<left bracket> ::= [
	<left bracket trigraph> ::= ??(
	<right bracket> ::= ]
	<right bracket trigraph> ::= ??)
	<circumflex> ::= ^
	<underscore> ::= _
	<vertical bar> ::= |
	<left brace> ::= {
	<right brace> ::= }
	*/
}
