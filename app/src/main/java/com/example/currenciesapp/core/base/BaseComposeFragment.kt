package com.example.currenciesapp.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.coreui.extensions.collectWhenStarted
import com.example.coreui.extensions.navigateSafe
import com.example.currenciesapp.core.navigation.Command

abstract class BaseComposeFragment<VM>() : Fragment()
        where VM : BaseComposeViewModel {

    abstract val viewModel: VM

    private var navController: NavController? = null
    protected open val navControllerRes: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = getNavController()
        collectWhenStarted(viewModel.command, ::processCommand)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                InitView()
            }
        }
    }

    @Composable
    protected open fun InitView() {}

    protected open fun processCommand(command: Command) {
        when (command) {
            is Command.FinishAppCommand -> activity?.finishAffinity()
            is Command.NavigateUpCommand -> navController?.popBackStack()
            is Command.NavCommand -> navController?.navigateSafe(command.navDirections)
        }
    }

    private fun getNavController() = try {
        navControllerRes?.let { resId ->
            Navigation.findNavController(requireActivity(), resId)
        } ?: findNavController()
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}