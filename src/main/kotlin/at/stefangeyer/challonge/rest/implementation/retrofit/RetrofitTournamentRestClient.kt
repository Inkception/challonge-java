package at.stefangeyer.challonge.rest.implementation.retrofit

import at.stefangeyer.challonge.exception.DataAccessException
import at.stefangeyer.challonge.model.Tournament
import at.stefangeyer.challonge.model.enumeration.TournamentType
import at.stefangeyer.challonge.model.enumeration.query.TournamentQueryState
import at.stefangeyer.challonge.model.query.TournamentQuery
import at.stefangeyer.challonge.rest.Callback
import at.stefangeyer.challonge.rest.TournamentRestClient
import retrofit2.Call
import retrofit2.Response
import java.time.OffsetDateTime

/**
 * Retrofit gson of the tournament rest client
 *
 * @author Stefan Geyer
 * @version 2018-06-30
 */
class RetrofitTournamentRestClient(private val challongeRetrofit: ChallongeRetrofit) : TournamentRestClient {

    override fun getTournaments(state: TournamentQueryState?, type: TournamentType?, createdAfter: OffsetDateTime?,
                                createdBefore: OffsetDateTime?, subdomain: String?): List<Tournament> {
        val response = this.challongeRetrofit.getTournaments(state, type, createdAfter, createdBefore, subdomain).execute()
        return parseResponse("GetTournaments", response)
    }

    override fun getTournaments(state: TournamentQueryState?, type: TournamentType?, createdAfter: OffsetDateTime?, createdBefore: OffsetDateTime?, subdomain: String?, onSuccess: Callback<List<Tournament>>, onFailure: Callback<DataAccessException>) {
        this.challongeRetrofit.getTournaments(state, type, createdAfter, createdBefore, subdomain).enqueue(
                object : retrofit2.Callback<List<Tournament>> {
                    override fun onFailure(call: Call<List<Tournament>>, t: Throwable) {
                        onFailure.handle(DataAccessException("DeleteAttachment request was not successful"))
                    }

                    override fun onResponse(call: Call<List<Tournament>>, response: Response<List<Tournament>>) {
                        onSuccess.handle(parseResponse("DeleteAttachment", response))
                    }
                })
    }

    override fun getTournament(tournament: String, includeParticipants: Boolean, includeMatches: Boolean): Tournament {
        val response = this.challongeRetrofit
                .getTournament(tournament, if (includeParticipants) 1 else 0, if (includeMatches) 1 else 0)
                .execute()
        return parseResponse("GetTournament", response)
    }

    override fun getTournament(tournament: String, includeParticipants: Boolean, includeMatches: Boolean, onSuccess: Callback<Tournament>, onFailure: Callback<DataAccessException>) {
        this.challongeRetrofit.getTournament(tournament, if (includeParticipants) 1 else 0, if (includeMatches) 1 else 0)
                .enqueue(object : retrofit2.Callback<Tournament> {
                    override fun onFailure(call: Call<Tournament>, t: Throwable) {
                        onFailure.handle(DataAccessException("GetTournament request was not successful"))
                    }

                    override fun onResponse(call: Call<Tournament>, response: Response<Tournament>) {
                        onSuccess.handle(parseResponse("GetTournament", response))
                    }
                })
    }

    override fun createTournament(tournamentData: TournamentQuery): Tournament {
        val response = this.challongeRetrofit.createTournament(tournamentData).execute()
        return parseResponse("CreateTournament", response)
    }

    override fun createTournament(tournamentData: TournamentQuery, onSuccess: Callback<Tournament>, onFailure: Callback<DataAccessException>) {
        this.challongeRetrofit.createTournament(tournamentData).enqueue(object : retrofit2.Callback<Tournament> {
            override fun onFailure(call: Call<Tournament>, t: Throwable) {
                onFailure.handle(DataAccessException("CreateTournament request was not successful"))
            }

            override fun onResponse(call: Call<Tournament>, response: Response<Tournament>) {
                onSuccess.handle(parseResponse("CreateTournament", response))
            }
        })
    }

    override fun updateTournament(tournament: String, tournamentData: TournamentQuery): Tournament {
        val response = this.challongeRetrofit.updateTournament(tournament, tournamentData).execute()
        return parseResponse("UpdateTournament", response)
    }

