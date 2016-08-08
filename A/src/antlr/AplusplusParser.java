// Generated from Aplusplus.g4 by ANTLR 4.4

	package app.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AplusplusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__27=1, T__26=2, T__25=3, T__24=4, T__23=5, T__22=6, T__21=7, T__20=8, 
		T__19=9, T__18=10, T__17=11, T__16=12, T__15=13, T__14=14, T__13=15, T__12=16, 
		T__11=17, T__10=18, T__9=19, T__8=20, T__7=21, T__6=22, T__5=23, T__4=24, 
		T__3=25, T__2=26, T__1=27, T__0=28, COMMENT=29, WSSKIP=30, ASSIGN=31, 
		ASSIGNDCL=32, ASSIGNPIN=33, WAIT=34, TGL=35, TURN=36, TO=37, ELSEIF=38, 
		ELSE=39, LPAREN=40, RPAREN=41, PIN=42, PLUS=43, MINUS=44, MULT=45, DIV=46, 
		GT=47, GTE=48, LT=49, LTE=50, OR=51, AND=52, XOR=53, NOT=54, EQUAL=55, 
		NOTEQUAL=56, TRUE=57, FALSE=58, ON=59, OFF=60, MON=61, TUE=62, WED=63, 
		THU=64, FRI=65, SAT=66, SUN=67, JAN=68, FEB=69, MAR=70, APR=71, MAY=72, 
		JUN=73, JUL=74, AUG=75, SEP=76, OCT=77, NOV=78, DEC=79, NEWLINE=80, D_NUMBER=81, 
		D_TIME=82, D_DURATION=83, D_INTERVAL=84, D_BOOLEAN=85, D_PERCENTAGE=86, 
		P_ANALOG=87, P_DIGITAL=88, H_BUTTON=89, H_LIGHT=90, H_CLIMATE=91, H_MOTIONSENSOR=92, 
		H_TEMPSENSOR=93, H_DIMMER=94, ID=95, NONNEG_INT=96, INTEGER=97, NUMBER=98, 
		TIME=99;
	public static final String[] tokenNames = {
		"<INVALID>", "'hold'", "'doublepressed'", "'end scenario'", "'while'", 
		"'end setup'", "'end group'", "'min'", "'end event'", "','", "'output'", 
		"'changed'", "'active'", "'assert'", "'scenario'", "'sec'", "'hr'", "'group'", 
		"'end if'", "'pressed'", "'if'", "'event'", "'change'", "'setup'", "'end while'", 
		"'end program'", "'program'", "'%'", "'input'", "COMMENT", "WSSKIP", "'set'", 
		"'as'", "'at'", "'wait'", "'toggle'", "'turn'", "'to'", "'else if'", "'else'", 
		"'('", "')'", "'pin'", "'+'", "'-'", "'*'", "'/'", "'>'", "GTE", "'<'", 
		"LTE", "OR", "AND", "XOR", "NOT", "EQUAL", "NOTEQUAL", "'true'", "'false'", 
		"'on'", "'off'", "'mon'", "'tue'", "'wed'", "'thu'", "'fri'", "'sat'", 
		"'sun'", "'jan'", "'feb'", "'mar'", "'apr'", "'may'", "'jun'", "'jul'", 
		"'aug'", "'sep'", "'oct'", "'nov'", "'dec'", "NEWLINE", "'number'", "'time'", 
		"'duration'", "'interval'", "'boolean'", "'percentage'", "'analog'", "'digital'", 
		"'button'", "'light'", "'climate'", "'motionsensor'", "'tempsensor'", 
		"'dimmer'", "ID", "NONNEG_INT", "INTEGER", "NUMBER", "TIME"
	};
	public static final int
		RULE_start = 0, RULE_setup = 1, RULE_pinDcl = 2, RULE_varDcl = 3, RULE_varAssign = 4, 
		RULE_varDclAssign = 5, RULE_group = 6, RULE_program = 7, RULE_btnAction = 8, 
		RULE_sensAction = 9, RULE_dimAction = 10, RULE_tempAction = 11, RULE_scenarioDcl = 12, 
		RULE_inputDcl = 13, RULE_outputDcl = 14, RULE_inputParameter = 15, RULE_setupStmt = 16, 
		RULE_groupStmt = 17, RULE_progStmt = 18, RULE_progStmtBlock = 19, RULE_scenStmtBlock = 20, 
		RULE_scenBlock = 21, RULE_scenStmt = 22, RULE_outputStmt = 23, RULE_toggleStmt = 24, 
		RULE_waitStmt = 25, RULE_whileStmtProg = 26, RULE_whileStmtScen = 27, 
		RULE_ifStmtProg = 28, RULE_ifElseStmtProg = 29, RULE_elseStmtProg = 30, 
		RULE_ifStmtScen = 31, RULE_ifElseStmtScen = 32, RULE_elseStmtScen = 33, 
		RULE_event = 34, RULE_argumentList = 35, RULE_condition = 36, RULE_expressionStatement = 37, 
		RULE_expression = 38, RULE_scenarioInvocation = 39, RULE_literal = 40, 
		RULE_numberLiteral = 41, RULE_timeLiteral = 42, RULE_durationLiteral = 43, 
		RULE_hourLiteral = 44, RULE_minLiteral = 45, RULE_secLiteral = 46, RULE_intervalLiteral = 47, 
		RULE_percentageLiteral = 48, RULE_type = 49, RULE_datatype = 50, RULE_pinType = 51, 
		RULE_hardwareType = 52, RULE_booleanLiteral = 53, RULE_dayType = 54, RULE_monthType = 55, 
		RULE_var = 56, RULE_assertExpr = 57;
	public static final String[] ruleNames = {
		"start", "setup", "pinDcl", "varDcl", "varAssign", "varDclAssign", "group", 
		"program", "btnAction", "sensAction", "dimAction", "tempAction", "scenarioDcl", 
		"inputDcl", "outputDcl", "inputParameter", "setupStmt", "groupStmt", "progStmt", 
		"progStmtBlock", "scenStmtBlock", "scenBlock", "scenStmt", "outputStmt", 
		"toggleStmt", "waitStmt", "whileStmtProg", "whileStmtScen", "ifStmtProg", 
		"ifElseStmtProg", "elseStmtProg", "ifStmtScen", "ifElseStmtScen", "elseStmtScen", 
		"event", "argumentList", "condition", "expressionStatement", "expression", 
		"scenarioInvocation", "literal", "numberLiteral", "timeLiteral", "durationLiteral", 
		"hourLiteral", "minLiteral", "secLiteral", "intervalLiteral", "percentageLiteral", 
		"type", "datatype", "pinType", "hardwareType", "booleanLiteral", "dayType", 
		"monthType", "var", "assertExpr"
	};

	@Override
	public String getGrammarFileName() { return "Aplusplus.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AplusplusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public List<GroupContext> group() {
			return getRuleContexts(GroupContext.class);
		}
		public GroupContext group(int i) {
			return getRuleContext(GroupContext.class,i);
		}
		public SetupContext setup() {
			return getRuleContext(SetupContext.class,0);
		}
		public ScenarioDclContext scenarioDcl(int i) {
			return getRuleContext(ScenarioDclContext.class,i);
		}
		public TerminalNode EOF() { return getToken(AplusplusParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public List<ScenarioDclContext> scenarioDcl() {
			return getRuleContexts(ScenarioDclContext.class);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116); setup();
			setState(118); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(117); match(NEWLINE);
				}
				}
				setState(120); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(122); group();
				setState(124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(123); match(NEWLINE);
					}
					}
					setState(126); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133); program();
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(135); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(134); match(NEWLINE);
						}
						}
						setState(137); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(139); scenarioDcl();
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(145); match(NEWLINE);
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetupContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public List<SetupStmtContext> setupStmt() {
			return getRuleContexts(SetupStmtContext.class);
		}
		public SetupStmtContext setupStmt(int i) {
			return getRuleContext(SetupStmtContext.class,i);
		}
		public SetupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterSetup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitSetup(this);
		}
	}

	public final SetupContext setup() throws RecognitionException {
		SetupContext _localctx = new SetupContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_setup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153); match(T__5);
			setState(155); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(154); match(NEWLINE);
				}
				}
				setState(157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15 || _la==ASSIGN || _la==ID) {
				{
				{
				setState(159); setupStmt();
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(160); match(NEWLINE);
					}
					}
					setState(163); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170); match(T__23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PinDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AplusplusParser.ID, 0); }
		public TerminalNode ASSIGNPIN() { return getToken(AplusplusParser.ASSIGNPIN, 0); }
		public PinTypeContext pinType() {
			return getRuleContext(PinTypeContext.class,0);
		}
		public TerminalNode PIN() { return getToken(AplusplusParser.PIN, 0); }
		public HardwareTypeContext hardwareType() {
			return getRuleContext(HardwareTypeContext.class,0);
		}
		public TerminalNode ASSIGNDCL() { return getToken(AplusplusParser.ASSIGNDCL, 0); }
		public TerminalNode NONNEG_INT() { return getToken(AplusplusParser.NONNEG_INT, 0); }
		public PinDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pinDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterPinDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitPinDcl(this);
		}
	}

	public final PinDclContext pinDcl() throws RecognitionException {
		PinDclContext _localctx = new PinDclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pinDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172); match(ID);
			setState(173); match(ASSIGNDCL);
			setState(174); hardwareType();
			setState(175); match(ASSIGNPIN);
			setState(176); pinType();
			setState(177); match(PIN);
			setState(178); match(NONNEG_INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AplusplusParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGNDCL() { return getToken(AplusplusParser.ASSIGNDCL, 0); }
		public VarDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterVarDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitVarDcl(this);
		}
	}

	public final VarDclContext varDcl() throws RecognitionException {
		VarDclContext _localctx = new VarDclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180); match(ID);
			setState(181); match(ASSIGNDCL);
			setState(182); type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarAssignContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(AplusplusParser.ASSIGN, 0); }
		public TerminalNode ID() { return getToken(AplusplusParser.ID, 0); }
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public VarAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterVarAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitVarAssign(this);
		}
	}

	public final VarAssignContext varAssign() throws RecognitionException {
		VarAssignContext _localctx = new VarAssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184); match(ASSIGN);
			setState(185); match(ID);
			setState(186); expressionStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDclAssignContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(AplusplusParser.ASSIGN, 0); }
		public TerminalNode ID() { return getToken(AplusplusParser.ID, 0); }
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGNDCL() { return getToken(AplusplusParser.ASSIGNDCL, 0); }
		public VarDclAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDclAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterVarDclAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitVarDclAssign(this);
		}
	}

	public final VarDclAssignContext varDclAssign() throws RecognitionException {
		VarDclAssignContext _localctx = new VarDclAssignContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDclAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188); match(ASSIGN);
			setState(189); match(ID);
			setState(190); match(ASSIGNDCL);
			setState(191); type();
			setState(192); expressionStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AplusplusParser.ID, 0); }
		public List<GroupStmtContext> groupStmt() {
			return getRuleContexts(GroupStmtContext.class);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public GroupStmtContext groupStmt(int i) {
			return getRuleContext(GroupStmtContext.class,i);
		}
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitGroup(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_group);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); match(T__11);
			setState(195); match(ID);
			setState(197); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(196); match(NEWLINE);
				}
				}
				setState(199); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(207); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(201); groupStmt();
				setState(203); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(202); match(NEWLINE);
					}
					}
					setState(205); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(209); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(211); match(T__22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public ProgStmtBlockContext progStmtBlock() {
			return getRuleContext(ProgStmtBlockContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213); match(T__2);
			setState(215); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(214); match(NEWLINE);
				}
				}
				setState(217); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(219); progStmtBlock();
			setState(220); match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BtnActionContext extends ParserRuleContext {
		public BtnActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_btnAction; }
	 
		public BtnActionContext() { }
		public void copyFrom(BtnActionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BtnPressedContext extends BtnActionContext {
		public BtnPressedContext(BtnActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterBtnPressed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitBtnPressed(this);
		}
	}
	public static class BtnHoldContext extends BtnActionContext {
		public BtnHoldContext(BtnActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterBtnHold(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitBtnHold(this);
		}
	}
	public static class BtnDblPressedContext extends BtnActionContext {
		public BtnDblPressedContext(BtnActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterBtnDblPressed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitBtnDblPressed(this);
		}
	}

	public final BtnActionContext btnAction() throws RecognitionException {
		BtnActionContext _localctx = new BtnActionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_btnAction);
		try {
			setState(225);
			switch (_input.LA(1)) {
			case T__9:
				_localctx = new BtnPressedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(222); match(T__9);
				}
				break;
			case T__26:
				_localctx = new BtnDblPressedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(223); match(T__26);
				}
				break;
			case T__27:
				_localctx = new BtnHoldContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(224); match(T__27);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SensActionContext extends ParserRuleContext {
		public SensActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sensAction; }
	 
		public SensActionContext() { }
		public void copyFrom(SensActionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SensActiveContext extends SensActionContext {
		public SensActiveContext(SensActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterSensActive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitSensActive(this);
		}
	}

	public final SensActionContext sensAction() throws RecognitionException {
		SensActionContext _localctx = new SensActionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sensAction);
		try {
			_localctx = new SensActiveContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(227); match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimActionContext extends ParserRuleContext {
		public DimActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimAction; }
	 
		public DimActionContext() { }
		public void copyFrom(DimActionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DimChangeContext extends DimActionContext {
		public DimChangeContext(DimActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterDimChange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitDimChange(this);
		}
	}

	public final DimActionContext dimAction() throws RecognitionException {
		DimActionContext _localctx = new DimActionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_dimAction);
		try {
			_localctx = new DimChangeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(229); match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TempActionContext extends ParserRuleContext {
		public TempActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tempAction; }
	 
		public TempActionContext() { }
		public void copyFrom(TempActionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TempChangeContext extends TempActionContext {
		public TempChangeContext(TempActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterTempChange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitTempChange(this);
		}
	}

	public final TempActionContext tempAction() throws RecognitionException {
		TempActionContext _localctx = new TempActionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tempAction);
		try {
			_localctx = new TempChangeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(231); match(T__17);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScenarioDclContext extends ParserRuleContext {
		public ScenStmtBlockContext scenStmtBlock() {
			return getRuleContext(ScenStmtBlockContext.class,0);
		}
		public TerminalNode ID() { return getToken(AplusplusParser.ID, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public InputDclContext inputDcl() {
			return getRuleContext(InputDclContext.class,0);
		}
		public OutputDclContext outputDcl() {
			return getRuleContext(OutputDclContext.class,0);
		}
		public ScenarioDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scenarioDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterScenarioDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitScenarioDcl(this);
		}
	}

	public final ScenarioDclContext scenarioDcl() throws RecognitionException {
		ScenarioDclContext _localctx = new ScenarioDclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_scenarioDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233); match(T__14);
			setState(234); match(ID);
			setState(236); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(235); match(NEWLINE);
				}
				}
				setState(238); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(246);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(240); inputDcl();
				setState(242); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(241); match(NEWLINE);
					}
					}
					setState(244); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
			}

			setState(254);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(248); outputDcl();
				setState(250); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(249); match(NEWLINE);
					}
					}
					setState(252); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				break;
			}
			setState(256); scenStmtBlock();
			setState(257); match(T__25);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InputDclContext extends ParserRuleContext {
		public InputParameterContext inputParameter(int i) {
			return getRuleContext(InputParameterContext.class,i);
		}
		public List<InputParameterContext> inputParameter() {
			return getRuleContexts(InputParameterContext.class);
		}
		public InputDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterInputDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitInputDcl(this);
		}
	}

	public final InputDclContext inputDcl() throws RecognitionException {
		InputDclContext _localctx = new InputDclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_inputDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); match(T__0);
			setState(260); inputParameter();
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(261); match(T__19);
				setState(262); inputParameter();
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OutputDclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGNDCL() { return getToken(AplusplusParser.ASSIGNDCL, 0); }
		public OutputDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterOutputDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitOutputDcl(this);
		}
	}

	public final OutputDclContext outputDcl() throws RecognitionException {
		OutputDclContext _localctx = new OutputDclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_outputDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268); match(T__18);
			setState(269); match(ASSIGNDCL);
			setState(270); type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InputParameterContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AplusplusParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public InputParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterInputParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitInputParameter(this);
		}
	}

	public final InputParameterContext inputParameter() throws RecognitionException {
		InputParameterContext _localctx = new InputParameterContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_inputParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272); type();
			setState(273); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetupStmtContext extends ParserRuleContext {
		public SetupStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setupStmt; }
	 
		public SetupStmtContext() { }
		public void copyFrom(SetupStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarDeclarationAssignmentContext extends SetupStmtContext {
		public VarDclAssignContext varDclAssign() {
			return getRuleContext(VarDclAssignContext.class,0);
		}
		public VarDeclarationAssignmentContext(SetupStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterVarDeclarationAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitVarDeclarationAssignment(this);
		}
	}
	public static class PinDeclarationContext extends SetupStmtContext {
		public PinDclContext pinDcl() {
			return getRuleContext(PinDclContext.class,0);
		}
		public PinDeclarationContext(SetupStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterPinDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitPinDeclaration(this);
		}
	}
	public static class VarAssignmentContext extends SetupStmtContext {
		public VarAssignContext varAssign() {
			return getRuleContext(VarAssignContext.class,0);
		}
		public VarAssignmentContext(SetupStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterVarAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitVarAssignment(this);
		}
	}
	public static class VarDeclarationContext extends SetupStmtContext {
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public VarDeclarationContext(SetupStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitVarDeclaration(this);
		}
	}
	public static class AssertStmtContext extends SetupStmtContext {
		public AssertExprContext assertExpr() {
			return getRuleContext(AssertExprContext.class,0);
		}
		public AssertStmtContext(SetupStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterAssertStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitAssertStmt(this);
		}
	}

	public final SetupStmtContext setupStmt() throws RecognitionException {
		SetupStmtContext _localctx = new SetupStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_setupStmt);
		try {
			setState(280);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new PinDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(275); pinDcl();
				}
				break;
			case 2:
				_localctx = new VarDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(276); varDcl();
				}
				break;
			case 3:
				_localctx = new VarAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(277); varAssign();
				}
				break;
			case 4:
				_localctx = new VarDeclarationAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(278); varDclAssign();
				}
				break;
			case 5:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(279); assertExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupStmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AplusplusParser.ID, 0); }
		public GroupStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterGroupStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitGroupStmt(this);
		}
	}

	public final GroupStmtContext groupStmt() throws RecognitionException {
		GroupStmtContext _localctx = new GroupStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_groupStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgStmtContext extends ParserRuleContext {
		public ProgStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progStmt; }
	 
		public ProgStmtContext() { }
		public void copyFrom(ProgStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileStatementContext extends ProgStmtContext {
		public WhileStmtProgContext whileStmtProg() {
			return getRuleContext(WhileStmtProgContext.class,0);
		}
		public WhileStatementContext(ProgStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitWhileStatement(this);
		}
	}
	public static class EventStatementContext extends ProgStmtContext {
		public EventContext event() {
			return getRuleContext(EventContext.class,0);
		}
		public EventStatementContext(ProgStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterEventStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitEventStatement(this);
		}
	}
	public static class SetStatementContext extends ProgStmtContext {
		public VarAssignContext varAssign() {
			return getRuleContext(VarAssignContext.class,0);
		}
		public SetStatementContext(ProgStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterSetStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitSetStatement(this);
		}
	}
	public static class ExprStatementContext extends ProgStmtContext {
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public ExprStatementContext(ProgStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterExprStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitExprStatement(this);
		}
	}
	public static class IfStatementContext extends ProgStmtContext {
		public IfStmtProgContext ifStmtProg() {
			return getRuleContext(IfStmtProgContext.class,0);
		}
		public IfStatementContext(ProgStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitIfStatement(this);
		}
	}
	public static class ToggleStatementContext extends ProgStmtContext {
		public ToggleStmtContext toggleStmt() {
			return getRuleContext(ToggleStmtContext.class,0);
		}
		public ToggleStatementContext(ProgStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterToggleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitToggleStatement(this);
		}
	}
	public static class WaitStatementContext extends ProgStmtContext {
		public WaitStmtContext waitStmt() {
			return getRuleContext(WaitStmtContext.class,0);
		}
		public WaitStatementContext(ProgStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterWaitStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitWaitStatement(this);
		}
	}

	public final ProgStmtContext progStmt() throws RecognitionException {
		ProgStmtContext _localctx = new ProgStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_progStmt);
		try {
			setState(291);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new SetStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(284); varAssign();
				}
				break;
			case 2:
				_localctx = new ToggleStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(285); toggleStmt();
				}
				break;
			case 3:
				_localctx = new WaitStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(286); waitStmt();
				}
				break;
			case 4:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(287); whileStmtProg();
				}
				break;
			case 5:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(288); ifStmtProg();
				}
				break;
			case 6:
				_localctx = new ExprStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(289); expressionStatement();
				}
				break;
			case 7:
				_localctx = new EventStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(290); event();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgStmtBlockContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public List<ProgStmtContext> progStmt() {
			return getRuleContexts(ProgStmtContext.class);
		}
		public ProgStmtContext progStmt(int i) {
			return getRuleContext(ProgStmtContext.class,i);
		}
		public ProgStmtBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progStmtBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterProgStmtBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitProgStmtBlock(this);
		}
	}

	public final ProgStmtBlockContext progStmtBlock() throws RecognitionException {
		ProgStmtBlockContext _localctx = new ProgStmtBlockContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_progStmtBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__8) | (1L << T__7) | (1L << ASSIGN) | (1L << WAIT) | (1L << TGL) | (1L << LPAREN) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << ON) | (1L << OFF))) != 0) || ((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (ID - 95)) | (1L << (NONNEG_INT - 95)) | (1L << (INTEGER - 95)) | (1L << (NUMBER - 95)) | (1L << (TIME - 95)))) != 0)) {
				{
				{
				setState(293); progStmt();
				setState(295); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(294); match(NEWLINE);
					}
					}
					setState(297); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScenStmtBlockContext extends ParserRuleContext {
		public List<ScenStmtContext> scenStmt() {
			return getRuleContexts(ScenStmtContext.class);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public ScenStmtContext scenStmt(int i) {
			return getRuleContext(ScenStmtContext.class,i);
		}
		public ScenStmtBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scenStmtBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterScenStmtBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitScenStmtBlock(this);
		}
	}

	public final ScenStmtBlockContext scenStmtBlock() throws RecognitionException {
		ScenStmtBlockContext _localctx = new ScenStmtBlockContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_scenStmtBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__18) | (1L << T__8) | (1L << ASSIGN) | (1L << WAIT) | (1L << TGL) | (1L << LPAREN) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << ON) | (1L << OFF))) != 0) || ((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (ID - 95)) | (1L << (NONNEG_INT - 95)) | (1L << (INTEGER - 95)) | (1L << (NUMBER - 95)) | (1L << (TIME - 95)))) != 0)) {
				{
				{
				setState(304); scenStmt();
				setState(306); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(305); match(NEWLINE);
					}
					}
					setState(308); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScenBlockContext extends ParserRuleContext {
		public List<ScenStmtContext> scenStmt() {
			return getRuleContexts(ScenStmtContext.class);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public ScenStmtContext scenStmt(int i) {
			return getRuleContext(ScenStmtContext.class,i);
		}
		public ScenBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scenBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterScenBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitScenBlock(this);
		}
	}

	public final ScenBlockContext scenBlock() throws RecognitionException {
		ScenBlockContext _localctx = new ScenBlockContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_scenBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__18) | (1L << T__8) | (1L << ASSIGN) | (1L << WAIT) | (1L << TGL) | (1L << LPAREN) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << ON) | (1L << OFF))) != 0) || ((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (ID - 95)) | (1L << (NONNEG_INT - 95)) | (1L << (INTEGER - 95)) | (1L << (NUMBER - 95)) | (1L << (TIME - 95)))) != 0)) {
				{
				{
				setState(315); scenStmt();
				setState(317); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(316); match(NEWLINE);
					}
					}
					setState(319); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScenStmtContext extends ParserRuleContext {
		public WhileStmtScenContext whileStmtScen() {
			return getRuleContext(WhileStmtScenContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public OutputStmtContext outputStmt() {
			return getRuleContext(OutputStmtContext.class,0);
		}
		public ToggleStmtContext toggleStmt() {
			return getRuleContext(ToggleStmtContext.class,0);
		}
		public VarDclAssignContext varDclAssign() {
			return getRuleContext(VarDclAssignContext.class,0);
		}
		public WaitStmtContext waitStmt() {
			return getRuleContext(WaitStmtContext.class,0);
		}
		public IfStmtScenContext ifStmtScen() {
			return getRuleContext(IfStmtScenContext.class,0);
		}
		public VarAssignContext varAssign() {
			return getRuleContext(VarAssignContext.class,0);
		}
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public ScenStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scenStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterScenStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitScenStmt(this);
		}
	}

	public final ScenStmtContext scenStmt() throws RecognitionException {
		ScenStmtContext _localctx = new ScenStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_scenStmt);
		try {
			setState(335);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(326); toggleStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(327); ifStmtScen();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(328); varDcl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(329); varAssign();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(330); varDclAssign();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(331); outputStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(332); waitStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(333); whileStmtScen();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(334); expressionStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OutputStmtContext extends ParserRuleContext {
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public OutputStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterOutputStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitOutputStmt(this);
		}
	}

	public final OutputStmtContext outputStmt() throws RecognitionException {
		OutputStmtContext _localctx = new OutputStmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_outputStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337); match(T__18);
			setState(338); expressionStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ToggleStmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AplusplusParser.ID, 0); }
		public TerminalNode TGL() { return getToken(AplusplusParser.TGL, 0); }
		public ToggleStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toggleStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterToggleStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitToggleStmt(this);
		}
	}

	public final ToggleStmtContext toggleStmt() throws RecognitionException {
		ToggleStmtContext _localctx = new ToggleStmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_toggleStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340); match(TGL);
			setState(341); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WaitStmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AplusplusParser.ID, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public DurationLiteralContext durationLiteral() {
			return getRuleContext(DurationLiteralContext.class,0);
		}
		public TerminalNode WAIT() { return getToken(AplusplusParser.WAIT, 0); }
		public WaitStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_waitStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterWaitStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitWaitStmt(this);
		}
	}

	public final WaitStmtContext waitStmt() throws RecognitionException {
		WaitStmtContext _localctx = new WaitStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_waitStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(343); match(WAIT);
			setState(346);
			switch (_input.LA(1)) {
			case NONNEG_INT:
				{
				setState(344); durationLiteral();
				}
				break;
			case ID:
				{
				setState(345); match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(351);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(348); match(NEWLINE);
					}
					} 
				}
				setState(353);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStmtProgContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public ProgStmtBlockContext progStmtBlock() {
			return getRuleContext(ProgStmtBlockContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public WhileStmtProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmtProg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterWhileStmtProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitWhileStmtProg(this);
		}
	}

	public final WhileStmtProgContext whileStmtProg() throws RecognitionException {
		WhileStmtProgContext _localctx = new WhileStmtProgContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_whileStmtProg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354); match(T__24);
			setState(355); condition();
			setState(357); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(356); match(NEWLINE);
				}
				}
				setState(359); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(361); progStmtBlock();
			setState(362); match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStmtScenContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public ScenBlockContext scenBlock() {
			return getRuleContext(ScenBlockContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public WhileStmtScenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmtScen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterWhileStmtScen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitWhileStmtScen(this);
		}
	}

	public final WhileStmtScenContext whileStmtScen() throws RecognitionException {
		WhileStmtScenContext _localctx = new WhileStmtScenContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_whileStmtScen);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364); match(T__24);
			setState(365); condition();
			setState(367); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(366); match(NEWLINE);
				}
				}
				setState(369); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(371); scenBlock();
			setState(372); match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtProgContext extends ParserRuleContext {
		public IfElseStmtProgContext ifElseStmtProg(int i) {
			return getRuleContext(IfElseStmtProgContext.class,i);
		}
		public List<IfElseStmtProgContext> ifElseStmtProg() {
			return getRuleContexts(IfElseStmtProgContext.class);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public ProgStmtBlockContext progStmtBlock() {
			return getRuleContext(ProgStmtBlockContext.class,0);
		}
		public ElseStmtProgContext elseStmtProg() {
			return getRuleContext(ElseStmtProgContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public IfStmtProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmtProg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterIfStmtProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitIfStmtProg(this);
		}
	}

	public final IfStmtProgContext ifStmtProg() throws RecognitionException {
		IfStmtProgContext _localctx = new IfStmtProgContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_ifStmtProg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374); match(T__8);
			setState(375); condition();
			setState(377); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(376); match(NEWLINE);
				}
				}
				setState(379); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(381); progStmtBlock();
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(382); ifElseStmtProg();
				}
				}
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(389);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(388); elseStmtProg();
				}
			}

			setState(391); match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfElseStmtProgContext extends ParserRuleContext {
		public TerminalNode ELSEIF() { return getToken(AplusplusParser.ELSEIF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public ProgStmtBlockContext progStmtBlock() {
			return getRuleContext(ProgStmtBlockContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public IfElseStmtProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStmtProg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterIfElseStmtProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitIfElseStmtProg(this);
		}
	}

	public final IfElseStmtProgContext ifElseStmtProg() throws RecognitionException {
		IfElseStmtProgContext _localctx = new IfElseStmtProgContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_ifElseStmtProg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393); match(ELSEIF);
			setState(394); condition();
			setState(396); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(395); match(NEWLINE);
				}
				}
				setState(398); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(400); progStmtBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStmtProgContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(AplusplusParser.ELSE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public ProgStmtBlockContext progStmtBlock() {
			return getRuleContext(ProgStmtBlockContext.class,0);
		}
		public ElseStmtProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmtProg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterElseStmtProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitElseStmtProg(this);
		}
	}

	public final ElseStmtProgContext elseStmtProg() throws RecognitionException {
		ElseStmtProgContext _localctx = new ElseStmtProgContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_elseStmtProg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402); match(ELSE);
			setState(404); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(403); match(NEWLINE);
				}
				}
				setState(406); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(408); progStmtBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtScenContext extends ParserRuleContext {
		public ElseStmtScenContext elseStmtScen() {
			return getRuleContext(ElseStmtScenContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public List<IfElseStmtScenContext> ifElseStmtScen() {
			return getRuleContexts(IfElseStmtScenContext.class);
		}
		public ScenBlockContext scenBlock() {
			return getRuleContext(ScenBlockContext.class,0);
		}
		public IfElseStmtScenContext ifElseStmtScen(int i) {
			return getRuleContext(IfElseStmtScenContext.class,i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public IfStmtScenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmtScen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterIfStmtScen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitIfStmtScen(this);
		}
	}

	public final IfStmtScenContext ifStmtScen() throws RecognitionException {
		IfStmtScenContext _localctx = new IfStmtScenContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_ifStmtScen);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410); match(T__8);
			setState(411); condition();
			setState(413); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(412); match(NEWLINE);
				}
				}
				setState(415); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(417); scenBlock();
			setState(421);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(418); ifElseStmtScen();
				}
				}
				setState(423);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(425);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(424); elseStmtScen();
				}
			}

			setState(427); match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfElseStmtScenContext extends ParserRuleContext {
		public TerminalNode ELSEIF() { return getToken(AplusplusParser.ELSEIF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public ScenBlockContext scenBlock() {
			return getRuleContext(ScenBlockContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public IfElseStmtScenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStmtScen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterIfElseStmtScen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitIfElseStmtScen(this);
		}
	}

	public final IfElseStmtScenContext ifElseStmtScen() throws RecognitionException {
		IfElseStmtScenContext _localctx = new IfElseStmtScenContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_ifElseStmtScen);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429); match(ELSEIF);
			setState(430); condition();
			setState(432); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(431); match(NEWLINE);
				}
				}
				setState(434); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(436); scenBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStmtScenContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(AplusplusParser.ELSE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public ScenBlockContext scenBlock() {
			return getRuleContext(ScenBlockContext.class,0);
		}
		public ElseStmtScenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmtScen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterElseStmtScen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitElseStmtScen(this);
		}
	}

	public final ElseStmtScenContext elseStmtScen() throws RecognitionException {
		ElseStmtScenContext _localctx = new ElseStmtScenContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_elseStmtScen);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438); match(ELSE);
			setState(440); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(439); match(NEWLINE);
				}
				}
				setState(442); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(444); scenBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AplusplusParser.ID, 0); }
		public TerminalNode TIME() { return getToken(AplusplusParser.TIME, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(AplusplusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AplusplusParser.NEWLINE, i);
		}
		public BtnActionContext btnAction() {
			return getRuleContext(BtnActionContext.class,0);
		}
		public TempActionContext tempAction() {
			return getRuleContext(TempActionContext.class,0);
		}
		public DimActionContext dimAction() {
			return getRuleContext(DimActionContext.class,0);
		}
		public List<ProgStmtContext> progStmt() {
			return getRuleContexts(ProgStmtContext.class);
		}
		public ProgStmtContext progStmt(int i) {
			return getRuleContext(ProgStmtContext.class,i);
		}
		public SensActionContext sensAction() {
			return getRuleContext(SensActionContext.class,0);
		}
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterEvent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitEvent(this);
		}
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_event);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446); match(T__7);
			setState(456);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(447); match(TIME);
				}
				break;
			case 2:
				{
				setState(448); match(ID);
				}
				break;
			case 3:
				{
				setState(449); match(ID);
				setState(454);
				switch (_input.LA(1)) {
				case T__27:
				case T__26:
				case T__9:
					{
					setState(450); btnAction();
					}
					break;
				case T__16:
					{
					setState(451); sensAction();
					}
					break;
				case T__6:
					{
					setState(452); dimAction();
					}
					break;
				case T__17:
					{
					setState(453); tempAction();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			setState(459); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(458); match(NEWLINE);
				}
				}
				setState(461); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__8) | (1L << T__7) | (1L << ASSIGN) | (1L << WAIT) | (1L << TGL) | (1L << LPAREN) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << ON) | (1L << OFF))) != 0) || ((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (ID - 95)) | (1L << (NONNEG_INT - 95)) | (1L << (INTEGER - 95)) | (1L << (NUMBER - 95)) | (1L << (TIME - 95)))) != 0)) {
				{
				{
				setState(463); progStmt();
				setState(465); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(464); match(NEWLINE);
					}
					}
					setState(467); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(473);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(474); match(T__20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentListContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitArgumentList(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476); expression(0);
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(477); match(T__19);
				setState(478); expression(0);
				}
				}
				setState(483);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484); expressionStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitExpressionStatement(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class XorExpressionContext extends ExpressionContext {
		public TerminalNode XOR() { return getToken(AplusplusParser.XOR, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public XorExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterXorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitXorExpression(this);
		}
	}
	public static class AssignExpressionContext extends ExpressionContext {
		public TerminalNode ASSIGN() { return getToken(AplusplusParser.ASSIGN, 0); }
		public TerminalNode ID() { return getToken(AplusplusParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterAssignExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitAssignExpression(this);
		}
	}
	public static class DifferenceExpressionContext extends ExpressionContext {
		public TerminalNode LT() { return getToken(AplusplusParser.LT, 0); }
		public TerminalNode GTE() { return getToken(AplusplusParser.GTE, 0); }
		public TerminalNode GT() { return getToken(AplusplusParser.GT, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode LTE() { return getToken(AplusplusParser.LTE, 0); }
		public DifferenceExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterDifferenceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitDifferenceExpression(this);
		}
	}
	public static class ParensExpressionContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(AplusplusParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(AplusplusParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParensExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterParensExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitParensExpression(this);
		}
	}
	public static class NotExpressionContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(AplusplusParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitNotExpression(this);
		}
	}
	public static class MultDivideExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public MultDivideExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterMultDivideExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitMultDivideExpression(this);
		}
	}
	public static class OrExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(AplusplusParser.OR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public OrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitOrExpression(this);
		}
	}
	public static class ScenarioCallExpressionContext extends ExpressionContext {
		public ScenarioInvocationContext scenarioInvocation() {
			return getRuleContext(ScenarioInvocationContext.class,0);
		}
		public ScenarioCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterScenarioCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitScenarioCallExpression(this);
		}
	}
	public static class AndExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(AplusplusParser.AND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitAndExpression(this);
		}
	}
	public static class IdExpressionContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(AplusplusParser.ID, 0); }
		public IdExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterIdExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitIdExpression(this);
		}
	}
	public static class PlusMinusExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public PlusMinusExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterPlusMinusExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitPlusMinusExpression(this);
		}
	}
	public static class EqualityExpressionContext extends ExpressionContext {
		public TerminalNode EQUAL() { return getToken(AplusplusParser.EQUAL, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode NOTEQUAL() { return getToken(AplusplusParser.NOTEQUAL, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public EqualityExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitEqualityExpression(this);
		}
	}
	public static class LiteralExpressionContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitLiteralExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(489); match(NOT);
				setState(490); expression(12);
				}
				break;
			case 2:
				{
				_localctx = new AssignExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(491); match(ASSIGN);
				setState(492); match(ID);
				setState(493); expression(4);
				}
				break;
			case 3:
				{
				_localctx = new ParensExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(494); match(LPAREN);
				setState(495); expression(0);
				setState(496); match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new ScenarioCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(498); scenarioInvocation();
				}
				break;
			case 5:
				{
				_localctx = new IdExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(499); match(ID);
				}
				break;
			case 6:
				{
				_localctx = new LiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(500); literal();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(526);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(524);
					switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
					case 1:
						{
						_localctx = new MultDivideExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(503);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(504);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(505); expression(12);
						}
						break;
					case 2:
						{
						_localctx = new PlusMinusExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(506);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(507);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(508); expression(11);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(509);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(510);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(511); expression(10);
						}
						break;
					case 4:
						{
						_localctx = new EqualityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(512);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(513);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(514); expression(9);
						}
						break;
					case 5:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(515);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(516); match(AND);
						setState(517); expression(8);
						}
						break;
					case 6:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(518);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(519); match(OR);
						setState(520); expression(7);
						}
						break;
					case 7:
						{
						_localctx = new XorExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(521);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(522); match(XOR);
						setState(523); expression(6);
						}
						break;
					}
					} 
				}
				setState(528);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ScenarioInvocationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AplusplusParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(AplusplusParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(AplusplusParser.RPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ScenarioInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scenarioInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterScenarioInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitScenarioInvocation(this);
		}
	}

	public final ScenarioInvocationContext scenarioInvocation() throws RecognitionException {
		ScenarioInvocationContext _localctx = new ScenarioInvocationContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_scenarioInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529); match(ID);
			setState(530); match(LPAREN);
			setState(532);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGN) | (1L << LPAREN) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << ON) | (1L << OFF))) != 0) || ((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (ID - 95)) | (1L << (NONNEG_INT - 95)) | (1L << (INTEGER - 95)) | (1L << (NUMBER - 95)) | (1L << (TIME - 95)))) != 0)) {
				{
				setState(531); argumentList();
				}
			}

			setState(534); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TimeLiteralContext timeLiteral() {
			return getRuleContext(TimeLiteralContext.class,0);
		}
		public PercentageLiteralContext percentageLiteral() {
			return getRuleContext(PercentageLiteralContext.class,0);
		}
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public DurationLiteralContext durationLiteral() {
			return getRuleContext(DurationLiteralContext.class,0);
		}
		public IntervalLiteralContext intervalLiteral() {
			return getRuleContext(IntervalLiteralContext.class,0);
		}
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_literal);
		try {
			setState(542);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(536); intervalLiteral();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(537); timeLiteral();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(538); durationLiteral();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(539); percentageLiteral();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(540); numberLiteral();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(541); booleanLiteral();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberLiteralContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(AplusplusParser.INTEGER, 0); }
		public TerminalNode NUMBER() { return getToken(AplusplusParser.NUMBER, 0); }
		public TerminalNode NONNEG_INT() { return getToken(AplusplusParser.NONNEG_INT, 0); }
		public NumberLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitNumberLiteral(this);
		}
	}

	public final NumberLiteralContext numberLiteral() throws RecognitionException {
		NumberLiteralContext _localctx = new NumberLiteralContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_numberLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			_la = _input.LA(1);
			if ( !(((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (NONNEG_INT - 96)) | (1L << (INTEGER - 96)) | (1L << (NUMBER - 96)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimeLiteralContext extends ParserRuleContext {
		public TerminalNode TIME() { return getToken(AplusplusParser.TIME, 0); }
		public TimeLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterTimeLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitTimeLiteral(this);
		}
	}

	public final TimeLiteralContext timeLiteral() throws RecognitionException {
		TimeLiteralContext _localctx = new TimeLiteralContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_timeLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546); match(TIME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DurationLiteralContext extends ParserRuleContext {
		public HourLiteralContext hourLiteral() {
			return getRuleContext(HourLiteralContext.class,0);
		}
		public SecLiteralContext secLiteral() {
			return getRuleContext(SecLiteralContext.class,0);
		}
		public MinLiteralContext minLiteral() {
			return getRuleContext(MinLiteralContext.class,0);
		}
		public DurationLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_durationLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterDurationLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitDurationLiteral(this);
		}
	}

	public final DurationLiteralContext durationLiteral() throws RecognitionException {
		DurationLiteralContext _localctx = new DurationLiteralContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_durationLiteral);
		try {
			setState(569);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(548); hourLiteral();
				setState(550);
				switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
				case 1:
					{
					setState(549); minLiteral();
					}
					break;
				}
				setState(553);
				switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
				case 1:
					{
					setState(552); secLiteral();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(556);
				switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
				case 1:
					{
					setState(555); hourLiteral();
					}
					break;
				}
				setState(558); minLiteral();
				setState(560);
				switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
				case 1:
					{
					setState(559); secLiteral();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(563);
				switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
				case 1:
					{
					setState(562); hourLiteral();
					}
					break;
				}
				setState(566);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(565); minLiteral();
					}
					break;
				}
				setState(568); secLiteral();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HourLiteralContext extends ParserRuleContext {
		public TerminalNode NONNEG_INT() { return getToken(AplusplusParser.NONNEG_INT, 0); }
		public HourLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hourLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterHourLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitHourLiteral(this);
		}
	}

	public final HourLiteralContext hourLiteral() throws RecognitionException {
		HourLiteralContext _localctx = new HourLiteralContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_hourLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571); match(NONNEG_INT);
			setState(572); match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MinLiteralContext extends ParserRuleContext {
		public TerminalNode NONNEG_INT() { return getToken(AplusplusParser.NONNEG_INT, 0); }
		public MinLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterMinLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitMinLiteral(this);
		}
	}

	public final MinLiteralContext minLiteral() throws RecognitionException {
		MinLiteralContext _localctx = new MinLiteralContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_minLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(574); match(NONNEG_INT);
			setState(575); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SecLiteralContext extends ParserRuleContext {
		public TerminalNode NONNEG_INT() { return getToken(AplusplusParser.NONNEG_INT, 0); }
		public SecLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_secLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterSecLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitSecLiteral(this);
		}
	}

	public final SecLiteralContext secLiteral() throws RecognitionException {
		SecLiteralContext _localctx = new SecLiteralContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_secLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577); match(NONNEG_INT);
			setState(578); match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalLiteralContext extends ParserRuleContext {
		public List<TimeLiteralContext> timeLiteral() {
			return getRuleContexts(TimeLiteralContext.class);
		}
		public MonthTypeContext monthType(int i) {
			return getRuleContext(MonthTypeContext.class,i);
		}
		public List<DayTypeContext> dayType() {
			return getRuleContexts(DayTypeContext.class);
		}
		public TimeLiteralContext timeLiteral(int i) {
			return getRuleContext(TimeLiteralContext.class,i);
		}
		public TerminalNode TO() { return getToken(AplusplusParser.TO, 0); }
		public DayTypeContext dayType(int i) {
			return getRuleContext(DayTypeContext.class,i);
		}
		public List<MonthTypeContext> monthType() {
			return getRuleContexts(MonthTypeContext.class);
		}
		public IntervalLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterIntervalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitIntervalLiteral(this);
		}
	}

	public final IntervalLiteralContext intervalLiteral() throws RecognitionException {
		IntervalLiteralContext _localctx = new IntervalLiteralContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_intervalLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(580); timeLiteral();
			setState(581); match(TO);
			setState(582); timeLiteral();
			setState(587);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(585);
					switch (_input.LA(1)) {
					case MON:
					case TUE:
					case WED:
					case THU:
					case FRI:
					case SAT:
					case SUN:
						{
						setState(583); dayType();
						}
						break;
					case JAN:
					case FEB:
					case MAR:
					case APR:
					case MAY:
					case JUN:
					case JUL:
					case AUG:
					case SEP:
					case OCT:
					case NOV:
					case DEC:
						{
						setState(584); monthType();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(589);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PercentageLiteralContext extends ParserRuleContext {
		public TerminalNode NONNEG_INT() { return getToken(AplusplusParser.NONNEG_INT, 0); }
		public PercentageLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_percentageLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterPercentageLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitPercentageLiteral(this);
		}
	}

	public final PercentageLiteralContext percentageLiteral() throws RecognitionException {
		PercentageLiteralContext _localctx = new PercentageLiteralContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_percentageLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590); match(NONNEG_INT);
			setState(591); match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public HardwareTypeContext hardwareType() {
			return getRuleContext(HardwareTypeContext.class,0);
		}
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_type);
		try {
			setState(595);
			switch (_input.LA(1)) {
			case D_NUMBER:
			case D_TIME:
			case D_DURATION:
			case D_INTERVAL:
			case D_BOOLEAN:
			case D_PERCENTAGE:
				enterOuterAlt(_localctx, 1);
				{
				setState(593); datatype();
				}
				break;
			case H_BUTTON:
			case H_LIGHT:
			case H_CLIMATE:
			case H_MOTIONSENSOR:
			case H_TEMPSENSOR:
			case H_DIMMER:
				enterOuterAlt(_localctx, 2);
				{
				setState(594); hardwareType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatatypeContext extends ParserRuleContext {
		public DatatypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype; }
	 
		public DatatypeContext() { }
		public void copyFrom(DatatypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NumberContext extends DatatypeContext {
		public NumberContext(DatatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitNumber(this);
		}
	}
	public static class PercentageContext extends DatatypeContext {
		public PercentageContext(DatatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterPercentage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitPercentage(this);
		}
	}
	public static class TimeContext extends DatatypeContext {
		public TimeContext(DatatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitTime(this);
		}
	}
	public static class DurationContext extends DatatypeContext {
		public DurationContext(DatatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitDuration(this);
		}
	}
	public static class BooleanContext extends DatatypeContext {
		public BooleanContext(DatatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitBoolean(this);
		}
	}
	public static class IntervalContext extends DatatypeContext {
		public IntervalContext(DatatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterInterval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitInterval(this);
		}
	}

	public final DatatypeContext datatype() throws RecognitionException {
		DatatypeContext _localctx = new DatatypeContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_datatype);
		try {
			setState(603);
			switch (_input.LA(1)) {
			case D_NUMBER:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(597); match(D_NUMBER);
				}
				break;
			case D_TIME:
				_localctx = new TimeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(598); match(D_TIME);
				}
				break;
			case D_DURATION:
				_localctx = new DurationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(599); match(D_DURATION);
				}
				break;
			case D_INTERVAL:
				_localctx = new IntervalContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(600); match(D_INTERVAL);
				}
				break;
			case D_BOOLEAN:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(601); match(D_BOOLEAN);
				}
				break;
			case D_PERCENTAGE:
				_localctx = new PercentageContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(602); match(D_PERCENTAGE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PinTypeContext extends ParserRuleContext {
		public PinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pinType; }
	 
		public PinTypeContext() { }
		public void copyFrom(PinTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AnalogContext extends PinTypeContext {
		public AnalogContext(PinTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterAnalog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitAnalog(this);
		}
	}
	public static class DigitalContext extends PinTypeContext {
		public DigitalContext(PinTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterDigital(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitDigital(this);
		}
	}

	public final PinTypeContext pinType() throws RecognitionException {
		PinTypeContext _localctx = new PinTypeContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_pinType);
		try {
			setState(607);
			switch (_input.LA(1)) {
			case P_ANALOG:
				_localctx = new AnalogContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(605); match(P_ANALOG);
				}
				break;
			case P_DIGITAL:
				_localctx = new DigitalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(606); match(P_DIGITAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HardwareTypeContext extends ParserRuleContext {
		public HardwareTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hardwareType; }
	 
		public HardwareTypeContext() { }
		public void copyFrom(HardwareTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClimateContext extends HardwareTypeContext {
		public ClimateContext(HardwareTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterClimate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitClimate(this);
		}
	}
	public static class ButtonContext extends HardwareTypeContext {
		public ButtonContext(HardwareTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterButton(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitButton(this);
		}
	}
	public static class LightContext extends HardwareTypeContext {
		public LightContext(HardwareTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterLight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitLight(this);
		}
	}
	public static class MotionSensorContext extends HardwareTypeContext {
		public MotionSensorContext(HardwareTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterMotionSensor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitMotionSensor(this);
		}
	}
	public static class TempSensorContext extends HardwareTypeContext {
		public TempSensorContext(HardwareTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterTempSensor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitTempSensor(this);
		}
	}
	public static class DimmerContext extends HardwareTypeContext {
		public DimmerContext(HardwareTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterDimmer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitDimmer(this);
		}
	}

	public final HardwareTypeContext hardwareType() throws RecognitionException {
		HardwareTypeContext _localctx = new HardwareTypeContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_hardwareType);
		try {
			setState(615);
			switch (_input.LA(1)) {
			case H_BUTTON:
				_localctx = new ButtonContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(609); match(H_BUTTON);
				}
				break;
			case H_LIGHT:
				_localctx = new LightContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(610); match(H_LIGHT);
				}
				break;
			case H_CLIMATE:
				_localctx = new ClimateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(611); match(H_CLIMATE);
				}
				break;
			case H_MOTIONSENSOR:
				_localctx = new MotionSensorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(612); match(H_MOTIONSENSOR);
				}
				break;
			case H_TEMPSENSOR:
				_localctx = new TempSensorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(613); match(H_TEMPSENSOR);
				}
				break;
			case H_DIMMER:
				_localctx = new DimmerContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(614); match(H_DIMMER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanLiteralContext extends ParserRuleContext {
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitBooleanLiteral(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ON) | (1L << OFF))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DayTypeContext extends ParserRuleContext {
		public DayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterDayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitDayType(this);
		}
	}

	public final DayTypeContext dayType() throws RecognitionException {
		DayTypeContext _localctx = new DayTypeContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_dayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			_la = _input.LA(1);
			if ( !(((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & ((1L << (MON - 61)) | (1L << (TUE - 61)) | (1L << (WED - 61)) | (1L << (THU - 61)) | (1L << (FRI - 61)) | (1L << (SAT - 61)) | (1L << (SUN - 61)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MonthTypeContext extends ParserRuleContext {
		public MonthTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_monthType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterMonthType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitMonthType(this);
		}
	}

	public final MonthTypeContext monthType() throws RecognitionException {
		MonthTypeContext _localctx = new MonthTypeContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_monthType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
			_la = _input.LA(1);
			if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (JAN - 68)) | (1L << (FEB - 68)) | (1L << (MAR - 68)) | (1L << (APR - 68)) | (1L << (MAY - 68)) | (1L << (JUN - 68)) | (1L << (JUL - 68)) | (1L << (AUG - 68)) | (1L << (SEP - 68)) | (1L << (OCT - 68)) | (1L << (NOV - 68)) | (1L << (DEC - 68)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AplusplusParser.ID, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssertExprContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AssertExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).enterAssertExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AplusplusListener ) ((AplusplusListener)listener).exitAssertExpr(this);
		}
	}

	public final AssertExprContext assertExpr() throws RecognitionException {
		AssertExprContext _localctx = new AssertExprContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_assertExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625); match(T__15);
			setState(626); expression(0);
			setState(627); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 38: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 11);
		case 1: return precpred(_ctx, 10);
		case 2: return precpred(_ctx, 9);
		case 3: return precpred(_ctx, 8);
		case 4: return precpred(_ctx, 7);
		case 5: return precpred(_ctx, 6);
		case 6: return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3e\u0278\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\6\2"+
		"y\n\2\r\2\16\2z\3\2\3\2\6\2\177\n\2\r\2\16\2\u0080\7\2\u0083\n\2\f\2\16"+
		"\2\u0086\13\2\3\2\3\2\6\2\u008a\n\2\r\2\16\2\u008b\3\2\7\2\u008f\n\2\f"+
		"\2\16\2\u0092\13\2\3\2\7\2\u0095\n\2\f\2\16\2\u0098\13\2\3\2\3\2\3\3\3"+
		"\3\6\3\u009e\n\3\r\3\16\3\u009f\3\3\3\3\6\3\u00a4\n\3\r\3\16\3\u00a5\7"+
		"\3\u00a8\n\3\f\3\16\3\u00ab\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\6\b\u00c8\n\b\r\b\16\b\u00c9\3\b\3\b\6\b\u00ce\n\b\r\b\16\b\u00cf\6\b"+
		"\u00d2\n\b\r\b\16\b\u00d3\3\b\3\b\3\t\3\t\6\t\u00da\n\t\r\t\16\t\u00db"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\5\n\u00e4\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\16\6\16\u00ef\n\16\r\16\16\16\u00f0\3\16\3\16\6\16\u00f5\n\16"+
		"\r\16\16\16\u00f6\5\16\u00f9\n\16\3\16\3\16\6\16\u00fd\n\16\r\16\16\16"+
		"\u00fe\5\16\u0101\n\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\7\17\u010a\n"+
		"\17\f\17\16\17\u010d\13\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\5\22\u011b\n\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u0126\n\24\3\25\3\25\6\25\u012a\n\25\r\25\16\25\u012b\7\25"+
		"\u012e\n\25\f\25\16\25\u0131\13\25\3\26\3\26\6\26\u0135\n\26\r\26\16\26"+
		"\u0136\7\26\u0139\n\26\f\26\16\26\u013c\13\26\3\27\3\27\6\27\u0140\n\27"+
		"\r\27\16\27\u0141\7\27\u0144\n\27\f\27\16\27\u0147\13\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0152\n\30\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\5\33\u015d\n\33\3\33\7\33\u0160\n\33\f\33\16\33\u0163"+
		"\13\33\3\34\3\34\3\34\6\34\u0168\n\34\r\34\16\34\u0169\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\6\35\u0172\n\35\r\35\16\35\u0173\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\6\36\u017c\n\36\r\36\16\36\u017d\3\36\3\36\7\36\u0182\n\36\f"+
		"\36\16\36\u0185\13\36\3\36\5\36\u0188\n\36\3\36\3\36\3\37\3\37\3\37\6"+
		"\37\u018f\n\37\r\37\16\37\u0190\3\37\3\37\3 \3 \6 \u0197\n \r \16 \u0198"+
		"\3 \3 \3!\3!\3!\6!\u01a0\n!\r!\16!\u01a1\3!\3!\7!\u01a6\n!\f!\16!\u01a9"+
		"\13!\3!\5!\u01ac\n!\3!\3!\3\"\3\"\3\"\6\"\u01b3\n\"\r\"\16\"\u01b4\3\""+
		"\3\"\3#\3#\6#\u01bb\n#\r#\16#\u01bc\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\5$\u01c9"+
		"\n$\5$\u01cb\n$\3$\6$\u01ce\n$\r$\16$\u01cf\3$\3$\6$\u01d4\n$\r$\16$\u01d5"+
		"\7$\u01d8\n$\f$\16$\u01db\13$\3$\3$\3%\3%\3%\7%\u01e2\n%\f%\16%\u01e5"+
		"\13%\3&\3&\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u01f8\n("+
		"\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u020f"+
		"\n(\f(\16(\u0212\13(\3)\3)\3)\5)\u0217\n)\3)\3)\3*\3*\3*\3*\3*\3*\5*\u0221"+
		"\n*\3+\3+\3,\3,\3-\3-\5-\u0229\n-\3-\5-\u022c\n-\3-\5-\u022f\n-\3-\3-"+
		"\5-\u0233\n-\3-\5-\u0236\n-\3-\5-\u0239\n-\3-\5-\u023c\n-\3.\3.\3.\3/"+
		"\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\7\61\u024c\n\61\f\61\16"+
		"\61\u024f\13\61\3\62\3\62\3\62\3\63\3\63\5\63\u0256\n\63\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\5\64\u025e\n\64\3\65\3\65\5\65\u0262\n\65\3\66\3\66\3"+
		"\66\3\66\3\66\3\66\5\66\u026a\n\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3"+
		";\3;\3;\2\3N<\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprt\2\n\3\2/\60\3\2-.\3\2\61\64\3\29:"+
		"\3\2bd\3\2;>\3\2?E\3\2FQ\u02a9\2v\3\2\2\2\4\u009b\3\2\2\2\6\u00ae\3\2"+
		"\2\2\b\u00b6\3\2\2\2\n\u00ba\3\2\2\2\f\u00be\3\2\2\2\16\u00c4\3\2\2\2"+
		"\20\u00d7\3\2\2\2\22\u00e3\3\2\2\2\24\u00e5\3\2\2\2\26\u00e7\3\2\2\2\30"+
		"\u00e9\3\2\2\2\32\u00eb\3\2\2\2\34\u0105\3\2\2\2\36\u010e\3\2\2\2 \u0112"+
		"\3\2\2\2\"\u011a\3\2\2\2$\u011c\3\2\2\2&\u0125\3\2\2\2(\u012f\3\2\2\2"+
		"*\u013a\3\2\2\2,\u0145\3\2\2\2.\u0151\3\2\2\2\60\u0153\3\2\2\2\62\u0156"+
		"\3\2\2\2\64\u0159\3\2\2\2\66\u0164\3\2\2\28\u016e\3\2\2\2:\u0178\3\2\2"+
		"\2<\u018b\3\2\2\2>\u0194\3\2\2\2@\u019c\3\2\2\2B\u01af\3\2\2\2D\u01b8"+
		"\3\2\2\2F\u01c0\3\2\2\2H\u01de\3\2\2\2J\u01e6\3\2\2\2L\u01e8\3\2\2\2N"+
		"\u01f7\3\2\2\2P\u0213\3\2\2\2R\u0220\3\2\2\2T\u0222\3\2\2\2V\u0224\3\2"+
		"\2\2X\u023b\3\2\2\2Z\u023d\3\2\2\2\\\u0240\3\2\2\2^\u0243\3\2\2\2`\u0246"+
		"\3\2\2\2b\u0250\3\2\2\2d\u0255\3\2\2\2f\u025d\3\2\2\2h\u0261\3\2\2\2j"+
		"\u0269\3\2\2\2l\u026b\3\2\2\2n\u026d\3\2\2\2p\u026f\3\2\2\2r\u0271\3\2"+
		"\2\2t\u0273\3\2\2\2vx\5\4\3\2wy\7R\2\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z"+
		"{\3\2\2\2{\u0084\3\2\2\2|~\5\16\b\2}\177\7R\2\2~}\3\2\2\2\177\u0080\3"+
		"\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082|\3"+
		"\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0090\5\20\t\2\u0088\u008a\7"+
		"R\2\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\5\32\16\2\u008e\u0089\3"+
		"\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0096\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0095\7R\2\2\u0094\u0093\3\2"+
		"\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a\7\2\2\3\u009a\3\3\2\2\2"+
		"\u009b\u009d\7\31\2\2\u009c\u009e\7R\2\2\u009d\u009c\3\2\2\2\u009e\u009f"+
		"\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a9\3\2\2\2\u00a1"+
		"\u00a3\5\"\22\2\u00a2\u00a4\7R\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7"+
		"\u00a1\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2"+
		"\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\7\7\2\2\u00ad"+
		"\5\3\2\2\2\u00ae\u00af\7a\2\2\u00af\u00b0\7\"\2\2\u00b0\u00b1\5j\66\2"+
		"\u00b1\u00b2\7#\2\2\u00b2\u00b3\5h\65\2\u00b3\u00b4\7,\2\2\u00b4\u00b5"+
		"\7b\2\2\u00b5\7\3\2\2\2\u00b6\u00b7\7a\2\2\u00b7\u00b8\7\"\2\2\u00b8\u00b9"+
		"\5d\63\2\u00b9\t\3\2\2\2\u00ba\u00bb\7!\2\2\u00bb\u00bc\7a\2\2\u00bc\u00bd"+
		"\5L\'\2\u00bd\13\3\2\2\2\u00be\u00bf\7!\2\2\u00bf\u00c0\7a\2\2\u00c0\u00c1"+
		"\7\"\2\2\u00c1\u00c2\5d\63\2\u00c2\u00c3\5L\'\2\u00c3\r\3\2\2\2\u00c4"+
		"\u00c5\7\23\2\2\u00c5\u00c7\7a\2\2\u00c6\u00c8\7R\2\2\u00c7\u00c6\3\2"+
		"\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00d1\3\2\2\2\u00cb\u00cd\5$\23\2\u00cc\u00ce\7R\2\2\u00cd\u00cc\3\2"+
		"\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\u00d2\3\2\2\2\u00d1\u00cb\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2"+
		"\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\7\b\2\2\u00d6"+
		"\17\3\2\2\2\u00d7\u00d9\7\34\2\2\u00d8\u00da\7R\2\2\u00d9\u00d8\3\2\2"+
		"\2\u00da\u00db\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd"+
		"\3\2\2\2\u00dd\u00de\5(\25\2\u00de\u00df\7\33\2\2\u00df\21\3\2\2\2\u00e0"+
		"\u00e4\7\25\2\2\u00e1\u00e4\7\4\2\2\u00e2\u00e4\7\3\2\2\u00e3\u00e0\3"+
		"\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\23\3\2\2\2\u00e5"+
		"\u00e6\7\16\2\2\u00e6\25\3\2\2\2\u00e7\u00e8\7\30\2\2\u00e8\27\3\2\2\2"+
		"\u00e9\u00ea\7\r\2\2\u00ea\31\3\2\2\2\u00eb\u00ec\7\20\2\2\u00ec\u00ee"+
		"\7a\2\2\u00ed\u00ef\7R\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f8\3\2\2\2\u00f2\u00f4\5\34"+
		"\17\2\u00f3\u00f5\7R\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00f2\3\2"+
		"\2\2\u00f8\u00f9\3\2\2\2\u00f9\u0100\3\2\2\2\u00fa\u00fc\5\36\20\2\u00fb"+
		"\u00fd\7R\2\2\u00fc\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00fc\3\2"+
		"\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\3\2\2\2\u0100\u00fa\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\5*\26\2\u0103\u0104\7\5"+
		"\2\2\u0104\33\3\2\2\2\u0105\u0106\7\36\2\2\u0106\u010b\5 \21\2\u0107\u0108"+
		"\7\13\2\2\u0108\u010a\5 \21\2\u0109\u0107\3\2\2\2\u010a\u010d\3\2\2\2"+
		"\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\35\3\2\2\2\u010d\u010b"+
		"\3\2\2\2\u010e\u010f\7\f\2\2\u010f\u0110\7\"\2\2\u0110\u0111\5d\63\2\u0111"+
		"\37\3\2\2\2\u0112\u0113\5d\63\2\u0113\u0114\7a\2\2\u0114!\3\2\2\2\u0115"+
		"\u011b\5\6\4\2\u0116\u011b\5\b\5\2\u0117\u011b\5\n\6\2\u0118\u011b\5\f"+
		"\7\2\u0119\u011b\5t;\2\u011a\u0115\3\2\2\2\u011a\u0116\3\2\2\2\u011a\u0117"+
		"\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u0119\3\2\2\2\u011b#\3\2\2\2\u011c"+
		"\u011d\7a\2\2\u011d%\3\2\2\2\u011e\u0126\5\n\6\2\u011f\u0126\5\62\32\2"+
		"\u0120\u0126\5\64\33\2\u0121\u0126\5\66\34\2\u0122\u0126\5:\36\2\u0123"+
		"\u0126\5L\'\2\u0124\u0126\5F$\2\u0125\u011e\3\2\2\2\u0125\u011f\3\2\2"+
		"\2\u0125\u0120\3\2\2\2\u0125\u0121\3\2\2\2\u0125\u0122\3\2\2\2\u0125\u0123"+
		"\3\2\2\2\u0125\u0124\3\2\2\2\u0126\'\3\2\2\2\u0127\u0129\5&\24\2\u0128"+
		"\u012a\7R\2\2\u0129\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0129\3\2"+
		"\2\2\u012b\u012c\3\2\2\2\u012c\u012e\3\2\2\2\u012d\u0127\3\2\2\2\u012e"+
		"\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130)\3\2\2\2"+
		"\u0131\u012f\3\2\2\2\u0132\u0134\5.\30\2\u0133\u0135\7R\2\2\u0134\u0133"+
		"\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137"+
		"\u0139\3\2\2\2\u0138\u0132\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2"+
		"\2\2\u013a\u013b\3\2\2\2\u013b+\3\2\2\2\u013c\u013a\3\2\2\2\u013d\u013f"+
		"\5.\30\2\u013e\u0140\7R\2\2\u013f\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141"+
		"\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0144\3\2\2\2\u0143\u013d\3\2"+
		"\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146"+
		"-\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u0152\5\62\32\2\u0149\u0152\5@!\2"+
		"\u014a\u0152\5\b\5\2\u014b\u0152\5\n\6\2\u014c\u0152\5\f\7\2\u014d\u0152"+
		"\5\60\31\2\u014e\u0152\5\64\33\2\u014f\u0152\58\35\2\u0150\u0152\5L\'"+
		"\2\u0151\u0148\3\2\2\2\u0151\u0149\3\2\2\2\u0151\u014a\3\2\2\2\u0151\u014b"+
		"\3\2\2\2\u0151\u014c\3\2\2\2\u0151\u014d\3\2\2\2\u0151\u014e\3\2\2\2\u0151"+
		"\u014f\3\2\2\2\u0151\u0150\3\2\2\2\u0152/\3\2\2\2\u0153\u0154\7\f\2\2"+
		"\u0154\u0155\5L\'\2\u0155\61\3\2\2\2\u0156\u0157\7%\2\2\u0157\u0158\7"+
		"a\2\2\u0158\63\3\2\2\2\u0159\u015c\7$\2\2\u015a\u015d\5X-\2\u015b\u015d"+
		"\7a\2\2\u015c\u015a\3\2\2\2\u015c\u015b\3\2\2\2\u015d\u0161\3\2\2\2\u015e"+
		"\u0160\7R\2\2\u015f\u015e\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u015f\3\2"+
		"\2\2\u0161\u0162\3\2\2\2\u0162\65\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0165"+
		"\7\6\2\2\u0165\u0167\5J&\2\u0166\u0168\7R\2\2\u0167\u0166\3\2\2\2\u0168"+
		"\u0169\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\3\2"+
		"\2\2\u016b\u016c\5(\25\2\u016c\u016d\7\32\2\2\u016d\67\3\2\2\2\u016e\u016f"+
		"\7\6\2\2\u016f\u0171\5J&\2\u0170\u0172\7R\2\2\u0171\u0170\3\2\2\2\u0172"+
		"\u0173\3\2\2\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\3\2"+
		"\2\2\u0175\u0176\5,\27\2\u0176\u0177\7\32\2\2\u01779\3\2\2\2\u0178\u0179"+
		"\7\26\2\2\u0179\u017b\5J&\2\u017a\u017c\7R\2\2\u017b\u017a\3\2\2\2\u017c"+
		"\u017d\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\3\2"+
		"\2\2\u017f\u0183\5(\25\2\u0180\u0182\5<\37\2\u0181\u0180\3\2\2\2\u0182"+
		"\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0187\3\2"+
		"\2\2\u0185\u0183\3\2\2\2\u0186\u0188\5> \2\u0187\u0186\3\2\2\2\u0187\u0188"+
		"\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\7\24\2\2\u018a;\3\2\2\2\u018b"+
		"\u018c\7(\2\2\u018c\u018e\5J&\2\u018d\u018f\7R\2\2\u018e\u018d\3\2\2\2"+
		"\u018f\u0190\3\2\2\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0192"+
		"\3\2\2\2\u0192\u0193\5(\25\2\u0193=\3\2\2\2\u0194\u0196\7)\2\2\u0195\u0197"+
		"\7R\2\2\u0196\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u0196\3\2\2\2\u0198"+
		"\u0199\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\5(\25\2\u019b?\3\2\2\2"+
		"\u019c\u019d\7\26\2\2\u019d\u019f\5J&\2\u019e\u01a0\7R\2\2\u019f\u019e"+
		"\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2"+
		"\u01a3\3\2\2\2\u01a3\u01a7\5,\27\2\u01a4\u01a6\5B\"\2\u01a5\u01a4\3\2"+
		"\2\2\u01a6\u01a9\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8"+
		"\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2\u01aa\u01ac\5D#\2\u01ab\u01aa\3\2\2"+
		"\2\u01ab\u01ac\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\7\24\2\2\u01ae"+
		"A\3\2\2\2\u01af\u01b0\7(\2\2\u01b0\u01b2\5J&\2\u01b1\u01b3\7R\2\2\u01b2"+
		"\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2"+
		"\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\5,\27\2\u01b7C\3\2\2\2\u01b8\u01ba"+
		"\7)\2\2\u01b9\u01bb\7R\2\2\u01ba\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc"+
		"\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\5,"+
		"\27\2\u01bfE\3\2\2\2\u01c0\u01ca\7\27\2\2\u01c1\u01cb\7e\2\2\u01c2\u01cb"+
		"\7a\2\2\u01c3\u01c8\7a\2\2\u01c4\u01c9\5\22\n\2\u01c5\u01c9\5\24\13\2"+
		"\u01c6\u01c9\5\26\f\2\u01c7\u01c9\5\30\r\2\u01c8\u01c4\3\2\2\2\u01c8\u01c5"+
		"\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8\u01c7\3\2\2\2\u01c9\u01cb\3\2\2\2\u01ca"+
		"\u01c1\3\2\2\2\u01ca\u01c2\3\2\2\2\u01ca\u01c3\3\2\2\2\u01cb\u01cd\3\2"+
		"\2\2\u01cc\u01ce\7R\2\2\u01cd\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf"+
		"\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d9\3\2\2\2\u01d1\u01d3\5&"+
		"\24\2\u01d2\u01d4\7R\2\2\u01d3\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5"+
		"\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d8\3\2\2\2\u01d7\u01d1\3\2"+
		"\2\2\u01d8\u01db\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da"+
		"\u01dc\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc\u01dd\7\n\2\2\u01ddG\3\2\2\2"+
		"\u01de\u01e3\5N(\2\u01df\u01e0\7\13\2\2\u01e0\u01e2\5N(\2\u01e1\u01df"+
		"\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4"+
		"I\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01e7\5L\'\2\u01e7K\3\2\2\2\u01e8"+
		"\u01e9\5N(\2\u01e9M\3\2\2\2\u01ea\u01eb\b(\1\2\u01eb\u01ec\78\2\2\u01ec"+
		"\u01f8\5N(\16\u01ed\u01ee\7!\2\2\u01ee\u01ef\7a\2\2\u01ef\u01f8\5N(\6"+
		"\u01f0\u01f1\7*\2\2\u01f1\u01f2\5N(\2\u01f2\u01f3\7+\2\2\u01f3\u01f8\3"+
		"\2\2\2\u01f4\u01f8\5P)\2\u01f5\u01f8\7a\2\2\u01f6\u01f8\5R*\2\u01f7\u01ea"+
		"\3\2\2\2\u01f7\u01ed\3\2\2\2\u01f7\u01f0\3\2\2\2\u01f7\u01f4\3\2\2\2\u01f7"+
		"\u01f5\3\2\2\2\u01f7\u01f6\3\2\2\2\u01f8\u0210\3\2\2\2\u01f9\u01fa\f\r"+
		"\2\2\u01fa\u01fb\t\2\2\2\u01fb\u020f\5N(\16\u01fc\u01fd\f\f\2\2\u01fd"+
		"\u01fe\t\3\2\2\u01fe\u020f\5N(\r\u01ff\u0200\f\13\2\2\u0200\u0201\t\4"+
		"\2\2\u0201\u020f\5N(\f\u0202\u0203\f\n\2\2\u0203\u0204\t\5\2\2\u0204\u020f"+
		"\5N(\13\u0205\u0206\f\t\2\2\u0206\u0207\7\66\2\2\u0207\u020f\5N(\n\u0208"+
		"\u0209\f\b\2\2\u0209\u020a\7\65\2\2\u020a\u020f\5N(\t\u020b\u020c\f\7"+
		"\2\2\u020c\u020d\7\67\2\2\u020d\u020f\5N(\b\u020e\u01f9\3\2\2\2\u020e"+
		"\u01fc\3\2\2\2\u020e\u01ff\3\2\2\2\u020e\u0202\3\2\2\2\u020e\u0205\3\2"+
		"\2\2\u020e\u0208\3\2\2\2\u020e\u020b\3\2\2\2\u020f\u0212\3\2\2\2\u0210"+
		"\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211O\3\2\2\2\u0212\u0210\3\2\2\2"+
		"\u0213\u0214\7a\2\2\u0214\u0216\7*\2\2\u0215\u0217\5H%\2\u0216\u0215\3"+
		"\2\2\2\u0216\u0217\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0219\7+\2\2\u0219"+
		"Q\3\2\2\2\u021a\u0221\5`\61\2\u021b\u0221\5V,\2\u021c\u0221\5X-\2\u021d"+
		"\u0221\5b\62\2\u021e\u0221\5T+\2\u021f\u0221\5l\67\2\u0220\u021a\3\2\2"+
		"\2\u0220\u021b\3\2\2\2\u0220\u021c\3\2\2\2\u0220\u021d\3\2\2\2\u0220\u021e"+
		"\3\2\2\2\u0220\u021f\3\2\2\2\u0221S\3\2\2\2\u0222\u0223\t\6\2\2\u0223"+
		"U\3\2\2\2\u0224\u0225\7e\2\2\u0225W\3\2\2\2\u0226\u0228\5Z.\2\u0227\u0229"+
		"\5\\/\2\u0228\u0227\3\2\2\2\u0228\u0229\3\2\2\2\u0229\u022b\3\2\2\2\u022a"+
		"\u022c\5^\60\2\u022b\u022a\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u023c\3\2"+
		"\2\2\u022d\u022f\5Z.\2\u022e\u022d\3\2\2\2\u022e\u022f\3\2\2\2\u022f\u0230"+
		"\3\2\2\2\u0230\u0232\5\\/\2\u0231\u0233\5^\60\2\u0232\u0231\3\2\2\2\u0232"+
		"\u0233\3\2\2\2\u0233\u023c\3\2\2\2\u0234\u0236\5Z.\2\u0235\u0234\3\2\2"+
		"\2\u0235\u0236\3\2\2\2\u0236\u0238\3\2\2\2\u0237\u0239\5\\/\2\u0238\u0237"+
		"\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u023c\5^\60\2\u023b"+
		"\u0226\3\2\2\2\u023b\u022e\3\2\2\2\u023b\u0235\3\2\2\2\u023cY\3\2\2\2"+
		"\u023d\u023e\7b\2\2\u023e\u023f\7\22\2\2\u023f[\3\2\2\2\u0240\u0241\7"+
		"b\2\2\u0241\u0242\7\t\2\2\u0242]\3\2\2\2\u0243\u0244\7b\2\2\u0244\u0245"+
		"\7\21\2\2\u0245_\3\2\2\2\u0246\u0247\5V,\2\u0247\u0248\7\'\2\2\u0248\u024d"+
		"\5V,\2\u0249\u024c\5n8\2\u024a\u024c\5p9\2\u024b\u0249\3\2\2\2\u024b\u024a"+
		"\3\2\2\2\u024c\u024f\3\2\2\2\u024d\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024e"+
		"a\3\2\2\2\u024f\u024d\3\2\2\2\u0250\u0251\7b\2\2\u0251\u0252\7\35\2\2"+
		"\u0252c\3\2\2\2\u0253\u0256\5f\64\2\u0254\u0256\5j\66\2\u0255\u0253\3"+
		"\2\2\2\u0255\u0254\3\2\2\2\u0256e\3\2\2\2\u0257\u025e\7S\2\2\u0258\u025e"+
		"\7T\2\2\u0259\u025e\7U\2\2\u025a\u025e\7V\2\2\u025b\u025e\7W\2\2\u025c"+
		"\u025e\7X\2\2\u025d\u0257\3\2\2\2\u025d\u0258\3\2\2\2\u025d\u0259\3\2"+
		"\2\2\u025d\u025a\3\2\2\2\u025d\u025b\3\2\2\2\u025d\u025c\3\2\2\2\u025e"+
		"g\3\2\2\2\u025f\u0262\7Y\2\2\u0260\u0262\7Z\2\2\u0261\u025f\3\2\2\2\u0261"+
		"\u0260\3\2\2\2\u0262i\3\2\2\2\u0263\u026a\7[\2\2\u0264\u026a\7\\\2\2\u0265"+
		"\u026a\7]\2\2\u0266\u026a\7^\2\2\u0267\u026a\7_\2\2\u0268\u026a\7`\2\2"+
		"\u0269\u0263\3\2\2\2\u0269\u0264\3\2\2\2\u0269\u0265\3\2\2\2\u0269\u0266"+
		"\3\2\2\2\u0269\u0267\3\2\2\2\u0269\u0268\3\2\2\2\u026ak\3\2\2\2\u026b"+
		"\u026c\t\7\2\2\u026cm\3\2\2\2\u026d\u026e\t\b\2\2\u026eo\3\2\2\2\u026f"+
		"\u0270\t\t\2\2\u0270q\3\2\2\2\u0271\u0272\7a\2\2\u0272s\3\2\2\2\u0273"+
		"\u0274\7\17\2\2\u0274\u0275\5N(\2\u0275\u0276\5N(\2\u0276u\3\2\2\2Ez\u0080"+
		"\u0084\u008b\u0090\u0096\u009f\u00a5\u00a9\u00c9\u00cf\u00d3\u00db\u00e3"+
		"\u00f0\u00f6\u00f8\u00fe\u0100\u010b\u011a\u0125\u012b\u012f\u0136\u013a"+
		"\u0141\u0145\u0151\u015c\u0161\u0169\u0173\u017d\u0183\u0187\u0190\u0198"+
		"\u01a1\u01a7\u01ab\u01b4\u01bc\u01c8\u01ca\u01cf\u01d5\u01d9\u01e3\u01f7"+
		"\u020e\u0210\u0216\u0220\u0228\u022b\u022e\u0232\u0235\u0238\u023b\u024b"+
		"\u024d\u0255\u025d\u0261\u0269";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}