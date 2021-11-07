package com.estia.neighbors.fragments.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.estia.neighbors.fragments.adapters.ListNeighborHandler
import com.estia.neighbors.fragments.adapters.ListNeighborsAdapter
import com.estia.neighbors.fragments.data.NeighborRepository
import com.estia.neighbors.fragments.data.service.DummyNeighborApiService
import com.estia.neighbors.fragments.models.NavigationListener
import com.estia.neighbors.fragments.models.Neighbor
import com.gmail.mmazouzi.neighbors.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListNeighborsFragment : Fragment(), ListNeighborHandler {
    private lateinit var recyclerView: RecyclerView
    private lateinit var addNeighbor: FloatingActionButton
    /**
     * Fonction permettant de définir une vue à attacher à un fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)
        (activity as? NavigationListener)?.updateTitle(R.string.list_neighbor_toolbar_name)
        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        addNeighbor = view.findViewById(R.id.add_button)
        addNeighbor.setOnClickListener {
            (activity as? NavigationListener)?.showFragment(AddNeighbourFragment())
        }

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }

    override fun onDeleteNeibor(neighbor: Neighbor) {
        activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(R.string.dialog_title)
            builder.apply {
                setPositiveButton(R.string.oui) { dialog, _ ->
                    val dummyNeighborApiService = DummyNeighborApiService()
                    dummyNeighborApiService.deleteNeighbour(neighbor)
                    dialog.dismiss()
                    NeighborRepository.getInstance().deleteNeighbour(neighbor)
                    refresh()
                }
                setNegativeButton(R.string.non) { dialog, _ ->
                    dialog.dismiss()
                }
            }
            builder.create().show()
        }
    }
    private fun refresh() {
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }
}
