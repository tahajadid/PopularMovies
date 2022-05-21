package com.example.popularmovies.model

import junit.framework.Assert
import org.junit.Test

class ModelTest {

    @Test
    fun callMeParamsToRequest() {

        val resultArray = arrayListOf<Results>()
        // Given
        val params = Model(page = 1, results = resultArray, totalPages = 12, totalResults = 11)

        // When
        val (page, results, totalPages, totalResults) = params

        // Then
        Assert.assertEquals(params.page, page)
        Assert.assertEquals(params.results, results)
        Assert.assertEquals(params.totalPages, totalPages)
        Assert.assertEquals(params.totalResults, totalResults)
    }
}
