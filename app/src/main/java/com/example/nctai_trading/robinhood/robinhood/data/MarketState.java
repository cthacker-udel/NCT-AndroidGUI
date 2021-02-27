package com.example.nctai_trading.robinhood.robinhood.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.robinhood.util.TimeUtil;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.Map;
import java.util.Optional;

/**
 robinhoodDay {
 "closes_at":"2017-03-13T20:00:00+00:00",
 "extended_opens_at":"2017-03-13T13:00:00+00:00",
 "next_open_hours":"https:\/\/api.robinhood.com\/markets\/XNAS\/hours\/2017-03-14\/",
 "previous_open_hours":"https:\/\/api.robinhood.com\/markets\/XNAS\/hours\/2017-03-10\/",
 "is_open":true,
 "extended_closes_at":"2017-03-13T22:00:00+00:00",
 "date":"2017-03-13",
 "opens_at":"2017-03-13T13:30:00+00:00"
 }
 **/

@Data
@AllArgsConstructor
public class MarketState {

    private Map<String, String> robinhoodDay;

    public MarketState(Map<String, String> stringStringMap) {
        this.robinhoodDay = stringStringMap;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean isOpenThisDay() {
        return Boolean.parseBoolean(robinhoodDay.getOrDefault("is_open", "false"));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean isOpenNow() {
        if (isOpenThisDay()) {
            final Optional<DateTime> openTime = getExtendedOpenTime();
            final Optional<DateTime> closeTime = getExtendedCloseTime();

            final DateTime now = new DateTime();

            if (openTime.isPresent() && closeTime.isPresent() &&
                    now.isAfter(openTime.get()) && now.isBefore(closeTime.get())) {
                return true;
            }
        }

        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean isAfterHoursNow() {
        if (isOpenThisDay()) {
            final Optional<DateTime> extendedOpenTime = getExtendedOpenTime();
            final Optional<DateTime> extendedCloseTime = getExtendedCloseTime();

            final Optional<DateTime> regularOpenTime = getOpenTime();
            final Optional<DateTime> regularCloseTime = getCloseTime();

            if (!extendedOpenTime.isPresent() || !extendedCloseTime.isPresent() ||
                    !regularOpenTime.isPresent() || !regularCloseTime.isPresent()) {
                return false;
            }

            final DateTime now = new DateTime();

            if ( (now.isAfter(extendedOpenTime.get()) && now.isBefore(regularOpenTime.get())) ||
                    (now.isAfter(regularCloseTime.get()) && now.isBefore(extendedCloseTime.get())) ) {
                return true;
            }
        }

        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<DateTime> getOpenTime() {
        if (!isOpenThisDay()) {
            return Optional.empty();
        }

        String opensAt = robinhoodDay.get("opens_at");

        Optional<DateTime> date = TimeUtil.createDateFromStr("yyyy-MM-dd'T'HH:mm:ssX", opensAt);

        return date;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<DateTime> getCloseTime() {
        if (!isOpenThisDay()) {
            return Optional.empty();
        }

        String closesAt = robinhoodDay.get("closes_at");

        Optional<DateTime> date = TimeUtil.createDateFromStr("yyyy-MM-dd'T'HH:mm:ssX", closesAt);

        return date;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<DateTime> getExtendedOpenTime() {
        if (!isOpenThisDay()) {
            return Optional.empty();
        }

        String opensAt = robinhoodDay.get("extended_opens_at");

        Optional<DateTime> date = TimeUtil.createDateFromStr("yyyy-MM-dd'T'HH:mm:ssX", opensAt);

        return date;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<DateTime> getExtendedCloseTime() {
        if (!isOpenThisDay()) {
            return Optional.empty();
        }

        String closesAt = robinhoodDay.get("extended_closes_at");

        Optional<DateTime> date = TimeUtil.createDateFromStr("yyyy-MM-dd'T'HH:mm:ssX", closesAt);

        return date;
    }
}
