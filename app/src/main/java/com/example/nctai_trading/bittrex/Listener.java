/*
 * *
 *  This file is part of the bittrex4j project.
 *
 *  @author CCob
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 * /
 */

package com.example.nctai_trading.bittrex;


@FunctionalInterface
public interface Listener<EventType> {
    void onEvent(EventType eventType);
}
