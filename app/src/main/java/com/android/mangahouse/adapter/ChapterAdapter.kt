package com.android.mangahouse.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.mangahouse.request.ComicChapterResp
import com.android.mangahouse.R
import com.android.mangahouse.activity.ReadActivity

class ChapterAdapter (val context: Context, val comicId: String?, val site: String?, val chapterList: List<ComicChapterResp.Chapter>): RecyclerView.Adapter<ChapterAdapter.ViewHolder>() {
    inner class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val chapterTitle: TextView = view.findViewById(R.id.chapterView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder(LayoutInflater.from(context).inflate(R.layout.chapter_item, parent, false))

        viewHolder.itemView.setOnClickListener {
            val chapter = chapterList[viewHolder.adapterPosition]
            val inent = Intent(context, ReadActivity::class.java).apply {
                putExtra("site", site)
                putExtra("comicId", comicId)
                putExtra("chapterId", chapter.chapter_number)
            }
            context.startActivity(inent)
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chapter = chapterList[position]
        holder.chapterTitle.text = chapter.title
//        Glide.with(context).load(manga.imageId).into(holder.mangaImage)
    }

    override fun getItemCount() = chapterList.size

}