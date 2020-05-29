package kastree.ast

open class Visitor {
    fun visit(v: Node) = visit(v, v)

    protected open fun visit(v: Node?, parent: Node) = v.run {
        when (this) {
            is Node.File -> {
                visitChildrenList(anns)
                visitChildren(pkg)
                visitChildrenList(imports)
                visitChildrenList(decls)
            }
            is Node.Script -> {
                visitChildrenList(anns)
                visitChildren(pkg)
                visitChildrenList(imports)
                visitChildrenList(exprs)
            }
            is Node.Package -> {
                visitChildrenList(mods)
            }
            is Node.Import -> {}
            is Node.Decl.Structured -> {
                visitChildrenList(mods)
                visitChildrenList(typeParams)
                visitChildren(primaryConstructor)
                visitChildrenList(parentAnns)
                visitChildrenList(parents)
                visitChildrenList(typeConstraints)
                visitChildrenList(members)
            }
            is Node.Decl.Structured.Parent.CallConstructor -> {
                visitChildren(type)
                visitChildrenList(typeArgs)
                visitChildrenList(args)
                visitChildren(lambda)
            }
            is Node.Decl.Structured.Parent.Type -> {
                visitChildren(type)
                visitChildren(by)
            }
            is Node.Decl.Structured.PrimaryConstructor -> {
                visitChildrenList(mods)
                visitChildrenList(params)
            }
            is Node.Decl.Init -> {
                visitChildren(block)
            }
            is Node.Decl.Func -> {
                visitChildrenList(mods)
                visitChildrenList(typeParams)
                visitChildren(receiverType)
                visitChildrenList(paramTypeParams)
                visitChildrenList(params)
                visitChildren(type)
                visitChildrenList(typeConstraints)
                visitChildren(body)
            }
            is Node.Decl.Func.Param -> {
                visitChildrenList(mods)
                visitChildren(type)
                visitChildren(default)
            }
            is Node.Decl.Func.Body.Block -> {
                visitChildren(block)
            }
            is Node.Decl.Func.Body.Expr -> {
                visitChildren(expr)
            }
            is Node.Decl.Property -> {
                visitChildrenList(mods)
                visitChildrenList(typeParams)
                visitChildren(receiverType)
                visitChildrenList(vars)
                visitChildrenList(typeConstraints)
                visitChildren(expr)
                visitChildren(accessors)
            }
            is Node.Decl.Property.Var -> {
                visitChildren(type)
            }
            is Node.Decl.Property.Accessors -> {
                visitChildren(first)
                visitChildren(second)
            }
            is Node.Decl.Property.Accessor.Get -> {
                visitChildrenList(mods)
                visitChildren(type)
                visitChildren(body)
            }
            is Node.Decl.Property.Accessor.Set -> {
                visitChildrenList(mods)
                visitChildrenList(paramMods)
                visitChildren(paramType)
                visitChildren(body)
            }
            is Node.Decl.TypeAlias -> {
                visitChildrenList(mods)
                visitChildrenList(typeParams)
                visitChildren(type)
            }
            is Node.Decl.Constructor -> {
                visitChildrenList(mods)
                visitChildrenList(params)
                visitChildren(delegationCall)
                visitChildren(block)
            }
            is Node.Decl.Constructor.DelegationCall -> {
                visitChildrenList(args)
            }
            is Node.Decl.EnumEntry -> {
                visitChildrenList(mods)
                visitChildrenList(args)
                visitChildrenList(members)
            }
            is Node.TypeParam -> {
                visitChildrenList(mods)
                visitChildren(type)
            }
            is Node.TypeConstraint -> {
                visitChildrenList(anns)
                visitChildren(type)
            }
            is Node.TypeRef.Paren -> {
                visitChildrenList(mods)
                visitChildren(type)
            }
            is Node.TypeRef.Func -> {
                visitChildren(receiverType)
                visitChildrenList(params)
                visitChildren(type)
            }
            is Node.TypeRef.Func.Param -> {
                visitChildren(type)
            }
            is Node.TypeRef.Simple -> {
                visitChildrenList(pieces)
            }
            is Node.TypeRef.Simple.Piece -> {
                visitChildrenList(typeParams)
            }
            is Node.TypeRef.Nullable -> {
                visitChildren(type)
            }
            is Node.TypeRef.Dynamic -> {}
            is Node.Type -> {
                visitChildrenList(mods)
                visitChildren(ref)
            }
            is Node.ValueArg -> {
                visitChildren(expr)
            }
            is Node.Expr.If -> {
                visitChildren(expr)
                visitChildren(body)
                visitChildren(elseBody)
            }
            is Node.Expr.Try -> {
                visitChildren(block)
                visitChildrenList(catches)
                visitChildren(finallyBlock)
            }
            is Node.Expr.Try.Catch -> {
                visitChildrenList(anns)
                visitChildren(varType)
                visitChildren(block)
            }
            is Node.Expr.For -> {
                visitChildrenList(anns)
                visitChildrenList(vars)
                visitChildren(inExpr)
                visitChildren(body)
            }
            is Node.Expr.While -> {
                visitChildren(expr)
                visitChildren(body)
            }
            is Node.Expr.BinaryOp -> {
                visitChildren(lhs)
                visitChildren(oper)
                visitChildren(rhs)
            }
            is Node.Expr.TypeOp.Oper -> {}
            is Node.Expr.TypeOp -> {
                visitChildren(lhs)
                visitChildren(oper)
                visitChildren(rhs)
            }
            is Node.Expr.BinaryOp.Oper.Infix -> {}
            is Node.Expr.BinaryOp.Oper.Token -> {}
            is Node.Expr.UnaryOp -> {
                visitChildren(expr)
                visitChildren(oper)
            }
            is Node.Expr.UnaryOp.Oper -> {}
            is Node.Expr.DoubleColonRef.Callable -> {
                visitChildren(recv)
            }
            is Node.Expr.DoubleColonRef.Class -> {
                visitChildren(recv)
            }
            is Node.Expr.DoubleColonRef.Recv.Expr -> {
                visitChildren(expr)
            }
            is Node.Expr.DoubleColonRef.Recv.Type -> {
                visitChildren(type)
            }
            is Node.Expr.Paren -> {
                visitChildren(expr)
            }
            is Node.Expr.StringTmpl -> {
                visitChildrenList(elems)
            }
            is Node.Expr.StringTmpl.Elem.Regular -> {}
            is Node.Expr.StringTmpl.Elem.ShortTmpl -> {}
            is Node.Expr.StringTmpl.Elem.UnicodeEsc -> {}
            is Node.Expr.StringTmpl.Elem.RegularEsc -> {}
            is Node.Expr.StringTmpl.Elem.LongTmpl -> {
                visitChildren(expr)
            }
            is Node.Expr.Const -> {}
            is Node.Expr.Brace -> {
                visitChildrenList(params)
                visitChildren(block)
            }
            is Node.Expr.Brace.Param -> {
                visitChildrenList(vars)
                visitChildren(destructType)
            }
            is Node.Expr.This -> {}
            is Node.Expr.Super -> {
                visitChildren(typeArg)
            }
            is Node.Expr.When -> {
                visitChildren(expr)
                visitChildrenList(entries)
            }
            is Node.Expr.When.Entry -> {
                visitChildrenList(conds)
                visitChildren(body)
            }
            is Node.Expr.When.Cond.Expr -> {
                visitChildren(expr)
            }
            is Node.Expr.When.Cond.In -> {
                visitChildren(expr)
            }
            is Node.Expr.When.Cond.Is -> {
                visitChildren(type)
            }
            is Node.Expr.Object -> {
                visitChildrenList(parents)
                visitChildrenList(members)
            }
            is Node.Expr.Throw -> {
                visitChildren(expr)
            }
            is Node.Expr.Return -> {
                visitChildren(expr)
            }
            is Node.Expr.Continue -> {}
            is Node.Expr.Break -> {}
            is Node.Expr.CollLit -> {
                visitChildrenList(exprs)
            }
            is Node.Expr.Name -> {}
            is Node.Expr.Labeled -> {
                visitChildren(expr)
            }
            is Node.Expr.Annotated -> {
                visitChildrenList(anns)
                visitChildren(expr)
            }
            is Node.Expr.Call -> {
                visitChildren(expr)
                visitChildrenList(typeArgs)
                visitChildrenList(args)
                visitChildren(lambda)
            }
            is Node.Expr.Call.TrailLambda -> {
                visitChildrenList(anns)
                visitChildren(func)
            }
            is Node.Expr.ArrayAccess -> {
                visitChildren(expr)
                visitChildrenList(indices)
            }
            is Node.Expr.AnonFunc -> {
                visitChildren(func)
            }
            is Node.Expr.Property ->  {
                visitChildren(decl)
            }
            is Node.Block -> {
                visitChildrenList(stmts)
            }
            is Node.Stmt.Decl -> {
                visitChildren(decl)
            }
            is Node.Stmt.Expr -> {
                visitChildren(expr)
            }
            is Node.Modifier.AnnotationSet -> {
                visitChildrenList(anns)
            }
            is Node.Modifier.AnnotationSet.Annotation -> {
                visitChildrenList(typeArgs)
                visitChildrenList(args)
            }
            is Node.Modifier.Lit -> {}
            is Node.Extra.BlankLines -> {}
            is Node.Extra.Comment -> {}
        }
    }

    protected fun <T: Node?> Node?.visitChildren(v: T) { visit(v, this!!) }

    private fun <T: Node?> Node?.visitChildrenList(v: List<T>) { v.forEach { orig -> visit(orig, this!!) } }

    companion object {
        fun visit(v: Node, fn: (v: Node?, parent: Node) -> Unit) = object : Visitor() {
            override fun visit(v: Node?, parent: Node) {
                fn(v, parent)
                super.visit(v, parent)
            }
        }.visit(v)
    }
}