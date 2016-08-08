package app.model;

import java.util.ArrayList;
import java.util.List;

import app.antlr.AplusplusParser.AndExpressionContext;
import app.antlr.AplusplusParser.ArgumentListContext;
import app.antlr.AplusplusParser.AssignExpressionContext;
import app.antlr.AplusplusParser.BooleanLiteralContext;
import app.antlr.AplusplusParser.DifferenceExpressionContext;
import app.antlr.AplusplusParser.DurationLiteralContext;
import app.antlr.AplusplusParser.EqualityExpressionContext;
import app.antlr.AplusplusParser.ExpressionContext;
import app.antlr.AplusplusParser.IdExpressionContext;
import app.antlr.AplusplusParser.IntervalLiteralContext;
import app.antlr.AplusplusParser.LiteralExpressionContext;
import app.antlr.AplusplusParser.MultDivideExpressionContext;
import app.antlr.AplusplusParser.NotExpressionContext;
import app.antlr.AplusplusParser.NumberLiteralContext;
import app.antlr.AplusplusParser.OrExpressionContext;
import app.antlr.AplusplusParser.ParensExpressionContext;
import app.antlr.AplusplusParser.PercentageLiteralContext;
import app.antlr.AplusplusParser.PlusMinusExpressionContext;
import app.antlr.AplusplusParser.ScenarioCallExpressionContext;
import app.antlr.AplusplusParser.TimeLiteralContext;
import app.antlr.AplusplusParser.XorExpressionContext;
import app.scopetype.IScope;
import app.symboltable.Symbol;

public abstract class Expression {
	private Type exprType;
	private Symbol.Type dataType;
	private Expression parent;
	
	public Type getExpressionType() { return exprType; }
	public Symbol.Type getDataType() { return dataType; }
	public void setDataType(Symbol.Type _type) { dataType = _type; }
	
	public Expression getParent() { return parent; }
	public void setParent(Expression p) { parent = p; }
	
	public Expression(Type _exprType){
		this(_exprType, null);
	}
	
	public Expression(Type _exprType, Symbol.Type _datatype){
		exprType = _exprType;
		dataType = _datatype;

	}
	
	public Unary asUnary(){
		return (Unary) this;
	}
	
	public Binary asBinary(){
		return (Binary) this;
	}
	
