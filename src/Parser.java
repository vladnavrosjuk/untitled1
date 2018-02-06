import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Владислав on 07.02.2018.
 */
public class Parser {
    public Parser(){}
    public void parsing(StringBuilder builder){
        Pattern p = Pattern.compile("Delivered-To: \\w+@\\w+.\\w+");
        Matcher m = p.matcher(builder);
        m.find();
        System.out.println(builder.substring(m.start(),m.end()));
        p = Pattern.compile("Return-path: \\<\\w+@\\w+.\\w+\\>");
        m = p.matcher(builder);
        m.find();
        System.out.println(builder.substring(m.start(),m.end()));
        p = Pattern.compile("\\d\\d \\w+ \\d\\d\\d\\d\\ \\d\\d:\\d\\d:\\d\\d");
        m = p.matcher(builder);
        m.find();
        System.out.println(builder.substring(m.start(),m.end()));

        p = Pattern.compile("Subject: \\w*\\s*");
        m = p.matcher(builder);
        m.find();
        System.out.println(builder.substring(m.start(),m.end()));

        p = Pattern.compile("(--\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w)\\nContent-Type: text\\/html; charset=\"UTF-8");
        m = p.matcher(builder);
        m.find();
        int start = m.start();


        p = Pattern.compile("(--\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w)\\nContent-Type: text\\/plain; charset=\"UTF-8");
        m = p.matcher(builder);
        m.find();
        int end = m.end();

        System.out.print(builder.substring(end,start));
    }
}
