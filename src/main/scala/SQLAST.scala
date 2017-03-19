package sqlparser

object SQLAST {
	trait ASTNode
	case class A(property: String) extends ASTNode
}
