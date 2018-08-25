package intern.line.tokyoaclient.HttpConnection.service

import intern.line.tokyoaclient.HttpConnection.model.Room
import intern.line.tokyoaclient.HttpConnection.model.RoomMember
import retrofit2.http.*
import rx.Completable
import rx.Single


interface RoomService {
    /* ROOM */
    @GET("/room")
    fun getAllRooms(): Single<List<Room>>

    @GET("/room/room_id/{room_id}")
    fun getRoomById(@Path("room_id") roomId: Long): Single<Room>

    @POST("/room/create/{room_name}")
    fun addRoom(@Path("room_name") roomName: String): Completable

    @PUT("/room/modify/{room_id}/{room_name}")
    fun modifyRoom(@Path("room_id") roomId: Long, @Path("room_name") roomName: String): Completable

    @DELETE("/room/delete/{room_id}")
    fun deleteRoom(@Path("room_id") roomId: Long): Single<Room>

    /* ROOM MEMBERS */
    @GET("/room_member")
    fun getAllRoomMembers(): Single<List<RoomMember>>

    @GET("/room_member/room_id/{room_id}")
    fun getMembersByRoomId(@Path("room_id") roomId: Long): Single<List<RoomMember>>

    @GET("/room_member/uid/{uid}")
    fun getRoomsByUserId(@Path("uid") uid: String): Single<List<RoomMember>>

    @POST("/room_member/create/{room_id}/{uid}")
    fun addRoomMember(@Path("room_id") roomId: Long, @Path("uid") uid: String): Completable

    @DELETE("/room/delete/{room_id}/{uid}")
    fun deleteRoomMember(@Path("room_id") roomId: Long, @Path("uid") uid: String): Single<RoomMember>
}