Glide加载图像以及磁盘缓存的方式,速度更快，并且Glide更有利于减少OutOfMemoryError的发生，GIF动画是Glide也可以加载.


# 设置了具体的尺寸大小
Picasso.with(this)
    .load("http://nuuneoi.com/uploads/source/playstore/cover.jpg")
    .resize(768, 432)
    .into(ivImgPicasso);



#ImageView大小是具体的值（而不是wrap_content),可以

Picasso.with(this)
    .load("http://nuuneoi.com/uploads/source/playstore/cover.jpg")
    .fit()
    .centerCrop()
    .into(ivImgPicasso);



#让Glide既缓存全尺寸又缓存其他尺寸：

Glide.with(this)
     .load("http://nuuneoi.com/uploads/source/playstore/cover.jpg")
     .diskCacheStrategy(DiskCacheStrategy.ALL)
     .into(ivImgGlide);


#特性

##Image Resizing

// Picasso
.resize(300, 200);

// Glide
.override(300, 200);



##Center Cropping

// Picasso
.centerCrop();

// Glide
.centerCrop();



##Transforming

// Picasso
.transform(new CircleTransform())

// Glide
.transform(new CircleTransform(context))



##设置占位图或者加载错误图：

// Picasso
.placeholder(R.drawable.placeholder)
.error(R.drawable.imagenotfound)

// Glide
.placeholder(R.drawable.placeholder)
.error(R.drawable.imagenotfound)