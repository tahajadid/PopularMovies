package com.example.popularmovies.model

import junit.framework.Assert
import org.junit.Test
import tahadeta.example.popularmovies.model.Results

class ResultsTest {
    @Test
    fun callMeParamsToRequest() {

        val resultArray = arrayListOf<Results>()
        // Given
        val params = Results(
            adult = true,
            backdropPath = "backdrop_path",
            genreIds = arrayListOf(),
            id = 11,
            originalLanguage = "Fr",
            originalTitle = "originalTitle",
            overview = "overview",
            popularity = 2.2,
            posterPath = "posterPath",
            releaseDate = "releaseDate",
            title = "MyTitle",
            video = true,
            voteAverage = 1.2,
            voteCount = 3
        )

        // When
        val (
            adult,
            backdropPath,
            genreIds,
            id,
            originalLanguage,
            originalTitle,
            overview,
            popularity,
            posterPath,
            releaseDate,
            title,
            video,
            voteAverage,
            voteCount
        ) = params

        // Then
        Assert.assertEquals(params.adult, adult)
        Assert.assertEquals(params.backdropPath, backdropPath)
        Assert.assertEquals(params.genreIds, genreIds)
        Assert.assertEquals(params.id, id)
        Assert.assertEquals(params.originalLanguage, originalLanguage)
        Assert.assertEquals(params.originalTitle, originalTitle)
        Assert.assertEquals(params.overview, overview)
        Assert.assertEquals(params.popularity, popularity)
        Assert.assertEquals(params.posterPath, posterPath)
        Assert.assertEquals(params.releaseDate, releaseDate)
        Assert.assertEquals(params.title, title)
        Assert.assertEquals(params.video, video)
        Assert.assertEquals(params.voteAverage, voteAverage)
        Assert.assertEquals(params.voteCount, voteCount)
    }
}