	// builds an expression object recursively
	public static Expression buildExpression(ExpressionContext ctx) throws InvalidExpressionException{
		Expression e = null;
		
		if (ctx instanceof AndExpressionContext){
			e = new Expression.Binary(Type.BinaryAnd,
					buildExpression(((AndExpressionContext) ctx).expression(0)),
					buildExpression(((AndExpressionContext) ctx).expression(1))
					);
		} else if (ctx instanceof DifferenceExpressionContext){
			String op = ((DifferenceExpressionContext) ctx).getChild(1).getText();
			
			Type type = Type.Invalid;
			
			if (op.matches("<")){
				type = Type.BinaryLessThan;
			} else if (op.matches("<=") || op.matches("=<")){
				type = Type.BinaryLessThanEqual;
			} else if (op.matches(">")){
				type = Type.BinaryGreaterThan;
			} else if (op.matches(">=") || op.matches("=>")){
				type = Type.BinaryGreaterThanEqual;
			}
			
			e = new Expression.Binary(type,
					buildExpression(((DifferenceExpressionContext) ctx).expression(0)),
					buildExpression(((DifferenceExpressionContext) ctx).expression(1))
					);
		} else if (ctx instanceof NotExpressionContext){
			e = new Expression.Unary(Type.UnaryNot, 
					buildExpression(((NotExpressionContext) ctx).expression())
					);
		} else if (ctx instanceof PlusMinusExpressionContext){
			String op = ((PlusMinusExpressionContext) ctx).getChild(1).getText();
			
			Type type = Type.Invalid;
			
			if (op.matches("\\+")){
				type = Type.BinaryAddition;
			} else if (op.matches("-")){
				type = Type.BinarySubtraction;
			} 
			
			e = new Expression.Binary(type, 
					buildExpression(((PlusMinusExpressionContext) ctx).expression(0)), 
					buildExpression(((PlusMinusExpressionContext) ctx).expression(1))
					);
		} else if (ctx instanceof AssignExpressionContext){
			e = new Expression.Assign(((AssignExpressionContext) ctx).ID().getText(), 
					buildExpression(((AssignExpressionContext) ctx).expression())
					);
		} else if (ctx instanceof MultDivideExpressionContext){
			String op = ((MultDivideExpressionContext) ctx).getChild(1).getText();
			
			Type type = Type.Invalid;
			
			if (op.matches("\\*")){
				type = Type.BinaryMultiply;
			} else if (op.matches("/")){
				type = Type.BinaryDivide;
			}
			
			e = new Expression.Binary(type, 
					buildExpression(((MultDivideExpressionContext) ctx).expression(0)), 
					buildExpression(((MultDivideExpressionContext) ctx).expression(1))
					);
		} else if (ctx instanceof EqualityExpressionContext){
			String op = ((EqualityExpressionContext) ctx).getChild(1).getText();
			
			Type type = Type.Invalid;
			
			if (op.matches("is") || op.matches("=")){
				type = Type.BinaryEqual;
			} else if (op.matches("is not") || op.matches("!=")){
				type = Type.BinaryNotEqual;
			}
			
			e = new Expression.Binary(type,
					buildExpression(((EqualityExpressionContext) ctx).expression(0)),
					buildExpression(((EqualityExpressionContext) ctx).expression(1))
					);
			
		} else if (ctx instanceof XorExpressionContext){
			e = new Expression.Binary(Type.BinaryXor,
					buildExpression(((XorExpressionContext) ctx).expression(0)),
					buildExpression(((XorExpressionContext) ctx).expression(1))
					);
		} else if (ctx instanceof ParensExpressionContext){
			e = new Expression.Unary(Type.UnaryParenthesis, 
					buildExpression(((ParensExpressionContext) ctx).expression())
					);
		} else if (ctx instanceof OrExpressionContext){
			e = new Expression.Binary(Type.BinaryOr,
					buildExpression(((OrExpressionContext) ctx).expression(0)),
					buildExpression(((OrExpressionContext) ctx).expression(1))
					);
		} else if (ctx instanceof IdExpressionContext){
			e = new Expression.Id(((IdExpressionContext) ctx).ID().getText());
		} else if (ctx instanceof LiteralExpressionContext){
			e = buildLiteralExpression((LiteralExpressionContext) ctx);
		} else if (ctx instanceof ScenarioCallExpressionContext) {
			e = buildScenarioExpression((ScenarioCallExpressionContext) ctx);
		} else {
			throw new InvalidExpressionException("Unknown expression");
		}
		
		return e;
	}
	
	// builds a scenario call expression
	private static Expression buildScenarioExpression(ScenarioCallExpressionContext ctx) throws InvalidExpressionException{
		ArgumentListContext argList = ctx.scenarioInvocation().argumentList();
		Expression.ScenarioCall scenCall = new Expression.ScenarioCall(((ScenarioCallExpressionContext) ctx).scenarioInvocation().ID().getText());
		
		if (argList != null){
			for (int i = 0; i < argList.getChildCount(); i++){
				if (argList.getChild(i) instanceof ExpressionContext){
					Expression expr = buildExpression((ExpressionContext) argList.getChild(i));
					expr.setParent(scenCall);
					scenCall.addArg(expr);
				}
			}
		}

		return scenCall;
	}
	
