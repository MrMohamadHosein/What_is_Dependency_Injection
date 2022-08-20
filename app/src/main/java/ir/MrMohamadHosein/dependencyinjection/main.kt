package ir.dunijet.dependencyinjection

class PicassoService : ImageLoader {
    override fun loadPicture() {
        // using picasso

    }
}

class GlideService : ImageLoader {
    override fun loadPicture() {
        // using glide

    }
}

interface ImageLoader {
    fun loadPicture()
}

class Activity1(private val imageLoader: ImageLoader) {
    fun loadImage() {
        imageLoader.loadPicture()
        println("Activity1 loading with glide")
    }
}

class Activity2(private val imageLoader: ImageLoader) {
    fun loadImage() {
        imageLoader.loadPicture()
        println("Activity2 loading with glide")
    }
}

object Injector {
    fun getImageLoader(): ImageLoader {
        return PicassoService()
    }
}

fun main() {

    val activity1 = Activity1(Injector.getImageLoader())
    activity1.loadImage()

    val activity2 = Activity2(Injector.getImageLoader())
    activity2.loadImage()

}