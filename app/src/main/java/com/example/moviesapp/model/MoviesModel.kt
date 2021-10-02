package com.example.moviesapp.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MoviesModel(
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("copyright")
    val copyright: String? = null,
    @SerializedName("has_more")
    val hasMore: Boolean? = null,
    @SerializedName("num_results")
    val numResults: Int? = null,
    @SerializedName("results")
    val results: List<Result>
)

data class Result(
    @SerializedName("display_title")
    var displayTitle: String? = null,
    @SerializedName("mpaa_rating")
    var mpaaRating: String? = null,
    @SerializedName("critics_pick")
    var criticsPick: Int? = null,
    @SerializedName("byline")
    var byline: String? = null,
    @SerializedName("headline")
    var headline: String? = null,
    @SerializedName("summary_short")
    var summaryShort: String? = null,
    @SerializedName("publication_date")
    var publicationDate: String? = null,
    @SerializedName("opening_date")
    var openingDate: String? = null,
    @SerializedName("date_updated")
    var dateUpdated: String? = null,
    @SerializedName("link")
    val link: Link?,
    @SerializedName("multimedia")
    val multimedia: Multimedia?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Link::class.java.getClassLoader()),
        parcel.readParcelable(Multimedia::class.java.getClassLoader()),
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(displayTitle)
        parcel.writeString(mpaaRating)
        parcel.writeValue(criticsPick)
        parcel.writeString(byline)
        parcel.writeString(headline)
        parcel.writeString(summaryShort)
        parcel.writeString(publicationDate)
        parcel.writeString(openingDate)
        parcel.writeString(dateUpdated)
        parcel.writeParcelable(link,flags)
        parcel.writeParcelable(multimedia,flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Result> {
        override fun createFromParcel(parcel: Parcel): Result {
            return Result(parcel)
        }

        override fun newArray(size: Int): Array<Result?> {
            return arrayOfNulls(size)
        }
    }
}

data class Link(
    @SerializedName("type")
    var type: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("suggested_link_text")
    var suggestedLinkText: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(url)
        parcel.writeString(suggestedLinkText)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Link> {
        override fun createFromParcel(parcel: Parcel): Link {
            return Link(parcel)
        }

        override fun newArray(size: Int): Array<Link?> {
            return arrayOfNulls(size)
        }
    }
}

data class Multimedia(
    @SerializedName("type")
    var type: String? = null,

    @SerializedName("src")
    var src: String? = null,

    @SerializedName("height")
    var height: Int? = null,

    @SerializedName("width")
    var width: Int? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(src)
        parcel.writeValue(height)
        parcel.writeValue(width)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Multimedia> {
        override fun createFromParcel(parcel: Parcel): Multimedia {
            return Multimedia(parcel)
        }

        override fun newArray(size: Int): Array<Multimedia?> {
            return arrayOfNulls(size)
        }
    }
}
