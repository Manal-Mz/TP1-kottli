package com.gmail.mmazouzi.neighbors.adapters

import com.gmail.mmazouzi.neighbors.models.Neighbor

interface ListNeighborHandler {
    fun onDeleteNeibor(neighbor: Neighbor)
}
