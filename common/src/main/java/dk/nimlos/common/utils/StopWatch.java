package dk.nimlos.common.utils;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StopWatch {

	public static final ConcurrentHashMap<String, Instant> stopWatchMap = new ConcurrentHashMap<>();

	public static void startStopWatch(String id) {
		stopWatchMap.put(id, Instant.now());
	}

	public static long stopStopWatch(String id) {
		Instant startTime = stopWatchMap.remove(id);
		Instant stopTime = Instant.now();

		Duration duration = Duration.between(startTime, stopTime);
		return duration.toMillis() % 1000;
	}

}
