package ar.edu.unicen.seminario

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.edu.unicen.seminario.databinding.ItemMovieBinding
import com.bumptech.glide.Glide

class MovieAdapter(
    private val movies : List<Movie>,
    private val onMovieClick:(Movie)->Unit
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(layoutInflater,parent,false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.show(movie)
    }

    inner class MovieViewHolder(
        private val binding : ItemMovieBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun show(movie: Movie){//aca
            binding.movieName.text=movie.title
            binding.movieEmail.text=movie.id.toString()

            Glide.with(itemView.context).load(movie.img).into(binding.movieImg)

            binding.root.setOnClickListener{
                onMovieClick(movie)
                val intent = Intent(itemView.context, BlueActivity::class.java)
                intent.putExtra("MOVIE_TITLE", movie.title)  // Pasando el título
                intent.putExtra("MOVIE_IMAGE", movie.img)    // Pasando la URL de la imagen
                intent.putExtra("MOVIE_ID", movie.id.toString())        // Pasando el ID de la película

                // Inicia la nueva Activity
                itemView.context.startActivity(intent)
            }

        }
    }

}