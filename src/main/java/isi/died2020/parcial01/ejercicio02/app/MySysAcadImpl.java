package isi.died2020.parcial01.ejercicio02.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import isi.died2020.parcial01.ejercicio02.db.BaseDeDatos;
import isi.died2020.parcial01.ejercicio02.db.BaseDeDatosExcepcion;
import isi.died2020.parcial01.ejercicio02.db.ErrorIngresandoDBException;
import isi.died2020.parcial01.ejercicio02.dominio.*;
import isi.died2020.parcial01.ejercicio02.dominio.Inscripcion.Estado;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	

	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) throws ErrorIngresandoDBException {
		Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
		d.agregarInscripcion(insc);
		a.addCursada(insc);
		m.addInscripcion(insc);
		// DESCOMENTAR Y gestionar excepcion
		try {
			//No llegue a implementar verificar las correlativas
			DB.guardar(insc);
		} catch (BaseDeDatosExcepcion e) {
			throw new ErrorIngresandoDBException();
		}
	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) {
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		// DESCOMENTAR Y gestionar excepcion
		// DB.guardar(e);
	}


	@Override
	public void registrarNota(Examen e, Integer nota) {
		e.setNota(nota);
		if(nota >= 6) {
			e.getAlumno().getMateriasCursadas().stream().filter(r -> r.getMateria().equals(e.getMateria())).findFirst().get().setEstado(Estado.PROMOCIONADO);
		}
	}

	@Override
	public Double promedioAprobados(Materia m) {
		Double nota=0.0;
		Long cantidadDeExamenes = m.getExamenes()
			.stream()
			.filter(e -> e.getNota() >= 6)
			.map(e -> nota + e.getNota())
			.count();
		
		return nota / cantidadDeExamenes;
	}


	@Override
	public List<Alumno> inscriptos(Materia m, Integer ciclo) {
		return m.getInscripciones()
				.stream()
				.filter(i -> i.getCicloLectivo().equals(ciclo))
				.map(i -> i.getInscripto())
				.sorted((a1,a2) -> a1.getNombre().compareTo(a2.getNombre()))
				.collect(Collectors.toList());
	}

}
