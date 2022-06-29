package com.benten.simplerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.benten.simplerecyclerview.adapters.Book
import com.benten.simplerecyclerview.adapters.BooksAdapter
import com.benten.simplerecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private val booksAdapter = BooksAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = booksAdapter

        booksAdapter.updateList(
            listOf(
                Book(
                    "Data tutashxia",
                    "https://upload.wikimedia.org/wikipedia/ka/3/38/Data_tutashkhia.jpg"
                ),
                Book(
                    "Fight club",
                    "https://media.newyorker.com/photos/5dbafcc91b4a6700085a7a9b/2:2/w_1707,h_1708,c_limit/Baker-FightClub.jpg"
                ),
                Book(
                    "Romeo and juliet",
                    "https://m.media-amazon.com/images/M/MV5BMGU4YmI1ZGQtZjExYi00M2E0LTgyYTAtNzQ5ZmVlMTk4NzUzXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX1000_.jpg"
                ),
                Book(
                    "Kotlin basics",
                    "https://upload.wikimedia.org/wikipedia/ka/3/38/Data_tutashkhia.jpg"
                ),
                Book("Idiot", "https://upload.wikimedia.org/wikipedia/ka/3/38/Data_tutashkhia.jpg"),
                Book(
                    "დანაშაული და სასჯელი",
                    "http://elibrary.sou.edu.ge/files/books/book-312/cover-312.jpg"
                ),
                Book(
                    "მოთამაშე",
                    "https://upload.wikimedia.org/wikipedia/ka/3/38/Data_tutashkhia.jpg"
                ),
                Book(
                    "ატლანტმა ფრთები გაშალა",
                    "https://upload.wikimedia.org/wikipedia/ka/3/38/Data_tutashkhia.jpg"
                ),
                Book(
                    "მარადისობის დასასრული",
                    "https://upload.wikimedia.org/wikipedia/ka/3/38/Data_tutashkhia.jpg"
                )
            )
        )

        binding.tvDelete.setOnClickListener {
            booksAdapter.deleteItem(0)
        }
        binding.tvInsertt.setOnClickListener {
            booksAdapter.insertItem(
                Book(
                    "პირველწყარო",
                    "https://apiv1.biblusi.ge/storage/book/oqsyyGzRSePk5XH9oZbviLCHnayVjM5Gfzq0HKBs.jpg"
                ), 2
            )
        }
        booksAdapter.setOnItemClickListener {
            Toast.makeText(this,it.bookName,Toast.LENGTH_LONG).show()
        }
        binding.tvUpdate.setOnClickListener {
            booksAdapter.updateItemAt(1,booksAdapter.bookList[1].copy(posterImage = "https://m.media-amazon.com/images/M/MV5BNDIzNDU0YzEtYzE5Ni00ZjlkLTk5ZjgtNjM3NWE4YzA3Nzk3XkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_FMjpg_UX1000_.jpg"))
        }
    }
}