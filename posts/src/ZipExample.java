import rx.Observable;
import java.util.concurrent.TimeUnit;
import static rx.Observable.*;

public class ZipExample {
    private static class Tenant {
        public static Observable<Long> getTenantId(){
                                 // Simulate network latency
            return just(456123L).delay(1, TimeUnit.SECONDS);
        }

        public static Observable<String> getTenantName(){
                                         // Simulate network latency
            return just("myCamelCompany").delay(2, TimeUnit.SECONDS);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Observable<String> tenantName = Tenant.getTenantName();
        Observable<Long>     tenantId = Tenant.getTenantId();

        zip(tenantName, tenantId, (name, id) -> {
                return name + " / " + id;
            }).subscribe(System.out::println);

        System.out.println("Let's go!");
        TimeUnit.SECONDS.sleep(3); // Dont quit just yet!
    }
}