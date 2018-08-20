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

import java.util.function.Consumer;

@SuppressWarnings("WeakerAccess")
public class ParaTaskOptions {
    private Integer threadPriority;
    private int parallelism = Runtime.getRuntime().availableProcessors();
    private Consumer<ParaTaskThread> onThreadCreate;
    private String managerName = "ParaTaskManager";

    public synchronized Integer getThreadPriority() {
        return threadPriority;
    }

    public synchronized void setThreadPriority(Integer threadPriority) {
        this.threadPriority = threadPriority;
    }

    public synchronized int getParallelism() {
        return parallelism;
    }

    public synchronized void setParallelism(int parallelism) {
        if (parallelism < 1) {
            throw new IllegalArgumentException("Parrallelism can not be less than 1");
        }
        this.parallelism = parallelism;
    }

    public synchronized String getManagerName() {
        return managerName;
    }

    public synchronized void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public synchronized Consumer<ParaTaskThread> getOnThreadCreate() {
        return onThreadCreate;
    }

    public synchronized void setOnThreadCreate(Consumer<ParaTaskThread> onThreadCreate) {
        this.onThreadCreate = onThreadCreate;
    }
}
