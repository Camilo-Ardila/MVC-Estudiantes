# MVC-Estudiantes

**Camilo José Ardila Restrepo**\
ID: 000543367

Repositorio del examen de DevOps -- Patrón Modelo-Vista-Controlador
(MVC)\
Plataformas de Programación Empresarial\
MJ 18:00--19:40 \| 2026-1

------------------------------------------------------------------------

## 1. Descripción del Proyecto

Este repositorio contiene una pequeña aplicación de ejemplo construida como ejercicio evaluativo para la clase Plataformas de Programación Empresarial MJ 18:00-19:40 2026-1. El ejercicio ilustra los conceptos básicos del patrón de diseño Modelo-Vista-Controlador (MVC) usando Java, junto a la implementación de diversas prácticas de desarrollo devops.

-   Implementación del patrón Modelo Vista Controlador (MVC)
-   Integración de Thymeleaf como motor de plantillas de visualización
-   Persistencia en memoria del servidor
-   Automatización mediante pipeline CI/CD con GitHub Actions
-   Estrategia de integración continua usando Trunk-Based Development

------------------------------------------------------------------------

## 2. Tecnologías Utilizadas (Dependencias recomendadas en clase)

-   Java 21
-   Spring Boot 4.0.2
-   Spring WebMVC
-   Spring Data JPA
-   Thymeleaf
-   H2 Database
-   Lombok
-   Gradle
-   GitHub Actions (CI/CD)

------------------------------------------------------------------------

## 3. Requisitos Previos

Antes de ejecutar el proyecto debes tener instalado:

-   JDK 21
-   Git
-   Gradle (opcional si usas gradlew, ya incluido en el proyecto)

------------------------------------------------------------------------

## 4. Instrucciones Exactas de Ejecución

### 1. Clonar el repositorio

    git clone https://github.com/Camilo-Ardila/MVC-Estudiantes.git

### 2. Entrar al directorio del proyecto

    cd MVC-Estudiantes

### 3. Ejecutar la aplicación en el puerto 6001

Linux / Mac:

    ./gradlew bootRun

Windows:

    gradlew.bat bootRun

La aplicación quedará disponible en:

    http://localhost:6001

------------------------------------------------------------------------

## 5. Pipeline CI/CD

El proyecto incluye un pipeline definido en:

    .github/workflows/pipeline.yml

### Flujo del Pipeline

Se ejecuta automáticamente cuando:

-   Se hace push a la rama main
-   Se crea un pull request hacia main

### Etapas del Pipeline

#### 1. Build and Test

-   Checkout del repositorio

-   Configuración de JDK 21 (Temurin)

-   Permisos al wrapper de Gradle

-   Ejecución de:

        gradlew clean build

Esto compila el proyecto y ejecuta los tests automáticamente.

#### 2. Create Release (solo en push a main)

-   Obtiene la versión definida en build.gradle
-   Genera el JAR ejecutable (bootJar)
-   Crea automáticamente un GitHub Release
-   Adjunta el .jar generado como artefacto descargable

------------------------------------------------------------------------

## 6. Herramientas Usadas en el Pipeline

### GitHub Actions

Servicio de integración continua de GitHub que permite ejecutar
workflows automáticamente ante eventos del repositorio.

### actions/checkout@v4

Clona el repositorio dentro del entorno de ejecución del workflow.

### actions/setup-java@v4

Configura el entorno con la versión específica de Java (Temurin 21).

### Gradle Wrapper

Permite compilar y construir el proyecto sin requerir que Gradle esté
instalado globalmente.

### softprops/action-gh-release@v2

Automatiza la creación de Releases en GitHub y adjunta artefactos
generados (JAR).

------------------------------------------------------------------------

## 7. Estrategia de Git Elegida

### Trunk-Based Development

Se eligió Trunk-Based Development en lugar de GitFlow.

### Justificación

Se elige Trunk-Based Development debido a la sencillez y facilidad que introduce para este ejercicio en particular. Sus características se alinean con los objetivos de este ejercicio: integración continua y despliegue automático al hacer merge a main. En Trunk-Based se trabaja con ramas cortas de feature/fix que se integran rápidamente a main mediante Pull Requests logrando reducir conflictos de merge, mantener un main apto para producción y facilitando la automatización de nuevas versiones.

Aparte de no ser tan familiar, GitFlow hubiera sido una opción más estructurada con una mayor variedad de ramas y estados, pero añade complejidad innecesaria para un proyecto individual de clase y un pipeline que debe liberar directamente al hacer merge a la rama principal.


## 8. Resultado Final

Este proyecto demuestra:

-   Implementación correcta del patrón MVC
-   Uso de Spring Boot con Gradle
-   Integración continua automatizada
-   Generación automática de releases
-   Aplicación de buenas prácticas DevOps en un entorno académico
