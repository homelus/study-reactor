package jun.study.reactor;

import java.util.concurrent.TimeUnit;

public class LazyService {

    public int lazyAdd(int num) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ignore) {
        }

        return num + 10;
    }

}
