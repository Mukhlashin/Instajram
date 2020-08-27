package cookode.instagram_clone.model

class User {
    private var username : String = ""
    private var fullname : String = ""
    private var bio : String = ""
    private var image : String = ""
    private var uid : String = ""

    constructor(username: String, fullname: String, bio: String, image: String, uid: String) {
        this.username = username
        this.fullname = fullname
        this.bio = bio
        this.image = image
        this.uid = uid
    }

    fun getUserName() : String {
        return username
    }

    fun getFullName() : String {
        return username
    }

    fun getBio() : String {
        return username
    }

    fun getImage() : String {
        return username
    }

    fun getUid() : String {
        return username
    }

    fun setUserName(username : String) {
        this.username = username
    }

    fun setFullName(fullname : String) {
        this.fullname = fullname
    }

    fun setBio(bio : String) {
        this.bio = bio
    }

    fun setImage(image : String) {
        this.image = image
    }

    fun setUid(uid : String) {
        this.uid = uid
    }
}