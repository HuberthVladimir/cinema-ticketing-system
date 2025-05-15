package com.huberthvladimir.cinema_ticketing_system.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.huberthvladimir.cinema_ticketing_system.entities.Seat;
import com.huberthvladimir.cinema_ticketing_system.projections.GetAllSeatsProjection;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query(nativeQuery = true, value = """
            SELECT
                seat.id AS seat_id,
                seat.SEAT_NUMBER,
                seat.SEAT_ROW,
                seat.is_special_seat,
                seat.theater_room_id,
                room.NAME AS theater_room_name,
                room.capacity,
                room.exibithion_type
            FROM TB_SEATS AS seat
            INNER JOIN TB_THEATER_ROOMS AS room ON seat.THEATER_ROOM_ID = room.id
            WHERE seat.theater_room_id = :theaterRoomId;
            """)
    List<GetAllSeatsProjection> searchByTheaterRoomId(Long theaterRoomId);

    @Query(nativeQuery = true, value = """
            SELECT
                seat.id AS seat_id,
                seat.SEAT_NUMBER,
                seat.SEAT_ROW,
                seat.is_special_seat,
                seat.theater_room_id,
                room.NAME AS theater_room_name,
                room.capacity,
                room.exibithion_type
            FROM TB_SEATS AS seat
            INNER JOIN TB_THEATER_ROOMS AS room ON seat.THEATER_ROOM_ID = room.id;
            """)
    List<GetAllSeatsProjection> searchAllSeats();

    @Query(nativeQuery = true, value = """
            SELECT EXISTS (
                SELECT 1
                FROM TB_SEATS
                WHERE THEATER_ROOM_ID = :theaterRoomId
                    AND SEAT_NUMBER = :seatNumber
                    AND SEAT_ROW = :seatRow
            );
            """)
    Boolean searchSeatIfExists(char seatRow, int seatNumber, Long theaterRoomId);

}
