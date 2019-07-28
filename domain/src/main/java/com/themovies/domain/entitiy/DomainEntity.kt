package com.themovies.domain.entitiy

import android.os.Parcel
import android.os.Parcelable


data class DomainEntityMovie(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readString().orEmpty(),
        parcel.createIntArray()?.toList().orEmpty(),
        parcel.readInt(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readDouble(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readByte() != 0.toByte(),
        parcel.readDouble(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (adult) 1 else 0)
        parcel.writeString(backdropPath)
        parcel.writeIntArray(genreIds.toIntArray())
        parcel.writeInt(id)
        parcel.writeString(originalLanguage)
        parcel.writeString(originalTitle)
        parcel.writeString(overview)
        parcel.writeDouble(popularity)
        parcel.writeString(posterPath)
        parcel.writeString(releaseDate)
        parcel.writeString(title)
        parcel.writeByte(if (video) 1 else 0)
        parcel.writeDouble(voteAverage)
        parcel.writeInt(voteCount)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<DomainEntityMovie> {
        override fun createFromParcel(parcel: Parcel): DomainEntityMovie = DomainEntityMovie(parcel)
        override fun newArray(size: Int): Array<DomainEntityMovie?> = arrayOfNulls(size)
    }
}