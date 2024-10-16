package ar.edu.unicen.seminario

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.edu.unicen.seminario.databinding.ItemMovieBinding

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
            binding.root.setOnClickListener{
                onMovieClick(movie)
            }

        }
    }

}