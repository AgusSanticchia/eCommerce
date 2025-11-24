# 🛍️ Dream Shop - eCommerce Platform

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

Una plataforma de comercio electrónico desarrollada con Spring Boot, que ofrece gestión de productos, carrito de compras, autenticación de usuarios y procesamiento de pedidos.

## 📋 Tabla de Contenidos

- [Características](#-características)
- [Tecnologías](#-tecnologías)
- [Arquitectura](#-arquitectura)
- [Requisitos Previos](#-requisitos-previos)
- [Instalación](#-instalación)
- [Configuración](#-configuración)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [API Endpoints](#-api-endpoints)
- [Seguridad](#-seguridad)
- [Base de Datos](#-base-de-datos)


## ✨ Características

### Gestión de Usuarios
- ✅ Registro y autenticación de usuarios
- ✅ Autenticación JWT
- ✅ Sistema de roles (USER, ADMIN)
- ✅ Perfiles de usuario personalizables
- ✅ Gestión de direcciones

### Catálogo de Productos
- ✅ CRUD completo de productos
- ✅ Categorización de productos
- ✅ Gestión de imágenes múltiples por producto
- ✅ Búsqueda y filtrado avanzado
- ✅ Gestión de inventario

### Carrito de Compras
- ✅ Agregar/eliminar productos del carrito
- ✅ Actualización de cantidades
- ✅ Cálculo automático de totales
- ✅ Persistencia del carrito por usuario

### Sistema de Pedidos
- ✅ Creación y seguimiento de pedidos
- ✅ Estados de pedido (PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED)
- ✅ Historial de pedidos por usuario
- ✅ Gestión de pedidos para administradores

### Panel de Administración
- ✅ Gestión completa de productos
- ✅ Gestión de categorías
- ✅ Visualización de todos los pedidos
- ✅ Gestión de usuarios

## 🚀 Tecnologías

### Backend
- **Java 21** - Lenguaje de programación
- **Spring Boot 3.5.7** - Framework principal
- **Spring Security** - Autenticación y autorización
- **Spring Data JPA** - Capa de persistencia
- **Hibernate** - ORM
- **JWT (JSON Web Tokens)** - Autenticación stateless

### Base de Datos
- **MySQL** - Base de datos relacional
- **HikariCP** - Connection pooling

### Herramientas
- **Lombok** - Reducción de código boilerplate
- **ModelMapper** - Mapeo de objetos
- **Maven** - Gestión de dependencias
- **Postman** - Testing de API (colección incluida)

## 🏗️ Arquitectura

El proyecto sigue una arquitectura de capas limpia:

```
┌─────────────────────────────────┐
│     Controllers (REST API)      │
├─────────────────────────────────┤
│      Services (Lógica)          │
├─────────────────────────────────┤
│  Repositories (Persistencia)    │
├─────────────────────────────────┤
│      Models (Entidades)         │
└─────────────────────────────────┘
```

### Patrones de Diseño Utilizados
- **Repository Pattern** - Abstracción de acceso a datos
- **Service Layer** - Lógica de negocio
- **DTO Pattern** - Transferencia de datos
- **Dependency Injection** - Inversión de control
- **Builder Pattern** - Construcción de objetos complejos

## 📦 Requisitos Previos

Antes de comenzar, asegúrate de tener instalado:

- **JDK 21** o superior
- **Maven 3.8+**
- **MySQL 8.0+**
- **Git**
- **IDE** (IntelliJ IDEA, Eclipse, VS Code)

## 🔧 Instalación

### 1. Clonar el Repositorio

```bash
git clone https://github.com/AgusSanticchia/eCommerce.git
cd eCommerce/dream-shop
```

### 2. Configurar la Base de Datos

Crea una base de datos en MySQL:

```sql
CREATE DATABASE dream_shop;
```

### 3. Configurar Variables de Entorno

Crea un archivo `application.properties` o configura las siguientes variables:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/dream_shop
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# JWT Configuration
jwt.secret=tu_clave_secreta_super_segura_de_al_menos_256_bits
jwt.expiration=86400000

# Server Configuration
server.port=8080
```

### 4. Construir el Proyecto

```bash
mvn clean install
```

### 5. Ejecutar la Aplicación

```bash
mvn spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

## ⚙️ Configuración

### Configuración de JWT

Modifica el archivo `application.properties`:

```properties
jwt.secret=MiClaveSecretaSuperSegura123456789012345678901234567890
jwt.expiration=86400000  # 24 horas en milisegundos
```

### Configuración de Archivos

Para la carga de imágenes:

```properties
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
```

### Perfiles de Entorno

Puedes crear diferentes perfiles:

- `application-dev.properties` - Desarrollo
- `application-prod.properties` - Producción

Ejecutar con un perfil específico:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## 📁 Estructura del Proyecto

```
eCommerce/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/agus/dreamshop/
│   │   │       ├── config/          # Configuraciones
│   │   │       ├── controller/      # Controladores REST
│   │   │       ├── data/           # Inicialización de datos
│   │   │       ├── dto/            # Data Transfer Objects
│   │   │       ├── enums/          # Enumeraciones
│   │   │       ├── exceptions/     # Manejo de excepciones
│   │   │       ├── model/          # Entidades JPA
│   │   │       ├── repository/     # Repositorios
│   │   │       ├── request/        # Request objects
│   │   │       ├── response/       # Response objects
│   │   │       ├── security/       # Configuración de seguridad
│   │   │       └── service/        # Servicios
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/             # Recursos estáticos
│   └── test/                       # Tests unitarios e integración
├── pom.xml
└── README.md
```

## 🔌 API Endpoints

### Autenticación

| Método | Endpoint | Descripción | Acceso |
|--------|----------|-------------|--------|
| POST | `/api/v1/auth/register` | Registrar nuevo usuario | Público |
| POST | `/api/v1/auth/login` | Iniciar sesión | Público |
| POST | `/api/v1/auth/logout` | Cerrar sesión | Autenticado |

### Productos

| Método | Endpoint | Descripción | Acceso |
|--------|----------|-------------|--------|
| GET | `/api/v1/products` | Listar todos los productos | Público |
| GET | `/api/v1/products/{id}` | Obtener producto por ID | Público |
| GET | `/api/v1/products/by/category` | Productos por categoría | Público |
| GET | `/api/v1/products/by/brand` | Productos por marca | Público |
| POST | `/api/v1/products` | Crear producto | ADMIN |
| PUT | `/api/v1/products/{id}` | Actualizar producto | ADMIN |
| DELETE | `/api/v1/products/{id}` | Eliminar producto | ADMIN |

### Categorías

| Método | Endpoint | Descripción | Acceso |
|--------|----------|-------------|--------|
| GET | `/api/v1/categories` | Listar categorías | Público |
| GET | `/api/v1/categories/{id}` | Obtener categoría | Público |
| POST | `/api/v1/categories` | Crear categoría | ADMIN |
| PUT | `/api/v1/categories/{id}` | Actualizar categoría | ADMIN |
| DELETE | `/api/v1/categories/{id}` | Eliminar categoría | ADMIN |

### Carrito

| Método | Endpoint | Descripción | Acceso |
|--------|----------|-------------|--------|
| GET | `/api/v1/cart/{userId}` | Obtener carrito | USER |
| POST | `/api/v1/cart/add` | Agregar item al carrito | USER |
| PUT | `/api/v1/cart/{cartId}/item/{itemId}` | Actualizar cantidad | USER |
| DELETE | `/api/v1/cart/{cartId}/item/{itemId}` | Eliminar item | USER |
| DELETE | `/api/v1/cart/{cartId}` | Limpiar carrito | USER |

### Pedidos

| Método | Endpoint | Descripción | Acceso |
|--------|----------|-------------|--------|
| GET | `/api/v1/orders/{orderId}` | Obtener pedido | USER |
| GET | `/api/v1/orders/user/{userId}` | Pedidos del usuario | USER |
| POST | `/api/v1/orders` | Crear pedido | USER |
| PUT | `/api/v1/orders/{orderId}` | Actualizar estado | ADMIN |

### Usuarios

| Método | Endpoint | Descripción | Acceso |
|--------|----------|-------------|--------|
| GET | `/api/v1/users/{userId}` | Obtener usuario | USER |
| PUT | `/api/v1/users/{userId}` | Actualizar usuario | USER |
| DELETE | `/api/v1/users/{userId}` | Eliminar usuario | ADMIN |

## 🔐 Seguridad

### Autenticación JWT

El sistema utiliza JWT (JSON Web Tokens) para la autenticación:

1. El usuario se registra o inicia sesión
2. El servidor genera un JWT token
3. El cliente incluye el token en cada petición:
   ```
   Authorization: Bearer <token>
   ```

### Ejemplo de Autenticación

```bash
# Login
curl -X POST http://localhost:8080/api/v1/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "user@email.com",
    "password": "123456"
  }'

# Usar el token
curl -X GET http://localhost:8080/api/v1/cart/1 \
  -H "Authorization: Bearer <tu_token_jwt>"
```

### Roles y Permisos

- **USER**: Acceso a funciones básicas (comprar, ver productos, gestionar carrito)
- **ADMIN**: Acceso completo (gestionar productos, categorías, pedidos)

## 💾 Base de Datos

### Modelo de Datos

#### Usuario
```sql
- id (PK)
- firstName
- lastName
- email (unique)
- password (encrypted)
- roles (ManyToMany)
```

#### Producto
```sql
- id (PK)
- name
- brand
- description
- price
- inventory
- category_id (FK)
```

#### Carrito
```sql
- id (PK)
- user_id (FK)
- totalAmount
- cartItems (OneToMany)
```

#### Pedido
```sql
- id (PK)
- orderDate
- totalAmount
- orderStatus
- user_id (FK)
- orderItems (OneToMany)
```

### Diagrama ER

```
┌──────────┐       ┌──────────┐       ┌──────────┐
│   User   │──────<│   Cart   │>──────│CartItem  │
└──────────┘       └──────────┘       └──────────┘
     │                                       │
     │                                       │
     │             ┌──────────┐             │
     └────────────<│  Order   │>────────────┘
                   └──────────┘
                        │
                        v
                   ┌──────────┐       ┌──────────┐
                   │OrderItem │──────>│ Product  │
                   └──────────┘       └──────────┘
                                           │
                                           v
                                      ┌──────────┐
                                      │Category  │
                                      └──────────┘
```

## 📝 Usuarios por Defecto

Al iniciar la aplicación, se crean usuarios por defecto:

**Usuarios normales:**
- Email: `user1@email.com` - `user5@email.com`
- Password: `123456`

**Administradores:**
- Email: `admin1@email.com` - `admin2@email.com`
- Password: `123456`

