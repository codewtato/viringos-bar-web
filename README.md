<h1 align="center">Sistema Web de Automatización de Reservas y Gestión de Señas</h1>
<h3 align="center">Viringo's Bar 🍻</h3>

<div align="center">

![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=flat&logo=javascript&logoColor=%23F7DF1E) ![TypeScript](https://img.shields.io/badge/typescript-%23007ACC.svg?style=flat&logo=typescript&logoColor=white) ![Vite](https://img.shields.io/badge/vite-%23646CFF.svg?style=flat&logo=vite&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white) ![Spring Boot](https://img.shields.io/badge/spring-%236DB33F.svg?style=flat&logo=spring&logoColor=white) ![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=flat&logo=mongodb&logoColor=white)

</div>

> **Trabajo Final Integrador** - Tecnicatura Universitaria en Programación (UTN)

## 👥 Equipo de Trabajo
- **D'Agostino Matías Julián**
- **Cufré Facundo Julián**
- **Tutor:** Londero Oscar

---

## 📋 Índice
- [Contexto y Problema](#-contexto-y-problema)
- [Solución Propuesta](#-solución-propuesta)
- [Stack Tecnológico](#-stack-tecnológico)
- [Arquitectura y Despliegue](#-arquitectura-y-despliegue)
- [Estructura del Repositorio](#-estructura-del-repositorio)

---

## ⚠️ Contexto y Problema
El proyecto está pensado para **Viringo's Bar**, un establecimiento gastronómico que actualmente enfrenta cuellos de botella operativos debido a la falta de un canal digital automatizado.

Todo el sistema de reservas se maneja de forma manual a través de WhatsApp, Instagram y Facebook. Según las observaciones del responsable del negocio, esto genera:
- **Carga operativa:** El personal dedica un tiempo considerable a responder consultas repetitivas y anotar reservas a mano, restando atención presencial y a otras tareas.
- **Ausentismo recurrente:** Al no existir compromiso económico o garantía previa, se observa que una parte de los clientes reserva mesas y no se presenta. Esto se traduce en mesas vacías y un impacto económico negativo para el local.

## 💡 Solución Propuesta
Se desarrollará una aplicación web ágil donde los clientes puedan autogestionar la reserva de sus mesas de manera autónoma.

La plataforma incluirá un sistema para requerir el pago o la simulación de una **seña previa** como condición obligatoria para confirmar el turno. Esto permitirá:
1. Filtrar a los clientes dubitativos o curiosos.
2. Reducir el ausentismo.
3. Disminuir la carga administrativa del personal asociada a la gestión de reservas.

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
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
- **Enfoque:** Almacenamiento NoSQL orientado a documentos, ideal para manejar estructuras dinámicas de reservas.

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
