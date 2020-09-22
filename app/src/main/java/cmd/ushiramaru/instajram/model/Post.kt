package cmd.ushiramaru.instajram.model

data class Post (
    var postId : String? = null,
    var postImage : String? = null,
    var publisher : String = "",
    var description : String = ""
)