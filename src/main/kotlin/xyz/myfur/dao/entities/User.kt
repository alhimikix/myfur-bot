package xyz.myfur.dao.entities

import javax.persistence.*

@Table(name = "users")
@Entity
class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @Column(nullable = true)
        var name: String? = null,
        @Column(name="telegramid",unique = true)
        var telegramid: Long? = null,
        @Column(nullable = true)
        var login: String? = null,
        @Column(nullable = true)
        var password: String? = null,
        @Column(nullable = true)
        var email: String? = null,

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
        var id: Long? = null,
        @ManyToOne()
        @JoinColumn(name = "comics_id")
        var owner: User?=null,
        var name: String? = null,
        var description: String?=null) {

}

@Table(name = "arts")
@Entity
class Arts(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?=null,
        @ManyToOne()
        @JoinColumn(name = "arts_id")
        var owner: User?=null,
        var name: String?=null,
        var description: String?=null
) {
    companion object {
        fun create(id: Long = 0, owner: User, name: String? = null, description: String? = null): Arts {
            return Arts(id, owner, name, description)
        }
    }
}