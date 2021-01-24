import rx.Observable;

public class Main {
    public static void main(String[] args) {
        Observable.just("Hey from Org mode").subscribe(System.out::println);
    }
}