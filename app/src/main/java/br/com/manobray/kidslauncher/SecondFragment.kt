package br.com.manobray.kidslauncher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_second.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: AppItemAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val listaApps = listOf(
        AppToOpen("Gmail", "com.google.android.gm", "https://cdn.iconscout.com/icon/free/png-256/gmail-1-93415.png"),
        AppToOpen("Photos", "com.google.android.apps.photos", "https://www.google.com/photos/about/static/images/ui/logo-photos.png"),
        AppToOpen("Culto Domestico", "br.com.manobray.culto_domestico_app2", "https://lh3.googleusercontent.com/M6tYmPikdkMDOjJyisnkakhid-PA2YhTXDOiA2W3Q_WzGE5ri5vC11VrX0IUcJnjNgw=s360")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        viewManager = GridLayoutManager(context, 2)

        viewAdapter = AppItemAdapter(::openApp)

        recyclerView = rcv_apps.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

        recyclerView.addItemDecoration(
            DividerItemDecoration(context,
                DividerItemDecoration.HORIZONTAL)
        )
        recyclerView.addItemDecoration(DividerItemDecoration(context,
            DividerItemDecoration.VERTICAL))

        viewAdapter.submitList(listaApps)
    }

    private fun openApp(appToOpen: AppToOpen) {
        val launchIntent = this.context?.packageManager?.getLaunchIntentForPackage(appToOpen.app_package)
        launchIntent?.let { startActivity(it) } ?: Toast.makeText(context, "Aplicativo não encontrado", Toast.LENGTH_SHORT).show()
    }
}

data class AppToOpen(
    val name: String,
    val app_package: String,
    val imageUrl: String
)