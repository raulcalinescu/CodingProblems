public class atakama2 {

    /*/
    Background

Markdown is a formatting syntax used by many documents (these instructions, for example!) because of it's plain-text simplicity and it's ability to be translated directly into HTML.

Task

Let's write a simple markdown parser function that will take in a single line of markdown and be translated into the appropriate HTML. To keep it simple, we'll support only one feature of markdown in atx syntax: headers.

Headers are designated by (1-6) hashes followed by a space, followed by text. The number of hashes determines the header level of the HTML output.

Examples

# Header will become <h1>Header</h1>
## Header will become <h2>Header</h2>
###### Header will become <h6>Header</h6>

Additional Rules

Header content should only come after the initial hashtag(s) plus a space character.

Invalid headers should just be returned as the markdown that was recieved, no translation necessary.

Spaces before and after both the header content and the hashtag(s) should be ignored in the resulting output.
     */

    public static String markdownParser( String markdown ) {
        boolean spaceFound = false;
        StringBuilder str = new StringBuilder();
        str.append("<h");
        for (char c : markdown.toCharArray()) {
            if(c!=' ') continue;
            if(c == ' ') {
                spaceFound = true;
                continue;
            }
            str.append()

        }

        return str.toString();
    }


}
