package com.example.nctai_trading.bibox;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/**
 * 定时产生一个ping的时间戳(全局唯一)
 */
public class HeartbeatTask
{
    private static HeartbeatTask heartbeatTask;
    private List<Consumer<Long>> triggers = new ArrayList<>();

    private HeartbeatTask(long interval, long delay)
    {
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                triggers.stream().forEach(trigger -> trigger.accept(System.currentTimeMillis()));
            }
        };
        Timer time = new Timer();
        time.schedule(task, delay, interval);
    }

    public static HeartbeatTask getHeartbeatTask(long interval, long delay)
    {
        Lock lock = new ReentrantLock();
        lock.lock();
        if (heartbeatTask == null) {
            heartbeatTask = new HeartbeatTask(interval, delay);
        }
        lock.unlock();
        return heartbeatTask;
    }

    public boolean registerTrigger(Consumer<Long> consumer)
    {
        return triggers.add(consumer);
    }
}
