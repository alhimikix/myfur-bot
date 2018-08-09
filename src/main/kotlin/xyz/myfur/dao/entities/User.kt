package xyz.myfur.dao.entities

import javax.persistence.*

@Table(name = "users")
@Entity
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        @Column(nullable = false)
        var name: String?,
        var telegram_id:Long,
        @Column(nullable = false)
        var login: String?,
        @Column(nullable = false)
        var password: String?,
        @Column(nullable = true)
        var email: String?,
        @OneToMany(mappedBy = "owner")
        var comics: Set<Comics> = HashSet(),
        @OneToMany(mappedBy = "owner")
        var art: Set<Arts> = HashSet()
)


@Table(name = "comics")
@Entity
class Comics(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        @ManyToOne()
        @JoinColumn(name = "comics_id")
        var owner: User,
        var name: String?,
        var description: String?){
    companion object {
        fun create(id: Long = 0, owner: User, name: String? = null, description: String? = null): Comics {
            return Comics(id, owner, name, description)
        }
    }}

@Table(name = "arts")
@Entity
class Arts(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        @ManyToOne()
        @JoinColumn(name = "arts_id")
        var owner: User,
        var name: String?,
        var description: String?
) {
    companion object {
        fun create(id: Long = 0, owner: User, name: String? = null, description: String? = null): Arts {
            return Arts(id, owner, name, description)
        }
    }
}