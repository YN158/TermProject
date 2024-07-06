package org.example.panels;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

public class IDgenerator
{

    private static final AtomicLong VCOUNTER = new AtomicLong(0);
    private static final long VOFFSET = Instant.now().getEpochSecond();

    private static final AtomicLong CCOUNTER = new AtomicLong(0);
    private static final long COFFSET = Instant.now().getEpochSecond();

    public static String VideoGetUniqueId()
    {
        long currentTime = Instant.now().getEpochSecond() - VOFFSET;
        long counterValue = VCOUNTER.incrementAndGet();

        long uniqueId = (currentTime << 32) | (counterValue & 0xFFFFFFFFL);

        return Long.toHexString(uniqueId);
    }
    public static String CommentGetUniqueId()
    {
        long currentTime = Instant.now().getEpochSecond() - COFFSET;
        long counterValue = CCOUNTER.incrementAndGet();

        long uniqueId = (currentTime << 32) | (counterValue & 0xFFFFFFFFL);
        return Long.toHexString(uniqueId);
    }
}
