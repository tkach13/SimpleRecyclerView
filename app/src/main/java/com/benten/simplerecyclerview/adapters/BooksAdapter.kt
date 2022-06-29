package com.benten.simplerecyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.benten.simplerecyclerview.databinding.LayoutBookItemBinding
import com.bumptech.glide.Glide

class BooksAdapter : RecyclerView.Adapter<BookViewHolder>() {
    val bookList = mutableListOf<Book>()

    private var onItemClickListener: ((Book) -> Unit)? = null

    fun updateList(list: List<Book>) {
        bookList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            LayoutBookItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun deleteItem(position: Int) {
        bookList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun insertItem(item: Book, position: Int) {
        bookList.add(position, item)
        notifyItemInserted(position)
    }

    fun updateItemAt(position: Int, item: Book) {
        bookList[position] = item
        notifyItemChanged(position)
    }

    fun setOnItemClickListener(listener: ((Book) -> Unit)) {
        onItemClickListener = listener
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val bookItem = bookList[position]
        holder.binding.tvBookName.text = bookItem.bookName
        Glide.with(holder.binding.root).load(bookItem.posterImage).into(holder.binding.ivPoster)
        holder.binding.root.setOnClickListener {
            onItemClickListener?.invoke(bookItem)
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

}


class BookViewHolder(val binding: LayoutBookItemBinding) : RecyclerView.ViewHolder(binding.root)

data class Book(val bookName: String, val posterImage: String)