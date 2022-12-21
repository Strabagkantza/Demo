package com.isolina.demo.ui.fragments.publications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.isolina.demo.databinding.FragmentPublicationBinding
import com.isolina.demo.ui.fragments.publications.adapter.PublicationItemAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PublicationsFragment : Fragment() {

    private lateinit var  binding: FragmentPublicationBinding
    private val viewModel: PublicationsViewModel by viewModels()
    private lateinit var adapter: PublicationItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPublicationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.publications()

        viewModel.items.observe(viewLifecycleOwner) {
            adapter = PublicationItemAdapter { pub ->
                pub.publicationId?.let { id ->
                    findNavController().navigate(PublicationsFragmentDirections.actionLocationsToIssues(id))
                }
            }
            binding.list.adapter = adapter
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
        }

        viewModel.progress.observe(viewLifecycleOwner) {
            binding.progress.visibility = if (it)  View.VISIBLE else View.GONE
        }

        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }

        StaggeredGridLayoutManager(
            1,
            StaggeredGridLayoutManager.VERTICAL
        ).apply {
            binding.list.layoutManager = this
        }



    }

}