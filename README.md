# 무비 다이어리

<br>

## 주제

<br>

- 영화를 본 후 해당 영화에 대한 나만의 후기를 남길 수 있는 다이어리

<br>
<br>

## 주요 기능

<br>

### 1️⃣ 영화 검색

- 네이버 검색 API 사용
- client `id`와 `password`는 보안을 위해 ignore함
- Recycler View

```
//GET - Request

apiURL = "/v1/search/movie?query=" + text!!

//GET - Response

{
    title,
    director,
    userRating,
}
```

1. 다이어리를 작성하고 싶은 영화를 검색한다.
2. 검색버튼을 누른다.
3. 하단에 검색된 영화 목록이 나열된다.

<br>

**EX) 해리포터 검색**

![image](https://user-images.githubusercontent.com/52737532/141108663-5d795be2-78ae-49ae-8a27-69c7caea7f98.png)

<img src="https://user-images.githubusercontent.com/52737532/141108848-889918cc-5dd0-4ba2-907d-350973cce191.png" width="250" height="550">

<br>
<br>

### 2️⃣ 다이어리 작성

1. 영화 목록에서 다이어리를 작성하고 싶은 영화를 클릭한다.
2. 작성창으로 넘어간다.

<br>
<br>

### 3️⃣ 다이어리 확인

1. 다이어리를 작성하고 `저장`버튼을 누르면 다이어리 확인 화면으로 넘어간다.

<br>
<br>
<br>

## 언제 다해 ❓❔

<br>

- RecyclerView - Adapter ⭕
- App theme ❌
- Navigation - Activities ⭕
- Navigation Component - Fragment ⭕
- ViewModel - LiveData ❌
- Data Binding - View Binding ⭕
- Coroutines ⭕
- Retrofit - Moshi - Coil ❌
- Room-Flow ❌

~~글렀다..~~

<br>
<br>

## 영상

[😎 ver 0.000001](https://drive.google.com/file/d/1DQV_9172L25BzJ5XExArhOb-P9y4bm8P/view?usp=sharing)