	// builds a data literal
	private static Expression buildLiteralExpression(LiteralExpressionContext ctx){
		if (ctx.getChild(0).getChild(0) instanceof NumberLiteralContext){
			return new Expression.NumberLiteral(ctx.getText());
		} else if (ctx.getChild(0).getChild(0) instanceof PercentageLiteralContext){
			return new Expression.PercentageLiteral(Integer.parseInt(ctx.getText().replace("%", "")));
		} else if (ctx.getChild(0).getChild(0) instanceof DurationLiteralContext){
			return new Expression.DurationLiteral(parseDurationLiteral((DurationLiteralContext) ctx.getChild(0).getChild(0)));
		} else if (ctx.getChild(0).getChild(0) instanceof TimeLiteralContext){
			String time = ctx.getText();
			return new Expression.TimeLiteral(
					""+Integer.parseInt(time.substring(0, 2)),
					""+Integer.parseInt(time.substring(3, 5)));
		} else if (ctx.getChild(0).getChild(0) instanceof IntervalLiteralContext){
			String s = "";
			
			for (int i = 0; i < ctx.getChild(0).getChild(0).getChildCount(); i++){
				s += ctx.getChild(0).getChild(0).getChild(i).getText();
				
				if (i < ctx.getChild(0).getChild(0).getChildCount() - 1)
					s += " ";
			}
			
			return new Expression.IntervalLiteral(s);
		} else if (ctx.getChild(0).getChild(0) instanceof BooleanLiteralContext){
			String s = ctx.getText();
			boolean b = false;
			
			if (s.matches("on") || s.matches("true")){
				b = true;
			}
			
			return new Expression.BooleanLiteral(b);
		} else {
			return null;
		}
	}
	
	private static long parseDurationLiteral(DurationLiteralContext ctx){
		long hours = ctx.hourLiteral() != null 
				? Long.parseLong(ctx.hourLiteral().getChild(0).getText()) : 0;
		long minutes = ctx.minLiteral() != null 
				? Long.parseLong(ctx.minLiteral().getChild(0).getText()) : 0;
		long seconds = ctx.secLiteral() != null 
				? Long.parseLong(ctx.secLiteral().getChild(0).getText()) : 0;
				
		return (long)(hours * 60 * 60 * 1000 + minutes * 60 * 1000 + seconds * 1000);
	}
	
	public static class InvalidExpressionException extends Exception {
		private static final long serialVersionUID = -296507755419328856L;

		public InvalidExpressionException(String msg){
			super(msg);
		}
	}
	
	// returns the data type of the given expression
	public static Symbol.Type getDataType(ExpressionContext ctx, IScope scope) throws InvalidDatatypeException, InvalidExpressionException {
		return getDataType(Expression.buildExpression(ctx), scope);
	}
	
