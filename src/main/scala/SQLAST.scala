package sqlparser

object SQLAST {
	trait ASTNode
	case class A(property: B) extends ASTNode
	case class B(property: String) extends ASTNode
}
