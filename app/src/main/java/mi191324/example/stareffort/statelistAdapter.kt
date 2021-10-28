package mi191324.example.stareffort

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class statelistAdapter(private val stateList: List<MainActivity.statelist>): RecyclerView.Adapter<statelistAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.friend_state_card,
            parent,
            false
        )

        return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = stateList[position]
        holder.textView1.text = currentItem.user
        val state = currentItem.state
        if (state == 0){
            holder.textView3.text = "オフライン"
            holder.imageView.setImageResource(R.drawable.ofline)
        }
        else {
            holder.textView3.text = "勉強中"
            holder.imageView.setImageResource(R.drawable.online)
        }
        holder.textView2.text = "@" + currentItem.id
        Log.d("adapter_", currentItem.id)
        Log.d("adapter_", currentItem.user)
        Log.d("adapter_", currentItem.state.toString())

        holder.itemView.setOnClickListener {
                v:View -> Unit
            var context = v.context
            val intent = Intent(context, studytimeFragment::class.java)
            intent.putExtra("id", currentItem.id)
            context.startActivity(intent)
        }
    }
    override fun getItemCount() = stateList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.findViewById(R.id.text1)
        val textView2: TextView = itemView.findViewById(R.id.text2)
        val textView3: TextView = itemView.findViewById(R.id.text3)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}