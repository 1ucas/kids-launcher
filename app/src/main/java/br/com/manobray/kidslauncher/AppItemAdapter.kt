package br.com.manobray.kidslauncher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.app_item.view.*

class AppItemAdapter(private val onItemClick: (AppToOpen) -> Unit) : ListAdapter<AppToOpen, AppItemAdapter.ViewHolder>(DIFF_UTIL) {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.app_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val appItem = getItem(position)
        with(holder.itemView) {

            setOnClickListener {
                onItemClick(appItem)
            }

            app_item_tv.text = appItem.name
            app_item_iv.loadImage(appItem.imageUrl)
        }
    }
}

private object DIFF_UTIL: DiffUtil.ItemCallback<AppToOpen>() {

    override fun areItemsTheSame(oldItem: AppToOpen, newItem: AppToOpen): Boolean {
        return oldItem.app_package == newItem.app_package
    }

    override fun areContentsTheSame(oldItem: AppToOpen, newItem: AppToOpen): Boolean {
        return oldItem == newItem
    }

}