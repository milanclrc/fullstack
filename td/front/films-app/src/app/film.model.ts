import { Acteur } from './acteur.model';

export interface Film {
  id: number;
  titre: string;
  realisateur: string;
  description?: string;
  dateSortie: string;
  genre: string;
  acteurs?: Acteur[];
}
