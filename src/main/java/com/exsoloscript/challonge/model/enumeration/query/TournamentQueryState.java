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

package com.exsoloscript.challonge.model.enumeration.query;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the different states that can be queried.
 * This enumeration does not represent the actual state of the tournament,
 * but groups a list ouf tournaments to subgroups.
 *
 * @author EXSolo
 * @version 20160820.1
 */
public enum TournamentQueryState {
    @SerializedName("all")
    ALL,
    @SerializedName("pending")
    PENDING,
    @SerializedName("in_progress")
    IN_PROGRESS,
    @SerializedName("ended")
    ENDED
}
