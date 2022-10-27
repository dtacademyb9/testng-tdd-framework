package pages;

public class Test {


    public static void main(String[] args) {


        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
        System.setProperty("browser", "firefox");  // can be set through command line
        System.out.println(System.getProperty("browser"));
    }
}
