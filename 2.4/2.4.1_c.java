import java.io.*;

class Main {
  public static void main(String[] args) throws IOException, Exception {
    Reader reader = new Reader();

    System.out.println("Enter a 0011-like expression:\n");

    String code = reader.read();
    Analyzer analyzer = new Analyzer(code);

    analyzer.s();

    System.out.println("That's nice!");
  }
}

class Analyzer {
  String code; 
  int cursor = 0;

  Analyzer(String s) {
    code = s + '\n';
  }

  void next() {
    cursor++;
  }

  char lookahead() {
    return code.charAt(cursor);
  }

  void complain() throws Exception {
    throw new Exception("unknown character \"" + lookahead() + "\"");
  }

  void match(char c) throws Exception {
    if (lookahead() != c) {
      complain();
    }

    next();
  }

  public void s() throws Exception {
    // todo: 00111 will pass analysis; must be fixed
  
    switch (lookahead()) {
      case '0':
        match('0'); s(); match('1');
        break;
    }
  }
}

class Reader {
  String read() throws IOException {
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    String s = buffer.readLine();
    return s;
  }
}
