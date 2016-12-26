package thread.context;

import java.util.concurrent.atomic.AtomicReference;

/**
 * context Switch
 * Created by seyMour on 2016/12/26.
 */
public class ContextSwitchTest {

    static final int RUNS = 3;
    static final int ITERATES = 1000000;
    static AtomicReference turn = new AtomicReference();
}
