import com.example.movies.screens.moviesdetails.ActorListRecyclerAdapter

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.data.MovieData

class MoviesDetailsFragment(
    movieData: MovieData,
    backListener: () -> Unit
) : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieName: TextView
    private lateinit var movieAge: TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var movieReviews: TextView
    private lateinit var movieGenre: TextView
    private lateinit var moviePic: ImageView
    private lateinit var backBt: TextView
    private lateinit var overview: TextView
    private lateinit var casts: TextView
    private val backListener = backListener

    private val movieData = movieData

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = requireContext()

        recyclerView = view.findViewById(R.id.recyclerView_actors)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.adapter = ActorListRecyclerAdapter(movieData.actors, context)

        movieName = view.findViewById(R.id.movie_name_details)
        movieName.text = movieData.name

        movieAge = view.findViewById(R.id.movie_age_details)
        movieAge.text = "${movieData.age}+"

        ratingBar = view.findViewById(R.id.ratingBar_details)
        ratingBar.rating = movieData.rating


        movieReviews = view.findViewById(R.id.movie_reviews_details)
        movieReviews.text = context.resources.getQuantityString(
            R.plurals.review,
            movieData.reviews,
            movieData.reviews
        )

        movieGenre = view.findViewById(R.id.movie_genre_details)
        movieGenre.text = movieData.genres.toString()

        moviePic = view.findViewById(R.id.movie_pic_details)
        val uri = Uri.parse(movieData.backdropPic)
        Glide
            .with(context)
            .load(uri)
            .into(moviePic);

        overview = view.findViewById(R.id.overview)
        overview.setText(movieData.overview)

        casts = view.findViewById(R.id.casts)

        if (movieData.actors.size > 0) {
            casts.visibility = View.VISIBLE
        }else{
            casts.visibility = View.INVISIBLE
        }

        backBt = view.findViewById(R.id.activity_movie_details_back_button)
        backBt.setOnClickListener { backListener() }

    }
}