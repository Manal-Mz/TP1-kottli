package com.gmail.mmazouzi.neighbors.data

import com.gmail.mmazouzi.neighbors.data.service.DummyNeighborApiService
import com.gmail.mmazouzi.neighbors.data.service.NeighborApiService
import com.gmail.mmazouzi.neighbors.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService

    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbours(): List<Neighbor> = apiService.neighbours
    fun createNeighbour(neighbor: Neighbor) = apiService.createNeighbour(neighbor)
    fun deleteNeighbour(neighbor: Neighbor) = apiService.deleteNeighbour(neighbor)

    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }
}
