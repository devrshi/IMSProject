/* Generated By:JavaCC: Do not edit this line. JSON.java */
package org.ofbiz.base.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javolution.util.FastMap;

import org.ofbiz.base.util.UtilIO;

@SuppressWarnings("all") public class JSON implements JSONConstants {
    private boolean allowResolve;

    public JSON(String fileName) {
        this(System.in);
        try { ReInit(new FileInputStream(new File(fileName))); }
        catch(Exception e) { e.printStackTrace(); }
//        allowed[TEXT] = 1;
//        allowed[FIRST_COLUMN_TEXT] = 1;
    }

    public JSON allowResolve(boolean allowResolve) {
        this.allowResolve = allowResolve;
    token_source.SwitchTo(allowResolve ? RESOLVE : DEFAULT);
    return this;
    }

  final public Object JSONValue() throws ParseException {
  Object value;
    value = JSONItem();
    jj_consume_token(0);
    {if (true) return value;}
    throw new Error("Missing return statement in function");
  }

  final public Object JSONItem() throws ParseException {
  Object value;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING_START:
      value = JSONString();
      break;
    case WHOLE_NUMBER:
      value = JSONLong();
      break;
    case FLOAT_NUMBER:
      value = JSONFloat();
      break;
    case OBJECT_BEGIN:
      value = JSONObject();
      break;
    case ARRAY_BEGIN:
      value = JSONArray();
      break;
    case TRUE:
      value = True();
      break;
    case FALSE:
      value = False();
      break;
    case NULL:
      value = Null();
      break;
    case RESOLVE_BEGIN:
      value = JSONResolve();
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return value;}
    throw new Error("Missing return statement in function");
  }

  final public Object JSONResolve() throws ParseException {
  String name, value;
    jj_consume_token(RESOLVE_BEGIN);
    value = JSONString();
    jj_consume_token(CLOSE_PAREN);
    try {
      {if (true) return UtilIO.readObject(value.toCharArray());}
    } catch (ClassNotFoundException e) {
      {if (true) throw generateParseException();}
    } catch (IOException e) {
      {if (true) throw generateParseException();}
    }
    throw new Error("Missing return statement in function");
  }

  final public String JSONString() throws ParseException {
  StringBuilder sb = new StringBuilder();
    jj_consume_token(STRING_START);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CHARACTER:
      case CONTROL_CHAR:
      case UNICODE:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CHARACTER:
        jj_consume_token(CHARACTER);
                  sb.append(getToken(0).image);
        break;
      case CONTROL_CHAR:
        jj_consume_token(CONTROL_CHAR);
    switch (getToken(0).image.charAt(1)) {
      case '"': sb.append('"'); break;
      case '\u005c\u005c': sb.append('\u005c\u005c'); break;
      case '/': sb.append('/'); break;
      case 'b': sb.append('\u005cb'); break;
      case 'f': sb.append('\u005cf'); break;
      case 'n': sb.append('\u005cn'); break;
      case 'r': sb.append('\u005cr'); break;
      case 't': sb.append('\u005ct'); break;
    }
        break;
      case UNICODE:
        jj_consume_token(UNICODE);
    int v = Integer.parseInt(getToken(0).image.substring(2), 16);
    sb.append((char) v);
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(STRING_END);
    {if (true) return sb.toString();}
    throw new Error("Missing return statement in function");
  }

  final public Long JSONLong() throws ParseException {
    try {
      jj_consume_token(WHOLE_NUMBER);
                     {if (true) return new Long(getToken(0).image);}
    } catch (NumberFormatException e) {
    {if (true) throw generateParseException();}
    }
    throw new Error("Missing return statement in function");
  }

  final public Double JSONFloat() throws ParseException {
    try {
      jj_consume_token(FLOAT_NUMBER);
                     {if (true) return new Double(getToken(0).image);}
    } catch (NumberFormatException e) {
    {if (true) throw generateParseException();}
    }
    throw new Error("Missing return statement in function");
  }

  final public Map<String, Object> JSONObject() throws ParseException {
  Map<String, Object> map = FastMap.newInstance();
    jj_consume_token(OBJECT_BEGIN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING_START:
      JSONObjectEntry(map);
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ITEM_SEP:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_2;
      }
      jj_consume_token(ITEM_SEP);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STRING_START:
        JSONObjectEntry(map);
        break;
      default:
        jj_la1[5] = jj_gen;
        ;
      }
    }
    jj_consume_token(OBJECT_END);
    {if (true) return map;}
    throw new Error("Missing return statement in function");
  }

  final public void JSONObjectEntry(Map<String, Object> map) throws ParseException {
  String key;
  Object value;
    key = JSONString();
    jj_consume_token(KEY_SEP);
    value = JSONItem();
    map.put(key, value);
  }

  final public List<Object> JSONArray() throws ParseException {
  ArrayList<Object> list = new ArrayList<Object>();
  Object value;
    jj_consume_token(ARRAY_BEGIN);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ITEM_SEP:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_3;
      }
      jj_consume_token(ITEM_SEP);
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OBJECT_BEGIN:
    case ARRAY_BEGIN:
    case TRUE:
    case FALSE:
    case NULL:
    case WHOLE_NUMBER:
    case FLOAT_NUMBER:
    case STRING_START:
    case RESOLVE_BEGIN:
      value = JSONItem();
                       list.add(value);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ITEM_SEP:
          ;
          break;
        default:
          jj_la1[7] = jj_gen;
          break label_4;
        }
        jj_consume_token(ITEM_SEP);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case OBJECT_BEGIN:
        case ARRAY_BEGIN:
        case TRUE:
        case FALSE:
        case NULL:
        case WHOLE_NUMBER:
        case FLOAT_NUMBER:
        case STRING_START:
        case RESOLVE_BEGIN:
          value = JSONItem();
                          list.add(value);
          break;
        default:
          jj_la1[8] = jj_gen;
          ;
        }
      }
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    jj_consume_token(ARRAY_END);
    {if (true) return list;}
    throw new Error("Missing return statement in function");
  }

  final public Boolean True() throws ParseException {
    jj_consume_token(TRUE);
           {if (true) return Boolean.TRUE;}
    throw new Error("Missing return statement in function");
  }

  final public Boolean False() throws ParseException {
    jj_consume_token(FALSE);
            {if (true) return Boolean.FALSE;}
    throw new Error("Missing return statement in function");
  }

  final public Object Null() throws ParseException {
    jj_consume_token(NULL);
           {if (true) return null;}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public JSONTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[10];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xaf8a,0xd0000,0xd0000,0x2000,0x20,0x2000,0x20,0x20,0xaf8a,0xaf8a,};
   }

  /** Constructor with InputStream. */
  public JSON(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public JSON(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new JSONTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public JSON(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new JSONTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public JSON(JSONTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(JSONTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[24];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 10; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 24; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
