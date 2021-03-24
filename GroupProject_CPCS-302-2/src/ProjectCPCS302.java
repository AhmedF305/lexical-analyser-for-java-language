
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Character;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import java.util.Scanner;
//lexical analyser for java language 
// GROUP MEMBERS :-
//============================
// MEMBER 1 : 
// NAME : Ahmed ALmutairi
// ID : 1740898
//============================
// MEMBER 2 : 
// NAME : Ahmed Hedaya
// ID : 1743728
//============================
public class ProjectCPCS302 {

    public static void main(String[] args) throws FileNotFoundException {
       
        char LookHead[] = tokenizer().toCharArray();
        int count = 0;
        String Lexemes[] = new String[LookHead.length];
        String Tokens[] = new String[LookHead.length];
        int state = 0;
        StringBuilder s = new StringBuilder();
        int i = 0;
       
        while (i != LookHead.length) {
            switch (state) {
                
                case 0:
                    if (LookHead[i] == '\n') {
                        
                    }
                    if (LookHead[i] == '\r' || LookHead[i] == '\t' || LookHead[i] == ' '
                            || LookHead[i] == '\n') {
                        state = 0;
                        i++;

                    } else if (LookHead[i] == '_' || LookHead[i] == '$' || isLetter(LookHead[i])) {
                        s.delete(0, s.length());

                        state = 1;

                    } else if (Character.isDigit(LookHead[i])) {
                        s.delete(0, s.length());

                        state = 3;
                    } else if (LookHead[i] == '+') {
                        s.delete(0, s.length());

                        state = 8;
                    } else if (LookHead[i] == '-') {
                        s.delete(0, s.length());

                        state = 12;
                    } else if (LookHead[i] == '*') {
                        s.delete(0, s.length());

                        state = 16;
                    }//
                    else if (LookHead[i] == '/') {
                        s.delete(0, s.length());

                        state = 19;
                    } else if (LookHead[i] == '%') {
                        s.delete(0, s.length());

                        state = 22;
                    } else if (LookHead[i] == '=') {
                        s.delete(0, s.length());

                        state = 25;
                    } else if (LookHead[i] == '!') {
                        s.delete(0, s.length());

                        state = 28;
                    } else if (LookHead[i] == '>') {
                        s.delete(0, s.length());

                        state = 31;
                    } else if (LookHead[i] == '<') {
                        s.delete(0, s.length());

                        state = 39;
                    } else if (LookHead[i] == '&') {
                        s.delete(0, s.length());

                        state = 45;
                    } else if (LookHead[i] == '|') {
                        s.delete(0, s.length());

                        state = 49;
                    } else if (LookHead[i] == '^') {
                        s.delete(0, s.length());

                        state = 53;
                    } else if (LookHead[i] == '"') {
                        s.delete(0, s.length());

                        state = 60;
                    } else if (LookHead[i] == '\'') {
                        s.delete(0, s.length());

                        state = 62;
                    } else if (LookHead[i] == ';') {
                        s.delete(0, s.length());

                        state = 66;
                    } else if (LookHead[i] == ',') {//
                        s.delete(0, s.length());

                        state = 67;
                    } else if (LookHead[i] == ':') {
                        s.delete(0, s.length());

                        state = 68;
                    } else if (LookHead[i] == '?') {
                        s.delete(0, s.length());

                        state = 69;
                    } else if (LookHead[i] == '{') {
                        s.delete(0, s.length());

                        state = 70;
                    } else if (LookHead[i] == '}') {
                        s.delete(0, s.length());

                        state = 71;
                    } else if (LookHead[i] == '(') {
                        s.delete(0, s.length());

                        state = 72;
                    } else if (LookHead[i] == ')') {
                        s.delete(0, s.length());

                        state = 73;
                    } else if (LookHead[i] == '[') {
                        s.delete(0, s.length());

                        state = 74;
                    } else if (LookHead[i] == ']') {
                        s.delete(0, s.length());

                        state = 75;
                    } else if (LookHead[i] == '.') {
                        s.delete(0, s.length());

                        state = 76;
                    } else if (LookHead[i] == '@') {
                        s.delete(0, s.length());

                        state = 78;
                    } else if (LookHead[i] == '~') {
                        s.delete(0, s.length());

                        state = 79;
                    }else if (LookHead[i] == '\\') {
                        s.delete(0, s.length());

                        state = 85;
                    } else {
                        i++;
                    }

                    ////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////                    
                    break;
                case 1:
                    while (isLetter(LookHead[i]) || isDigit(LookHead[i]) || LookHead[i] == '_' || LookHead[i] == '$') {
                        s.append(LookHead[i]);
                        i++;
                    }

                    state = 2;
                    break;

                case 2:
                    Lexemes[count] = s.toString();
                    if (ResevedWord(s.toString())) {
                        if (s.toString() == "true") {
                            state = 64;
                        } else if (s.toString() == "false") {
                            state = 65;
                        }
                        Tokens[count] = s.toString();
                    } else {
                        Tokens[count] = "id";
                    }
                    state = 0;
                    count++;

                    break;
                case 3:
                    while (isDigit(LookHead[i])) {
                        s.append(LookHead[i]);
                        i++;
                    }

                    if (LookHead[i] == '.') {
                        state = 4;
                    } else {
                        state = 7;
                    }

                    break;
                case 4:
                    s.append(LookHead[i]);
                    i++;
                    while (isDigit(LookHead[i])) {
                        s.append(LookHead[i]);
                        i++;
                    }

                    if (LookHead[i] == 'f') {
                        state = 5;
                    } else {
                        state = 6;
                    }

                    break;

                case 5:
                    s.append(LookHead[i]);
                    Lexemes[count] = s.toString();
                    Tokens[count] = "float_Literal";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 6:
                    Lexemes[count] = s.toString();
                    Tokens[count] = "double_Literal";
                    count++;
                    state = 0;
                    // i++;
                    break;
                case 7:
                    Lexemes[count] = s.toString();
                    Tokens[count] = "Int_Literal";
                    count++;
                    state = 0;
                    //  i++;
                    break;
                case 8:
                    if (LookHead[i + 1] == '+') {
                        i++;
                        state = 9;
                    } else if (LookHead[i + 1] == '=') {
                        i++;
                        state = 10;
                    } else {
                        state = 11;
                    }
                    break;
                case 9:
                    Lexemes[count] = "++";
                    Tokens[count] = "Inc_Op";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 10:
                    Lexemes[count] = "+=";
                    Tokens[count] = "addition assignment operator";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 11:
                    Lexemes[count] = "+";
                    Tokens[count] = "arithmetic plus ";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 12:
                    if (LookHead[i + 1] == '-') {
                        i++;
                        state = 13;
                    } else if (LookHead[i + 1] == '=') {
                        i++;
                        state = 14;
                    } else {
                        state = 15;
                    }
                    break;
                case 13:
                    Lexemes[count] = "--";
                    Tokens[count] = "Dec_Op";
                    count++;
                    state = 0;
                    i++;

                    break;
                case 14:
                    Lexemes[count] = "-=";
                    Tokens[count] = "subtraction assignment operator";
                    count++;
                    state = 0;
                    i++;

                    break;
                case 15:
                    Lexemes[count] = "-";
                    Tokens[count] = "arithmetic minus ";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 16:
                    if (LookHead[i + 1] == '=') {
                        i++;
                        state = 17;
                    } else {
                        state = 18;
                    }
                    break;
                case 17:
                    Lexemes[count] = "*=";
                    Tokens[count] = "Multiplication assignment operator";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 18:
                    Lexemes[count] = "*";
                    Tokens[count] = "arithmetic multiplication";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 19:
                    if (LookHead[i + 1] == '=') {
                        state = 20;
                        i++;
                    } else if (LookHead[i + 1] == '/') {
                        state = 56;
                        i++;
                    } else if (LookHead[i + 1] == '*') {
                        state = 58;
                        i++;
                    } else {
                        state = 21;
                    }
                    break;
                case 20:
                    Lexemes[count] = "/=";
                    Tokens[count] = "Division assignment operator";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 21:
                    Lexemes[count] = "/";
                    Tokens[count] = "arithmetic Division";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 22:
                    if (LookHead[i + 1] == '=') {
                        state = 23;
                        i++;
                    } else {
                        state = 24;
                    }
                    break;
                case 23:
                    Lexemes[count] = "%";
                    Tokens[count] = "arithmetic Modulus";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 24:
                    Lexemes[count] = "%=";
                    Tokens[count] = "Modulus assignment operator";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 25:
                    if (LookHead[i + 1] == '=') {
                        state = 26;
                        i++;
                    } else {
                        state = 27;
                    }
                    break;
                case 26:
                    Lexemes[count] = "==";
                    Tokens[count] = "equal to";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 27:
                    Lexemes[count] = "=";
                    Tokens[count] = "Assign_Op";
                    count++;
                    state = 0;
                    i++;

                    break;
                case 28:
                    if (LookHead[i + 1] == '=') {
                        state = 29;
                        i++;
                    } else {
                        state = 30;
                    }
                    break;
                case 29:
                    Lexemes[count] = "!=";
                    Tokens[count] = "not equal to ";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 30:
                    Lexemes[count] = "!";
                    Tokens[count] = "Logical NOT Operator";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 31:
                    if (LookHead[i + 1] == '=') {
                        state = 32;
                        i++;
                    } else if (LookHead[i + 1] == '>') {
                        state = 33;
                        i++;
                    } else {
                        state = 38;
                    }
                    break;
                case 32:
                    Lexemes[count] = ">=";
                    Tokens[count] = "greater than or equal to ";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 33:
                    if (LookHead[i + 1] == '=') {
                        state = 34;
                        i++;
                    } else if (LookHead[i + 1] == '>') {
                        state = 35;
                        i++;
                    } else {
                        state = 37;
                    }

                    break;
                case 34:
                    Lexemes[count] = ">>=";
                    Tokens[count] = "Right shift AND assignment operator. ";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 35:
                    if (LookHead[i + 1] == '=') {
                        state = 36;
                        i++;
                    } else {
                       Lexemes[count] = ">>>";
                    Tokens[count] = "Unsigned Right shift operator ";
                    count++;
                    state = 0;
                    i++;
                        
                    }
                    break;
                case 36:
                    Lexemes[count] = ">>>=";
                    Tokens[count] = "compound right-shift filled 0 assignment operator ";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 37:
                    Lexemes[count] = ">>";
                    Tokens[count] = "right shift ";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 38:
                    Lexemes[count] = ">";
                    Tokens[count] = "greater than";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 39:
                    if (LookHead[i + 1] == '=') {

                        state = 40;
                        i++;
                    } else if (LookHead[i + 1] == '<') {
                        state = 41;
                        i++;
                    } else {
                        state = 44;
                    }
                    break;
                case 40:
                    Lexemes[count] = "<=";
                    Tokens[count] = " less than or equal to";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 41:
                    if (LookHead[i + 1] == '=') {
                        state = 42;
                        i++;
                    } else {
                        state = 43;
                    }
                    break;
                case 42:
                    Lexemes[count] = "<<=";
                    Tokens[count] = "left shift AND assignment operator. ";
                    count++;
                    state = 0;
                    i++;
                            
                    break;
                case 43:
                    Lexemes[count] = "<<";
                    Tokens[count] = "left shift ";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 44:
                    Lexemes[count] = "<";
                    Tokens[count] = "less than";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 45:
                    if (LookHead[i + 1] == '&') {
                        state = 46;
                        i++;
                    } else if (LookHead[i + 1] == '=') {
                        state = 47;
                        i++;
                    } else {
                        state = 48;
                    }
                    break;
                case 46:
                    Lexemes[count] = "&&";
                    Tokens[count] = "logical and";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 47:
                    Lexemes[count] = "&=";
                    Tokens[count] = "Bitwise AND assignment operator";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 48:
                    Lexemes[count] = "&";
                    Tokens[count] = "bitwise and";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 49:
                    if (LookHead[i + 1] == '|') {
                        state = 50;
                        i++;
                    } else if (LookHead[i + 1] == '=') {
                        state = 51;
                        i++;
                    } else {
                        state = 52;
                    }
                    break;
                case 50:
                    Lexemes[count] = "||";
                    Tokens[count] = "logical or";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 51:
                    Lexemes[count] = "|=";
                    Tokens[count] = "bitwise inclusive OR and assignment operator";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 52:
                    Lexemes[count] = "|";
                    Tokens[count] = "bitwise or";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 53:
                    if (LookHead[i + 1] == '=') {
                        state = 54;
                        i++;
                    } else {
                        state = 55;
                    }
                    break;
                case 54:
                    Lexemes[count] = "^=";
                    Tokens[count] = "bitwise exclusive OR and assignment operator";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 55:
                    Lexemes[count] = "^";
                    Tokens[count] = "bitwise XOR";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 56:
                    while (LookHead[i + 1] != '\n') {
                        s.append(LookHead[i++]);
                    }
                    state = 57;
                    break;
                case 57:
                    Lexemes[count] = "//" ;
                    Tokens[count] = "Single Line Comments";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 58:int Nostar=i;
                    while (LookHead[i + 1] != '*' || LookHead[i + 2] != '/') {
                        s.append(LookHead[i++]);
                       
                        if (i+2==LookHead.length){
                            i=Nostar-1;
                            state=21;
                            break;
                        }
                            
                    }
                    if(state!=21)
                    state = 59;
                    break;
                case 59:
                    i++;i++;i++;
                    Lexemes[count] = "/**/";
                    Tokens[count] = "Multi Line Comments";
                    count++;
                    state = 0;
                    
                    break;
                case 60:int double_quotes=i;
                    while ( LookHead[i + 1] != '"' ) {
                        
                        s.append(LookHead[i++]);
                        if (i+1==LookHead.length){
                            i=double_quotes;
                            state=81;
                            break;
                        }
                        if (LookHead[i]=='\\') {
                            state=84;
                            
                            break;
                        }
                    }
                    if(state !=81 && state !=84)
                    state = 61;

                    break;
                case 61:
                    Lexemes[count] = s.toString() + LookHead[i] + LookHead[++i];
                    Tokens[count] = "String literals";
                    count++;
                    state = 0;
                    i++;
                    
                    break;
                case 62: 
                    
                    if (LookHead[i + 1] == '\\') {
                        state =83;
                        i++;
                    }
                    else if(i+2!=LookHead.length &&LookHead[i + 1]!='\'' && LookHead[i + 2]=='\''){
                       state = 63;
                        i++;
                    }
                    else state =82;
                    break;
                case 63:
                    Lexemes[count] = "\'" + s.toString() + LookHead[i] + LookHead[++i];
                    Tokens[count] = "Character literals";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 64:
                    Lexemes[count] = "true";
                    Tokens[count] = "boolean literals";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 65:
                    Lexemes[count] = "false";
                    Tokens[count] = "boolean literals";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 66:
                    Lexemes[count] = ";";
                    Tokens[count] = "Semi_Colon";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 67:
                    Lexemes[count] = ",";
                    Tokens[count] = "Comma";
                    count++;
                    state = 0;
                    i++;

                    break;
                case 68:
                   
                    if (LookHead[i+1] == ':') {
                        i++;
                        state = 80;
                    } else {
                     Lexemes[count] = ":";
                    Tokens[count] = "Colon";
                    count++;
                    state = 0;
                    i++;}
                    break;

                case 69:
                    Lexemes[count] = "?";
                    Tokens[count] = "Question_Mark";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 70:
                    Lexemes[count] = "{";
                    Tokens[count] = "Left_Curly";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 71:
                    Lexemes[count] = "}";
                    Tokens[count] = "Right_Curly";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 72:
                    Lexemes[count] = "(";
                    Tokens[count] = "Left_Paren";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 73:
                    Lexemes[count] = ")";
                    Tokens[count] = "Right_Paren";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 74:
                    Lexemes[count] = "[";
                    Tokens[count] = "left brackets";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 75:
                    Lexemes[count] = "]";
                    Tokens[count] = "Right brackets";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 76:
                    Lexemes[count] = ".";
                    Tokens[count] = "dot";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 77:
                    Lexemes[count] = "#";
                    Tokens[count] = "Number";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 78:
                    Lexemes[count] = "@";
                    Tokens[count] = "";
                    count++;
                    state = 0;
                    i++;

                    break;
                case 79:
                    Lexemes[count] = "~";
                    Tokens[count] = "";
                    count++;
                    state = 0;
                    i++;
                    break;
                case 80:
                    Lexemes[count] = "::";
                    Tokens[count] = "Double colon operator";
                    count++;
                    state = 0;
                    i++;
                    break;
                    
                    case 81:
                    Lexemes[count] = " \" ";
                    Tokens[count] = "Double quotes";
                    count++;
                    state = 0;
                     if (LookHead[i]=='"') {
                            System.out.println("hi");
                        }
                    i++;
                       
                    break;
                    
                     case 82:
                    Lexemes[count] = " \' ";
                    Tokens[count] = "Single quotes";
                    count++;
                    state = 0;
                    i++;
                    break;
                    
                         
                     case 83: 
                     if (LookHead[i+1]=='n') {
                         i++; 
                    i++; 
                    i++; 
                           Lexemes[count] = "'\\n'";
                    Tokens[count] = "Character literals";
                    count++;
                    state = 0;
                    i++; 
                         }
                    else if (LookHead[i+1]=='t') {
                        i++; 
                    i++; 
                    i++; 
                           Lexemes[count] = "'\\t'";
                    Tokens[count] = "Character literals";
                    count++;
                    state = 0;
                    i++; 
                         }
                    else if (LookHead[i+1]=='r'&&LookHead[i+2]=='\'') {
                        i++; 
                    i++; 
                    i++; 
                    Lexemes[count] = "'\\r'";
                    Tokens[count] = "Character literals";
                    count++;
                    state = 0;
                    i++; 
                         }
                     else if (LookHead[i+1]=='\\' &&LookHead[i+2]=='\'') {
                         i++; 
                    i++; 
                    i++; 
                    Lexemes[count] = "'\\'";
                    Tokens[count] = "Character literals";
                    count++;
                    state = 0;
                    i++; 
                         }
                     else if (LookHead[i+1]=='f' &&LookHead[i+2]=='\'') {
                         i++; 
                    i++; 
                    i++; 
                    Lexemes[count] = "'\\f'";
                    Tokens[count] = "Character literals";
                    count++;
                    state = 0;
                    i++; 
                         }
                     else if (LookHead[i+1]=='b' &&LookHead[i+2]=='\'') {
                    Lexemes[count] = "\\b";
                    Tokens[count] = "Character literals";
                    count++;
                    state = 0;
                    i++; 
                    i++; 
                    i++; 
                         }
                    else if (LookHead[i+1]=='u' && isDigit(LookHead[i+2])&& isDigit(LookHead[i+3])&& isDigit(LookHead[i+4])&& isDigit(LookHead[i+5]) &&LookHead[i+6]=='\'') {
                        String u=LookHead[i++]+""+LookHead[i++]+""+LookHead[i++]+""+LookHead[i++]+""+LookHead[i++]+""+LookHead[i++];
                    Lexemes[count] = '\''+u+'\'';
                    Tokens[count] = "Character literals";
                    count++;
                    state = 0;
                    i++; 
                         }
                    else if (LookHead[i+1]=='\"' &&LookHead[i+2]=='\'') {
                    Lexemes[count] = "'\"'";
                    Tokens[count] = "Character literals";
                    count++;
                    state = 0;
                    i++; 
                    i++; 
                    i++; 
                    }
                    else if (LookHead[i+1]=='\'' &&LookHead[i+2]=='\'') {
                    Lexemes[count] = "'\''";
                    Tokens[count] = "Character literals";
                    count++;
                    state = 0;
                    i++; 
                    i++; 
                    i++; 
                    }
                    else {state=82;
                    --i;
                    }
                    break;
                    
                     case 84:
                          if (LookHead[i+1]=='n') {
//                         i++; 
//                    i++; 
                     state=60;
                           s.append("\n")  ;
                          }
                          else if (LookHead[i+1]=='t') {
//                         i++; 
//                    i++; 
                     state=60;
                           s.append("\t")  ;
                          }
                          else if (LookHead[i+1]=='r') {
//                         i++; 
//                    i++; 
                     state=60;
                           s.append("\r")  ;
                          }
                          else if (LookHead[i+1]=='f') {
//                         i++; 
//                    i++; 
                     state=60;
                           s.append("\f")  ;
                          }
                          else if (LookHead[i+1]=='b') {
                         //i++; 
                   // i++; 
                     state=60;
                           s.append("\b")  ;
                          }
                          
                          else if(LookHead[i+1]=='\"'){
                             // i++; 
                    i++; 
                     state=60;
                          // s.append("\"")  ;
                          }
                          else if(LookHead[i+1]=='\''){
                              //i++; 
                    i++; 
                     state=60;
                          // s.append("\'")  ;
                          }
                          else{ state=60;i++;
                          }
                          break;
                          
                     case 85:
                         Lexemes[count] = "\\";
                    Tokens[count] = "backslash";
                    count++;
                    state = 0;
                    i++;
                         break;
                default:
                    System.out.println("UNRECOGNIZED_TOKEN");
                    
                    break;
            }
        }

        System.out.println("Lexemes				Tokens");
        for (int x = 0; x < Lexemes.length && Lexemes[x] != null; x++) {
            System.out.println(Lexemes[x] + "				" + Tokens[x]);
        }
    }

    public static String tokenizer() throws FileNotFoundException {
        // this method will read the input file and save it in varble String
        if ((new File("input.txt").exists())) {
            StringBuilder s = new StringBuilder();
            Scanner input = new Scanner(new File("input.txt"));

            while (input.hasNext()) {
                s.append(input.nextLine());
                s.append("\n");
            }

            return s.toString();
        } else {
            return "";
        }
    }

    public static boolean ResevedWord(String s) {
        String reserved_words[] = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while", "null", "false", "true", "goto", "const"};
        for (int i = 0; i < reserved_words.length; i++) {
            if (s.equals(reserved_words[i])) {
                return true;
            }
        }
        return false;
    }
}
