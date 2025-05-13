package com.daas.service;

import com.daas.dto.request.ShowCreateRequest;
import com.daas.entity.Seat;
import com.daas.entity.Show;
import com.daas.repository.SeatRepository;
import com.daas.repository.ShowRepository;
import com.daas.translator.ShowTranslator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class ShowService {

    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;

    public List<Show> getAllShows() {
        return showRepository.listAll();
    }

    @Transactional
    public List<Show> createShows(final List<ShowCreateRequest> requests) {

        List<Show> shows = requests.stream()
                .map(ShowTranslator::toEntity)
                .collect(Collectors.toList());
        shows.forEach(showRepository::persist);

        List<Seat> seats = generateSeats(requests);
        seats.forEach(seatRepository::persist);
        return shows;
    }

    public List<Seat> generateSeats(List<ShowCreateRequest> requests) {
        Map<String, Show> showByTitle = requests.stream()
                .map(ShowCreateRequest::getTitle)
                .distinct()
                .collect(Collectors.toMap(
                        Function.identity(),
                        title -> showRepository.findByTitle(title)
                ));

        return requests.stream()
                .flatMap(req -> {
                    Show show = showByTitle.get(req.getTitle());
                    return IntStream.range(0, req.getNumberOfSeats())
                            .mapToObj(i -> {
                                Seat seat = new Seat();
                                seat.setSeatNumber("S" + (i + 1));
                                seat.setBooked(false);
                                seat.setShow(show);
                                return seat;
                            });
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteShow(Long id) {
            showRepository.deleteById(id);
    }
}