    override fun updateTournament(tournament: String, tournamentData: TournamentQuery, onSuccess: Callback<Tournament>, onFailure: Callback<DataAccessException>) {
        this.challongeRetrofit.updateTournament(tournament, tournamentData).enqueue(object : retrofit2.Callback<Tournament> {
            override fun onFailure(call: Call<Tournament>, t: Throwable) {
                onFailure.handle(DataAccessException("UpdateTournament request was not successful"))
            }

            override fun onResponse(call: Call<Tournament>, response: Response<Tournament>) {
                onSuccess.handle(parseResponse("UpdateTournament", response))
            }
        })
    }

    override fun deleteTournament(tournament: String): Tournament {
        val response = this.challongeRetrofit.deleteTournament(tournament).execute()
        return parseResponse("DeleteTournament", response)
    }

    override fun deleteTournament(tournament: String, onSuccess: Callback<Tournament>, onFailure: Callback<DataAccessException>) {
        this.challongeRetrofit.deleteTournament(tournament).enqueue(object : retrofit2.Callback<Tournament> {
            override fun onFailure(call: Call<Tournament>, t: Throwable) {
                onFailure.handle(DataAccessException("DeleteTournament request was not successful"))
            }

            override fun onResponse(call: Call<Tournament>, response: Response<Tournament>) {
                onSuccess.handle(parseResponse("DeleteTournament", response))
            }
        })
    }

    override fun processCheckIns(tournament: String, includeParticipants: Boolean, includeMatches: Boolean): Tournament {
        val response = this.challongeRetrofit
                .processCheckIns(tournament, if (includeParticipants) 1 else 0, if (includeMatches) 1 else 0)
                .execute()
        return parseResponse("ProcessCheckIns", response)
    }

    override fun processCheckIns(tournament: String, includeParticipants: Boolean, includeMatches: Boolean, onSuccess: Callback<Tournament>, onFailure: Callback<DataAccessException>) {
        this.challongeRetrofit.processCheckIns(tournament, if (includeParticipants) 1 else 0, if (includeMatches) 1 else 0)
                .enqueue(object : retrofit2.Callback<Tournament> {
                    override fun onFailure(call: Call<Tournament>, t: Throwable) {
                        onFailure.handle(DataAccessException("ProcessCheckIns request was not successful"))
                    }

                    override fun onResponse(call: Call<Tournament>, response: Response<Tournament>) {
                        onSuccess.handle(parseResponse("ProcessCheckIns", response))
                    }
                })
    }

    override fun abortCheckIn(tournament: String, includeParticipants: Boolean, includeMatches: Boolean): Tournament {
        val response = this.challongeRetrofit
                .abortCheckIn(tournament, if (includeParticipants) 1 else 0, if (includeMatches) 1 else 0)
                .execute()
        return parseResponse("AbortCheckIns", response)
    }

    override fun abortCheckIn(tournament: String, includeParticipants: Boolean, includeMatches: Boolean, onSuccess: Callback<Tournament>, onFailure: Callback<DataAccessException>) {
        this.challongeRetrofit.abortCheckIn(tournament, if (includeParticipants) 1 else 0, if (includeMatches) 1 else 0)
                .enqueue(object : retrofit2.Callback<Tournament> {
                    override fun onFailure(call: Call<Tournament>, t: Throwable) {
                        onFailure.handle(DataAccessException("AbortCheckIns request was not successful"))
                    }

                    override fun onResponse(call: Call<Tournament>, response: Response<Tournament>) {
                        onSuccess.handle(parseResponse("AbortCheckIns", response))
                    }
                })
    }

    override fun startTournament(tournament: String, includeParticipants: Boolean, includeMatches: Boolean): Tournament {
        val response = this.challongeRetrofit
                .startTournament(tournament, if (includeParticipants) 1 else 0, if (includeMatches) 1 else 0)
                .execute()
        return parseResponse("StartTournament", response)
    }

