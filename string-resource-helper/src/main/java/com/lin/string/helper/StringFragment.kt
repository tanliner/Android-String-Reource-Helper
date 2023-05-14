package com.lin.string.helper

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.lin.string.helper.theme.StringResourceHelperTheme
import com.lin.string.helper.ui.ResourceTestContent

class StringFragment : Fragment() {

    companion object {
        fun newInstance() = StringFragment()
    }

    private val viewModel: StringViewModel by lazy {
        ViewModelProvider(this.activity as FragmentActivity)[StringViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(inflater.context).apply {
            setContent {
                StringResourceHelperTheme {

                    val display = viewModel.display.collectAsState().value
                    ResourceTestContent(
                        stringResource(R.string.title),
                        display
                    )
                }
            }
        }
    }
}
