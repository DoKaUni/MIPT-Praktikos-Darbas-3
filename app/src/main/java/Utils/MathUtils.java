package Utils;

public class MathUtils {
    public static String removeChar(String string, int index){
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.deleteCharAt(index);

        return stringBuilder.toString();
    }

    public static String addChar(String string, char character, int index){
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.insert(index, character);

        return stringBuilder.toString();
    }

    public static boolean unfinishedOperationExists(String string){
        if(string.length() < 2)
            return false;

        char operationChar = string.charAt(string.length() - 2);
        return operationChar == '/' || operationChar == '*' || operationChar == '+' || operationChar == '-';
    }

    public static boolean isLastCharDigit(String string){
        if(string.isEmpty())
            return false;

        return Character.isDigit(string.charAt(string.length() - 1));
    }

    public static String copyDigitSection(String string){
        int lastWhitespaceIndex = string.lastIndexOf(' ');

        if(lastWhitespaceIndex == -1)
            return string;
        else
            return string.substring(lastWhitespaceIndex + 1);
    }
}
