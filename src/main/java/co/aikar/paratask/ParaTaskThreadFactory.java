/*
 * Copyright (c) 2018-2018 Daniel Ennis (Aikar) - MIT License
 *
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 *
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package co.aikar.paratask;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class ParaTaskThreadFactory implements ForkJoinPool.ForkJoinWorkerThreadFactory {

    private final ParaTaskManager manager;
    private final AtomicInteger threadCount = new AtomicInteger(1);

    ParaTaskThreadFactory(ParaTaskManager manager) {
        this.manager = manager;
    }

    public final ForkJoinWorkerThread newThread(ForkJoinPool pool) {
        ParaTaskThread thread = new ParaTaskThread(pool);
        thread.setName(manager.options.getManagerName() + " Task Thread #" + threadCount.getAndIncrement());
        Integer threadPriority = manager.options.getThreadPriority();
        if (threadPriority != null) {
            thread.setPriority(threadPriority);
        }
        synchronized (manager.options) {
            Consumer<ParaTaskThread> onThreadCreate = manager.options.getOnThreadCreate();
            if (onThreadCreate != null) {
                onThreadCreate.accept(thread);
            }
        }
        return thread;
    }
}
