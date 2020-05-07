public class UsingStack {
    public static void main(String[] args) {
        Stack mirrorWord = new Stack(20);
        String rightWord = "Hello World!";
        mirrorWord.pushString(rightWord);
        mirrorWord.displayMirrorString();
    }
}
