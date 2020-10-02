import java.io.PrintWriter;

/**
 * @author Deki on 03.10.2020
 * @project code_opensource_20207
 **/
public class Quine {

  public static void main(String[] args) throws Exception {
    char q = 34;
    String out = "Quine$";
    String text = (
        "import java.io.*; " +
            "public class [OUT] { " +
            "public static void main(String[] args) throws Exception { " +
            "char q = 34; String out = `[OUT]$`; String text = `[TEXT]`; " +
            "PrintWriter pw = new PrintWriter(out + `.java`); " +
            "pw.format(text, 34, out, text); " +
            "pw.close(); Runtime runtime = Runtime.getRuntime(); " +
            "runtime.exec(`javac ` + out + `.java`).waitFor(); " +
            "runtime.exec(`java ` + out); " +
            "} " +
            "}"
    ).replace("`", "%1$c").replace("[OUT]", "%2$s").replace("[TEXT]", "%3$s");
    PrintWriter pw = new PrintWriter(out + ".java");
    pw.format(text, 34, out, text);
    pw.close();
    Runtime runtime = Runtime.getRuntime();
    runtime.exec("javac " + out + ".java").waitFor();
    runtime.exec("java " + out);
  }

}
