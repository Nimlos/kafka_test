package dk.nimlos.a.kafkasetup;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticsHandler {

	private long maxValue = 0;
	private long minValue = Integer.MAX_VALUE;
	private double averageValue = 0;
	private long count = 0;
	private long sum = 0;
	private double batchAverage = 0;
	private long batchSum = 0;
	private int batchCount = 50;

	public void addData(long msTime) {
		if (maxValue < msTime) {
			maxValue = msTime;
		}
		if (minValue > msTime) {
			minValue = msTime;
		}
		count += 1;
		sum += msTime;
		averageValue = sum / (double) count;
		batchSum += msTime;

		if (count % batchCount == 0) {
			batchAverage = batchSum / (double) batchCount;
			log.info("Count: {}\tBatch average: {}\tAverage: {}\tMin: {}\tMax: {}", count, String.format("%.2f", batchAverage), String.format("%.2f", averageValue), minValue, maxValue);
			batchAverage = 0;
			batchSum = 0;
		}
	}

}
