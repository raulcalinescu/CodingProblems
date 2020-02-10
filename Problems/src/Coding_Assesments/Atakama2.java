package Coding_Assesments;

import com.sun.net.httpserver.Headers;

import javax.swing.text.html.HTML;

/*
Markdown is a formatting syntax used by many documents (these instructions, for example!) because of it's plain-text
simplicity and it's ability to be translated directly into HTML.

Task:

Let's write a simple markdown parser function that will take in a single line of markdown and be translated into the
appropriate HTML. To keep it simple, we'll support only one feature of markdown in atx syntax: headers.

Headers are designated by (1-6) hashes followed by a space, followed by text. The number of hashes determines the header
level of the javax.swing.text.html.HTML output.

Examples:

# Header will become <h1>Header</h1>
## Header will become <h2>Header</h2>
###### Header will become <h6>Header</h6>

Additional Rules:

Header content should only come after the initial hashtag(s) plus a space character.

Invalid headers should just be returned as the markdown that was recieved, no translation necessary.

Spaces before and after both the header content and the hashtag(s) should be ignored in the resulting output.
     */

public class Atakama2 {

    public static String markdownParser( String markdown ) {
        boolean spaceFound = false, firstIteration = true;
        int hashCount=0;
        StringBuilder str = new StringBuilder();
        str.append("<h");

        for (char c : markdown.toCharArray()) {
            if(c!='#' && firstIteration)
                return markdown;
            else
                firstIteration = false;

            if(c!=' ' && c=='#' && spaceFound == false) {
                hashCount++;
                continue;
            }
            if(c == ' ' && spaceFound == false) {
                spaceFound = true;
                str.append(hashCount+">");
                continue;
            }
            if(!spaceFound)
                return markdown;
            str.append(c);
        }
        str.append("</h"+hashCount+">");

        return str.toString();
    }

    public static void main(String[] args) {
        String string = new String("Header#the house");
        System.out.println(markdownParser(string));
    }


}
