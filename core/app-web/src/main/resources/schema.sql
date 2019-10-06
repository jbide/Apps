CREATE TABLE t_txn_adresse
(
  id_adresse integer NOT NULL,
  code_postal character varying(255),
  commune character varying(255),
  libelle_rue character varying(255),
  num_rue character varying(255),
  pays character varying(255),
  CONSTRAINT t_txn_adresse_pkey PRIMARY KEY (id_adresse)
);

CREATE TABLE t_txn_famille_article
(
  id_famille_article integer NOT NULL,
  description character varying(255),
  nom character varying(255),
  CONSTRAINT t_txn_famille_article_pkey PRIMARY KEY (id_famille_article)
);

CREATE TABLE t_txn_magasin
(
  reference integer NOT NULL,
  prix_unit character varying(255),
  quantite character varying(255),
  CONSTRAINT t_txn_magasin_pkey PRIMARY KEY (reference)
);

CREATE TABLE t_txn_commande
(
  id_commande integer NOT NULL,
  date_livraison date,
  mode_livraison character varying(255),
  etat_commande character varying(255),
  num_client integer,
  CONSTRAINT t_txn_commande_pkey PRIMARY KEY (id_commande)
);

CREATE TABLE t_txn_ligne_commande
(
  id_ligne_commande integer NOT NULL,
  id_commande integer,
  id_article integer,
  quantite character varying(255),
  CONSTRAINT t_txn_ligne_commande_pkey PRIMARY KEY (id_ligne_commande),
  CONSTRAINT t_txn_ligne_commande_id_commande_fkey FOREIGN KEY (id_commande)
      REFERENCES t_txn_commande (id_commande)
);

CREATE TABLE t_txn_fournisseur
(
  id_fournisseur integer NOT NULL,
  nom character varying(255),
  tel character varying(255),
  id_adresse integer,
  CONSTRAINT t_txn_fournisseur_pkey PRIMARY KEY (id_fournisseur),
  CONSTRAINT t_txn_fournisseur_id_adresse_fkey FOREIGN KEY (id_adresse)
      REFERENCES t_txn_adresse (id_adresse)
);

CREATE TABLE t_txn_facture
(
  id_facture integer NOT NULL,
  id_commande integer,
  num_client integer,
  cout_total character varying(255),
  CONSTRAINT t_txn_facture_pkey PRIMARY KEY (id_facture),
  CONSTRAINT t_txn_facture_id_commande_fkey FOREIGN KEY (id_commande)
      REFERENCES t_txn_commande (id_commande)
);

CREATE TABLE t_txn_client
(
  id_client integer NOT NULL,
  nom character varying(255),
  prenom character varying(255),
  tel character varying(255),
  id_adresse integer,
  CONSTRAINT t_txn_client_pkey PRIMARY KEY (id_client),
  CONSTRAINT t_txn_client_id_adresse_fkey FOREIGN KEY (id_adresse)
      REFERENCES t_txn_adresse (id_adresse)
);

CREATE TABLE t_txn_article
(
  id_article integer NOT NULL,
  couleur character varying(255),
  description character varying(255),
  nom character varying(255),
  reference character varying(255),
  id_fam integer,
  id_fournisseur integer,
  CONSTRAINT t_txn_article_pkey PRIMARY KEY (id_article),
  CONSTRAINT t_txn_article_id_fournisseur_fkey FOREIGN KEY (id_fournisseur)
      REFERENCES t_txn_fournisseur (id_fournisseur),
  CONSTRAINT t_txn_article_id_fam_fkey FOREIGN KEY (id_fam)
      REFERENCES t_txn_famille_article (id_famille_article)
);

CREATE TABLE t_ref_privileges
(
  id_client integer NOT NULL,
  droit character varying(255),
  CONSTRAINT t_ref_privileges_id_client_fkey FOREIGN KEY (id_client)
      REFERENCES t_txn_client (id_client)
);



