/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 EXSolo <exsoloscripter at gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.exsoloscript.challonge.handler.call;

import com.exsoloscript.challonge.handler.retrofit.RetrofitMatchHandler;
import com.exsoloscript.challonge.handler.retrofit.RetrofitServiceProvider;
import com.exsoloscript.challonge.model.Match;
import com.exsoloscript.challonge.model.enumeration.MatchState;
import com.exsoloscript.challonge.model.query.MatchQuery;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.List;

/**
 * Accessible API handler for matches.
 *
 * @author EXSolo
 * @version 20160822.1
 */
@Singleton
public class MatchHandler {

    private final RetrofitMatchHandler matchHandler;
    private final RetrofitChallongeApiCallFactory factory;

    @Inject
    MatchHandler(RetrofitServiceProvider provider, RetrofitChallongeApiCallFactory factory) {
        this.matchHandler = provider.createService(RetrofitMatchHandler.class);
        this.factory = factory;
    }

    /**
     * @see RetrofitMatchHandler#getMatches(String, Integer, MatchState)
     */
    public ChallongeApiCall<List<Match>> getMatches(String tournament, Integer participantId, MatchState state) {
        Validate.isTrue(StringUtils.isNotBlank(tournament), "Tournament string is required");
        return this.factory.createApiCall(this.matchHandler.getMatches(tournament, participantId, state));
    }

    public ChallongeApiCall<List<Match>> getMatches(String tournament) {
        return getMatches(tournament, null, null);
    }

    /**
     * @see RetrofitMatchHandler#getMatch(String, int, int)
     */
    public ChallongeApiCall<Match> getMatch(String tournament, int matchId, boolean includeAttachments) {
        Validate.isTrue(StringUtils.isNotBlank(tournament), "Tournament string is required");
        return this.factory.createApiCall(matchHandler.getMatch(tournament, matchId, includeAttachments ? 1 : 0));
    }

    /**
     * @see RetrofitMatchHandler#updateMatch(String, int, MatchQuery)
     */
    public ChallongeApiCall<Match> updateMatch(String tournament, int matchId, MatchQuery match) {
        Validate.isTrue(StringUtils.isNotBlank(tournament), "Tournament string is required");
        return this.factory.createApiCall(this.matchHandler.updateMatch(tournament, matchId, match));
    }
}
