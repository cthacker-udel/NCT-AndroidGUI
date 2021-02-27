package com.example.nctai_trading.robinhood;


import com.example.nctai_trading.robinhood.robinhood.data.EquityHistorical;
import com.example.nctai_trading.robinhood.robinhood.data.Instrument;
import com.example.nctai_trading.robinhood.robinhood.data.MarginBalances;
import com.example.nctai_trading.robinhood.robinhood.data.MarketState;
import com.example.nctai_trading.robinhood.robinhood.data.Order;
import com.example.nctai_trading.robinhood.robinhood.data.Portfolio;
import com.example.nctai_trading.robinhood.robinhood.data.Position;
import com.example.nctai_trading.robinhood.robinhood.data.Quote;
import com.example.nctai_trading.robinhood.robinhood.exception.RobinhoodException;

import org.joda.time.DateTime;
import org.json.JSONException;

import java.util.*;

public interface RobinhoodAPI {

    Portfolio getPortfolio() throws RobinhoodException;

    Set<Instrument> getAllInstruments() throws JSONException;

    Optional<Instrument> getInstrumentFromURL(final String instrumentURL);

    Optional<Instrument> getInstrumentForSymbol(final String symbol) throws JSONException;

    public MarginBalances getMarginBalances() throws RobinhoodException, JSONException;

    List<Position> getPositions() throws RobinhoodException, JSONException;

    Collection<Order> getOrdersAfterDate(final Date date) throws RobinhoodException, JSONException;

    List<EquityHistorical> getHistoricalValues(final String span, final String interval, final String bounds) throws RobinhoodException, JSONException;

    List<Quote> getQuotes(final Collection<String> symbols) throws RobinhoodException;

    Quote getQuote(final String symbol) throws RobinhoodException;

    Order buyShares(final String symbol, final int shares, final double limit) throws RobinhoodException, JSONException;

    Order sellShares(final String symbol, final int shares, final double limit) throws RobinhoodException, JSONException;

    Optional<Order> getOrderFromURL(final String orderURL) throws RobinhoodException;

    MarketState getMarketStateForDate(final DateTime dateTime) throws RobinhoodException;

}

