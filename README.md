
# VTI Voucher Management System

Hệ thống quản lý voucher được xây dựng bằng Spring Boot theo kiến trúc Clean Architecture.
Dự án hỗ trợ quản lý voucher, quản lý user và sử dụng voucher thông qua RESTful API kết hợp giao diện Thymeleaf.

---

# Công nghệ sử dụng

* Java 21
* Spring Boot
* Spring Web MVC
* Spring Data JPA
* Thymeleaf
* MySQL
* Lombok
* Maven

---

# Database

Dự án sử dụng:

* MySQL Localhost
* phpMyAdmin để quản lý database
* import file voucher_management.sql vào phpMyAdmin

Ví dụ cấu hình database ở file application.properties:

```properties id="1cl3xq"
spring.datasource.url=jdbc:mysql://localhost:3306/voucher_management
spring.datasource.username=your_account
spring.datasource.password=your_password
```

---

# Chức năng hệ thống

## 1. Quản lý Voucher

Hệ thống hỗ trợ:

* Thêm voucher mới
* Cập nhật voucher
* Xóa voucher
* Xem danh sách voucher
* Tìm kiếm voucher theo code

### Validate

* Code voucher không được trùng
* Discount percent phải từ 1 -> 100
* Quantity phải >= 0
* Expired date phải lớn hơn ngày hiện tại

---

## 2. Quản lý User

Hệ thống hỗ trợ:

* Thêm user
* Xem danh sách user

### Validate

* Email không được trùng
* Email đúng định dạng

---

## 3. Sử dụng Voucher

Hệ thống cho phép user sử dụng voucher.

Khi sử dụng voucher:

* Quantity của voucher giảm đi 1
* Lưu lịch sử vào bảng `voucher_usages`

### Điều kiện validate

Không cho phép sử dụng voucher nếu:

* Voucher đã hết hạn
* Voucher ở trạng thái INACTIVE
* Quantity bằng 0

---

# RESTful APIs

## Voucher APIs

| Method | API                             | Mô tả                      |
| ------ | ------------------------------- | -------------------------- |
| GET    | `/api/vouchers`                 | Lấy danh sách voucher      |
| POST   | `/api/vouchers`                 | Tạo voucher                |
| PUT    | `/api/vouchers/{id}`            | Cập nhật voucher           |
| DELETE | `/api/vouchers/{id}`            | Xóa voucher                |
| GET    | `/api/vouchers/search?code=ABC` | Tìm kiếm voucher theo code |

---

## User APIs

| Method | API          | Mô tả              |
| ------ | ------------ | ------------------ |
| GET    | `/api/users` | Lấy danh sách user |
| POST   | `/api/users` | Tạo user           |

---

## Voucher Usage APIs

| Method | API                       | Mô tả                       |
| ------ | ------------------------- | --------------------------- |
| POST   | `/api/voucher-usages/use` | User sử dụng voucher        |
| GET    | `/api/voucher-usages`     | Xem lịch sử sử dụng voucher |

---

# Giao diện hệ thống

Dự án sử dụng Thymeleaf để xây dựng giao diện server-side rendering.

Các module giao diện bao gồm:

* Voucher Management
* User Management
* Voucher Usage Management

---

# Kiến trúc dự án

Dự án được tổ chức theo mô hình Clean Architecture nhằm tách biệt business logic, presentation và infrastructure.

```text id="8d3k7r"
src/main/java/org/example/voucher_manager
│
├── application
│   ├── dto
│   ├── mapper
│   └── service
│
├── domain
│   ├── constant
│   ├── entity
│   ├── exception
│   └── repository
│
├── infrastructure
│   ├── client
│   ├── config
│   ├── persistence
│   │   ├── entity
│   │   ├── mapper
│   │   └── repository
│   └── repository
│
└── presentation
    ├── advice
    ├── controller
    └── dto
```

---

# Giải thích các package

## application

Chứa business logic của hệ thống.

### dto

* Request DTO
* Response DTO

### mapper

* Mapping giữa entity và DTO

### service

* Xử lý business logic

---

## domain

Chứa core domain của hệ thống.

### entity

* Business entity

### repository

* Interface repository

### constant

* Enum và các hằng số

### exception

* Custom exception

---

## infrastructure

Chứa phần triển khai kỹ thuật.

### config

* Spring configuration

### persistence

* JPA entity
* Repository implementation
* Database mapper

### client

* Kết nối service ngoài (nếu có)

---

## presentation

Chứa tầng giao tiếp với client.

### controller

* REST API Controller
* Thymeleaf View Controller

### advice

* Global exception handler

### dto

* DTO dành riêng cho presentation layer

---

# Cấu trúc giao diện Thymeleaf

```text id="r0xk5d"
src/main/resources
│
├── static
│   ├── css
│   ├── js
│   └── images
│
└── templates
    ├── fragments
    ├── users
    ├── vouchers
    └── voucher-usages
```

---

# Chức năng giao diện

## Voucher

* Danh sách voucher

* Form thêm/sửa voucher
* Tìm kiếm voucher

## User

* Danh sách user
* Form tạo user

## Voucher Usage

* Form sử dụng voucher
* Lịch sử sử dụng voucher

---

# Author

* Nguyễn Xuân Trường