	// returns the data type of the given expression
	public static Symbol.Type getDataType(Expression e, IScope scope) throws InvalidDatatypeException, InvalidExpressionException{
		switch (e.getExpressionType()){
		case UnaryParenthesis:
			return getDataType(((Unary)e).getArg(), scope);
		case UnaryNot:
			return getDataType(((Unary)e).getArg(), scope);
		case UnaryId:
			if (scope.resolve(((Id)e).getId()) != null){
				return scope.resolve(((Id)e).getId()).getType();
			} else {
				throw new InvalidExpressionException("variable '"+((Id)e).getId()+"' does not exist in this context");
			}
		case UnaryTimeLiteral:
		case UnaryNumberLiteral:
		case UnaryBooleanLiteral:
		case UnaryDurationLiteral:
		case UnaryIntervalLiteral:
		case UnaryPercentageLiteral:
			return e.getDataType();
		case BinaryMultiply:
		case BinaryDivide:
			if (getDataType(e.asBinary().getArg1(), scope) == Symbol.Type.Number
				&& getDataType(e.asBinary().getArg2(), scope) == Symbol.Type.Number) {
				return Symbol.Type.Number;
			} else {
				throw new InvalidDatatypeException(
						"Cannot multiply nor divide types "
								+getDataType(e.asBinary().getArg1(), scope)
								+" and "
								+getDataType(e.asBinary().getArg2(), scope));
			}
		case BinaryAddition:
		case BinarySubtraction:
			if (getDataType(e.asBinary().getArg1(), scope) == Symbol.Type.Number
				&& getDataType(e.asBinary().getArg2(), scope) == Symbol.Type.Number) {
				return Symbol.Type.Number;
			} else if ((getDataType(e.asBinary().getArg1(), scope) == Symbol.Type.Percentage
				&& getDataType(e.asBinary().getArg2(), scope) == Symbol.Type.Number)
				|| (getDataType(e.asBinary().getArg1(), scope) == Symbol.Type.Number
						&& getDataType(e.asBinary().getArg2(), scope) == Symbol.Type.Percentage)
				|| (getDataType(e.asBinary().getArg1(), scope) == Symbol.Type.Percentage
						&& getDataType(e.asBinary().getArg2(), scope) == Symbol.Type.Percentage)) {
				return Symbol.Type.Percentage;
			} else if ((getDataType(e.asBinary().getArg1(), scope) == Symbol.Type.Time
					&& getDataType(e.asBinary().getArg2(), scope) == Symbol.Type.Duration)) {
					return Symbol.Type.Time;
			} else if ((getDataType(e.asBinary().getArg1(), scope) == Symbol.Type.Duration
					&& getDataType(e.asBinary().getArg2(), scope) == Symbol.Type.Duration)) {
					return Symbol.Type.Duration;
			} else {
				throw new InvalidDatatypeException(
						"Cannot add nor substract "
								+getDataType(e.asBinary().getArg1(), scope)
								+" and "
								+getDataType(e.asBinary().getArg2(), scope));
			}
		case BinaryEqual:
		case BinaryNotEqual:
			if (getDataType(e.asBinary().getArg1(), scope) == Symbol.Type.Boolean
				&& getDataType(e.asBinary().getArg2(), scope) == Symbol.Type.Boolean){
				return Symbol.Type.Boolean;
			}
		case BinaryGreaterThan:
		case BinaryGreaterThanEqual:
		case BinaryLessThan:
		case BinaryLessThanEqual:
			if (getDataType(e.asBinary().getArg1(), scope) == Symbol.Type.Number
				&& getDataType(e.asBinary().getArg2(), scope) == Symbol.Type.Number){
				return Symbol.Type.Boolean;
			} else if (getDataType(e.asBinary().getArg1(), scope) == Symbol.Type.Percentage
				&& getDataType(e.asBinary().getArg2(), scope) == Symbol.Type.Percentage){
				return Symbol.Type.Boolean;
			} else if (getDataType(e.asBinary().getArg1(), scope) == Symbol.Type.Duration
				&& getDataType(e.asBinary().getArg2(), scope) == Symbol.Type.Duration){
				return Symbol.Type.Boolean;
			} else if (getDataType(e.asBinary().getArg1(), scope) == Symbol.Type.Time
				&& getDataType(e.asBinary().getArg2(), scope) == Symbol.Type.Time){
				return Symbol.Type.Boolean;
			} else {
				throw new InvalidDatatypeException(
						"Cannot compare types "
								+getDataType(e.asBinary().getArg1(), scope)
								+" and "
								+getDataType(e.asBinary().getArg2(), scope));
			}
		case BinaryAnd:
		case BinaryOr:
		case BinaryXor:
			if (getDataType(e.asBinary().getArg1(), scope) == Symbol.Type.Boolean
				&& getDataType(e.asBinary().getArg2(), scope) == Symbol.Type.Boolean){
				return Symbol.Type.Boolean;
			} else {
				throw new InvalidDatatypeException(
						"Cannot apply boolean operators on types "
								+getDataType(e.asBinary().getArg1(), scope)
								+" and "
								+getDataType(e.asBinary().getArg2(), scope));
			}
		case Assign:
			return getDataType(e.asUnary().getArg(), scope);
		case ScenarioCall:
			if (scope.resolve(((ScenarioCall)e).getId()) != null){
				return scope.resolve(((ScenarioCall)e).getId()).getType();
			} else {
				throw new InvalidExpressionException("scenario '"+((ScenarioCall)e).getId()+"()' does not exist");
			}
		default:
			throw new InvalidDatatypeException("Expression has an invalid type");
		}
	}
	
	public static class InvalidDatatypeException extends Exception {
		private static final long serialVersionUID = -1147160805180957563L;
		
