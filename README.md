## 🚀 실행 방법

### 1️⃣ **로컬에서 실행하기**
1. **프로젝트 클론**
   ```sh
   git clone https://github.com/USERNAME/todo-api.git
   cd todo-api
   ```
2. **Gradle을 이용해 프로젝트 실행**
   ```sh
   ./gradlew bootRun
   ```

3. **서버가 정상 실행되면 아래 주소에서 API를 테스트할 수 있습니다.**
   ```
   http://localhost:8080
   ```

---

## 🌍 **API 테스트 (Postman)**
Postman을 사용하여 API 요청을 보낼 수 있습니다.

### 📌 **1. Todo 생성 (POST)**
- **URL**: `http://localhost:8080/api/todos`
- **Method**: `POST`
- **Params**:
  - `title`: `"스프링 공부하기"`
  - `content`: `"spring bean에 대해 공부하기"`

#### ✅ **Postman Response**
```json
{
  "id": 1,
  "title": "스프링 공부하기",
  "content": "spring bean에 대해 공부하기",
  "date": "2025-02-03T16:30:00"
}
```

---

### 📌 **2. Todo 목록 조회 (GET)**
- **URL**: `http://localhost:8080/api/todos`
- **Method**: `GET`

#### ✅ **Postman Response**
```json
[
  {
    "id": 1,
    "title": "스프링 공부하기",
    "content": "spring bean에 대해 공부하기",
    "date": "2025-02-03T16:30:00"
  }
]
```

---

### 📌 **3. 특정 Todo 조회 (GET)**
- **URL**: `http://localhost:8080/api/todos/1`
- **Method**: `GET`

#### ✅ **Postman Response**
```json
{
  "id": 1,
  "title": "스프링 공부하기",
  "content": "spring bean에 대해 공부하기",
  "date": "2025-02-03T16:30:00"
}
```

---

### 📌 **4. Todo 수정 (PUT)**
- **URL**: `http://localhost:8080/api/todos/1`
- **Method**: `PUT`
- **Params**:
  - `title`: `"JPA 공부하기"`
  - `content`: `"Entity 관계 매핑 공부"`

#### ✅ **Postman Response**
```json
{
  "id": 1,
  "title": "JPA 공부하기",
  "content": "Entity 관계 매핑 공부",
  "date": "2025-02-03T16:30:00"
}
```

---

### 📌 **5. Todo 삭제 (DELETE)**
- **URL**: `http://localhost:8080/api/todos/1`
- **Method**: `DELETE`

#### ✅ **성공 응답 (`204 No Content`)**
```
(응답 본문 없음)
```

---

## 📂 **프로젝트 폴더 구조**
```
todo-api
├── src
│   ├── main
│   │   ├── java/com/example/todoapi
│   │   │   ├── controller (API 엔드포인트)
│   │   │   ├── dto (데이터 전송 객체)
│   │   │   ├── entity (JPA 엔터티)
│   │   │   ├── repository (데이터베이스 인터페이스)
│   │   │   ├── service (비즈니스 로직)
│   ├── resources
│   │   ├── application.yml (설정 파일)
├── build.gradle (Gradle 설정)
├── README.md (이 문서)
```

---

## 💡 **기술 스택**
- **Backend**: Java, Spring Boot, Spring Data JPA
- **Database**: H2 (In-memory)
- **Build Tool**: Gradle
- **API Testing**: Postman

---

## ✨ **기능 추가 계획**
✅ 기본적인 CRUD API 개발  
✅ Postman을 이용한 API 테스트  
🔜 JWT 인증 추가  
🔜 MySQL/PostgreSQL로 DB 변경  

---

## 🎯 **기여 방법**
1. 프로젝트를 `Fork`합니다.
2. 개선사항을 반영한 후 `Pull Request`를 보냅니다.
3. 추가 기능 제안은 `Issues` 탭에서 자유롭게 의견을 남겨주세요!

---

