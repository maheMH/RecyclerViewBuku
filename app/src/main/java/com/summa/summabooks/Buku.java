package com.summa.summabooks;

import android.os.Parcel;
import android.os.Parcelable;

public class Buku implements Parcelable {
    private String img, judul, author, series, isbn, penerbit, tglterbit, sinopsis, review;

    protected Buku(Parcel in) {
        img = in.readString();
        judul = in.readString();
        author = in.readString();
        series = in.readString();
        isbn = in.readString();
        penerbit = in.readString();
        tglterbit = in.readString();
        sinopsis = in.readString();
        review = in.readString();
    }

    public static final Creator<Buku> CREATOR = new Creator<Buku>() {
        @Override
        public Buku createFromParcel(Parcel in) {
            return new Buku(in);
        }

        @Override
        public Buku[] newArray(int size) {
            return new Buku[size];
        }
    };

    public Buku() {

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getTglTerbit() {
        return tglterbit;
    }

    public void setTglTerbit(String tglterbit) {
        this.tglterbit = tglterbit;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.img);
        parcel.writeString(this.judul);
        parcel.writeString(this.author);
        parcel.writeString(this.series);
        parcel.writeString(this.isbn);
        parcel.writeString(this.penerbit);
        parcel.writeString(this.tglterbit);
        parcel.writeString(this.sinopsis);
        parcel.writeString(this.review);
    }
}
