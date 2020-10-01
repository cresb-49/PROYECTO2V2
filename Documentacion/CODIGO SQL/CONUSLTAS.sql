///CONSULTA DE LOS PACIENTES CON MAYOR CANTIDAD DE REPORTES
SELECT COUNT(PACIENTE_codigo) AS cantidad,PACIENTE.nombre,PACIENTE.codigo FROM REPORTE INNER JOIN PACIENTE ON PACIENTE.codigo = REPORTE.PACIENTE_codigo AND REPORTE.fecha BETWEEN "2020-01-01" AND "2020-01-04" GROUP BY PACIENTE.nombre ORDER BY cantidad DESC;
///HISTORIAL PACIENTE
SELECT * FROM CITA WHERE PACIENTE_codigo ="118258";
SELECT * FROM RESULTADO WHERE PACIENTE_codigo ="118258";
///CITAS AGENDADAS EN INTEVARLO DE TIMEPO
SELECT * FROM CITA WHERE MEDICO_codigo ="MED-127" AND fecha BETWEEN "2020-09-01" AND "2020-09-20" ORDER BY fecha ASC;
///REPORTE DE CITAS PARA EL DIA EN CURSO
SELECT * FROM CITA WHERE MEDICO_codigo ="MED-127" AND fecha="2020-09-14" ORDER BY hora ASC;
----------------------------------------FIN MEDICO----------------------------------------------
//EXAMENES A REALIZAR EN EL DIA
SELECT * FROM SOLUCITUD_EXAMEN WHERE LABORATORISTA_codigo = "LAB-123" AND fecha ="2020-01-02";
////RESULTADOS EN EL DIA LAB
SELECT * FROM RESULTADO WHERE LABORATORISTA_codigo = "LAB-948" AND fecha ="2020-09-06" ORDER BY hora ASC;
///CANTIDAD DE RESULTADOS SEGUN SUS DIAS DE TRABAJO
SELECT COUNT(fecha) AS cantidad,fecha FROM RESULTADO WHERE LABORATORISTA_codigo = "LAB-948" GROUP BY fecha ORDER BY cantidad DESC LIMIT 10;
----------------------------------FIN LABORATORISTA------------------------------------------------------------------------------------
/////ULTIMOS 5 EXAMENES REALIZADOS
SELECT * FROM RESULTADO WHERE PACIENTE_codigo = "977693" ORDER BY fecha DESC LIMIT 5;
////ULTIMOS EXAMENES REALIZADOS EN UN RANGO DE TIEMPO
SELECT COUNT(EXAMEN_codigo) AS ex,EXAMEN.nombre FROM RESULTADO INNER JOIN EXAMEN ON RESULTADO.EXAMEN_codigo = EXAMEN.codigo AND RESULTADO.PACIENTE_codigo="977693" AND RESULTADO.fecha BETWEEN "2020-09-01" AND "2020-09-10" GROUP BY EXAMEN.codigo ORDER BY ex DESC;
///ULTIMAS 5 CONSULTAS REALIZADAS
SELECT * FROM CITA WHERE PACIENTE_codigo ="977693" ORDER BY fecha DESC LIMIT 5;
/////CONSULTAS REALIZADAS CON UN MEDICO EN ESPECIFICO EN INTERVALO DE TIMEPO
SELECT COUNT(CITA.MEDICO_codigo),MEDICO.nombre,MEDICO.codigo FROM CITA INNER JOIN MEDICO ON CITA.MEDICO_codigo = MEDICO.codigo AND CITA.PACIENTE_codigo = "977693" AND CITA.fecha BETWEEN "2020-09-01"AND "2020-09-20" GROUP BY MEDICO.codigo ORDER BY CITA.fecha DESC;
-------------------------------------------------------------FIN PACIENTE---------------------------------------------------------------------
//////10 MEDICOS CON LOS INFORMES REALIZADOS EN UN INTERVALO DE TIEMPO
SELECT COUNT(MEDICO.codigo) AS cantidad ,MEDICO.nombre,MEDICO.codigo FROM MEDICO INNER JOIN REPORTE ON REPORTE.MEDICO_codigo = MEDICO.codigo GROUP BY MEDICO.codigo ORDER BY cantidad DESC LIMIT 10;
/////LOS 5 MEDICOS CON MENOR CANTIDAD DE CITAS
SELECT COUNT(CITA.MEDICO_codigo) AS C,MEDICO.codigo,MEDICO.nombre FROM MEDICO INNER JOIN CITA WHERE MEDICO.codigo = CITA.MEDICO_codigo GROUP BY MEDICO.codigo ORDER BY C ASC LIMIT 5;
///LOS EXAMENES DE LABORATORIO MAS DEMANDADOS EN UN INTERVALO
SELECT COUNT(RESULTADO.MEDICO_codigo) AS C, MEDICO.codigo,MEDICO.nombre  FROM RESULTADO INNER JOIN MEDICO ON RESULTADO.MEDICO_codigo = MEDICO.codigo GROUP BY MEDICO.codigo ORDER BY C DESC;


