# 📱 Actividad 10 Multimedia en Android

## 🔧 Requisitos Técnicos

- Plataforma: Android con Java
- API Level: 30
- IDE: Android Studio

## Desarrollo

### 1 🎬 Que ventajitas brinda VideoView para reproducir vídeos en una app Android?

La clase `VideoView`, presenta múltiples ventajas para mostrar videos fácil en Android.

- Permite tocar archivos de video locales, o incluso desde internet, todo con código corto.
- Tiene controlitos básicos como play, pause y buscar, vienen de serie.
- Se junta fácilmente con los layouts XML, y se ajusta a cualquier pantalla.
- Funciona bien con muchos formatos de video populares.

### 2 📂 De dónde se puede reproducir audio y video en una app Android?

En Android, se puede reproducir vídeos y audios desde sitios distintos.

- Archivos locales: Dentro del almacenamiento del dispositivo, sea interno o externo.
- Recursos de la app: videos o audios metidos en la carpeta `res/raw` o `assets`.
- URLs o streams en línea: a través de la red, como vídeos de servidores o APIs.
- Contenido multimedia compartido: Acceder a medios de otras aplicaciones, utilizando `ContentProvider`.

### 3. 🛠️ Clases de Android para acceder a servicios multimedia

- MediaPlayer: Este reproduce audio y video! con control completo; play, pause, stop y seek.
- VideoView: Es un widget simplificado, reproduce videos en layouts XML, con controles básicos.
- AudioManager: Administra audio del dispositivo, controla el volumen, modos y fuentes de entrada.
- MediaStore: Da acceso a archivos multimedia del sistema, como fotos, videos, y audios.

### 4. 💭 Reflexión Personal del Tema

El manejo de multimedia en Android... es crucial, ¿sabes? Para aplicaciones interactivas y modernas. Clases como `VideoView` y `MediaPlayer` permiten la reproducción eficiente de contenido; mientras `MediaStore` y `AudioManager` simplifican el acceso y el control de archivos en el dispositivo. Combinar estas herramientas... mejora la experiencia de usuario y te permite desarrollar apps llenas de contenido visual y sonoro; y fomentando la optimización de memoria y rendimiento.
