package com.devsuperior.dslist.projections;

public interface GameMinProjection {
	//vai ter que colocar metodos gets correspondentes a consulta repository
	
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
	

}
