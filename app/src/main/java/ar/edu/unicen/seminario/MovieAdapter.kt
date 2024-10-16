package ar.edu.unicen.seminario

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.edu.unicen.seminario.databinding.ItemMovieBinding

class MovieAdapter(
    private val movies : List<Movie>
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    //dueño de una view


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

    class MovieViewHolder(
        private val binding : ItemMovieBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun show(movie: Movie){//aca
            binding.movieName.text=movie.title
            binding.movieEmail.text=movie.email
        }
    }

}