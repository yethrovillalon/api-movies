package cl.yet.system.repository;

import cl.yet.system.dto.AnioMovie;

public interface MovieRepository {

	AnioMovie findById(int id);
}
