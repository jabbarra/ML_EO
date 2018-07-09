
CREATE TABLE public.climas
(
    id serial,
    nombre character varying (30),
    PRIMARY KEY (id)
);

CREATE TABLE public.dias
(
    id serial,
    numero integer,
	intensidad_lluvia  double precision,
	id_climas integer REFERENCES public.climas(id),
	PRIMARY KEY (id)
);