    override fun startTournament(tournament: String, includeParticipants: Boolean, includeMatches: Boolean, onSuccess: Callback<Tournament>, onFailure: Callback<DataAccessException>) {
        this.challongeRetrofit.startTournament(tournament, if (includeParticipants) 1 else 0, if (includeMatches) 1 else 0)
                .enqueue(object : retrofit2.Callback<Tournament> {
                    override fun onFailure(call: Call<Tournament>, t: Throwable) {
                        onFailure.handle(DataAccessException("StartTournament request was not successful"))
                    }

                    override fun onResponse(call: Call<Tournament>, response: Response<Tournament>) {
                        onSuccess.handle(parseResponse("StartTournament", response))
                    }
                })
    }

    override fun finalizeTournament(tournament: String, includeParticipants: Boolean, includeMatches: Boolean): Tournament {
        val response = this.challongeRetrofit
                .finalizeTournament(tournament, if (includeParticipants) 1 else 0, if (includeMatches) 1 else 0)
                .execute()
        return parseResponse("FinalizeTournament", response)
    }

    override fun finalizeTournament(tournament: String, includeParticipants: Boolean, includeMatches: Boolean, onSuccess: Callback<Tournament>, onFailure: Callback<DataAccessException>) {
        this.challongeRetrofit.finalizeTournament(tournament, if (includeParticipants) 1 else 0, if (includeMatches) 1 else 0)
                .enqueue(object : retrofit2.Callback<Tournament> {
                    override fun onFailure(call: Call<Tournament>, t: Throwable) {
                        onFailure.handle(DataAccessException("FinalizeTournament request was not successful"))
                    }

                    override fun onResponse(call: Call<Tournament>, response: Response<Tournament>) {
                        onSuccess.handle(parseResponse("FinalizeTournament", response))
                    }
                })
    }

    override fun resetTournament(tournament: String, includeParticipants: Boolean, includeMatches: Boolean): Tournament {
        val response = this.challongeRetrofit
                .resetTournament(tournament, if (includeParticipants) 1 else 0, if (includeMatches) 1 else 0)
                .execute()
        return parseResponse("ResetTournament", response)
    }

    override fun resetTournament(tournament: String, includeParticipants: Boolean, includeMatches: Boolean, onSuccess: Callback<Tournament>, onFailure: Callback<DataAccessException>) {
        this.challongeRetrofit.finalizeTournament(tournament, if (includeParticipants) 1 else 0, if (includeMatches) 1 else 0)
                .enqueue(object : retrofit2.Callback<Tournament> {
                    override fun onFailure(call: Call<Tournament>, t: Throwable) {
                        onFailure.handle(DataAccessException("ResetTournament request was not successful"))
                    }

                    override fun onResponse(call: Call<Tournament>, response: Response<Tournament>) {
                        onSuccess.handle(parseResponse("ResetTournament", response))
                    }
                })
    }

    override fun openTournamentForPredictions(tournament: String, includeParticipants: Boolean, includeMatches: Boolean): Tournament {
        val response = this.challongeRetrofit
                .openTournamentForPredictions(tournament, if (includeParticipants) 1 else 0, if (includeMatches) 1 else 0)
                .execute()
        return parseResponse("OpenTournamentForPredictions", response)
    }

    override fun openTournamentForPredictions(tournament: String, includeParticipants: Boolean, includeMatches: Boolean, onSuccess: Callback<Tournament>, onFailure: Callback<DataAccessException>) {
        this.challongeRetrofit.finalizeTournament(tournament, if (includeParticipants) 1 else 0, if (includeMatches) 1 else 0)
                .enqueue(object : retrofit2.Callback<Tournament> {
                    override fun onFailure(call: Call<Tournament>, t: Throwable) {
                        onFailure.handle(DataAccessException("OpenTournamentForPredictions request was not successful"))
                    }

                    override fun onResponse(call: Call<Tournament>, response: Response<Tournament>) {
                        onSuccess.handle(parseResponse("OpenTournamentForPredictions", response))
                    }
                })
    }

    private fun <T> parseResponse(action: String, response: Response<T>): T {
        if (!response.isSuccessful) {
            throw DataAccessException(action + " request was not successful (" +
                    response.code() + ") and returned: " + response.errorBody().toString())
        }

        val body = response.body()

        if (body != null) {
            return body
        }

        throw DataAccessException("Received response body was null")
    }
}