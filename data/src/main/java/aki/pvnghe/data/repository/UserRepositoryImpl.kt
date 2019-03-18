package aki.pvnghe.data.repository

import aki.pvnghe.data.model.User
import aki.pvnghe.data.service.GithubUserService
import io.reactivex.Single
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private var githubUserService: GithubUserService): UserRepository{
    override fun searchUsers(searchTerm: String): Single<List<User>> = githubUserService.searchGithubUsers(searchTerm = searchTerm)
        .map{ it.items }


    fun getUser(name: String): Single<User> = githubUserService.getUser(username = name)

}