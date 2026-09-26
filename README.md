<h1 align="center">Sistema Web de Automatización de Reservas y Gestión de Señas</h1>
<h3 align="center">Viringo's Bar 🍻</h3>

<div align="center">

![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=flat&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=flat&logo=css3&logoColor=white) ![TypeScript](https://img.shields.io/badge/typescript-%23007ACC.svg?style=flat&logo=typescript&logoColor=white) ![Vite](https://img.shields.io/badge/vite-%23646CFF.svg?style=flat&logo=vite&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white) ![Spring Boot](https://img.shields.io/badge/spring-%236DB33F.svg?style=flat&logo=spring&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-%234479A1.svg?style=flat&logo=mysql&logoColor=white)

</div>

> **Trabajo Final Integrador** - Tecnicatura Universitaria en Programación (UTN)

## 👥 Equipo de Trabajo
- **D'Agostino Matías Julián**
- **Cufré Facundo Julián**
- **Tutor:** Londero Oscar

---

## 📋 Índice
- [Stack Tecnológico](#-stack-tecnológico)
- [Arquitectura y Despliegue](#-arquitectura-y-despliegue)
- [Estructura del Repositorio](#-estructura-del-repositorio)

---

## 🚀 Stack Tecnológico

### Frontend
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![TypeScript](https://img.shields.io/badge/typescript-%23007ACC.svg?style=for-the-badge&logo=typescript&logoColor=white)
![Vite](https://img.shields.io/badge/vite-%23646CFF.svg?style=for-the-badge&logo=vite&logoColor=white)
- **Enfoque:** Interfaz de usuario construida con HTML5, CSS3 y TypeScript puro (Vanilla) utilizando Vite como entorno de desarrollo. Asegura un tipado estricto de los datos y una navegación intuitiva para que el cliente final seleccione fecha, horario, cantidad de personas y complete el proceso de reserva.

### Backend
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
- **Enfoque:** Construcción de una API REST sólida encargada de procesar reglas de negocio, validar disponibilidad y gestionar estados aplicando los principios de POO.

### Base de Datos
![MySQL](https://img.shields.io/badge/mysql-%234479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
- **Enfoque:** Se optó por una base de datos relacional (MySQL). El dominio del bar presenta relaciones fuertemente estructuradas entre clientes, disponibilidad de horarios, reservas y estados de pagos. Un modelo relacional garantiza la integridad referencial y permite gestionar bloqueos concurrentes (transacciones ACID) para evitar que dos clientes ocupen la misma capacidad simultáneamente, alineándose con las reglas de negocio evaluadas.

---

## ☁️ Arquitectura y Despliegue
- **Frontend:** Vercel
- **Backend:** Railway
- **Base de Datos:** MongoDB Atlas

---

## 📁 Estructura del Repositorio
- **/frontend:** Entorno de la interfaz del cliente inicializado con Vite.
- **/backend:** Lógica del servidor y API REST desarrollada con Spring Boot.
- **/docs:** Archivos de documentación, incluyendo la propuesta inicial del proyecto.
- **/database:** Scripts y esquemas futuros para la base de datos MongoDB.