		public InvalidDatatypeException(String msg){
			super(msg);
		}
	}
	
	public static class Unary extends Expression {
		private Expression arg;
		public Expression getArg() { return arg; }
		
		public Unary(Type _type, Expression _arg){
			super(_type, _arg.getDataType());
			arg = _arg;
		}
	}
	
	public static class Binary extends Expression {
		private Expression arg1;
		private Expression arg2;
		
		public Expression getArg1() { return arg1; }
		public Expression getArg2() { return arg2; }
		
		public Binary(Type _type, Expression _arg1, Expression _arg2){
			super(_type);
			
			arg1 = _arg1;
			arg2 = _arg2;
		}
	}
	
	public static class Assign extends Unary {
		private String id;
		
		public String getId() { return id; }
		
		public Assign(String _id, Expression _arg){
			super(Type.Assign, _arg);
			
			id = _id;
		}
	}
	
	public static class Id extends Expression {
		private String id;
		
		public String getId() { return id; }
		
		public Id(String _id){
			super(Type.UnaryId);
			
			id = _id;
		}
	}
	
	public static class TimeLiteral extends Expression {
		private String hour;
		private String minute;
		
		public String getHour() { return hour; }
		public String getMinute() { return minute; }
		
		public TimeLiteral(String _hour, String _minute){
			super(Type.UnaryTimeLiteral, Symbol.Type.Time);
			
			hour = _hour;
			minute = _minute;
		}
	}
	
	public static class NumberLiteral extends Expression {
		private String value;
		
		public String getValue() { return value; }
		
		public NumberLiteral(String _value){
			super(Type.UnaryNumberLiteral, Symbol.Type.Number);
			
			value = _value;
		}
	}
	
	public static class BooleanLiteral extends Expression {
		private boolean value;
		
		public boolean getValue() { return value; }
		
		public BooleanLiteral(boolean _value){
			super(Type.UnaryBooleanLiteral, Symbol.Type.Boolean);
			
			value = _value;
		}
	}
	
	public static class DurationLiteral extends Expression {
		private long value;
		
		public long getValue() { return value; }
		
		public DurationLiteral(long _value){
			super(Type.UnaryDurationLiteral, Symbol.Type.Duration);
			
			value = _value;
		}
	}
	
	public static class IntervalLiteral extends Expression {
		private String value;
		
		public String getValue() { return value; }
		
		public IntervalLiteral(String _value){
			super(Type.UnaryIntervalLiteral, Symbol.Type.Interval);
			
			value = _value;
		}
	}
	
	public static class PercentageLiteral extends Expression {
		private int value;
		
		public int getValue() { return value; }
		
		public PercentageLiteral(int _value){
			super(Type.UnaryPercentageLiteral, Symbol.Type.Percentage);
			
			value = _value;
		}
	}
	
	public static class ScenarioCall extends Expression {
		private String id;
		private List<Expression> args;
		
		public String getId() { return id; }
		public List<Expression> getArgs() { return args; }
		
		public ScenarioCall(String _id) {
			super(Type.ScenarioCall);
			
			id = _id;
			args = new ArrayList<Expression>();
		}
		
		public void addArg(Expression arg){
			args.add(arg);
		}
	}
	
	public static enum Type {
		Invalid,
		UnaryParenthesis,
		UnaryNot,
		UnaryId,
		UnaryTimeLiteral,
		UnaryNumberLiteral,
		UnaryBooleanLiteral,
		UnaryDurationLiteral,
		UnaryIntervalLiteral,
		UnaryPercentageLiteral,
		
		BinaryMultiply,
		BinaryDivide,
		BinaryAddition,
		BinarySubtraction,
		
		BinaryGreaterThan,
		BinaryGreaterThanEqual,
		BinaryLessThan,
		BinaryLessThanEqual,
		
		BinaryEqual,
		BinaryNotEqual,
		
		BinaryAnd,
		BinaryOr,
		BinaryXor,
		
		Assign,
		
		ScenarioCall
	}
	
}
