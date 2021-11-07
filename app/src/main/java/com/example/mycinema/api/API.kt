package com.example.mycinema.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mycinema.client.Client
import org.json.JSONException
import org.json.JSONObject
import java.io.*
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder

class API {
    fun searchMovie(input: String):List<String> {
        val movies = mutableListOf<String>()
        var client = Client()

        var text: String? = null
        try {
            text = URLEncoder.encode(input, "UTF-8")
        } catch (e: UnsupportedEncodingException) {
            throw RuntimeException("검색어 인코딩 실패", e)
        }

        val apiURL = "https://openapi.naver.com/v1/search/movie?query=" + text!!

        val requestHeaders : HashMap<String, String> = HashMap()
        requestHeaders.put("X-Naver-Client-Id", client.clientId)
        requestHeaders.put("X-Naver-Client-Secret", client.clientSecret)
        val responseBody = get(apiURL, requestHeaders)

//        parseData(responseBody)

        var title: String
        var star: Int

        var jsonObject: JSONObject? = null
        try {
            jsonObject = JSONObject(responseBody)
            val jsonArray = jsonObject.getJSONArray("items")

            for (i in 0 until jsonArray.length()) {
                val item = jsonArray.getJSONObject(i)
                title = item.getString("title")
                star = item.getInt("userRating")

                movies.add("TITLE : $title, star : $star");
//                return "TITLE : $title, star : $star";
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return movies;
    }

    fun main(input: String) {
        var client = Client()

        var text: String? = null
        try {
            text = URLEncoder.encode(input, "UTF-8")
        } catch (e: UnsupportedEncodingException) {
            throw RuntimeException("검색어 인코딩 실패", e)
        }

        val apiURL = "https://openapi.naver.com/v1/search/movie?query=" + text!!

        val requestHeaders : HashMap<String, String> = HashMap()
        requestHeaders.put("X-Naver-Client-Id", client.clientId)
        requestHeaders.put("X-Naver-Client-Secret", client.clientSecret)
        val responseBody = get(apiURL, requestHeaders)

        parseData(responseBody)

    }

    private operator fun get(apiUrl: String, requestHeaders: Map<String, String>): String {
        val con = connect(apiUrl)
        try {
            con.setRequestMethod("GET")
            for ((key, value) in requestHeaders) {
                con.setRequestProperty(key, value)
            }

            val responseCode = con.getResponseCode()
            return if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                readBody(con.getInputStream())
            } else { // 에러 발생
                readBody(con.getErrorStream())
            }

        } catch (e: IOException) {
            throw RuntimeException("API 요청과 응답 실패", e)
        } finally {
            con.disconnect()
        }
    }

    private fun connect(apiUrl: String): HttpURLConnection {
        try {
            val url = URL(apiUrl)
            return url.openConnection() as HttpURLConnection
        } catch (e: MalformedURLException) {
            throw RuntimeException("API URL이 잘못되었습니다. : $apiUrl", e)
        } catch (e: IOException) {
            throw RuntimeException("연결이 실패했습니다. : $apiUrl", e)
        }

    }

    private fun readBody(body: InputStream): String {
        val streamReader = InputStreamReader(body)

        try {
            BufferedReader(streamReader).use { lineReader ->
                val responseBody = StringBuilder()

                var line: String? = lineReader.readLine()
                while (line != null) {
                    responseBody.append(line)
                    line = lineReader.readLine()
                }
                return responseBody.toString()
            }
        } catch (e: IOException) {
            throw RuntimeException("API 응답을 읽는데 실패했습니다.", e)
        }
    }

    private fun parseData(responseBody: String) {
        var title: String
        var star: Int

        var jsonObject: JSONObject? = null
        try {
            jsonObject = JSONObject(responseBody)
            val jsonArray = jsonObject.getJSONArray("items")

            for (i in 0 until jsonArray.length()) {
                val item = jsonArray.getJSONObject(i)
                title = item.getString("title")
                star = item.getInt("userRating")

                println("TITLE : $title, star : $star")
            }



        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }
}