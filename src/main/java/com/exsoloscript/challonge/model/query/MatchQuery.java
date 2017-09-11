/*
 * Copyright 2017 Stefan Geyer <stefangeyer at outlook.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.exsoloscript.challonge.model.query;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Query for updating a match. This class can be accessed using it's builder.
 *
 * @author EXSolo
 * @version 20160819.1
 */
@Data
@Accessors(fluent = true)
@Builder
public class MatchQuery {
    @SerializedName("winner_id")
    private String winnerId;
    @SerializedName("player1_votes")
    private Integer votesForPlayer1;
    @SerializedName("player2_votes")
    private Integer votesForPlayer2;
    @SerializedName("scores_csv")
    private String scoresCsv;
}
