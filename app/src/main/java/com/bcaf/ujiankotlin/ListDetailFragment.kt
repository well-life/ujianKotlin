package com.bcaf.ujiankotlin

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bcaf.ujiankotlin.model.Article

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListDetailFragment : Fragment() {

    // Menyimpan artikel yang diterima
    lateinit var article: Article

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            article = it.getParcelable(ARG_PARAM1) ?: throw IllegalStateException("Article data not found in arguments")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(article != null) {
            view.findViewById<ImageView>(R.id.articleDetailImage)
                .setImageResource(article.imageResourceId)
            view.findViewById<TextView>(R.id.articleDetailTitle).text = article.title
            view.findViewById<TextView>(R.id.articleDetailOverview).text = article.overview
            view.findViewById<TextView>(R.id.articleDetailDescription).text = article.description
        }
    }

    companion object {
        private const val ARG_PARAM1 = "param1"

        @JvmStatic
        fun newInstance(article: Article, param2: String) =
            ListDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, article)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}