package com.isolina.demo.ui.fragments.issues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.isolina.demo.databinding.FragmentIssuesBinding
import com.isolina.demo.ui.fragments.issues.adapter.IssueItemAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class IssuesFragment : Fragment() {
    private lateinit var  binding: FragmentIssuesBinding
    private val viewModel: IssuesViewModel by viewModels()
    private val args: IssuesFragmentArgs by navArgs()
    private lateinit var adapter: IssueItemAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIssuesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.issues(args.idLocation)

        viewModel.items.observe(viewLifecycleOwner) {
            adapter = IssueItemAdapter { iss ->
                val text = if (iss.isForSale) "Buy" else "Download"
               Toast.makeText(context, text, Toast.LENGTH_LONG).show()
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